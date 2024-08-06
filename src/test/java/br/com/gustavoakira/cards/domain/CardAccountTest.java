package br.com.gustavoakira.cards.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CardAccountTest {
    @Test
    void shouldReturnTrueWhenValidateCardAndCardIsValid(){

    }

    @Test
    void shouldCreateCardAccountWithNumberWhenCallCreateAccount(){
        CardAccount cardAccount = CardAccount.createAccount("", BigDecimal.valueOf(0.0),"black", LocalDateTime.now().plusDays(5));
        assertNotNull(cardAccount.accountNumber());
        assertNotNull(cardAccount);
    }

    @Test
    void shouldChargeWhenCardIsValid(){

    }

    @Test
    void shouldMakePaymentWhenCardIsValidAndBalanceIsEnough(){

    }

    @Test
    void shouldShowBalance(){

    }

    @Test
    void shouldThrownCardNotValidExceptionWhenChargeInvalidCard(){

    }

    @Test
    void shouldThrownBalanceExceptionWhenCardIsValidAndBalanceIsNotEnoughToMakePayment(){

    }
    @Test
    void shouldThrownCardNotValidExceptionWhenMakePaymentWithInvalidCard(){

    }

    @Test
    void shouldReturnFalseWhenValidateCardAndInInvalid(){

    }


}