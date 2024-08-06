package br.com.gustavoakira.cards.domain;

import br.com.gustavoakira.cards.domain.exception.CardNotValidException;
import org.instancio.Instancio;
import org.instancio.Model;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.instancio.Select.field;
import static org.junit.jupiter.api.Assertions.*;

class CardAccountTest {

    Model<CardAccount>  validCardAccountModel = Instancio.of(CardAccount.class).set(field("expirationDate"),LocalDateTime.now().plusDays(5)).toModel();

    Model<CardAccount>  invalidCardAccountModel = Instancio.of(CardAccount.class).set(field("expirationDate"),LocalDateTime.now().minusDays(1)).toModel();


    @Test
    void shouldReturnTrueWhenValidateCardAndCardIsValid(){

        CardAccount account = Instancio.create(validCardAccountModel);

        assertTrue(account.validateCard());
    }

    @Test
    void shouldCreateCardAccountWithNumberWhenCallCreateAccount(){
        CardAccount cardAccount = CardAccount.createAccount("", BigDecimal.valueOf(0.0),"black", LocalDateTime.now().plusDays(5));
        assertNotNull(cardAccount.getAccountNumber());
        assertNotNull(cardAccount);
    }

    @Test
    void shouldChargeWhenCardIsValid(){
        CardAccount cardAccount = Instancio.create(validCardAccountModel);
        BigDecimal oldValue = cardAccount.getBalance();
        cardAccount.charge(BigDecimal.TEN);
        assertEquals(oldValue.add(BigDecimal.TEN), cardAccount.getBalance());
    }

    @Test
    void shouldMakePaymentWhenCardIsValidAndBalanceIsEnough(){
        CardAccount cardAccount = Instancio.create(validCardAccountModel);
        BigDecimal oldValue = cardAccount.getBalance();
        cardAccount.makePayment(BigDecimal.ONE);
        assertEquals(oldValue.subtract(BigDecimal.ONE), cardAccount.getBalance());
    }


    @Test
    void shouldThrownCardNotValidExceptionWhenChargeInvalidCard(){
        CardAccount account = Instancio.create(invalidCardAccountModel);
        assertThrows(CardNotValidException.class,()->account.charge(BigDecimal.ONE));
    }

    @Test
    void shouldThrownBalanceExceptionWhenCardIsValidAndBalanceIsNotEnoughToMakePayment(){

    }
    @Test
    void shouldThrownCardNotValidExceptionWhenMakePaymentWithInvalidCard(){

    }

    @Test
    void shouldReturnFalseWhenValidateCardAndInInvalid(){
        CardAccount account = Instancio.create(invalidCardAccountModel);
        assertFalse(account.validateCard());
    }


}