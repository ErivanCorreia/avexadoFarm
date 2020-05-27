package br.com.avexadoFarm.domain.model;

import br.com.avexadoFarm.domain.enumeration.TipoProduto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "t_produto")
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoProduto tipo;

    @NotNull
    private String nome;

    private String descricao;

    private Produto() {

    }

    private Produto(TipoProduto tipo, String nome) {
        this.tipo = tipo;
        this.nome = nome;
    }

    private Produto(TipoProduto tipo, String nome, String descricao) {
        this.tipo = tipo;
        this.nome = nome;
        this.descricao = descricao;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long idProduto) {
        this.id = idProduto;
    }

    public TipoProduto getTipo() {
        return tipo;
    }

    public void setTipo(TipoProduto tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
