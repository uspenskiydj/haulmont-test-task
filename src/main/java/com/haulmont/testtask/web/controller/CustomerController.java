package com.haulmont.testtask.web.controller;

import com.haulmont.testtask.model.Customer;
import com.haulmont.testtask.service.BankService;
import com.haulmont.testtask.service.CustomerService;
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
public class CustomerController {
    @Autowired
    private CustomerService service;
    @Autowired
    private BankService bankService;

    @PostMapping("/customers")
    public String createOrUpdate(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("banks", bankService.getAll());
            return "customerForm";
        }
        if (customer.getId() == null) {
            service.create(customer);
        }
        else {
            service.update(customer);
        }
        return "redirect:/customers";
    }

    @GetMapping("/customers/delete")
    public String delete(@RequestParam String id) {
        service.delete(UUID.fromString(id));
        return "redirect:/customers";
    }

    @GetMapping("customerCreateForm")
    public String getCustomerToCreate(Model model) {
        final Customer customer = new Customer();
        model.addAttribute("customer", customer);
        model.addAttribute("banks", bankService.getAll());
        return "customerForm";
    }

    @GetMapping("customerUpdateForm")
    public String getCustomerToUpdate(Model model, @RequestParam String id) {
        final Customer customer = service.get(UUID.fromString(id));
        model.addAttribute("customer", customer);
        model.addAttribute("banks", bankService.getAll());
        return "customerForm";
    }

    @GetMapping("/customers")
    public String getAll(Model model) {
        model.addAttribute("customers", service.getAll());
        return "customers";
    }

    @GetMapping("/customersByBank")
    public String getAllByBank(@RequestParam String bankId, Model model) {
        model.addAttribute("customers", service.getAllByBank(UUID.fromString(bankId)));
        return "customers";
    }
}
