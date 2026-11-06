package com.estoquecerto.exception;

public class FornecedorNaoEncontradoException extends RuntimeException {

    public FornecedorNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}