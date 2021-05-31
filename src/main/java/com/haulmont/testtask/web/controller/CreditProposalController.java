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
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView getCreditProposalToCreate() {
        return getCreditProposalForm(false);
    }

    @PostMapping("creditProposalCreateForm")
    public ModelAndView getCreditProposalWithPaymentsToCreate(HttpServletRequest request) throws IOException {
        request.setCharacterEncoding("UTF-8");
        UUID creditId = UUID.fromString(request.getParameter("creditId"));
        UUID customerId = UUID.fromString(request.getParameter("customerId"));
        Credit credit = creditService.get(creditId);
        if (!ValidationUtil.isValidCreditAmount(request.getParameter("creditAmount"), credit)) {
            return getCreditProposalForm(true);
        }
        CreditProposal creditProposal = new CreditProposal();
        creditProposal.setCreditAmount(new BigDecimal(request.getParameter("creditAmount")));
        creditProposal.setCredit(credit);
        creditProposal.setCustomer(customerService.get(customerId));
        List<Payment> payments = PaymentsUtil.createNew(creditProposal, credit);
        creditProposal.setPayments(payments);
        ModelAndView modelAndView = new ModelAndView("creditProposalWithPaymentsForm");
        modelAndView.addObject("creditProposal", creditProposal);
        modelAndView.addObject("creditBalancePerMonth", PaymentsUtil.calcCreditBalancePerMonth(payments));
        modelAndView.addObject("percentSum", PaymentsUtil.calcPercentSum(payments));
        return modelAndView;
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

    private ModelAndView getCreditProposalForm(boolean hasErrors) {
        ModelAndView modelAndView = new ModelAndView("creditProposalForm");
        modelAndView.addObject("customers", customerService.getAll());
        modelAndView.addObject("credits", creditService.getAll());
        if (hasErrors) {
            modelAndView.addObject("creditAmountError", true);
        }
        return modelAndView;
    }
}
