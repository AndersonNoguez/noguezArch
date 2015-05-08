package br.com.ngz.repository;

import java.util.List;

/**
 *
 * @author anoguez
 * @param <T> entidade
 * @param <PK> identificador
 */
public interface GenericDAO_bck<T, PK> {

    public void save(T entity);

    public void update(T entity);

    public void delete(T entity);

    public void deleteByIds(List<T> listEntities);

    public T findById(PK pk);

    public List<T> findAll();

}
