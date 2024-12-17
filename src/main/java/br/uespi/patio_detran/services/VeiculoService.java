package br.uespi.patio_detran.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.uespi.patio_detran.models.VeiculoModel;
import br.uespi.patio_detran.repositories.VeiculoRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public VeiculoModel createVeiculo(VeiculoModel veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public List<VeiculoModel> getAllVeiculos() {
        return veiculoRepository.findAll();
    }

    public Optional<VeiculoModel> getVeiculoById(UUID id) {
        return veiculoRepository.findById(id);
    }

    public VeiculoModel updateVeiculo(UUID id, VeiculoModel updatedVeiculo) {
        Optional<VeiculoModel> existingVeiculo = veiculoRepository.findById(id);
        if (existingVeiculo.isPresent()) {
            VeiculoModel veiculo = existingVeiculo.get();
            veiculo.setModelo(updatedVeiculo.getModelo());
            veiculo.setNome(updatedVeiculo.getNome());
            veiculo.setPlaca(updatedVeiculo.getPlaca());
            veiculo.setPropietario(updatedVeiculo.getPropietario());
            return veiculoRepository.save(veiculo);
        }
        return null;  // Retornar uma exceção personalizada aqui seria ideal
    }

    public void deleteVeiculo(UUID id) {
        veiculoRepository.deleteById(id);
    }
}