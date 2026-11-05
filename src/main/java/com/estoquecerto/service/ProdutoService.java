package com.estoquecerto.service;

import com.estoquecerto.entity.Produto;
import com.estoquecerto.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.estoquecerto.exception.ProdutoNaoEncontradoException;

import com.estoquecerto.dto.ProdutoMapper;
import com.estoquecerto.dto.ProdutoRequestDTO;
import com.estoquecerto.dto.ProdutoResponseDTO;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public ProdutoResponseDTO salvar(ProdutoRequestDTO dto) {

    Produto produto = ProdutoMapper.toEntity(dto);

    Produto produtoSalvo = produtoRepository.save(produto);

    return ProdutoMapper.toDTO(produtoSalvo);
}

    public List<ProdutoResponseDTO> listarTodos() {
    return produtoRepository.findAll()
            .stream()
            .map(ProdutoMapper::toDTO)
            .toList();
}

public Optional<ProdutoResponseDTO> buscarPorId(Long id) {
    return produtoRepository.findById(id)
            .map(ProdutoMapper::toDTO);
}

public ProdutoResponseDTO atualizar(Long id, ProdutoRequestDTO dadosAtualizados) {

    Produto produto = produtoRepository.findById(id)
        .orElseThrow(() -> new ProdutoNaoEncontradoException("Produto não encontrado")); 

    produto.setCodigo(dadosAtualizados.getCodigo());
    produto.setNome(dadosAtualizados.getNome());
    produto.setDescricao(dadosAtualizados.getDescricao());
    produto.setUnidadeMedida(dadosAtualizados.getUnidadeMedida());
    produto.setQuantidadeEstoque(dadosAtualizados.getQuantidadeEstoque());
    produto.setQuantidadeMinima(dadosAtualizados.getQuantidadeMinima());
    produto.setPreco(dadosAtualizados.getPreco());

    Produto produtoAtualizado = produtoRepository.save(produto);
    return ProdutoMapper.toDTO(produtoAtualizado);
}

public void excluir(Long id) {

    Produto produto = produtoRepository.findById(id)
        .orElseThrow(() -> new ProdutoNaoEncontradoException("Produto não encontrado"));

    produtoRepository.delete(produto);
}
}