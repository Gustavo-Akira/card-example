package br.com.gustavoakira.cards.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction{
    private String transactionId;
    private LocalDateTime transactionDate;
    private BigDecimal amount;
    private String type;
    private CardAccount account;

    public Transaction(String transactionId, LocalDateTime transactionDate, BigDecimal amount, String type, CardAccount account) {
        this.transactionId = transactionId;
        this.transactionDate = transactionDate;
        this.amount = amount;
        this.type = type;
        this.account = account;
    }



    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public CardAccount getAccount() {
        return account;
    }

    public void setAccount(CardAccount account) {
        this.account = account;
    }

    public void makeTransaction() {
        if(type.equals("Positive")){
            this.account.charge(amount);
        }else{
            this.account.makePayment(amount);
        }
    }
}
