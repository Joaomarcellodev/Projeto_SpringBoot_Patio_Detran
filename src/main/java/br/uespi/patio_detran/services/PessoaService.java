package br.uespi.patio_detran.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.uespi.patio_detran.models.PessoaModel;
import br.uespi.patio_detran.repositories.PessoaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoaModel createPessoa(PessoaModel pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public List<PessoaModel> getAllPessoas() {
        return pessoaRepository.findAll();
    }

    public Optional<PessoaModel> getPessoaById(UUID id) {
        return pessoaRepository.findById(id);
    }

    public PessoaModel updatePessoa(UUID id, PessoaModel updatedPessoa) {
        Optional<PessoaModel> existingPessoa = pessoaRepository.findById(id);
        if (existingPessoa.isPresent()) {
            PessoaModel pessoa = existingPessoa.get();
            pessoa.setNome(updatedPessoa.getNome());
            pessoa.setSexo(updatedPessoa.getSexo());
            pessoa.setTipoPessoa(updatedPessoa.getTipoPessoa());
            return pessoaRepository.save(pessoa);
        }
        return null;
    }

    public void deletePessoa(UUID id) {
        pessoaRepository.deleteById(id);
    }
}
