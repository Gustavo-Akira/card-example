package br.com.gustavoakira.cards.infrastructure.repository;

import br.com.gustavoakira.cards.domain.CardHolder;
import br.com.gustavoakira.cards.domain.CardHolderRepository;
import br.com.gustavoakira.cards.infrastructure.repository.entity.CardAccountEntity;
import br.com.gustavoakira.cards.infrastructure.repository.entity.CardHolderEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SQLCardHolderRepository implements CardHolderRepository {

    private final SpringSQLCardHolderRepository repository;
    private final SpringSQlCardAccountRepository cardAccountRepository;

    public SQLCardHolderRepository(SpringSQLCardHolderRepository repository, SpringSQlCardAccountRepository cardAccountRepository){

        this.repository = repository;
        this.cardAccountRepository = cardAccountRepository;
    }

    @Override
    public void save(List<CardHolder> cardHolders) {
        cardHolders.forEach(cardHolder->{
            this.repository.save(CardHolderEntity.fromDomain(cardHolder));
        });
    }

    @Override
    public CardHolder findById(Long id) {
        CardHolderEntity entity = this.repository.findById(id).orElseThrow();
        return entity.toDomain(cardAccountRepository.findByCardHolder(entity).stream().map(CardAccountEntity::toDomain).collect(Collectors.toList()));
    }

    @Override
    public List<CardHolder> findAll() {
        List<CardHolder> list = new ArrayList<>();
        for (CardHolderEntity cardHolder : this.repository.findAll()) {
            CardHolder holder = cardHolder.toDomain(cardAccountRepository.findByCardHolder(cardHolder).stream().map(CardAccountEntity::toDomain).collect(Collectors.toList()));
            list.add(holder);
        }
        return list;
    }

    @Override
    public CardHolder findByName(String name) {
        CardHolderEntity entity = this.repository.findByName(name).orElseThrow();
        return entity.toDomain(cardAccountRepository.findByCardHolder(entity).stream().map(CardAccountEntity::toDomain).collect(Collectors.toList()));
    }
}
