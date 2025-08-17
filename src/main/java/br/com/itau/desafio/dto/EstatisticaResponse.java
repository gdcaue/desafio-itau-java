package br.com.itau.desafio.dto;

import java.util.DoubleSummaryStatistics;

/**
 * DTO de resposta para o endpoint GET /estatistica.
 *
 * Contém as estatísticas calculadas sobre as transações
 * ocorridas nos últimos 60 segundos.
 */
public class EstatisticaResponse {

    private long count;   // quantidade de transações
    private double sum;   // soma dos valores
    private double avg;   // média dos valores
    private double min;   // menor valor
    private double max;   // maior valor

    /**
     * Constrói o DTO a partir de um {@link DoubleSummaryStatistics}.
     *
     * @param stats estatísticas calculadas das transações
     */
    public EstatisticaResponse(DoubleSummaryStatistics stats) {
        this.count = stats.getCount();
        this.sum = stats.getSum();
        this.avg = stats.getAverage();
        this.min = stats.getMin();
        this.max = stats.getMax();
    }
    
    public long getCount() {
        return count;
    }

    public double getSum() {
        return sum;
    }

    public double getAvg() {
        return avg;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }
}
