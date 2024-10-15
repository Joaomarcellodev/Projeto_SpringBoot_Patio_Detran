package br.uespi.patio_detran.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.uespi.patio_detran.models.GuardaModel;
import br.uespi.patio_detran.repositories.GuardaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GuardaService {

    @Autowired
    private GuardaRepository guardaRepository;

    public GuardaModel createGuarda(GuardaModel guarda) {
        return guardaRepository.save(guarda);
    }

    public List<GuardaModel> getAllGuardas() {
        return guardaRepository.findAll();
    }

    public Optional<GuardaModel> getGuardaById(UUID id) {
        return guardaRepository.findById(id);
    }

    public GuardaModel updateGuarda(UUID id, GuardaModel updatedGuarda) {
        Optional<GuardaModel> existingGuarda = guardaRepository.findById(id);
        if (existingGuarda.isPresent()) {
            GuardaModel guarda = existingGuarda.get();
            guarda.setNome(updatedGuarda.getNome());
            guarda.setSexo(updatedGuarda.getSexo());
            return guardaRepository.save(guarda);
        }
        return null; 
    }

    public void deleteGuarda(UUID id) {
        guardaRepository.deleteById(id);
    }
}
