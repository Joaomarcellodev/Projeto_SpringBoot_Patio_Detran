package br.uespi.patio_detran.models;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "TB_VEICULO")
public class VeiculoModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull(message = "O modelo não pode ser nulo")
    @Size(min = 2, max = 50, message = "O modelo deve ter entre 2 e 50 caracteres")
    @Column(nullable = false)
    private String modelo;

    @NotNull(message = "O nome não pode ser nulo")
    @Size(min = 2, max = 50, message = "O nome deve ter entre 2 e 50 caracteres")
    @Column(nullable = false)
    private String nome;

    @NotNull(message = "A placa não pode ser nula")
    @Size(min = 7, max = 7, message = "A placa deve ter exatamente 7 caracteres")
    @Column(nullable = false, length = 7)
    private String placa;

    @NotNull(message = "O tipo de veículo não pode ser nulo")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoVeiculo tipoVeiculo;

    @ManyToOne
    @JoinColumn(name = "proprietario_id")
    private PessoaModel proprietario;

    // Getters e Setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public TipoVeiculo getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public PessoaModel getProprietario() {
        return proprietario;
    }

    public void setProprietario(PessoaModel proprietario) {
        this.proprietario = proprietario;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
