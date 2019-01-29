
package com.claudio.cadastro.server.dao;

import com.claudio.cadastro.server.model.Cadastro;

/**
 *
 * @author aluno
 */
public interface DAO <T extends Cadastro> {
    
    T findById(long id);
    T findByField(String FiledName, Object value);
    boolean remove(T entity);
    
    void save(T entity);
    
    
    
    
}
