package com.haulmont.testtask.web.controller;

import com.haulmont.testtask.model.Bank;
import com.haulmont.testtask.service.BankService;
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
import java.util.UUID;

@Controller
public class BankController {
    @Autowired
    private BankService service;

    @PostMapping("/banks")
    public String createOrUpdate(HttpServletRequest request) throws IOException {
        Bank bank = getBank(request);
        if (!StringUtils.hasText(request.getParameter("id"))) {
            service.create(bank);
        }
        else {
            bank.setId(UUID.fromString(request.getParameter("id")));
            service.update(bank);
        }
        return "redirect:/banks";
    }

    @GetMapping("/banks/delete")
    public String delete(@RequestParam String id) {
        service.delete(UUID.fromString(id));
        return "redirect:/banks";
    }

    @GetMapping("/banks")
    public String getAll(Model model) {
        model.addAttribute("banks", service.getAll());
        return "banks";
    }

    private Bank getBank(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        return new Bank();
    }
}
