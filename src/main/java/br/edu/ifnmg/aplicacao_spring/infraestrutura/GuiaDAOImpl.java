/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package br.edu.ifnmg.aplicacao_spring.infraestrutura;

import br.edu.ifnmg.aplicacao_spring.entidades.Guia;
import br.edu.ifnmg.aplicacao_spring.servicos.GuiaDAO;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class GuiaDAOImpl extends GenericDAOImpl<Guia, Long> implements GuiaDAO {

    public GuiaDAOImpl() {
        super(Guia.class);
    }

    @Override
    public Guia buscaPorEmail(String email) {
        try {
            TypedQuery<Guia> query = getManager().createQuery("SELECT g FROM Guia g WHERE g.email = :email", Guia.class);
            query.setParameter("email", email); // setando o parametro pra query
            return query.getSingleResult();
        } catch (Exception ex){
            return null;
        }
    }
}
