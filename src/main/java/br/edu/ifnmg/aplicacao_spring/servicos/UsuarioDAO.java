package br.edu.ifnmg.aplicacao_spring.servicos;

import br.edu.ifnmg.aplicacao_spring.entidades.Usuario;

public interface UsuarioDAO  extends  GenericDAO<Usuario, Long>{
    Usuario buscarPorLogin(String login);
}
