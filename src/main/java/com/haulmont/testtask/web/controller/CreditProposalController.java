package com.haulmont.testtask.web.controller;

import com.haulmont.testtask.model.*;
import com.haulmont.testtask.service.CreditProposalService;
import com.haulmont.testtask.service.CreditService;
import com.haulmont.testtask.service.CustomerService;
import com.haulmont.testtask.util.PaymentsUtil;
import com.haulmont.testtask.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@SessionAttributes("creditProposal")
@Controller
public class CreditProposalController {
    @Autowired
    private CreditProposalService service;
    @Autowired
    private CreditService creditService;
    @Autowired
    private CustomerService customerService;

    @GetMapping("/creditProposals/delete")
    public String delete(@RequestParam String id) {
        service.delete(UUID.fromString(id));
        return "redirect:/creditProposals";
    }

    @GetMapping("creditProposalCreate")
    public String getCreditProposalToCreate(Model model) {
        model.addAttribute("customers", customerService.getAll());
        model.addAttribute("credits", creditService.getAll());
        return "creditProposalForm";
    }

    @PostMapping("creditProposalCreateForm")
    public String getCreditProposalWithPaymentsToCreate(Model model, HttpServletRequest request) throws IOException {
        request.setCharacterEncoding("UTF-8");
        CreditProposal creditProposal = new CreditProposal();
        UUID creditId = UUID.fromString(request.getParameter("creditId"));
        Credit credit = creditService.get(creditId);
        if (!ValidationUtil.isValidCreditAmount(request.getParameter("creditAmount"), credit)) {
            model.addAttribute("customers", customerService.getAll());
            model.addAttribute("credits", creditService.getAll());
            model.addAttribute("creditAmountError", true);
            return "creditProposalForm";
        }
        creditProposal.setCreditAmount(new BigDecimal(request.getParameter("creditAmount")));
        creditProposal.setCredit(credit);
        UUID customerId = UUID.fromString(request.getParameter("customerId"));
        creditProposal.setCustomer(customerService.get(customerId));
        List<Payment> payments = PaymentsUtil.createNew(creditProposal, credit);
        creditProposal.setPayments(payments);
        model.addAttribute("creditProposal", creditProposal);
        model.addAttribute("creditBalancePerMonth", PaymentsUtil.calcCreditBalancePerMonth(payments));
        model.addAttribute("percentSum", PaymentsUtil.calcPercentSum(payments));
        return "creditProposalWithPaymentsForm";
    }

    @PostMapping(value = "/creditProposals")
    public String createCreditProposal(CreditProposal creditProposal, SessionStatus status) {
        service.create(creditProposal);
        status.setComplete();
        return "redirect:/creditProposals";
    }

    @GetMapping("/creditProposals")
    public String getAll(Model model) {
        model.addAttribute("creditProposals", service.getAll());
        return "creditProposals";
    }
}
