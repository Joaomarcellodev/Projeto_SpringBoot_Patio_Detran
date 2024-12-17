package br.uespi.patio_detran.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.uespi.patio_detran.models.VeiculoModel;
import br.uespi.patio_detran.services.VeiculoService;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @PostMapping
    public ResponseEntity<VeiculoModel> createVeiculo(@Valid @RequestBody VeiculoModel veiculo) {
        return ResponseEntity.ok(veiculoService.createVeiculo(veiculo));
    }

    @GetMapping
    public ResponseEntity<List<VeiculoModel>> getAllVeiculos() {
        return ResponseEntity.ok(veiculoService.getAllVeiculos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeiculoModel> getVeiculoById(@PathVariable UUID id) {
        Optional<VeiculoModel> veiculo = veiculoService.getVeiculoById(id);
        if (veiculo.isPresent()) {
            return ResponseEntity.ok(veiculo.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<VeiculoModel> updateVeiculo(@PathVariable UUID id, @Valid @RequestBody VeiculoModel veiculo) {
        VeiculoModel updatedVeiculo = veiculoService.updateVeiculo(id, veiculo);
        if (updatedVeiculo != null) {
            return ResponseEntity.ok(updatedVeiculo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVeiculo(@PathVariable UUID id) {
        veiculoService.deleteVeiculo(id);
        return ResponseEntity.noContent().build();
    }
}
