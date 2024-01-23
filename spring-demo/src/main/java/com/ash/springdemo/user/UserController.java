package com.ash.springdemo.user;

import com.ash.springdemo.user.dto.CustomerRegistrationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// TODO : Add annotations to make this class a REST controller with all requests starting /user
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    CustomerService customerService;

    // TODO : create an action that returns a list of users
    @RequestMapping("/list")
    public Iterable<Customer> list() {
        // get list of Customers
        Iterable<Customer> customers = customerService.listAllCustomers();
        return customers;
    }

    // TODO : Create an to register a user. It should accept a CustomerRegistrationDTO as parameter
    @RequestMapping("/register")
    public Customer register(CustomerRegistrationDTO customerRegistrationDTO) {
        // TODO : call customerService's registerCustomer method and return the result
        return customerService.registerCustomer(customerRegistrationDTO);
    }

}
