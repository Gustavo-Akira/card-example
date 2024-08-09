package br.com.gustavoakira.cards.infrastructure.repository;

import br.com.gustavoakira.cards.domain.CardAccount;
import br.com.gustavoakira.cards.domain.CardHolder;
import org.instancio.Instancio;
import org.instancio.Model;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.instancio.Select.field;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SQLCardHolderRepositoryTest {
    @Autowired
    SQLCardHolderRepository repository;
    Model<CardHolder> model = Instancio.of(CardHolder.class).set(field("id"),null).toModel();
    @Test
    void save() {
        CardHolder cardHolder = Instancio.create(model);
        this.repository.save(Collections.singletonList(cardHolder));
        CardHolder saved = this.repository.findByName(cardHolder.getName());
        assertEquals(cardHolder.getName(), saved.getName());
    }

    @Test
    void findById() {
        CardHolder cardHolder = Instancio.create(model);
        this.repository.save(Collections.singletonList(cardHolder));
        CardHolder saved = this.repository.findByName(cardHolder.getName());
        assertEquals(cardHolder.getName(),saved.getName());
        assertEquals(cardHolder.getName(), this.repository.findById(saved.getId()).getName());
    }

    @Test
    void findAll() {
        CardHolder cardHolder = Instancio.create(model);
        this.repository.save(Collections.singletonList(cardHolder));
        List<CardHolder> holders = this.repository.findAll();
        assertNotEquals(0,this.repository.findAll().size());
    }

    @Test
    void findByName() {
        CardHolder cardHolder = Instancio.create(model);
        this.repository.save(Collections.singletonList(cardHolder));
        CardHolder saved = this.repository.findByName(cardHolder.getName());
        assertEquals(cardHolder.getName(),saved.getName());
    }
}