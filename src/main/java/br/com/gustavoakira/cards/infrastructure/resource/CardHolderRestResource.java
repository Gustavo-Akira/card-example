package br.com.gustavoakira.cards.infrastructure.resource;

import br.com.gustavoakira.cards.api.CardHolderApi;
import br.com.gustavoakira.cards.api.dto.in.CreateCardHolder;
import br.com.gustavoakira.cards.api.dto.out.CardHolderOutDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class CardHolderRestResource {
    @Autowired
    private CardHolderApi api;

    @GetMapping()
    public ResponseEntity<List<CardHolderOutDTO>> findAll(){
        return ResponseEntity.ok(api.findAll());
    }

    @PostMapping()
    public ResponseEntity<CardHolderOutDTO> save(@RequestBody CreateCardHolder holder){
        this.api.save(holder);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardHolderOutDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(api.findById(id));
    }
}
