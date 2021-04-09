package br.com.avexadoFarm.application.controller;

import br.com.avexadoFarm.application.service.ProdutoServiceImpl;
import br.com.avexadoFarm.domain.model.produto.Produto;
import br.com.avexadoFarm.infrastructure.search.annotation.SearchPredicate;
import br.com.avexadoFarm.infrastructure.service.ConverterService;
import br.com.avexadoFarm.presentation.dto.produto.BuscaDTO;
import br.com.avexadoFarm.presentation.dto.produto.ProdutoRequestDTO;
import br.com.avexadoFarm.presentation.dto.produto.ProdutoResponseDTO;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoServiceImpl produtoServiceImpl;

    @Autowired
    private ConverterService converterService;

    @Autowired
    private SearchPredicate searchPredicate;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USUARIO')")
    public ResponseEntity<Page<ProdutoResponseDTO>> findAll(BuscaDTO buscaDTO, Pageable pageable) {
        BooleanExpression predicate = searchPredicate.getPredicate(buscaDTO);
        Page<Produto> produtos = produtoServiceImpl.findAll(predicate, pageable);
        Page<ProdutoResponseDTO> produtoResponseDTOS = converterService.
                converter(produtos, ProdutoResponseDTO.class);
        return ResponseEntity.ok(produtoResponseDTOS);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<ProdutoResponseDTO> save(@RequestBody ProdutoRequestDTO produtoRequestDTO) {
        Produto produto = converterService.converter(produtoRequestDTO, Produto.class);
        Produto produtoSalvo = produtoServiceImpl.save(produto);
        ProdutoResponseDTO produtoResponseDTO = converterService.
                converter(produtoSalvo, ProdutoResponseDTO.class);
        return ResponseEntity.ok(produtoResponseDTO);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USUARIO')")
    public ResponseEntity<ProdutoResponseDTO> findById(@PathVariable Long id) {
        Produto produto = produtoServiceImpl.findById(id);
        return ResponseEntity.ok(converterService.converter(produto, ProdutoResponseDTO.class));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        produtoServiceImpl.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<ProdutoResponseDTO> update(@PathVariable Long id,
            @RequestBody ProdutoRequestDTO produtoRequestDTO) {
        Produto produto = converterService.converter(produtoRequestDTO, Produto.class);
        Produto produtoAtualizado = produtoServiceImpl.update(id, produto);

        return ResponseEntity.ok().body(converterService.converter(produtoAtualizado, ProdutoResponseDTO.class));
    }
}
