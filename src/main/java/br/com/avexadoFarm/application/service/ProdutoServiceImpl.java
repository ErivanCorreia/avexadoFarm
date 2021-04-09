package br.com.avexadoFarm.application.service;

import br.com.avexadoFarm.domain.model.produto.Produto;
import br.com.avexadoFarm.infrastructure.repository.ProdutoRepository;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl extends BaseServiceImpl<Produto, Long> {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Page<Produto> findAll(Predicate predicate, Pageable pageable) {
        return getRepository().findAll(predicate, pageable);
    }

    @Override
    protected ProdutoRepository getRepository() {
        return produtoRepository;
    }
}
