package br.edu.ifnmg.aplicacao_spring.infraestrutura;

import br.edu.ifnmg.aplicacao_spring.entidades.Usuario;
import br.edu.ifnmg.aplicacao_spring.servicos.UsuarioDAO;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDAOImpl extends GenericDAOImpl<Usuario, Long>
        implements UsuarioDAO {

    public UsuarioDAOImpl() {
        super(Usuario.class);
    }

    @Override
    public Usuario buscarPorLogin(String login) {
        try {
            TypedQuery<Usuario> query = getManager().createQuery("SELECT u FROM Usuario WHERE u.login = :login", Usuario.class);
            query.setParameter("login", login); // setando o parametro pra query
            return query.getSingleResult();
        } catch (Exception ex){
            System.out.println("Usuario não encontrado!");
            return null;
        }

    }
}
