package br.com.gustavoakira.cards.infrastructure.repository.entity;

import br.com.gustavoakira.cards.domain.CardAccount;
import br.com.gustavoakira.cards.domain.CardHolder;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class CardAccountEntity implements Serializable {
    @Id
    private String accountNumber;
    @ManyToOne(optional = false, cascade = CascadeType.REMOVE)
    private CardHolderEntity cardHolder;
    @Column(name = "balance")
    private BigDecimal balance;
    @Column(name = "type")
    private String cardType;
    @Column(name = "expiration")
    private LocalDateTime expirationDate;

    public static CardAccountEntity fromDomain(CardAccount account){
        CardHolderEntity cardHolderEntity = new CardHolderEntity();
        cardHolderEntity.setName(account.getCardHolderName());
        CardAccountEntity entity = new CardAccountEntity();
        entity.setAccountNumber(account.getAccountNumber());
        entity.setBalance(account.getBalance());
        entity.setCardType(account.getCardType());
        entity.setExpirationDate(account.getExpirationDate());
        entity.setCardHolder(cardHolderEntity);
        return entity;
    }

    public CardAccount toDomain(){
        return new CardAccount(accountNumber,cardHolder.getName(),balance,cardType,expirationDate);
    }
}
