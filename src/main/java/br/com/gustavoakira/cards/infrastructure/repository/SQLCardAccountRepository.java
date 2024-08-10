package br.com.gustavoakira.cards.infrastructure.repository;

import br.com.gustavoakira.cards.domain.CardAccount;
import br.com.gustavoakira.cards.domain.CardAccountRepository;
import br.com.gustavoakira.cards.infrastructure.repository.entity.CardAccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SQLCardAccountRepository implements CardAccountRepository {
    @Autowired
    private SpringSQlCardAccountRepository repository;

    @Autowired
    private SpringSQLCardHolderRepository cardHolderRepository;

    @Override
    public void save(List<CardAccount> cardAccounts) {
        cardAccounts.forEach(cardAccount->{
            CardAccountEntity entity = CardAccountEntity.fromDomain(cardAccount);
            entity.setCardHolder(cardHolderRepository.findByName(cardAccount.getCardHolderName()).orElseThrow());
            this.repository.save(entity);
        });
    }

    @Override
    public CardAccount findById(String id) {
        return this.repository.findById(id).orElseThrow().toDomain();
    }

    @Override
    public List<CardAccount> findAll() {
        return this.repository.findAll().stream().map(CardAccountEntity::toDomain).toList();
    }

    @Override
    public void remove(String accountNumber) {
        this.repository.deleteById(accountNumber);
    }
}
