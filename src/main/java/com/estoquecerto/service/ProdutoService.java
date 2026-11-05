package com.estoquecerto.service;

import com.estoquecerto.entity.Produto;
import com.estoquecerto.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.estoquecerto.exception.ProdutoNaoEncontradoException;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> listarTodos() {
    return produtoRepository.findAll();
}

public Optional<Produto> buscarPorId(Long id) {
    return produtoRepository.findById(id);
}

public Produto atualizar(Long id, Produto dadosAtualizados) {

    Produto produto = produtoRepository.findById(id)
        .orElseThrow(() -> new ProdutoNaoEncontradoException("Produto não encontrado")); 

    produto.setCodigo(dadosAtualizados.getCodigo());
    produto.setNome(dadosAtualizados.getNome());
    produto.setDescricao(dadosAtualizados.getDescricao());
    produto.setUnidadeMedida(dadosAtualizados.getUnidadeMedida());
    produto.setQuantidadeEstoque(dadosAtualizados.getQuantidadeEstoque());
    produto.setQuantidadeMinima(dadosAtualizados.getQuantidadeMinima());
    produto.setPreco(dadosAtualizados.getPreco());

    return produtoRepository.save(produto);
}

public void excluir(Long id) {

    Produto produto = produtoRepository.findById(id)
        .orElseThrow(() -> new ProdutoNaoEncontradoException("Produto não encontrado"));

    produtoRepository.delete(produto);
}
}