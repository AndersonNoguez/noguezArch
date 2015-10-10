package br.com.ngz.arch.base;

import java.util.List;

/**
 *
 * @author Anderson Noguez
 * @param <T> TO ou Model
 * @param <PK>
 */
public interface BaseFacade<T, PK>{
    
    public void save(T entity);

    public void update(T entity);

    public void delete(T entity);
    
    public T findById(PK pk);

    public List<T> findAll();
    
    public void deleteByIds(List<T> listEntities);
}
