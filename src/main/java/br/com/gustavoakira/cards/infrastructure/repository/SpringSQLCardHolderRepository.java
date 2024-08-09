package br.com.gustavoakira.cards.infrastructure.repository;

import br.com.gustavoakira.cards.infrastructure.repository.entity.CardHolderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringSQLCardHolderRepository extends JpaRepository<CardHolderEntity, Long> {
    Optional<CardHolderEntity> findByName(String name);
}
