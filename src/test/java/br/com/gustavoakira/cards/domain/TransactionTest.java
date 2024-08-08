package br.com.gustavoakira.cards.domain;

import org.instancio.Instancio;
import org.instancio.Model;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.instancio.Select.field;
import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

    Model<Transaction> positiveType = Instancio.of(Transaction.class).set(field("type"), "Positive").toModel();

    Model<Transaction> negativeType = Instancio.of(Transaction.class).set(field("type"), "Negative").set(field("amount"), BigDecimal.valueOf(Long.MIN_VALUE)).toModel();

    @Test
    void shouldCallMakePaymentOnCardAccountWhenTransactionTypeNegative(){

        Transaction transaction = Instancio.create(negativeType);
        BigDecimal old = transaction.getAccount().getBalance();
        transaction.makeTransaction();
        assertEquals(old.subtract(transaction.getAmount()),transaction.getAccount().getBalance());
    }

    @Test
    void shouldCallChargeWhenTransactionTypeIsPositive(){
        Transaction transaction = Instancio.create(positiveType);
        BigDecimal old = transaction.getAccount().getBalance();
        transaction.makeTransaction();
        assertEquals(transaction.getAmount().add(old), transaction.getAccount().getBalance());
    }


}