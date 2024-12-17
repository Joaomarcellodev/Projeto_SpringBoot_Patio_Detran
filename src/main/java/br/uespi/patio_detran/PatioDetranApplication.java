package br.uespi.patio_detran;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import br.uespi.patio_detran.models.PessoaModel;
import br.uespi.patio_detran.models.MultaModel;
import br.uespi.patio_detran.models.VeiculoModel;
import br.uespi.patio_detran.models.VistoriaModel;
import br.uespi.patio_detran.models.TipoPessoa;
import br.uespi.patio_detran.repositories.PessoaRepository;
import br.uespi.patio_detran.repositories.MultaRepository;
import br.uespi.patio_detran.repositories.VeiculoRepository;
import br.uespi.patio_detran.repositories.VistoriaRepository;

@SpringBootApplication
public class PatioDetranApplication {
    public static void main(String[] args) {
        SpringApplication.run(PatioDetranApplication.class, args);
    }

    @Bean
    CommandLineRunner init(
            @Autowired PessoaRepository pessoaRepository,
            @Autowired MultaRepository multaRepository,
            @Autowired VeiculoRepository veiculoRepository,
            @Autowired VistoriaRepository vistoriaRepository) {
        return args -> {
            // Instanciando entidades
            PessoaModel guarda = new PessoaModel();
            guarda.setNome("José da Silva");
            guarda.setSexo("Masculino");
            guarda.setTipoPessoa(TipoPessoa.GUARDA);

            MultaModel multa = new MultaModel();
            multa.setDescricao("Estacionamento proibido");
            multa.setPreco(150.0f);
            multa.setGuarda(guarda);

            PessoaModel propietario = new PessoaModel();
            propietario.setNome("Maria Oliveira");
            propietario.setSexo("Feminino");
            propietario.setTipoPessoa(TipoPessoa.PROPRIETARIO);

            VeiculoModel veiculo = new VeiculoModel();
            veiculo.setModelo("Civic");
            veiculo.setNome("Honda");
            veiculo.setPlaca("ABC-1234");
            veiculo.setPropietario(propietario);

            VistoriaModel vistoria = new VistoriaModel();
            vistoria.setDescricao("Vistoria de rotina");

            // Salvando entidades no banco de dados
            pessoaRepository.save(guarda);
            pessoaRepository.save(propietario);
            multaRepository.save(multa);
            veiculoRepository.save(veiculo);
            vistoriaRepository.save(vistoria);
        };
    }
}
