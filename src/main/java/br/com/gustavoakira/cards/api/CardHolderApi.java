package br.com.gustavoakira.cards.api;

import br.com.gustavoakira.cards.api.dto.in.CreateCardHolder;
import br.com.gustavoakira.cards.api.dto.in.UpdateCardHolder;
import br.com.gustavoakira.cards.api.dto.out.CardHolderOutDTO;
import br.com.gustavoakira.cards.domain.CardHolderRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class CardHolderApi {
    private final CardHolderRepository repository;

    public CardHolderApi(CardHolderRepository repository) {
        this.repository = repository;
    }

    public void save(CreateCardHolder createCardHolder){
        this.repository.save(createCardHolder.toDomain());
    }

    public void update(UpdateCardHolder cardHolder){
        this.repository.save(cardHolder.toDomain());
    }

    public List<CardHolderOutDTO> findAll(){
        return this.repository.findAll().stream().map(CardHolderOutDTO::fromDomain).collect(Collectors.toList());
    }

    public CardHolderOutDTO findByName(String name){
        return CardHolderOutDTO.fromDomain(this.repository.findByName(name));
    }

    public CardHolderOutDTO findById(Long id){
        return CardHolderOutDTO.fromDomain(this.repository.findById(id));
    }
}
