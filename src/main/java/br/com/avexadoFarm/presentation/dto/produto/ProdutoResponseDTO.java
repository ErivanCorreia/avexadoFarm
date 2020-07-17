package br.com.avexadoFarm.presentation;

import br.com.avexadoFarm.domain.enumeration.TipoProduto;

public class ProdutoResponseDTO {

    private Long idProduto;
    private TipoProduto tipoProduto;
    private String nome;
    private String descricao;

    public ProdutoResponseDTO() {

    }

    public ProdutoResponseDTO(Long idProduto, TipoProduto tipoProduto, String nome, String descricao) {
        this.idProduto = idProduto;
        this.tipoProduto = tipoProduto;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
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
