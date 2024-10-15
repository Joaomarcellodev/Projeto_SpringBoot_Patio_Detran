package br.uespi.patio_detran.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.uespi.patio_detran.models.PropietarioModel;
import br.uespi.patio_detran.services.PropietarioService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/propietarios")
public class PropietarioController {

    @Autowired
    private PropietarioService propietarioService;

    @PostMapping
    public ResponseEntity<PropietarioModel> createPropietario(@RequestBody PropietarioModel propietario) {
        return ResponseEntity.ok(propietarioService.createPropietario(propietario));
    }

    @GetMapping
    public ResponseEntity<List<PropietarioModel>> getAllPropietarios() {
        return ResponseEntity.ok(propietarioService.getAllPropietarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PropietarioModel> getPropietarioById(@PathVariable UUID id) {
        Optional<PropietarioModel> propietario = propietarioService.getPropietarioById(id);
        if (propietario.isPresent()) {
            return ResponseEntity.ok(propietario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PropietarioModel> updatePropietario(@PathVariable UUID id, @RequestBody PropietarioModel propietario) {
        PropietarioModel updatedPropietario = propietarioService.updatePropietario(id, propietario);
        if (updatedPropietario != null) {
            return ResponseEntity.ok(updatedPropietario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePropietario(@PathVariable UUID id) {
        propietarioService.deletePropietario(id);
        return ResponseEntity.noContent().build();
    }
}
