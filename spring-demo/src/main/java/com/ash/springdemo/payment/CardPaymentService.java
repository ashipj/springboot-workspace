package com.ash.springdemo.payment;

import org.springframework.stereotype.Service;

@Service
public class CardPaymentService implements PaymentService {
    @Override
    public boolean isValidPayment(PaymentInfo cardInfo) {
        // Write code to validate the card information contained in cardInfo
//        // Return true if valid, false otherwise
//
//        /**
//         * Card payment validation logic goes here.
//         * For now, we'll just return false.
//         * This will cause the payment to fail.
//         * You can replace this with your own validation logic.
//         * You can also add more payment services to this class
//         * to support different payment types.
//         *
//         * For example, you could add a PayPalPaymentService
//         * to support PayPal payments.
//         * Or you could add a StripePaymentService
//         * to support Stripe payments.
//         * Or you could add a PayStackPaymentService
//         * to support PayStack payments.
//         * Or you could add a CoinbasePaymentService
//         * to support Coinbase payments.
//         * Or you could add a FlutterwavePaymentService
//         * to support Flutterwave payments.
//         * Or you could add a SquarePaymentService
//         * to support Square payments.
//         * Or you could add a PayPalPaymentService
//         * to support PayPal payments.
//         * Or you could add a StripePaymentService
//         */
//
//        /**
//         * TODO : Implement card payment validation logic here.
//         */
//        System.out.println("Card payment validation logic goes here.");
//
//        // Validate the expiry date of the card.
//        // Write code to validate expiry date of the card in cardInfo.
        return false;
    }
    public boolean isValidPayment(CardInfo cardInfo) {
        // TODO : Card expiryYear should not be a past year. Get current year dynamically rather than hardcoded.
//        System.out.println("Card payment validation logic goes here.");
//
//        // Write code to validate the card information contained in cardInfo
//        // Return true if valid, false otherwise
//
//        // Write code to validate the expiry date from cardInfo
//        if ( cardInfo.getExpiryYear()  < 2023 && cardInfo.getExpiryMonth() < 5 ) {
//            return false;
//        }
//
//        // check if card has expiry year greater than current year
//        if ( cardInfo.getExpiryYear()  > 2023 ) {
//            return false;
//        }
//
//        // card expiryYear should not be a past year
//        if ( cardInfo.getExpiryYear()  < 2023 ) {
//            return false;
//        }
//
//        // card expiryYear should not be a past year. Get current year dynamically rather than hardcoded.
//        int currentYear = 2023;
//        if ( cardInfo.getExpiryYear()  < currentYear ) {
//            return false;
//        }
//
//
//        // write a code block that applies luhn algorithm to validate cardInfo.getCardNumber()
//        // write a code block that checks if cardInfo.getCardNumber() is a valid card number.
//        if ( cardInfo.getCardNumber() % 2 == 0 ) {
//            return false;
//        }




        /**
         * Card payment validation logic goes here.
         * For now, we'll just return false.
         * This will cause the payment to fail.
         * You can replace this with your own validation logic.
         * You can also add more payment services to this class
         * to support different payment types.
         *
         * For example, you could add a PayPalPaymentService
         * to support PayPal payments.
         * Or you could add a StripePaymentService
         * to support Stripe payments.
         * Or you could add a PayStackPaymentService
         * to support PayStack payments.
         * Or you could add a CoinbasePaymentService
         * to support Coinbase payments.
         * Or you could add a FlutterwavePaymentService
         * to support Flutterwave payments.
         * Or you could add a SquarePaymentService
         * to support Square payments.
         * Or you could add a PayPalPaymentService
         * to support PayPal payments.
     */
        return false;
    }

}
