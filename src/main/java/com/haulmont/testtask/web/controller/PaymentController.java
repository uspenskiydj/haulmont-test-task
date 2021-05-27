package com.haulmont.testtask.web.controller;

import com.haulmont.testtask.model.Payment;
import com.haulmont.testtask.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Controller
public class PaymentController {
    @Autowired
    private PaymentService service;

    @PostMapping("/payments")
    public String createOrUpdate(HttpServletRequest request) throws IOException {
        Payment payment = getPayment(request);
        UUID creditProposalId = UUID.fromString(request.getParameter("creditProposalId"));
        if (!StringUtils.hasText(request.getParameter("id"))) {
            service.create(payment, creditProposalId);
        }
        else {
            payment.setId(UUID.fromString(request.getParameter("id")));
            service.update(payment, creditProposalId);
        }
        return "redirect:/payments";
    }

    @GetMapping("/banks/delete")
    public String delete(HttpServletRequest request, @RequestParam String id) {
        UUID creditProposalId = UUID.fromString(request.getParameter("creditProposalId"));
        service.delete(UUID.fromString(id), creditProposalId);
        return "redirect:/payments";
    }

    @GetMapping("/payments")
    public String getAll(HttpServletRequest request, Model model) {
        UUID creditProposalId = UUID.fromString(request.getParameter("creditProposalId"));
        model.addAttribute("payments", service.getAll(creditProposalId));
        return "payments";
    }

    private Payment getPayment(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        return new Payment(LocalDate.parse(request.getParameter("date")),
                new BigDecimal(request.getParameter("totalAmount")),
                new BigDecimal(request.getParameter("amountOfCreditBodyRepayment")),
                new BigDecimal(request.getParameter("amountOfInterestRepayment")), null);
    }
}
