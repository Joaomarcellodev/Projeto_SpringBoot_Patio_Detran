package br.uespi.patio_detran.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;




@Entity
@Table(name="TB_MULTA")
public class MultaModel implements Serializable {

    public static final long serialVersionUID = 1l;
    
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
     @OneToMany(mappedBy = "guarda",fetch = FetchType.LAZY)
     private Set<MultaModel> multas = new HashSet<>();


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

    public Set<MultaModel> getMultas() {
        return multas;
    }

    public void setMultas(Set<MultaModel> multas) {
        this.multas = multas;
    }

    
}
