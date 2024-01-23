package com.ash.springdemo.payment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardInfo implements PaymentInfo {
    private long cardNumber;
    private int expiryMonth;
    private int expiryYear;
    private int cvv;
    private String cardHolderName;
}
