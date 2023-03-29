package br.edu.ifnmg.aplicacao_spring.aplicacao;

import br.edu.ifnmg.aplicacao_spring.entidades.*;
import br.edu.ifnmg.aplicacao_spring.servicos.GuiaDAO;
import br.edu.ifnmg.aplicacao_spring.servicos.ResponsavelGrupoDAO;
import br.edu.ifnmg.aplicacao_spring.servicos.UsuarioDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@EntityScan("br.edu.ifnmg.aplicacao_spring.entidades")
@ComponentScan({"br.edu.ifnmg.aplicacao_spring.infraestrutura"})
@SpringBootApplication
public class AplicacaoSpringApplication implements CommandLineRunner {

	private final GuiaDAO guias;
	private final ResponsavelGrupoDAO responsavel;
	private final UsuarioDAO usuarios;

	public AplicacaoSpringApplication(GuiaDAO guias, UsuarioDAO usuarios, ResponsavelGrupoDAO responsavel) {
		this.guias = guias;
		this.usuarios = usuarios;
		this.responsavel = responsavel;
	}

	public static void main(String[] args) {
		SpringApplication.run(AplicacaoSpringApplication.class, args);
	}

	public void testeUsuarios(){
		Usuario u = new Usuario();
		//------ Salvar - Funfou -------
		u.setLogin("gerinha");
		u.setPassword("maisumasen");
		usuarios.salvar(u);

		// ------ Atualizar + busca por ID  funcionou -------
	//	u = usuarios.buscaPorId(6L);
	//	u.setLogin("Carlos");
	//	u.setPassword("password");
	//	usuarios.atualizar(u);

		// ------ Busca por Login funcionou -------
		System.out.println("Busca por Login: "+ usuarios.buscarPorLogin("matheus"));


		// ------ Listar todos funcinou -------
		for (Usuario uu : usuarios.buscarTodos()){	//funfou
			System.out.println(uu);
		}

		// ------ EXCLUIR FUNCIONAL ------
	//	u = usuarios.buscaPorId(4L);
	//	usuarios.excluir(u);
	}

	public void testeResposavelGrupo(){
		ResponsavelGrupo responsavelGrupo = new ResponsavelGrupo();

		responsavelGrupo.setNome("Matheus de Freitas Issa");
		responsavelGrupo.setEmail("emailteste@outlook.com");
		responsavelGrupo.setCpf("05114361650");
		responsavelGrupo.setTelefone("38999175551");
		responsavel.salvar(responsavelGrupo);

	}

	public void testeGuia(){
		Guia guia = new Guia();
		guia.setNome("Jõao da Neves");
		guia.setEmail("emailguia@oulook.com");
		guia.setTelefone("38999745551");

		guias.salvar(guia);

	}
	@Override
	public void run(String... args) throws Exception {

	}
}
