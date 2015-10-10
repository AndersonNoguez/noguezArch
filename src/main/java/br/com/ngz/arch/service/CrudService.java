package br.com.ngz.arch.service;

import br.com.ngz.arch.repository.GenericDAO;
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
    
    public abstract GenericDAO getDAO();
    
    public void save(T entity);

    public void update(T entity);

    public void delete(T entity);
    
    public void deleteByIds(List<T> listEntities);

    public T findById(PK pk);

    public List<T> findAll();
    
}
