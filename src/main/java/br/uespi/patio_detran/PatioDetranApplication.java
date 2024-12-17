package br.uespi.patio_detran;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;

import br.uespi.patio_detran.models.*;
import br.uespi.patio_detran.repositories.*;

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
            @Autowired VistoriaRepository vistoriaRepository,
            @Autowired SedeRepository sedeRepository) {
        return args -> {
            // Instanciando entidades
            PessoaModel guarda = new PessoaModel();
            guarda.setNome("José da Silva");
            guarda.setSexo("Masculino");
            guarda.setCategoria(Categoria.GUARDA);

            PessoaModel proprietario = new PessoaModel();
            proprietario.setNome("Maria Oliveira");
            proprietario.setSexo("Feminino");
            proprietario.setCategoria(Categoria.PROPRIETARIO);

            VeiculoModel veiculoCarro = new VeiculoModel();
            veiculoCarro.setModelo("Civic");
            veiculoCarro.setNome("Honda");
            veiculoCarro.setPlaca("ABC1234");
            veiculoCarro.setTipoVeiculo(TipoVeiculo.CARRO);
            veiculoCarro.setProprietario(proprietario);

            VeiculoModel veiculoMoto = new VeiculoModel();
            veiculoMoto.setModelo("CB 500");
            veiculoMoto.setNome("Honda");
            veiculoMoto.setPlaca("DEF5678");
            veiculoMoto.setTipoVeiculo(TipoVeiculo.MOTO);
            veiculoMoto.setProprietario(proprietario);

            VeiculoModel veiculoCaminhao = new VeiculoModel();
            veiculoCaminhao.setModelo("FH 540");
            veiculoCaminhao.setNome("Volvo");
            veiculoCaminhao.setPlaca("GHI9101");
            veiculoCaminhao.setTipoVeiculo(TipoVeiculo.CAMINHAO);
            veiculoCaminhao.setProprietario(proprietario);

            MultaModel multa = new MultaModel();
            multa.setDescricao("Estacionamento proibido");
            multa.setPreco(150.0f);
            multa.setGuarda(guarda);
            veiculoCarro.setProprietario(proprietario);  // Associando multa ao veículo

            VistoriaModel vistoria = new VistoriaModel();
            vistoria.setDescricao("Vistoria de rotina");
            veiculoMoto.setProprietario(proprietario); // Associando vistoria ao veículo

            SedeModel sede = new SedeModel();
            sede.setNome("Sede Central");
            veiculoCaminhao.setProprietario(proprietario); // Associando vistoria à sede

            // Salvando entidades no banco de dados
            pessoaRepository.save(guarda);
            pessoaRepository.save(proprietario);
            veiculoRepository.save(veiculoCarro);
            veiculoRepository.save(veiculoMoto);
            veiculoRepository.save(veiculoCaminhao);
            multaRepository.save(multa);
            vistoriaRepository.save(vistoria);
            sedeRepository.save(sede);

            // Log de inicialização
            System.out.println("Dados iniciais inseridos com sucesso!");
        };
    }
}
