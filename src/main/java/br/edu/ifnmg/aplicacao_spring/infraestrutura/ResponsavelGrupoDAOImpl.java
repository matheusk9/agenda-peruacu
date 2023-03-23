package br.edu.ifnmg.aplicacao_spring.infraestrutura;

import br.edu.ifnmg.aplicacao_spring.entidades.ResponsavelGrupo;
import br.edu.ifnmg.aplicacao_spring.entidades.Usuario;
import br.edu.ifnmg.aplicacao_spring.servicos.ResponsavelGrupoDAO;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class ResponsavelGrupoDAOImpl extends GenericDAOImpl<ResponsavelGrupo, Long>
        implements ResponsavelGrupoDAO {

    public ResponsavelGrupoDAOImpl() {
        super(ResponsavelGrupo.class);
    }

    @Override
    public ResponsavelGrupo buscaPorCPF(String cpf) {
        try{
            TypedQuery<ResponsavelGrupo> query = getManager().createQuery("SELECT u FROM ResponsavelGrupo u WHERE u.cpf = :cpf",ResponsavelGrupo.class);
            query.setParameter("cpf", cpf);
            return query.getSingleResult();
        } catch (Exception ex){
            System.out.println("CPF não encontrado");
            return null;
        }
    }
}
