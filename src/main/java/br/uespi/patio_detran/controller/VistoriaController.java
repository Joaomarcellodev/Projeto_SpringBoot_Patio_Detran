package br.uespi.patio_detran.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.uespi.patio_detran.models.VistoriaModel;
import br.uespi.patio_detran.services.VistoriaService;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/vistorias")
public class VistoriaController {

    @Autowired
    private VistoriaService vistoriaService;

    @PostMapping
    public ResponseEntity<VistoriaModel> createVistoria(@Valid @RequestBody VistoriaModel vistoria) {
        return ResponseEntity.ok(vistoriaService.createVistoria(vistoria));
    }

    @GetMapping
    public ResponseEntity<List<VistoriaModel>> getAllVistorias() {
        return ResponseEntity.ok(vistoriaService.getAllVistorias());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VistoriaModel> getVistoriaById(@PathVariable UUID id) {
        Optional<VistoriaModel> vistoria = vistoriaService.getVistoriaById(id);
        if (vistoria.isPresent()) {
            return ResponseEntity.ok(vistoria.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<VistoriaModel> updateVistoria(@PathVariable UUID id, @Valid @RequestBody VistoriaModel vistoria) {
        VistoriaModel updatedVistoria = vistoriaService.updateVistoria(id, vistoria);
        if (updatedVistoria != null) {
            return ResponseEntity.ok(updatedVistoria);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVistoria(@PathVariable UUID id) {
        vistoriaService.deleteVistoria(id);
        return ResponseEntity.noContent().build();
    }
}
