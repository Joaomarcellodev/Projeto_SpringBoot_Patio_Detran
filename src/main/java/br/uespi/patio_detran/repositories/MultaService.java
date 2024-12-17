package br.uespi.patio_detran.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.uespi.patio_detran.models.MultaModel;
import br.uespi.patio_detran.repositories.MultaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MultaService {

    @Autowired
    private MultaRepository multaRepository;

    public MultaModel createMulta(MultaModel multa) {
        return multaRepository.save(multa);
    }

    public List<MultaModel> getAllMultas() {
        return multaRepository.findAll();
    }

    public Optional<MultaModel> getMultaById(UUID id) {
        return multaRepository.findById(id);
    }

    public MultaModel updateMulta(UUID id, MultaModel updatedMulta) {
        Optional<MultaModel> existingMulta = multaRepository.findById(id);
        if (existingMulta.isPresent()) {
            MultaModel multa = existingMulta.get();
            multa.setDescricao(updatedMulta.getDescricao());
            multa.setPreco(updatedMulta.getPreco());
            return multaRepository.save(multa);
        }
        return null;  // Pode retornar uma exceção personalizada
    }

    public void deleteMulta(UUID id) {
        multaRepository.deleteById(id);
    }
}