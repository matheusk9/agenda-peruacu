package br.edu.ifnmg.aplicacao_spring.servicos;

import java.util.List;

public interface GenericDAO <T, ID> {
    boolean salvar(T entidade);
    boolean atualizar(T entidade);
    boolean excluir(T entidade);
    T buscaPorId(ID id);
    List<T> buscarTodos( );
}
