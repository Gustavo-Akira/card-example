package br.com.gustavoakira.cards.infrastructure.repository;

import br.com.gustavoakira.cards.domain.CardAccount;
import br.com.gustavoakira.cards.domain.CardHolder;
import br.com.gustavoakira.cards.infrastructure.repository.entity.CardAccountEntity;
import br.com.gustavoakira.cards.infrastructure.repository.entity.CardHolderEntity;
import org.instancio.Instancio;
import org.instancio.Model;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.instancio.Select.field;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SQLCardAccountRepositoryTest {

    @Autowired
    private SQLCardAccountRepository repository;

    @Autowired
    private SQLCardHolderRepository cardHolderRepository;

    Model<CardAccount> validCardAccountModel = null;


    @BeforeEach
    void setup(){
        CardHolder entity = Instancio.create(CardHolder.class);
        this.cardHolderRepository.save(entity);
        this.validCardAccountModel = Instancio.of(CardAccount.class).set(field("cardHolderName"), entity.getName()).set(field("expirationDate"), LocalDateTime.now().plusDays(5)).toModel();
    }



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
        assertNotEquals(0,saved.size());
    }
}