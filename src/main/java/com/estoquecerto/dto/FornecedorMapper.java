package com.estoquecerto.dto;

import com.estoquecerto.entity.Fornecedor;

public class FornecedorMapper {
    
    public static FornecedorResponseDTO toDTO(Fornecedor fornecedor) {
        FornecedorResponseDTO dto = new FornecedorResponseDTO();
        dto.setId(fornecedor.getId());
        dto.setCnpj(fornecedor.getCnpj());
        dto.setRazaoSocial(fornecedor.getRazaoSocial());
        dto.setNomeFantasia(fornecedor.getNomeFantasia());
        dto.setInscricaoEstadual(fornecedor.getInscricaoEstadual());
        dto.setCep(fornecedor.getCep());
        dto.setLogradouro(fornecedor.getLogradouro());
        dto.setNumero(fornecedor.getNumero());
        dto.setComplemento(fornecedor.getComplemento());
        dto.setBairro(fornecedor.getBairro());
        dto.setMunicipio(fornecedor.getMunicipio());
        dto.setUf(fornecedor.getUf());
        dto.setTelefone(fornecedor.getTelefone());
        dto.setEmail(fornecedor.getEmail());
        dto.setObservacoes(fornecedor.getObservacoes());
        dto.setAtivo(fornecedor.getAtivo());
        return dto;
    }

    public static Fornecedor toEntity(FornecedorRequestDTO dto) {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setCnpj(dto.getCnpj());
        fornecedor.setRazaoSocial(dto.getRazaoSocial());
        fornecedor.setNomeFantasia(dto.getNomeFantasia());
        fornecedor.setInscricaoEstadual(dto.getInscricaoEstadual());
        fornecedor.setCep(dto.getCep());
        fornecedor.setLogradouro(dto.getLogradouro());
        fornecedor.setNumero(dto.getNumero());
        fornecedor.setComplemento(dto.getComplemento());
        fornecedor.setBairro(dto.getBairro());
        fornecedor.setMunicipio(dto.getMunicipio());
        fornecedor.setUf(dto.getUf());
        fornecedor.setTelefone(dto.getTelefone());
        fornecedor.setEmail(dto.getEmail());
        fornecedor.setObservacoes(dto.getObservacoes());
        return fornecedor;
    }
}
