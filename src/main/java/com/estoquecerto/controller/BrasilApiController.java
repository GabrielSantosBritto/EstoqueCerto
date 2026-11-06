package com.estoquecerto.controller;

import com.estoquecerto.dto.BrasilApiResponseDTO;
import com.estoquecerto.service.BrasilApiService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/brasilapi")
public class BrasilApiController {

    private final BrasilApiService brasilApiService;

    public BrasilApiController(BrasilApiService brasilApiService) {
        this.brasilApiService = brasilApiService;
    }

    @GetMapping("/cnpj/{cnpj}")
    public ResponseEntity<BrasilApiResponseDTO> consultarCnpj(
            @PathVariable String cnpj) {

        BrasilApiResponseDTO dadosEmpresa =
                brasilApiService.consultarCnpj(cnpj);

        return ResponseEntity.ok(dadosEmpresa);
    }
}