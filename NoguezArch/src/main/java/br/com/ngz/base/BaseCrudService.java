package br.com.ngz.base;

import br.com.ngz.repository.GenericDAOImpl;
import br.com.ngz.service.CrudService;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author andersonNoguez
 * @param <T> entidade
 * @param <PK> identificador
 */
public abstract class BaseCrudService<T extends BaseEntity, PK extends Serializable> implements CrudService<T, PK>{
    
    @Override
    public abstract GenericDAOImpl getDAO();
        
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
