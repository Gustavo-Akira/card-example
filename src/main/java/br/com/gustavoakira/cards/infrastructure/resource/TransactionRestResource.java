package br.com.gustavoakira.cards.infrastructure.resource;

import br.com.gustavoakira.cards.api.TransactionApi;
import br.com.gustavoakira.cards.api.dto.in.CreateTransaction;
import br.com.gustavoakira.cards.api.dto.in.UpdateTransaction;
import br.com.gustavoakira.cards.api.dto.out.TransactionOutDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/transaction")
public class TransactionRestResource {
    @Autowired
    private TransactionApi api;

    @GetMapping()
    public ResponseEntity<List<TransactionOutDTO>> findAll(){
        return ResponseEntity.ok(api.findAll());
    }

    @PostMapping()
    public ResponseEntity<Void> save(@RequestBody @Valid CreateTransaction transaction){
        this.api.save(transaction);
        return ResponseEntity.ok().build();
    }

    @PutMapping()
    public ResponseEntity<Void> update(@RequestBody @Valid UpdateTransaction transaction){
        this.api.update(transaction);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{transactionNumber}")
    public ResponseEntity<TransactionOutDTO> findById(@PathVariable String transactionNumber){
        return ResponseEntity.ok(api.findById(transactionNumber));
    }

    @DeleteMapping("/{transactionNumber}")
    public ResponseEntity<Void> remove(@PathVariable String transactionNumber){
        api.remove(transactionNumber);
        return ResponseEntity.ok().build();
    }
}
