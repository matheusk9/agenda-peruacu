package br.edu.ifnmg.aplicacao_spring.servicos;

import br.edu.ifnmg.aplicacao_spring.entidades.Guia;


public interface GuiaDAO extends GenericDAO<Guia, Long>{
    Guia buscaPorEmail(String email);
}
