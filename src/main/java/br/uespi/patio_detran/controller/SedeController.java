package br.uespi.patio_detran.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.uespi.patio_detran.models.SedeModel;
import br.uespi.patio_detran.services.SedeService;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/sedes")
public class SedeController {

    @Autowired
    private SedeService sedeService;

    @PostMapping
    public ResponseEntity<SedeModel> createSede(@Valid @RequestBody SedeModel sede) {
        return ResponseEntity.ok(sedeService.createSede(sede));
    }

    @GetMapping
    public ResponseEntity<List<SedeModel>> getAllSedes() {
        return ResponseEntity.ok(sedeService.getAllSedes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SedeModel> getSedeById(@PathVariable UUID id) {
        Optional<SedeModel> sede = sedeService.getSedeById(id);
        if (sede.isPresent()) {
            return ResponseEntity.ok(sede.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<SedeModel> updateSede(@PathVariable UUID id, @Valid @RequestBody SedeModel sede) {
        SedeModel updatedSede = sedeService.updateSede(id, sede);
        if (updatedSede != null) {
            return ResponseEntity.ok(updatedSede);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSede(@PathVariable UUID id) {
        sedeService.deleteSede(id);
        return ResponseEntity.noContent().build();
    }
}
