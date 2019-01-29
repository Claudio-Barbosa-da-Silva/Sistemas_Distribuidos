
package com.claudio.cadastro.server.config;

import com.claudio.cadastro.server.dao.DAO;
import com.claudio.cadastro.server.dao.JpaDAO;
import com.claudio.cadastro.server.model.Cadastro;
import java.lang.reflect.ParameterizedType;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author aluno
 */
public class Producers {
    
    @Produces
    @PersistenceContext
    private EntityManager em;
    
    @Produces
    public <T extends Cadastro> DAO<T> getDao(InjectionPoint ip){
        ParameterizedType t = (ParameterizedType) ip.getType();
        Class classe = (Class) t.getActualTypeArguments()[0];
        return new JpaDAO(em, classe);
    }
    
}
