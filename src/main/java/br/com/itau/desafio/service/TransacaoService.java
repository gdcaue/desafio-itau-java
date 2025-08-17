package br.com.itau.desafio.service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.stereotype.Service;

import br.com.itau.desafio.model.Transacao;

/**
 * Serviço responsável pela lógica de negócio relacionada às transações.
 *
 * Mantém as transações em memória (fila concorrente) e
 * disponibiliza operações para adicionar, limpar e calcular estatísticas.
 */
@Service
public class TransacaoService {

    /**
     * Estrutura em memória para armazenar transações.
     * 
     * Foi utilizada {@link ConcurrentLinkedQueue} para garantir segurança em cenários
     * de concorrência (múltiplas threads acessando simultaneamente).
     */
    private final Queue<Transacao> transacoes = new ConcurrentLinkedQueue<>();

    /**
     * Adiciona uma nova transação na fila em memória.
     *
     * @param transacao objeto já validado de transação
     */
    public void addTransacao(Transacao transacao){
        transacoes.add(transacao);
    }

    /**
     * Remove todas as transações armazenadas em memória.
     */
    public void limpaTransacoes(){
        transacoes.clear();
    }

    /**
     * Calcula as estatísticas (count, sum, avg, min, max)
     * das transações ocorridas nos últimos 60 segundos.
     *
     * @return {@link DoubleSummaryStatistics} contendo os resultados
     */
    public DoubleSummaryStatistics getStatistics() {
        OffsetDateTime now = OffsetDateTime.now();

        // filtra apenas transações do último minuto e calcula estatísticas
        return transacoes.stream()
            .filter(t -> t.getDataHora().isAfter(now.minusSeconds(60)))
            .mapToDouble(Transacao::getValor)
            .summaryStatistics();
    }
}
