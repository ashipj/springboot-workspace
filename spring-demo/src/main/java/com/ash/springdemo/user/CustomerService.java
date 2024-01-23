package com.ash.springdemo.user;

import com.ash.springdemo.payment.CardInfo;
import com.ash.springdemo.payment.CardPaymentService;
import com.ash.springdemo.user.dto.CustomerRegistrationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerReposiory customerReposiory;

    @Autowired
    CardPaymentService cardPaymentService;

    // create a method list all Customer users in the database.
    public Iterable<Customer> listAllCustomers() {
        // use customerRepository to get list of Customers in database.
        return customerReposiory.findAll();
    }

    // create a customer registration action that accepts CustomerRegistrationDTO as parameter
    public Customer registerCustomer(CustomerRegistrationDTO customerRegistrationDTO) {
        // TODO : Use customerRepository to check if user with same email exist in database. If user with same email exist, throw an exception.

        // TODO : validate email in customerRegistrationDTO using regex. If email is invalid, throw an exception.
        if ( customerRegistrationDTO.getEmail().length() < 5 ) {
            throw new RuntimeException("Invalid email");
        }
        if ( !customerRegistrationDTO.getEmail().contains("@") ) {
            throw new RuntimeException("Invalid email");
        }


        // check if user already exists in database
//        if ( customerReposiory.findByUsername(customerRegistrationDTO.getUsername()) != null ) {
//            throw new RuntimeException("User already exists");
//        }

        // check if email already exists in database
        if ( customerReposiory.findByEmail(customerRegistrationDTO.getEmail()) != null ) {
            throw new RuntimeException("Email already exists");
        }

        // Copy data from customerRegistrationDTO to CardInfo
        Customer customer = new Customer();
//        customer.setFirstName(customerRegistrationDTO.getFirstName());
//        customer.setLastName(customerRegistrationDTO.getLastName());
        customer.setEmail(customerRegistrationDTO.getEmail());
        customer.setPassword(customerRegistrationDTO.getPassword());
        customer.setPhone(customerRegistrationDTO.getPhone());
        customer.setAddress(customerRegistrationDTO.getAddress());
        customer.setCity(customerRegistrationDTO.getCity());
        customer.setState(customerRegistrationDTO.getState());
        customer.setZip(customerRegistrationDTO.getZip());
//        customer.setCountry(customerRegistrationDTO.getCountry());
//        customer.setUsername(customerRegistrationDTO.getUsername());
//        customer.setRole(customerRegistrationDTO.getRole());

        CardInfo cardInfo = new CardInfo();
        // copy  data from customerRegistrationDTO to cardInfo
        cardInfo.setCardNumber(customerRegistrationDTO.getCardNumber());
        cardInfo.setExpiryMonth(customerRegistrationDTO.getExpiryMonth());
        cardInfo.setExpiryYear(customerRegistrationDTO.getExpiryYear());
        cardInfo.setCvv(customerRegistrationDTO.getCvv());

        cardPaymentService.isValidPayment(cardInfo); // call isValidPayment method from CardPaymentService class.

        return customerReposiory.save(customer); // save the customer object to the database.
    }
}
