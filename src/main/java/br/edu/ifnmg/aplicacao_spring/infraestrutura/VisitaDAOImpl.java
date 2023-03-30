package br.edu.ifnmg.aplicacao_spring.infraestrutura;

import br.edu.ifnmg.aplicacao_spring.entidades.Visita;
import br.edu.ifnmg.aplicacao_spring.servicos.VisitaDAO;
import org.springframework.stereotype.Repository;

@Repository
public class VisitaDAOImpl extends GenericDAOImpl<Visita, Long>
        implements VisitaDAO {

    public VisitaDAOImpl() {
        super(Visita.class);
    }
}
