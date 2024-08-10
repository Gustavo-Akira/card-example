package br.com.gustavoakira.cards.infrastructure.repository.entity;

import br.com.gustavoakira.cards.domain.CardAccount;
import br.com.gustavoakira.cards.domain.Transaction;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class TransactionEntity implements Serializable {
    @Id
    private String transactionId;
    @Column(name = "date")
    private LocalDateTime transactionDate;
    private BigDecimal amount;
    private String type;
    @ManyToOne(optional = false, cascade = CascadeType.REMOVE)
    private CardAccountEntity account;

    public static TransactionEntity fromDomain(Transaction transaction){
        TransactionEntity entity = new TransactionEntity();
        entity.setTransactionId(transaction.getTransactionId());
        entity.setTransactionDate(transaction.getTransactionDate());
        entity.setAmount(transaction.getAmount());
        entity.setType(transaction.getType());
        entity.setAccount(CardAccountEntity.fromDomain(transaction.getAccount()));
        return entity;
    }

    public Transaction toDomain(){
        return new Transaction(transactionId,transactionDate,amount,type,account.toDomain());
    }
}
