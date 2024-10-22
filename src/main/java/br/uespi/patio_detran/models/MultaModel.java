package br.uespi.patio_detran.models;

import java.io.Serializable;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name="TB_MULTA")
public class MultaModel implements Serializable {
    public static final long serialVersionUID = 1L;
    
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    
    @Column(nullable = false)
    private String descricao;
    
    @Column(nullable = false)
    private float preco;

    // Relacionamento 
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name = "guarda_id")
    private GuardaModel guarda;

    // Getters and Setters
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public UUID getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public float getPreco() {
        return preco;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public GuardaModel getGuarda() {
        return guarda;
    }

    public void setGuarda(GuardaModel guarda) {
        this.guarda = guarda;
    }
}