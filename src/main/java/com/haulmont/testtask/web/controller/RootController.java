package com.haulmont.testtask.web.controller;

import com.haulmont.testtask.service.CreditService;
import com.haulmont.testtask.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CreditService creditService;

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/customers")
    public String getCustomers(Model model) {
        model.addAttribute("customers", customerService.getAll());
        return "customers";
    }

    @GetMapping("/credits")
    public String getCredits(Model model) {
        model.addAttribute("credits", creditService.getAll());
        return "credits";
    }
}
