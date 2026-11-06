package com.estoquecerto.controller;

import com.estoquecerto.dto.FornecedorRequestDTO;
import com.estoquecerto.dto.FornecedorResponseDTO;
import com.estoquecerto.service.FornecedorService;
import com.estoquecerto.exception.FornecedorNaoEncontradoException;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/fornecedores")
public class FornecedorController {

    private final FornecedorService fornecedorService;

    public FornecedorController(FornecedorService fornecedorService) {
        this.fornecedorService = fornecedorService;
    }

    @PostMapping
    public ResponseEntity<FornecedorResponseDTO> cadastrar(
            @RequestBody FornecedorRequestDTO dto) {

        FornecedorResponseDTO fornecedorSalvo = fornecedorService.salvar(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(fornecedorSalvo);
    }

    @GetMapping
    public ResponseEntity<List<FornecedorResponseDTO>> listarTodos() {
        return ResponseEntity.ok(fornecedorService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FornecedorResponseDTO> buscarPorId(@PathVariable Long id) {

        FornecedorResponseDTO fornecedor = fornecedorService.buscarPorId(id)
            .orElseThrow(() -> new FornecedorNaoEncontradoException("Fornecedor não encontrado."));

        return ResponseEntity.ok(fornecedor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FornecedorResponseDTO> atualizar(
            @PathVariable Long id,
            @RequestBody FornecedorRequestDTO dto) {

        FornecedorResponseDTO fornecedorAtualizado = fornecedorService.atualizar(id, dto);

        return ResponseEntity.ok(fornecedorAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {

        fornecedorService.excluir(id);

        return ResponseEntity.noContent().build();
    }

}
