package com.estoquecerto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProdutoNaoEncontradoException.class)
    public ResponseEntity<String> tratarProdutoNaoEncontrado(
            ProdutoNaoEncontradoException exception) {

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }

    @ExceptionHandler(FornecedorNaoEncontradoException.class)
    public ResponseEntity<String> tratarFornecedorNaoEncontrado(
            FornecedorNaoEncontradoException exception) {

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }

    @ExceptionHandler(CnpjJaCadastradoException.class)
    public ResponseEntity<String> tratarCnpjJaCadastrado(
            CnpjJaCadastradoException exception) {

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(exception.getMessage());
    }

    @ExceptionHandler(BrasilApiException.class)
    public ResponseEntity<String> tratarErroBrasilApi(BrasilApiException exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_GATEWAY)
                .body(exception.getMessage());
    }
}
