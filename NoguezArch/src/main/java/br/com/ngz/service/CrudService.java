package br.com.ngz.service;

import br.com.ngz.repository.GenericDaoImpl;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author andersonNoguez
 * @param <T> entidade
 * @param <PK> identificador
 */
@Local
public interface CrudService <T, PK>{
    
    public abstract GenericDaoImpl getDAO();
    
    public void save(T entity);

    public void update(T entity);

    public void delete(T entity);
    
    public void deleteByIds(List<T> listEntities);

    public T findById(PK pk);

    public List<T> findAll();
    
}
