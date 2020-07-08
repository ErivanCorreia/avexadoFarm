package br.com.avexadoFarm.application.service;

import br.com.avexadoFarm.domain.model.Produto;
import br.com.avexadoFarm.infrastructure.repository.BaseRepository;
import br.com.avexadoFarm.infrastructure.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl extends BaseServiceImpl<Produto, Long> {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    protected ProdutoRepository getRepository() {
        return produtoRepository;
    }
}
