package com.haulmont.testtask.web.controller;

import com.haulmont.testtask.model.*;
import com.haulmont.testtask.service.CreditProposalService;
import com.haulmont.testtask.service.CreditService;
import com.haulmont.testtask.service.CustomerService;
import com.haulmont.testtask.util.PaymentsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Controller
public class CreditProposalController {
    @Autowired
    private CreditProposalService service;
    @Autowired
    private CreditService creditService;
    @Autowired
    private CustomerService customerService;

    @GetMapping("creditProposals/delete")
    public String delete(@RequestParam String id) {
        service.delete(UUID.fromString(id));
        return "redirect:/creditProposals";
    }

    @GetMapping("creditProposalCreate")
    public String getCreditProposalToCreate(Model model) {
        final CreditProposal creditProposal = new CreditProposal();
        model.addAttribute("creditProposal", creditProposal);
        model.addAttribute("customers", customerService.getAll());
        model.addAttribute("credits", creditService.getAll());
        return "creditProposalForm";
    }

    @PostMapping("creditProposalCreateForm")
    public String getCreditProposalWithPaymentsToCreate(Model model, HttpServletRequest request) throws IOException {
        CreditProposal creditProposal = getCreditProposal(request);
        UUID customerId = UUID.fromString(request.getParameter("customerId"));
        UUID creditId = UUID.fromString(request.getParameter("creditId"));
        List<Payment> payments = PaymentsUtil.createNew(creditProposal, creditService.get(creditId));
        Customer customer = customerService.get(customerId);
        Credit credit = creditService.get(creditId);
        creditProposal.setPayments(payments);
        creditProposal.setCustomer(customer);
        creditProposal.setCredit(credit);
        model.addAttribute("creditProposal", creditProposal);
        model.addAttribute("creditBalancePerMonth", PaymentsUtil.calcCreditBalancePerMonth(payments));
        model.addAttribute("percentSum", PaymentsUtil.calcPercentSum(payments));
        return "creditProposalWithPaymentsForm";
    }

    @PostMapping(value = "/creditProposals")
    public String createCreditProposal(@ModelAttribute("creditProposal") CreditProposal creditProposal) {
        service.create(creditProposal, creditProposal.getCustomer().getId(), creditProposal.getCredit().getId());
        return "redirect:/creditProposals";
    }

    @GetMapping("/creditProposals")
    public String getAll(Model model) {
        model.addAttribute("creditProposals", service.getAll());
        return "creditProposals";
    }

    private CreditProposal getCreditProposal(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        CreditProposal creditProposal = new CreditProposal();
        creditProposal.setCreditAmount(new BigDecimal(request.getParameter("creditAmount")));
        return creditProposal;
    }
}
