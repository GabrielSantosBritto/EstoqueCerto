package com.estoquecerto.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import com.estoquecerto.dto.BrasilApiResponseDTO;
import com.estoquecerto.exception.BrasilApiException;

import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.ResourceAccessException;

@Component
public class BrasilApiClient {
    private final RestClient restClient;

    public BrasilApiClient(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder
            .baseUrl("https://brasilapi.com.br/api/cnpj/v1")
            .build();
    }

    public BrasilApiResponseDTO consultarCnpj(String cnpj) {
        try {
            return restClient.get()
                    .uri("/{cnpj}", cnpj)
                    .retrieve()
                    .body(BrasilApiResponseDTO.class);

        } catch (RestClientResponseException e) {
            if (e.getStatusCode().value() == 404) {
                throw new BrasilApiException("CNPJ não encontrado na BrasilAPI.");
            }

            throw new BrasilApiException("Erro retornado pela BrasilAPI: " + e.getStatusCode());

        } catch (ResourceAccessException e) {
            throw new BrasilApiException("Não foi possível conectar à BrasilAPI.");
        }
    } 
}
