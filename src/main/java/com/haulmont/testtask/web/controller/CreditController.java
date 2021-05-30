package com.haulmont.testtask.web.controller;

import com.haulmont.testtask.model.Credit;
import com.haulmont.testtask.service.BankService;
import com.haulmont.testtask.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
import java.util.UUID;

@Controller
public class CreditController {
    @Autowired
    private CreditService service;
    @Autowired
    private BankService bankService;

    @PostMapping("/credits")
    public String createOrUpdate(@Valid @ModelAttribute("credit") Credit credit, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("banks", bankService.getAll());
            return "creditForm";
        }
        if (credit.getId() == null) {
            service.create(credit);
        }
        else {
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
}
