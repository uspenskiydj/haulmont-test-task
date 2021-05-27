package com.haulmont.testtask.web.controller;

import com.haulmont.testtask.model.*;
import com.haulmont.testtask.service.CreditProposalService;
import com.haulmont.testtask.service.CreditService;
import com.haulmont.testtask.service.CustomerService;
import com.haulmont.testtask.util.PaymentsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
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
        return "redirect:/creditProposalCreateForm";
    }

    @GetMapping("creditProposalCreateForm")
    public String getCreditProposalWithPaymentsToCreate(Model model, HttpServletRequest request) throws IOException {
        CreditProposal creditProposal = getCreditProposal(request);
        UUID customerId = UUID.fromString(request.getParameter("customerId"));
        UUID creditId = UUID.fromString(request.getParameter("creditId"));
        creditProposal.setPayments(PaymentsUtil.createNew(creditProposal, creditService.get(creditId)));
        model.addAttribute("creditProposal", creditProposal);
        model.addAttribute("customer", customerService.get(customerId));
        model.addAttribute("credit", creditService.get(creditId));
        return "redirect:/creditProposalWithPaymentsForm";
    }

    @PostMapping("/creditProposals")
    public String createCreditProposal(HttpServletRequest request, @RequestBody CreditProposal creditProposal) {
        UUID customerId = UUID.fromString(request.getParameter("customerId"));
        UUID creditId = UUID.fromString(request.getParameter("creditId"));
        service.create(creditProposal, customerId, creditId);
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
