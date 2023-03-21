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

		//------ Salvar - Funfou -------
	/*
		u.setLogin("pedro");
		u.setPassword("351");
		usuarios.salvar(u);
	*/


		// ------ Atualizar + busca por ID  funcionou -------
	/*
		u = usuarios.buscaPorId(3L);
		u.setLogin("JoaoAtualizado");
		usuarios.atualizar(u);
	 */

		// ------ Busca por Login funcionou -------
		System.out.println("Busca por Login: "+ usuarios.buscarPorLogin("matheus"));


		// ------ Listar todos funcinou -------
		for (Usuario uu : usuarios.buscarTodos()){	//funfou
			System.out.println(uu);
		}

		// ------ EXCLUIR FUNCIONAL ------
		u = usuarios.buscaPorId(3L);
		usuarios.excluir(u);

	}

}
