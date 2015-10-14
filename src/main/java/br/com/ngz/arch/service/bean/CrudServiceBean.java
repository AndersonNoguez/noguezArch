package br.com.ngz.arch.service.bean;

import br.com.ngz.arch.base.BaseEntity;
import br.com.ngz.arch.repository.GenericDAO;
import br.com.ngz.arch.service.CrudService;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author andersonNoguez
 * @param <T> entidade
 * @param <PK> identificador
 */
public abstract class CrudServiceBean<T extends BaseEntity, PK extends Serializable> implements CrudService<T, PK>{
    
    @Override
    public abstract GenericDAO getDAO();
        
    @Override
    public void save(T entity) {
        getDAO().save(entity);
    }

    @Override
    public void update(T entity) {
        getDAO().update(entity);
    }

    @Override
    public void delete(T entity) {
        getDAO().delete(entity);
    }

    @Override
    public T findById(PK pk) {
        return (T) getDAO().findById(pk);
    }

    @Override
    public List<T> findAll() {
        return getDAO().findAll();
    }

    @Override
    public void deleteByIds(List<T> listEntities) {
        getDAO().deleteByIds(listEntities);
    }

    
}
