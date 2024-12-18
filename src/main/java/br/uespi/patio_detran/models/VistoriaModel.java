package br.uespi.patio_detran.models;

import java.util.UUID;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "TB_VISTORIA")
public class VistoriaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull(message = "A descrição não pode ser nula")
    @Size(min = 2, max = 100, message = "A descrição deve ter entre 2 e 100 caracteres")
    @Column(nullable = false)
    private String descricao;

    // Getters e Setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
