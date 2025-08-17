package br.com.itau.desafio.controller;

import java.time.OffsetDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.desafio.dto.TransacaoRequest;
import br.com.itau.desafio.model.Transacao;
import br.com.itau.desafio.service.TransacaoService;
import jakarta.validation.Valid;

/**
 * Controller responsável pelos endpoints relacionados a transações.
 *
 * Permite registrar novas transações (POST /transacao) e
 * limpar todas as transações em memória (DELETE /transacao).
 */
@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private final TransacaoService transacaoService;

    /**
     * Injeta o serviço de transações responsável pela lógica de negócio.
     *
     * @param transacaoService serviço para manipulação de transações
     */
    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    /**
     * Cria uma nova transação, caso válida.
     *
     * Regras de negócio:
     * - Não pode ter data futura
     * - Valor deve ser igual ou maior que zero
     *
     * @param request dados da transação recebidos no corpo da requisição
     * @return 201 Created se aceita,
     *         422 Unprocessable Entity se inválida,
     *         400 Bad Request se JSON inválido
     */
    @PostMapping
    public ResponseEntity<Void> criaTransacao(@Valid @RequestBody TransacaoRequest request){

        // Validações de negócio: data no futuro ou valor menor que 0 não são aceitos
        if (request.getDataHora().isAfter(OffsetDateTime.now()) || request.getValor() < 0) {
            return ResponseEntity.unprocessableEntity().build();
        }

        // Adiciona transação válida em memória
        transacaoService.addTransacao(new Transacao(request.getValor(), request.getDataHora()));

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * Remove todas as transações armazenadas em memória.
     *
     * @return 200 OK se todas foram removidas
     */
    @DeleteMapping
    public ResponseEntity<Void> limpaTransacoes(){
        transacaoService.limpaTransacoes();
        return ResponseEntity.ok().build();
    }
}
