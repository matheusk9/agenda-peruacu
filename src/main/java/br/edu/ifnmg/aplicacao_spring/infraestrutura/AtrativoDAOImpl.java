
package br.edu.ifnmg.aplicacao_spring.infraestrutura;

import br.edu.ifnmg.aplicacao_spring.entidades.Atrativo;
import br.edu.ifnmg.aplicacao_spring.servicos.AtrativoDAO;
import org.springframework.stereotype.Repository;

@Repository
public class AtrativoDAOImpl extends GenericDAOImpl<Atrativo, Long>
        implements AtrativoDAO {

    public AtrativoDAOImpl() {
        super(Atrativo.class);
    }

}
