package br.edu.ifnmg.aplicacao_spring.servicos;

import br.edu.ifnmg.aplicacao_spring.entidades.ResponsavelGrupo;

public interface ResponsavelGrupoDAO extends GenericDAO<ResponsavelGrupo, Long>{
    ResponsavelGrupo buscaPorCPF(String cpf);
}
