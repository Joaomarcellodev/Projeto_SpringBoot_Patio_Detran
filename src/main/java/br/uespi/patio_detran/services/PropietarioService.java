package br.uespi.patio_detran.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.uespi.patio_detran.models.PropietarioModel;
import br.uespi.patio_detran.repositories.PropietarioRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PropietarioService {

    @Autowired
    private PropietarioRepository propietarioRepository;

    public PropietarioModel createPropietario(PropietarioModel propietario) {
        return propietarioRepository.save(propietario);
    }

    public List<PropietarioModel> getAllPropietarios() {
        return propietarioRepository.findAll();
    }

    public Optional<PropietarioModel> getPropietarioById(UUID id) {
        return propietarioRepository.findById(id);
    }

    public PropietarioModel updatePropietario(UUID id, PropietarioModel updatedPropietario) {
        Optional<PropietarioModel> existingPropietario = propietarioRepository.findById(id);
        if (existingPropietario.isPresent()) {
            PropietarioModel propietario = existingPropietario.get();
            propietario.setNome(updatedPropietario.getNome());
            propietario.setCpf(updatedPropietario.getCpf());
            propietario.setDataDeNascimento(updatedPropietario.getDataDeNascimento());
            propietario.setSexo(updatedPropietario.getSexo());
            return propietarioRepository.save(propietario);
        }
        return null; 
    }

    public void deletePropietario(UUID id) {
        propietarioRepository.deleteById(id);
    }
}
