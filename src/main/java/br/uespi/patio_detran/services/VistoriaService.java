package br.uespi.patio_detran.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.uespi.patio_detran.models.VistoriaModel;
import br.uespi.patio_detran.repositories.VistoriaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VistoriaService {

    @Autowired
    private VistoriaRepository vistoriaRepository;

    public VistoriaModel createVistoria(VistoriaModel vistoria) {
        return vistoriaRepository.save(vistoria);
    }

    public List<VistoriaModel> getAllVistorias() {
        return vistoriaRepository.findAll();
    }

    public Optional<VistoriaModel> getVistoriaById(UUID id) {
        return vistoriaRepository.findById(id);
    }

    public VistoriaModel updateVistoria(UUID id, VistoriaModel updatedVistoria) {
        Optional<VistoriaModel> existingVistoria = vistoriaRepository.findById(id);
        if (existingVistoria.isPresent()) {
            VistoriaModel vistoria = existingVistoria.get();
            vistoria.setDescricao(updatedVistoria.getDescricao());
            return vistoriaRepository.save(vistoria);
        }
        return null;
    }

    public void deleteVistoria(UUID id) {
        vistoriaRepository.deleteById(id);
    }
}
