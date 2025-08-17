package br.com.itau.desafio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principal da aplicação.
 *
 * É o ponto de entrada do Spring Boot, responsável por inicializar
 * todo o contexto da aplicação e subir o servidor embutido.
 */
@SpringBootApplication
public class DesafioApplication {

    /**
     * Método main responsável por iniciar a aplicação.
     *
     * @param args argumentos de linha de comando
     */
    public static void main(String[] args) {
        SpringApplication.run(DesafioApplication.class, args);
    }
}
