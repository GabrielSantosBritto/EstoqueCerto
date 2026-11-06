package com.estoquecerto.service;

import com.estoquecerto.entity.Fornecedor;
import com.estoquecerto.repository.FornecedorRepository;
import com.estoquecerto.dto.FornecedorMapper;
import com.estoquecerto.dto.FornecedorRequestDTO;
import com.estoquecerto.dto.FornecedorResponseDTO;
import java.util.List;
import java.util.Optional;
import com.estoquecerto.exception.FornecedorNaoEncontradoException;
import com.estoquecerto.exception.CnpjJaCadastradoException;

import org.springframework.stereotype.Service;

@Service
public class FornecedorService {

    private final FornecedorRepository fornecedorRepository;

    public FornecedorService(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    public FornecedorResponseDTO salvar(FornecedorRequestDTO dto) {

    if (fornecedorRepository.existsByCnpj(dto.getCnpj())) {
        throw new CnpjJaCadastradoException("CNPJ já cadastrado.");
    }

    Fornecedor fornecedor = FornecedorMapper.toEntity(dto);

    Fornecedor fornecedorSalvo = fornecedorRepository.save(fornecedor);

    return FornecedorMapper.toDTO(fornecedorSalvo);
}

    public List<FornecedorResponseDTO> listarTodos() {
    return fornecedorRepository.findAll()
            .stream()
            .map(FornecedorMapper::toDTO)
            .toList();
}

    public Optional<FornecedorResponseDTO> buscarPorId(Long id) {
    return fornecedorRepository.findById(id)
            .map(FornecedorMapper::toDTO);
}

    public FornecedorResponseDTO atualizar(Long id, FornecedorRequestDTO dadosAtualizados) {

    Fornecedor fornecedor = fornecedorRepository.findById(id)
        .orElseThrow(() -> new FornecedorNaoEncontradoException("Fornecedor não encontrado."));

    if (fornecedorRepository.existsByCnpjAndIdNot(dadosAtualizados.getCnpj(), id)) {
        throw new CnpjJaCadastradoException("CNPJ já cadastrado para outro fornecedor.");
    }

    fornecedor.setCnpj(dadosAtualizados.getCnpj());
    fornecedor.setRazaoSocial(dadosAtualizados.getRazaoSocial());
    fornecedor.setNomeFantasia(dadosAtualizados.getNomeFantasia());
    fornecedor.setInscricaoEstadual(dadosAtualizados.getInscricaoEstadual());
    fornecedor.setCep(dadosAtualizados.getCep());
    fornecedor.setLogradouro(dadosAtualizados.getLogradouro());
    fornecedor.setNumero(dadosAtualizados.getNumero());
    fornecedor.setComplemento(dadosAtualizados.getComplemento());
    fornecedor.setBairro(dadosAtualizados.getBairro());
    fornecedor.setMunicipio(dadosAtualizados.getMunicipio());
    fornecedor.setUf(dadosAtualizados.getUf());
    fornecedor.setTelefone(dadosAtualizados.getTelefone());
    fornecedor.setEmail(dadosAtualizados.getEmail());
    fornecedor.setObservacoes(dadosAtualizados.getObservacoes());

    Fornecedor fornecedorAtualizado = fornecedorRepository.save(fornecedor);

    return FornecedorMapper.toDTO(fornecedorAtualizado);
}

    public void excluir(Long id) {

    Fornecedor fornecedor = fornecedorRepository.findById(id)
        .orElseThrow(() -> new FornecedorNaoEncontradoException("Fornecedor não encontrado."));

    fornecedor.setAtivo(false);

    fornecedorRepository.save(fornecedor);
}

}
