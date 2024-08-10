package br.com.gustavoakira.cards.api;

import br.com.gustavoakira.cards.api.dto.in.CreateCardAccount;
import br.com.gustavoakira.cards.api.dto.in.UpdateCardAccount;
import br.com.gustavoakira.cards.api.dto.out.CardAccountOutDTO;
import br.com.gustavoakira.cards.domain.CardAccountRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class CardAccountApi {
    private final CardAccountRepository repository;

    public CardAccountApi(CardAccountRepository repository) {
        this.repository = repository;
    }

    public void save(CreateCardAccount createCardHolder){
        this.repository.save(createCardHolder.toDomain());
    }

    public void update(UpdateCardAccount cardHolder){
        this.repository.save(cardHolder.toDomain());
    }

    public List<CardAccountOutDTO> findAll(){
        return this.repository.findAll().stream().map(CardAccountOutDTO::fromDomain).collect(Collectors.toList());
    }

    public void remove(String accountNumber){
        this.repository.remove(accountNumber);
    }

    public CardAccountOutDTO findById(String accountNumber){
        return CardAccountOutDTO.fromDomain(this.repository.findById(accountNumber));
    }
}
