package br.edu.ifnmg.aplicacao_spring.servicos;

import br.edu.ifnmg.aplicacao_spring.entidades.Usuario;

public interface Autenticacao {

    boolean autenticar(String usuario, String senha);
    Usuario getUsuario();
}
