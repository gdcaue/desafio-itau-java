package br.com.itau.desafio.controller;

import java.util.DoubleSummaryStatistics;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.desafio.dto.EstatisticaResponse;
import br.com.itau.desafio.service.TransacaoService;

/**
 * Controller responsável pelo endpoint de estatísticas.
 * 
 * Esse endpoint expõe os dados agregados (count, sum, avg, min, max)
 * das transações registradas nos últimos 60 segundos.
 */
@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {

    private final TransacaoService transacaoService;

    /**
     * Injeta o serviço de transações para calcular as estatísticas.
     * 
     * @param transacaoService serviço responsável por manipular as transações
     */
    public EstatisticaController(TransacaoService transacaoService){
        this.transacaoService = transacaoService;
    }

    /**
     * Retorna as estatísticas das transações dos últimos 60 segundos.
     *
     * @return EstatisticaResponse com os campos count, sum, avg, min e max
     */
    @GetMapping
    public ResponseEntity<EstatisticaResponse> getStatistics() {
        // Recupera estatísticas usando a API DoubleSummaryStatistics
        DoubleSummaryStatistics stats = transacaoService.getStatistics();
        
        // Converte para DTO de resposta no formato esperado pelo desafio
        return ResponseEntity.ok(new EstatisticaResponse(stats));
    }

}
