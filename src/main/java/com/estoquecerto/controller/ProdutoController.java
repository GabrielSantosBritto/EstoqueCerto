package com.estoquecerto.controller;

import com.estoquecerto.entity.Produto;
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
public ResponseEntity<Produto> cadastrar(@RequestBody Produto produto) {
    Produto produtoSalvo = produtoService.salvar(produto);

    return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(produtoSalvo);
}

@GetMapping
public ResponseEntity<List<Produto>> listarTodos() {
    return ResponseEntity.ok(produtoService.listarTodos());
}


@GetMapping("/{id}")
public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
    Produto produto = produtoService.buscarPorId(id)
        .orElseThrow(() -> new ProdutoNaoEncontradoException("Produto não encontrado"));

    return ResponseEntity.ok(produto);
}

@PutMapping("/{id}")
public ResponseEntity<Produto> atualizar(
        @PathVariable Long id,
        @RequestBody Produto produto) {

    Produto produtoAtualizado = produtoService.atualizar(id, produto);

    return ResponseEntity.ok(produtoAtualizado);
}

@DeleteMapping("/{id}")
public ResponseEntity<Void> excluir(@PathVariable Long id) {
    produtoService.excluir(id);

    return ResponseEntity.noContent().build();
}
}