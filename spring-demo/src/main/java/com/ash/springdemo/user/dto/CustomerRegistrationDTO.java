package com.ash.springdemo.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerRegistrationDTO {

    private String name;
    private String email;
    private String password;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String zip;

    private long cardNumber;
    private int expiryMonth;
    private int expiryYear;
    private int cvv;
    private String cardHolderName;
}
