package br.edu.ifnmg.aplicacao_spring.infraestrutura;

import br.edu.ifnmg.aplicacao_spring.servicos.GenericDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;


import java.util.List;

public class GenericDAOImpl<T, ID> implements GenericDAO<T, ID> {

    @PersistenceContext
    private EntityManager manager;
    private final Class<T> classePersistente;

    public GenericDAOImpl(Class<T> classePersistente) {
        this.classePersistente = classePersistente;
    }

   protected EntityManager getManager() {
        return manager;
    }

    public Class<T> getClasse() {
        return classePersistente;
    }

    @Override
    @Transactional  // Responsavel por dar o 'begin' automaticamente
    public boolean salvar(T entidade) {
        try {
            EntityManager manager = getManager();
            manager.persist(entidade);
            manager.flush();
            return true;
        } catch (Exception e){
            System.out.println("Não foi possivel salvar");
            return false;
        }
    }

    @Override
    @Transactional
    public boolean atualizar(T entidade) {
        try {
            EntityManager manager = getManager();
            manager.merge(entidade);
            manager.flush();
            return true;
        } catch (Exception e){
            System.out.println("Não foi possivel atualizar!");
            return false;
        }
    }

    @Override
    @Transactional
    public boolean excluir(T entidade) {
        try {
            EntityManager manager = getManager();
            manager.remove(entidade);
            manager.flush();
            return true;
        } catch (Exception e){
            System.out.println("Não foi possivel excluir!");
            return false;
        }
    }

    @Override
    public T buscaPorId(ID id) {
        EntityManager manager = getManager();
        return manager.find(classePersistente, id);
    }

    @Override
    public List<T> buscarTodos() {
        TypedQuery<T> query = manager.createQuery("SELECT e FROM " + classePersistente.getSimpleName() + " e", classePersistente);
        return query.getResultList();
    }
}
