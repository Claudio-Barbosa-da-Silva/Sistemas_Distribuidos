
package com.claudio.cadastro.server.dao;

import com.claudio.cadastro.server.model.Cadastro;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class JpaDAO<T extends Cadastro> implements DAO<T> {
    private final EntityManager em;
    private final Class<T> classe;

    public JpaDAO(EntityManager em, Class<T> classe){
        this.em = em;
        this.classe = classe;
    }

    @Override
    public T findById(long id) {
        return em.find(classe, id);
    }

    @Override
    public boolean remove(T entity) {
        em.remove(entity);
        return true;
    }

    @Override
    public long save(T entity) {
        if(entity.getId() > 0){
            em.merge(entity);
        }
        else {
            em.persist(entity);
        }
        
        return entity.getId();
    }

    @Override
    public T findByField(String fieldName, Object value) {
        final String jpql = "select o from " + classe.getSimpleName() + " o " +
                            " where o." + fieldName + " = :" + fieldName;
        TypedQuery<T> query = em.createQuery(jpql, classe);
        query.setParameter(fieldName, value);
        return query.getSingleResult();
    }

    @Override
    public boolean remove(long id) {
        T entity = findById(id);
        return remove(entity);
    }

    @Override
    public List<T> list() {
        final String jpql = "select o from " + classe.getSimpleName() + " o ";
        TypedQuery<T> query = em.createQuery(jpql, classe);
        return query.getResultList();
    }
}
