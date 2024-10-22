package br.uespi.patio_detran;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import br.uespi.patio_detran.models.GuardaModel;
import br.uespi.patio_detran.models.MultaModel;
import br.uespi.patio_detran.models.PropietarioModel;
import br.uespi.patio_detran.models.VeiculoModel;
import br.uespi.patio_detran.repositories.GuardaRepository;
import br.uespi.patio_detran.repositories.MultaRepository;
import br.uespi.patio_detran.repositories.PropietarioRepository;
import br.uespi.patio_detran.repositories.VeiculoRepository;

@SpringBootApplication
public class PatioDetranApplication {
    public static void main(String[] args) {
        SpringApplication.run(PatioDetranApplication.class, args);
    }

    @Bean
    CommandLineRunner init(
            @Autowired GuardaRepository guardaRepository,
            @Autowired MultaRepository multaRepository,
            @Autowired PropietarioRepository propietarioRepository,
            @Autowired VeiculoRepository veiculoRepository) {
        return args -> {
            // Instanciando entidades
            GuardaModel guarda = new GuardaModel();
            guarda.setNome("José da Silva");
            guarda.setSexo("Masculino");

            MultaModel multa = new MultaModel();
            multa.setDescricao("Estacionamento proibido");
            multa.setPreco(150.0f);
            multa.setGuarda(guarda);

            PropietarioModel propietario = new PropietarioModel();
            propietario.setNome("Maria Oliveira");
            propietario.setCpf("123.456.789-00");
            propietario.setDataDeNascimento("01/01/1980");
            propietario.setSexo("Feminino");

            VeiculoModel veiculo = new VeiculoModel();
            veiculo.setModelo("Civic");
            veiculo.setNome("Honda");
            veiculo.setPlaca("ABC-1234");
            veiculo.setPropietario(propietario);

            // Salvando entidades no banco de dados
            guardaRepository.save(guarda);
            multaRepository.save(multa);
            propietarioRepository.save(propietario);
            veiculoRepository.save(veiculo);
        };
    }
}