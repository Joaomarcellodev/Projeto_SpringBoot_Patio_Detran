package br.uespi.patio_detran.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.uespi.patio_detran.models.PessoaModel;
import br.uespi.patio_detran.services.PessoaService;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<PessoaModel> createPessoa(@Valid @RequestBody PessoaModel pessoa) {
        return ResponseEntity.ok(pessoaService.createPessoa(pessoa));
    }

    @GetMapping
    public ResponseEntity<List<PessoaModel>> getAllPessoas() {
        return ResponseEntity.ok(pessoaService.getAllPessoas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaModel> getPessoaById(@PathVariable UUID id) {
        Optional<PessoaModel> pessoa = pessoaService.getPessoaById(id);
        if (pessoa.isPresent()) {
            return ResponseEntity.ok(pessoa.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaModel> updatePessoa(@PathVariable UUID id, @Valid @RequestBody PessoaModel pessoa) {
        PessoaModel updatedPessoa = pessoaService.updatePessoa(id, pessoa);
        if (updatedPessoa != null) {
            return ResponseEntity.ok(updatedPessoa);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePessoa(@PathVariable UUID id) {
        pessoaService.deletePessoa(id);
        return ResponseEntity.noContent().build();
    }
}
