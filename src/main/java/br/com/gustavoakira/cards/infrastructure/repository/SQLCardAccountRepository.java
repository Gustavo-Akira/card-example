package br.com.gustavoakira.cards.infrastructure.repository;

import br.com.gustavoakira.cards.domain.CardAccount;
import br.com.gustavoakira.cards.domain.CardAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SQLCardAccountRepository implements CardAccountRepository {
    @Autowired
    private SpringSQlCardAccountRepository repository;

    @Override
    public void save(List<CardAccount> cardAccounts) {
        cardAccounts.forEach(cardAccount->{
            this.repository.save(cardAccount);
        });
    }

    @Override
    public CardAccount findById(String id) {
        return this.repository.findById(id).orElseThrow();
    }

    @Override
    public List<CardAccount> findAll() {
        return this.repository.findAll();
    }
}
