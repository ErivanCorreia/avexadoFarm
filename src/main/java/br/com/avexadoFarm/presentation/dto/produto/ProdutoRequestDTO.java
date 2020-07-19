package br.com.avexadoFarm.presentation.dto.produto;

import br.com.avexadoFarm.domain.model.produto.TipoProduto;

public class ProdutoRequestDTO {

    private TipoProduto tipoProduto;
    private String nome;
    private String descricao;

    public ProdutoRequestDTO() {

    }

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(TipoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
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
