package br.uespi.patio_detran.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.uespi.patio_detran.models.GuardaModel;
import br.uespi.patio_detran.services.GuardaService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/guardas")
public class GuardaController {

    @Autowired
    private GuardaService guardaService;

    @PostMapping
    public ResponseEntity<GuardaModel> createGuarda(@RequestBody GuardaModel guarda) {
        return ResponseEntity.ok(guardaService.createGuarda(guarda));
    }

    @GetMapping
    public ResponseEntity<List<GuardaModel>> getAllGuardas() {
        return ResponseEntity.ok(guardaService.getAllGuardas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GuardaModel> getGuardaById(@PathVariable UUID id) {
        Optional<GuardaModel> guarda = guardaService.getGuardaById(id);
        if (guarda.isPresent()) {
            return ResponseEntity.ok(guarda.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<GuardaModel> updateGuarda(@PathVariable UUID id, @RequestBody GuardaModel guarda) {
        GuardaModel updatedGuarda = guardaService.updateGuarda(id, guarda);
        if (updatedGuarda != null) {
            return ResponseEntity.ok(updatedGuarda);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuarda(@PathVariable UUID id) {
        guardaService.deleteGuarda(id);
        return ResponseEntity.noContent().build();
    }
}
