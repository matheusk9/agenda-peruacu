package br.edu.ifnmg.aplicacao_spring.aplicacao;

import br.edu.ifnmg.aplicacao_spring.entidades.Usuario;
import br.edu.ifnmg.aplicacao_spring.servicos.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@EntityScan("br.edu.ifnmg.aplicacao_spring.entidades")
@ComponentScan("br.edu.ifnmg.aplicacao_spring")
@SpringBootApplication
public class AplicacaoSpringApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AplicacaoSpringApplication.class, args);
	}

	@Autowired
	UsuarioDAO usuarios;


	@Override
	public void run(String... args) throws Exception {
		Usuario u = new Usuario();
		u.setLogin("matheus");
		u.setPassword("123");

		usuarios.salvar(u);
	}

}
