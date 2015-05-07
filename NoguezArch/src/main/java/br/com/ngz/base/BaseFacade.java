package br.com.ngz.base;

import br.com.ngz.service.CrudService;
import java.util.List;

/**
 *
 * @author Anderson Noguez
 * @param <T> TO
 * @param <PK>
 */
public interface BaseFacade<T, PK>{
    
    public void save(T entity);

    public void update(T entity);

    public void delete(T entity);
    
    public T findById(PK pk);

    public List<T> findAll();
    
}
