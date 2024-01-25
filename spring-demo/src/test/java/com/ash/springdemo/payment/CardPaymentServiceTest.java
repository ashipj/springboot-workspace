package com.ash.springdemo.payment;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//annotate this class, so that it becomes test class
@SpringBootTest(classes = CardPaymentService.class)
class CardPaymentServiceTest {

    @Test
    void contextLoads() { }

    // When CardInfo object is not null and contain a valid credit-card number, a dummy cardholders name, a future expiryYear, an expiryMonth and a valid CVV, then the isValidPayment method should return true
    @Test
    void isValidPayment_validCardInfo_returnsTrue() {
        // Arrange
//         CardInfo cardInfo = new CardInfo("0000000000000000", "John Doe", 2023, 5, "123");

        // Use builder to create CardInfo object with valid credit-card number, a dummy cardholders name, a future expiryYear, an expiryMonth and a valid CVV
        CardInfo cardInfo = CardInfo.builder()
                .cardNumber(1233123312331233L)
                .cardHolderName("John Doe")
                .expiryYear(2023)
                .expiryMonth(5)
                .cvv(123)
                .build();

        // Act
        boolean isValidPayment = new CardPaymentService().isValidPayment(cardInfo);

        // Assert
        assert isValidPayment;
    }

    // When CardInfo Object is null, then the isValidate() method returns false
    @Test
    void isValidPayment_nullCardInfo_returnsFalse() {
        // Arrange
        CardInfo cardInfo = null;

        // Act
        boolean isValidPayment = new CardPaymentService().isValidPayment(cardInfo);

        // Assert
        assert !isValidPayment;
    }

    // When CardInfo object doesnt contain a cardNumber, then the isValidPayment() method returns false
    @Test
    void isValidPayment_noCardNumber_returnsFalse() {
        // Arrange
        CardInfo cardInfo = CardInfo.builder()
                .cardHolderName("John Doe")
                .expiryYear(2023)
                .expiryMonth(5)
                .cvv(123)
                .build();

        // Act
        boolean isValidPayment = new CardPaymentService().isValidPayment(cardInfo);

        // Assert
        assert !isValidPayment;
    }

    // When cardInfo doesnt contain a cardHolderName, then the isValidPayment() method returns false
    @Test
    void isValidPayment_noCardHolderName_returnsFalse() {
        // Arrange
        CardInfo cardInfo = CardInfo.builder()
                .cardNumber(1233123312331233L)
                .expiryYear(2023)
                .expiryMonth(5)
                .cvv(123)
                .build();

        // Act
        boolean isValidPayment = new CardPaymentService().isValidPayment(cardInfo);

        // Assert
        assert !isValidPayment;
    }

    // When cardInfo doesnt contain a expiryYear, then the isValidPayment() method returns false
    @Test
    void isValidPayment_noExpiryYear_returnsFalse() {
        // Arrange
        CardInfo cardInfo = CardInfo.builder()
                .cardNumber(1233123312331233L)
                .cardHolderName("John Doe")
                .expiryMonth(5)
                .cvv(123)
                .build();

        // Act
        boolean isValidPayment = new CardPaymentService().isValidPayment(cardInfo);

        // Assert
        assert !isValidPayment;
    }

    // When cardInfo doesnt contain a expiryMonth, then the isValidPayment() method returns false
    @Test
    void isValidPayment_noExpiryMonth_returnsFalse() {
        // Arrange
        CardInfo cardInfo = CardInfo.builder()
                .cardNumber(1233123312331233L)
                .cardHolderName("John Doe")
                .expiryYear(2023)
                .cvv(123)
                .build();

        // Act
        boolean isValidPayment = new CardPaymentService().isValidPayment(cardInfo);

        // Assert
        assert !isValidPayment;
    }

    // When cardInfo doesnt contain a CVV, then the isValidPayment() method returns false
    @Test
    void isValidPayment_noCVV_returnsFalse() {
        // Arrange
        CardInfo cardInfo = CardInfo.builder()
                .cardNumber(1233123312331233L)
                .cardHolderName("John Doe")
                .expiryYear(2023)
                .expiryMonth(5)
                .build();

        // Act
        boolean isValidPayment = new CardPaymentService().isValidPayment(cardInfo);

        // Assert
        assert !isValidPayment;
    }

    // When cardInfo contains a cardNumber, but it is not a valid credit-card number with only contains 10 digits, then the isValidPayment() method returns false
    @Test
    void isValidPayment_invalidCardNumber_returnsFalse() {
        // Arrange
        CardInfo cardInfo = CardInfo.builder()
                .cardNumber(123456789L)
                .cardHolderName("John Doe")
                .expiryYear(2023)
                .expiryMonth(5)
                .cvv(123)
                .build();

        // Act
        boolean isValidPayment = new CardPaymentService().isValidPayment(cardInfo);

        // Assert
        assert !isValidPayment;
    }

    // When cardInfo contains an expiryYear. But, if the expiryYear has already passed, then the isValidPayment() method returns false
    @Test
    void isValidPayment_expiredCard_returnsFalse() {
        // Arrange
        CardInfo cardInfo = CardInfo.builder()
                .cardNumber(1233123312331233L)
                .cardHolderName("John Doe")
                .expiryYear(2000)
                .expiryMonth(5)
                .cvv(123)
                .build();

        // Act
        boolean isValidPayment = new CardPaymentService().isValidPayment(cardInfo);

        // Assert
        assert !isValidPayment;
    }

    // When expiryYear in cardInfo is current year and if the expiryMonth has passed, then the isValidPayment() method returns false
    @Test
    void isValidPayment_expiredCard_returnsFalse2() {
        // Arrange
        CardInfo cardInfo = CardInfo.builder()
                .cardNumber(1233123312331233L)
                .cardHolderName("John Doe")
                .expiryYear(2023)
                .expiryMonth(1)
                .cvv(123)
                .build();

        // Act
        boolean isValidPayment = new CardPaymentService().isValidPayment(cardInfo);

        // Assert
        assert !isValidPayment;
    }
}