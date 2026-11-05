package com.estoquecerto.controller;

import com.estoquecerto.dto.ProdutoRequestDTO;
import com.estoquecerto.dto.ProdutoResponseDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.estoquecerto.service.ProdutoService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.DeleteMapping;

import com.estoquecerto.exception.ProdutoNaoEncontradoException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

@PostMapping
public ResponseEntity<ProdutoResponseDTO> cadastrar(@RequestBody ProdutoRequestDTO dto) {
    ProdutoResponseDTO produtoSalvo = produtoService.salvar(dto);

    return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(produtoSalvo);
}

@GetMapping
public ResponseEntity<List<ProdutoResponseDTO>> listarTodos() {
    return ResponseEntity.ok(produtoService.listarTodos());
}


@GetMapping("/{id}")
public ResponseEntity<ProdutoResponseDTO> buscarPorId(@PathVariable Long id) {
    ProdutoResponseDTO produto = produtoService.buscarPorId(id)
        .orElseThrow(() -> new ProdutoNaoEncontradoException("Produto não encontrado"));

    return ResponseEntity.ok(produto);
}

@PutMapping("/{id}")
public ResponseEntity<ProdutoResponseDTO> atualizar(
        @PathVariable Long id,
        @RequestBody ProdutoRequestDTO dto) {

    ProdutoResponseDTO produtoAtualizado = produtoService.atualizar(id, dto);

    return ResponseEntity.ok(produtoAtualizado);
}

@DeleteMapping("/{id}")
public ResponseEntity<Void> excluir(@PathVariable Long id) {
    produtoService.excluir(id);

    return ResponseEntity.noContent().build();
}
}