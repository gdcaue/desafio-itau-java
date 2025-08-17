package br.com.itau.desafio.model;

import java.time.OffsetDateTime;

/**
 * Representa uma transação válida armazenada em memória.
 *
 * Diferente do {@link br.com.itau.desafio.dto.TransacaoRequest},
 * esta classe é usada internamente no domínio da aplicação,
 * após passar pelas validações de negócio.
 */
public class Transacao {

    private double valor;               // valor monetário da transação
    private OffsetDateTime dataHora;    // data/hora em que ocorreu

    /**
     * Cria uma nova transação.
     *
     * @param valor    valor da transação (>= 0)
     * @param dataHora data/hora da transação (não pode ser futura)
     */
    public Transacao(final double valor, final OffsetDateTime dataHora) {
        this.valor = valor;
        this.dataHora = dataHora;
    }

    public double getValor() {
        return valor;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }
}
