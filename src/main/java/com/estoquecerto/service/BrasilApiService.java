package com.estoquecerto.service;

import com.estoquecerto.client.BrasilApiClient;
import com.estoquecerto.dto.BrasilApiResponseDTO;

import org.springframework.stereotype.Service;

@Service
public class BrasilApiService {

    private final BrasilApiClient brasilApiClient;

    public BrasilApiService(BrasilApiClient brasilApiClient) {
        this.brasilApiClient = brasilApiClient;
    }

    public BrasilApiResponseDTO consultarCnpj(String cnpj) {
        return brasilApiClient.consultarCnpj(cnpj);
    }
}