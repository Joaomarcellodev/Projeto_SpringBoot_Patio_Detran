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
@Table(name= "TB_GUARDA")
public class GuardaModel implements Serializable {



    // Atributos 

    public static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;


    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String sexo;


    // Relacionamento

     @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
     @OneToMany(mappedBy = "multas",fetch = FetchType.LAZY)
     private Set<GuardaModel> guardas = new HashSet<>();


    // Getters and Setters 

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSexo() {
        return sexo;
    }

    public static void setSerialVersionUID(long serialVersionUID) {
        GuardaModel.serialVersionUID = serialVersionUID;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Set<GuardaModel> getGuardas() {
        return guardas;
    }

    public void setGuardas(Set<GuardaModel> guardas) {
        this.guardas = guardas;
    }

}
