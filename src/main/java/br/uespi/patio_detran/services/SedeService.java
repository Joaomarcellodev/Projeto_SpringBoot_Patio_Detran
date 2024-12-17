package br.uespi.patio_detran.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.uespi.patio_detran.models.SedeModel;
import br.uespi.patio_detran.repositories.SedeRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SedeService {

    @Autowired
    private SedeRepository sedeRepository;

    public SedeModel createSede(SedeModel sede) {
        return sedeRepository.save(sede);
    }

    public List<SedeModel> getAllSedes() {
        return sedeRepository.findAll();
    }

    public Optional<SedeModel> getSedeById(UUID id) {
        return sedeRepository.findById(id);
    }

    public SedeModel updateSede(UUID id, SedeModel updatedSede) {
        Optional<SedeModel> existingSede = sedeRepository.findById(id);
        if (existingSede.isPresent()) {
            SedeModel sede = existingSede.get();
            sede.setNome(updatedSede.getNome());
            return sedeRepository.save(sede);
        }
        return null;
    }

    public void deleteSede(UUID id) {
        sedeRepository.deleteById(id);
    }
}
