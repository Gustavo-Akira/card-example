package br.com.gustavoakira.cards.api;

import br.com.gustavoakira.cards.api.dto.in.CreateCardAccount;
import br.com.gustavoakira.cards.api.dto.in.CreateTransaction;
import br.com.gustavoakira.cards.api.dto.in.UpdateCardAccount;
import br.com.gustavoakira.cards.api.dto.in.UpdateTransaction;
import br.com.gustavoakira.cards.api.dto.out.CardAccountOutDTO;
import br.com.gustavoakira.cards.api.dto.out.TransactionOutDTO;
import br.com.gustavoakira.cards.domain.TransactionRepository;

import java.util.List;
import java.util.stream.Collectors;

public class TransactionApi {

    private final TransactionRepository repository;

    public TransactionApi(TransactionRepository repository) {
        this.repository = repository;
    }

    public void save(CreateTransaction transaction){
        this.repository.save(transaction.toDomain());
    }

    public void update(UpdateTransaction transaction){
        this.repository.save(transaction.toDomain());
    }

    public List<TransactionOutDTO> findAll(){
        return this.repository.findAll().stream().map(TransactionOutDTO::fromDomain).collect(Collectors.toList());
    }

    public void remove(String transactionId){
        this.repository.remove(transactionId);
    }

    public TransactionOutDTO findById(String accountNumber){
        return TransactionOutDTO.fromDomain(this.repository.findById(accountNumber));
    }
}
