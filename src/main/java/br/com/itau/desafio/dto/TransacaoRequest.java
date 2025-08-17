package br.com.itau.desafio.dto;

import java.time.OffsetDateTime;

import jakarta.validation.constraints.NotNull;

/**
 * DTO de requisição para o endpoint POST /transacao.
 *
 * Representa os dados que o cliente envia ao criar uma nova transação.
 */
public class TransacaoRequest {

    @NotNull
    private Double valor; // valor monetário da transação

    @NotNull
    private OffsetDateTime dataHora; // data e hora da transação (ISO 8601)

    /**
     * @return valor da transação
     */
    public Double getValor() {
        return valor;
    }

    /**
     * @return data/hora da transação
     */
    public OffsetDateTime getDataHora() {
        return dataHora;
    }

}
