package br.uespi.patio_detran.models;

import java.util.UUID;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "TB_PESSOA")
public class PessoaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull(message = "O nome não pode ser nulo")
    @Size(min = 2, max = 50, message = "O nome deve ter entre 2 e 50 caracteres")
    @Column(nullable = false)
    private String nome;

    @NotNull(message = "O sexo não pode ser nulo")
    @Size(max = 10, message = "O sexo deve ter no máximo 10 caracteres")
    @Column(nullable = false)
    private String sexo;

    @NotNull(message = "A categoria não pode ser nula")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Categoria categoria;

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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
