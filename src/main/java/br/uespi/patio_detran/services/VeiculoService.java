package br.uespi.patio_detran.services;

import org.springframework.stereotype.Service;
import br.uespi.patio_detran.models.VeiculoModel;
import br.uespi.patio_detran.repositories.VeiculoRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;

    // Injeção de dependência via construtor
    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    // Criar um novo veículo
    public VeiculoModel createVeiculo(VeiculoModel veiculo) {
        return veiculoRepository.save(veiculo);
    }

    // Buscar todos os veículos
    public List<VeiculoModel> getAllVeiculos() {
        return veiculoRepository.findAll();
    }

    // Buscar um veículo por ID
    public Optional<VeiculoModel> getVeiculoById(UUID id) {
        return veiculoRepository.findById(id);
    }

    // Atualizar um veículo
    public VeiculoModel updateVeiculo(UUID id, VeiculoModel updatedVeiculo) {
        VeiculoModel existingVeiculo = veiculoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado com ID: " + id));

        // Atualiza os campos necessários
        existingVeiculo.setModelo(updatedVeiculo.getModelo());
        existingVeiculo.setNome(updatedVeiculo.getNome());
        existingVeiculo.setPlaca(updatedVeiculo.getPlaca());
        existingVeiculo.setProprietario(updatedVeiculo.getProprietario());

        return veiculoRepository.save(existingVeiculo);
    }

    // Deletar um veículo por ID
    public void deleteVeiculo(UUID id) {
        if (!veiculoRepository.existsById(id)) {
            throw new RuntimeException("Veículo não encontrado com ID: " + id);
        }
        veiculoRepository.deleteById(id);
    }
}
