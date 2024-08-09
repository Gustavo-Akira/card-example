package br.com.gustavoakira.cards.infrastructure.repository;

import br.com.gustavoakira.cards.domain.CardAccount;
import br.com.gustavoakira.cards.infrastructure.repository.entity.CardAccountEntity;
import org.instancio.Instancio;
import org.instancio.Model;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.instancio.Select.field;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
class SQLCardAccountRepositoryTest {

    @Autowired
    private SQLCardAccountRepository repository;

    Model<CardAccount> validCardAccountModel = Instancio.of(CardAccount.class).set(field("expirationDate"), LocalDateTime.now().plusDays(5)).toModel();


    @Test
    void shouldSaveCardAccount() {
        CardAccount account = Instancio.create(validCardAccountModel);
        repository.save(account);
        CardAccount saved = repository.findById(account.getAccountNumber());
        assertEquals(account.getAccountNumber(),saved.getAccountNumber());
    }

    @Test
    void findById() {
        CardAccount account = Instancio.create(validCardAccountModel);
        repository.save(account);
        CardAccount saved = repository.findById(account.getAccountNumber());
        assertEquals(account.getAccountNumber(),saved.getAccountNumber());
    }

    @Test
    void findAll() {
        CardAccount account = Instancio.create(validCardAccountModel);
        repository.save(account);
        List<CardAccount> saved = repository.findAll();
        assertEquals(1,saved.size());
        assertEquals(account,saved.get(0));
    }
}