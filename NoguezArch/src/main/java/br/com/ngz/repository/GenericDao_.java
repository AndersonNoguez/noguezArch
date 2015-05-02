package br.com.ngz.repository;

import java.util.List;

/**
 *
 * @author anoguez
 * @param <PK> identificador
 * @param <T> entidade
 */
public interface GenericDao_<PK, T> {

    public void save(T entity);

    public void update(T entity);

    public void delete(T entity);

    public void deleteByIds(List<T> listEntities);

    public T findById(PK pk);

    public List<T> findAll();

}
