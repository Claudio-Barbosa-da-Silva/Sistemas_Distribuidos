
package com.claudio.cadastro.server.dao;

import com.claudio.cadastro.server.model.Cadastro;
import java.util.List;

/**
 *
 * @author aluno
 */
public interface DAO <T extends Cadastro> {
    /**
     * Busca uma entidade (objeto) no banco
     * a partir do seu id
     * @param id id do objeto a ser localizado
     * @return o objeto encontrado ou null caso não seja localizado
     */
    T findById(long id);
    
    List<T> list();
    
    T findByField(String FiledName, Object value);
    boolean remove(T entity);
    boolean remove(long id);
    
    long save(T entity);
}
