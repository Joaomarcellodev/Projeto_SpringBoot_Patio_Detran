package br.uespi.patio_detran.models;

import java.util.UUID;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "TB_SEDE")
public class SedeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull(message = "O nome não pode ser nulo")
    @Size(min = 2, max = 50, message = "O nome deve ter entre 2 e 50 caracteres")
    @Column(nullable = false)
    private String nome;

    // Getters e Setters

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
}
