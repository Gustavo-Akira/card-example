package br.com.gustavoakira.cards.domain;

import br.com.gustavoakira.cards.domain.exception.BalanceNotEnoughException;
import br.com.gustavoakira.cards.domain.exception.CardNotValidException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class CardAccount {
    private String accountNumber;
    private String cardHolderName;
    private BigDecimal balance;
    private String cardType;
    private LocalDateTime expirationDate;

    public CardAccount(String accountNumber, String cardHolderName, BigDecimal balance, String cardType, LocalDateTime expirationDate) {
        this.accountNumber = accountNumber;
        this.cardHolderName = cardHolderName;
        this.balance = balance;
        this.cardType = cardType;
        this.expirationDate = expirationDate;
    }

    public static CardAccount createAccount(String cardHolderName, BigDecimal initialValue, String type, LocalDateTime expiration) {
        return new CardAccount(UUID.randomUUID().toString(), cardHolderName, initialValue, type, expiration);
    }

    public boolean validateCard() {
        return !this.expirationDate.isBefore(LocalDateTime.now());
    }

    public void makePayment(BigDecimal value) {
        if(!validateCard()){
            throw new CardNotValidException();
        }
        if(value.doubleValue() > this.balance.doubleValue()){
            throw new BalanceNotEnoughException(this.balance, value);
        }

        this.balance = this.balance.subtract(value);
    }

    public void charge(BigDecimal value) {
        if(!this.validateCard()){
            throw new CardNotValidException();
        }
        this.balance = this.balance.add(value);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }


}
