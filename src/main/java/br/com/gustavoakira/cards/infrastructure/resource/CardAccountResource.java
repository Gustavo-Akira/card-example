package br.com.gustavoakira.cards.infrastructure.resource;

import br.com.gustavoakira.cards.api.CardAccountApi;
import br.com.gustavoakira.cards.api.dto.in.CreateCardAccount;
import br.com.gustavoakira.cards.api.dto.in.CreateCardHolder;
import br.com.gustavoakira.cards.api.dto.in.UpdateCardAccount;
import br.com.gustavoakira.cards.api.dto.in.UpdateCardHolder;
import br.com.gustavoakira.cards.api.dto.out.CardAccountOutDTO;
import br.com.gustavoakira.cards.api.dto.out.CardHolderOutDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/card/account")
public class CardAccountResource {

    private final CardAccountApi api;

    public CardAccountResource(CardAccountApi api) {
        this.api = api;
    }

    @GetMapping()
    public ResponseEntity<List<CardAccountOutDTO>> findAll(){
        return ResponseEntity.ok(api.findAll());
    }

    @PostMapping()
    public ResponseEntity<Void> save(@RequestBody @Valid CreateCardAccount account){
        this.api.save(account);
        return ResponseEntity.ok().build();
    }

    @PutMapping()
    public ResponseEntity<Void> update(@RequestBody @Valid UpdateCardAccount account){
        this.api.update(account);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<CardAccountOutDTO> findById(@PathVariable String accountNumber){
        return ResponseEntity.ok(api.findById(accountNumber));
    }

    @DeleteMapping("/{accountNumber}")
    public ResponseEntity<Void> remove(@PathVariable String accountNumber){
        api.remove(accountNumber);
        return ResponseEntity.ok().build();
    }

}
