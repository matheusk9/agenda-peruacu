package br.edu.ifnmg.aplicacao_spring.infraestrutura;

import br.edu.ifnmg.aplicacao_spring.entidades.Usuario;
import br.edu.ifnmg.aplicacao_spring.servicos.Autenticacao;
import br.edu.ifnmg.aplicacao_spring.servicos.UsuarioDAO;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
public class AutenticacaoImpl implements Autenticacao {
    private Usuario usuario;

    private final UsuarioDAO repositorio;

    public AutenticacaoImpl(UsuarioDAO repositorio) {
        this.usuario = null;
        this.repositorio = repositorio;
    }

    @Override
    public boolean autenticar(String login, String senha) {
        usuario = repositorio.buscarPorLogin(login);
        if(usuario != null){
            if(usuario.getPassword().equals(senha)){
                return true;
            } else {
                usuario = null;
            }
        }
        return false;
    }

    @Override
    public Usuario getUsuario() {
        return usuario;
    }
}
