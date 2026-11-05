package com.estoquecerto.dto;

import com.estoquecerto.entity.Produto;

public class ProdutoMapper {

    public static ProdutoResponseDTO toDTO(Produto produto) {
        ProdutoResponseDTO dto = new ProdutoResponseDTO();
        dto.setId(produto.getId());
        dto.setCodigo(produto.getCodigo());
        dto.setNome(produto.getNome());
        dto.setDescricao(produto.getDescricao());
        dto.setUnidadeMedida(produto.getUnidadeMedida());
        dto.setQuantidadeEstoque(produto.getQuantidadeEstoque());
        dto.setQuantidadeMinima(produto.getQuantidadeMinima());
        dto.setPreco(produto.getPreco());
        return dto;
    }

    public static Produto toEntity(ProdutoRequestDTO dto) {
        Produto produto = new Produto();
        produto.setCodigo(dto.getCodigo());
        produto.setNome(dto.getNome());
        produto.setDescricao(dto.getDescricao());
        produto.setUnidadeMedida(dto.getUnidadeMedida());
        produto.setQuantidadeEstoque(dto.getQuantidadeEstoque());
        produto.setQuantidadeMinima(dto.getQuantidadeMinima());
        produto.setPreco(dto.getPreco());
        return produto;
    }
}