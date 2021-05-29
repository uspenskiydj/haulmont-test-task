package com.haulmont.testtask.web.controller;

import com.haulmont.testtask.model.Payment;
import com.haulmont.testtask.service.PaymentService;
import com.haulmont.testtask.util.PaymentsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
public class PaymentController {
    @Autowired
    private PaymentService service;

    @GetMapping("/paymentsByCreditProposal")
    public String getAll(@RequestParam String creditProposalId, Model model) {
        List<Payment> payments = service.getAll(UUID.fromString(creditProposalId));
        model.addAttribute("payments", payments);
        model.addAttribute("creditBalancePerMonth", PaymentsUtil.calcCreditBalancePerMonth(payments));
        return "payments";
    }
}
