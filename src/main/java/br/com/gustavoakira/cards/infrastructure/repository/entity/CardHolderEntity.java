package br.com.gustavoakira.cards.infrastructure.repository.entity;

import br.com.gustavoakira.cards.domain.CardAccount;
import br.com.gustavoakira.cards.domain.CardHolder;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
public class CardHolderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String name;
    private String address;
    @Column(name = "phone-number")
    private String phoneNumber;

    public static CardHolderEntity fromDomain(CardHolder domain){
        CardHolderEntity entity = new CardHolderEntity();
        entity.setId(domain.getId());
        entity.setName(domain.getName());
        entity.setAddress(domain.getAddress());
        entity.setPhoneNumber(domain.getPhoneNumber());
        return entity;
    }


    public CardHolder toDomain(List<CardAccount> cardAccounts){
        return new CardHolder(id,name,address,phoneNumber,cardAccounts);
    }
}
