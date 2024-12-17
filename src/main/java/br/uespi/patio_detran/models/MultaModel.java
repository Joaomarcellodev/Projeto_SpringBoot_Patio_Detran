package br.uespi.patio_detran.models;

import java.io.Serializable;
import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="TB_MULTA")
public class MultaModel implements Serializable {
    public static final long serialversionuid = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull(message = "A descrição não pode ser nula")
    @Size(min = 2, max = 100, message = "A descrição deve ter entre 2 e 100 caracteres")
    @Column(nullable = false)
    private String descricao;

    @NotNull(message = "O preço não pode ser nulo")
    @Min(value = 0, message = "O preço deve ser maior ou igual a zero")
    @Column(nullable = false)
    private float preco;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name = "guarda_id")
    private PessoaModel guarda;

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

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public PessoaModel getGuarda() {
        return guarda;
    }

    public void setGuarda(PessoaModel guarda) {
        this.guarda = guarda;
    }

    public static long getSerialversionuid() {
        return serialversionuid;
    }
}
