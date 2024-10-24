package com.curso.domains;

import com.curso.domains.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

    @Entity
    @Table(name = "grupoproduto")
public class GrupoProduto {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_grupoproduto")
        private int id;

        @NotNull  @NotBlank
        private String descricao;

        @Enumerated(EnumType.ORDINAL)
        @JoinColumn(name = "status")
        private Status status;

        @JsonIgnore
        @OneToMany(mappedBy = "grupoProduto")
        private List<Produto> produtos = new ArrayList<>();

        public List<Produto> getProdutos() {
            return produtos;
        }

        public void setProdutos(List<Produto> produtos) {
            this.produtos = produtos;
        }

        public GrupoProduto() {
            this.status = Status.ATIVO;}


    public GrupoProduto(int id, Status status, String descricao) {
        this.id = id;
        this.status = status;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrupoProduto that = (GrupoProduto) o;
        return id == that.id && Objects.equals(descricao, that.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao);
    }
}
