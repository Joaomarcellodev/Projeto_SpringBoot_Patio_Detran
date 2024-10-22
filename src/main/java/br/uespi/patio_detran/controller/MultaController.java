package br.uespi.patio_detran.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.uespi.patio_detran.models.MultaModel;
import br.uespi.patio_detran.services.MultaService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
 
@RestController
@RequestMapping("/multas")
public class MultaController {

    @Autowired
    private MultaService multaService;

    @PostMapping
    public ResponseEntity<MultaModel> createMulta(@RequestBody MultaModel multa) {
        return ResponseEntity.ok(multaService.createMulta(multa));
    }

    @GetMapping
    public ResponseEntity<List<MultaModel>> getAllMultas() {
        return ResponseEntity.ok(multaService.getAllMultas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MultaModel> getMultaById(@PathVariable UUID id) {
        Optional<MultaModel> multa = multaService.getMultaById(id);
        if (multa.isPresent()) {
            return ResponseEntity.ok(multa.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<MultaModel> updateMulta(@PathVariable UUID id, @RequestBody MultaModel multa) {
        MultaModel updatedMulta = multaService.updateMulta(id, multa);
        if (updatedMulta != null) {
            return ResponseEntity.ok(updatedMulta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMulta(@PathVariable UUID id) {
        multaService.deleteMulta(id);
        return ResponseEntity.noContent().build();
    }
}
