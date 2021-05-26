package com.haulmont.testtask.web.controller;

import com.haulmont.testtask.model.Bank;
import com.haulmont.testtask.model.Customer;
import com.haulmont.testtask.service.CustomerService;
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
public class CustomerController {
    @Autowired
    private CustomerService service;

    @PostMapping("/customers")
    public String createOrUpdate(HttpServletRequest request) throws IOException {
        Customer customer = getCustomer(request);
        if (!StringUtils.hasText(request.getParameter("id"))) {
            service.create(customer);
        }
        else {
            customer.setId(UUID.fromString(request.getParameter("id")));
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
        return "customerForm";
    }

    @GetMapping("customerUpdateForm")
    public String getCustomerToUpdate(Model model, @RequestParam String id) {
        final Customer customer = service.get(UUID.fromString(id));
        model.addAttribute("customer", customer);
        return "customerForm";
    }

    @GetMapping("/customers")
    public String getAll(Model model) {
        model.addAttribute("customers", service.getAll());
        return "customers";
    }

    private Customer getCustomer(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        return new Customer(request.getParameter("FIO"),
                request.getParameter("phoneNumber"),
                request.getParameter("email"),
                request.getParameter("passportNumber"),
                new Bank(UUID.fromString(request.getParameter("bank"))));
    }
}
