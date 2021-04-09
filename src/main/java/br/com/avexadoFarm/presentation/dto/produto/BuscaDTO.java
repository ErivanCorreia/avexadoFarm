package br.com.avexadoFarm.presentation.dto.produto;

import br.com.avexadoFarm.domain.model.produto.Produto;
import br.com.avexadoFarm.infrastructure.search.annotation.SearchEntity;
import br.com.avexadoFarm.infrastructure.search.annotation.SearchParam;

import java.io.Serializable;

@SearchEntity(Produto.class)
public class BuscaDTO implements Serializable {

    @SearchParam(property = "nome")
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
