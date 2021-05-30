package com.haulmont.testtask.web.controller;

import com.haulmont.testtask.model.Bank;
import com.haulmont.testtask.model.Credit;
import com.haulmont.testtask.service.BankService;
import com.haulmont.testtask.service.CreditService;
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
import java.util.UUID;

@Controller
public class CreditController {
    @Autowired
    private CreditService service;
    @Autowired
    private BankService bankService;

    @PostMapping("/credits")
    public String createOrUpdate(HttpServletRequest request) throws IOException {
        Credit credit = getCredit(request);
        if (!StringUtils.hasText(request.getParameter("id"))) {
            service.create(credit);
        } else {
            credit.setId(UUID.fromString(request.getParameter("id")));
            service.update(credit);
        }
        return "redirect:/credits";
    }

    @GetMapping("/credits/delete")
    public String delete(@RequestParam String id) {
        service.delete(UUID.fromString(id));
        return "redirect:/credits";
    }

    @GetMapping("creditCreateForm")
    public String getCreditToCreate(Model model) {
        final Credit credit = new Credit();
        model.addAttribute("credit", credit);
        model.addAttribute("banks", bankService.getAll());
        return "creditForm";
    }

    @GetMapping("creditUpdateForm")
    public String getCreditToUpdate(Model model, @RequestParam String id) {
        final Credit credit = service.get(UUID.fromString(id));
        model.addAttribute("credit", credit);
        model.addAttribute("banks", bankService.getAll());
        return "creditForm";
    }

    @GetMapping("/credits")
    public String getAll(Model model) {
        model.addAttribute("credits", service.getAll());
        return "credits";
    }

    @GetMapping("/creditsByBank")
    public String getAllByBank(@RequestParam String bankId, Model model) {
        model.addAttribute("credits", service.getAllByBank(UUID.fromString(bankId)));
        return "credits";
    }

    private Credit getCredit(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        return new Credit(new BigDecimal(request.getParameter("limit")),
                Double.parseDouble(request.getParameter("interestRate")),
                bankService.get(UUID.fromString(request.getParameter("bankId"))));
    }
}
