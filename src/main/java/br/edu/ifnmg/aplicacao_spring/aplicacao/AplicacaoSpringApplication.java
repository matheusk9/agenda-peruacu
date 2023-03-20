package br.edu.ifnmg.aplicacao_spring.aplicacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("br.edu.ifnmg.aplicacao_spring.entidades")
@SpringBootApplication
public class AplicacaoSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(AplicacaoSpringApplication.class, args);
	}
}
