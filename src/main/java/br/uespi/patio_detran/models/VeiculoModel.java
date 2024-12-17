package br.uespi.patio_detran.models;

import java.util.UUID;
import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="TB_VEICULO")
public class VeiculoModel implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String placa;

    @ManyToOne
    @JoinColumn(name = "propietario_id")
    private PessoaModel propietario;

    // Getters and Setters

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

    public PessoaModel getPropietario() {
        return propietario;
    }

    public void setPropietario(PessoaModel propietario) {
        this.propietario = propietario;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}
