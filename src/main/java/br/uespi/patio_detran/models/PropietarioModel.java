package br.uespi.patio_detran.models;

import java.io.Serializable;
import java.util.UUID;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


// Começar a mapear o JPA
@Entity
@Table(name= "TB_PROPIETARIO")
public class PropietarioModel implements Serializable{


    // Definir um ID
    public static final long serialVersionUID = 1L;

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false , unique = true)
    private String cpf;

    @Column(nullable = false)
    private String dataDeNascimento;

    @Column(nullable = false)
    private String sexo;


    // Getters and Setters 

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
}
