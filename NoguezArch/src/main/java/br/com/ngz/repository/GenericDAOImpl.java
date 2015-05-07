package br.com.ngz.repository;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author andersonNoguez
 * @param <PK> Identificador
 * @param <T> Entidade a ser passada
 */
@SuppressWarnings("unchecked")
public abstract class GenericDAOImpl<T, PK> implements GenericDAO<T, PK> {

    @PersistenceContext
    protected EntityManager entityManager;
    
    public EntityManager getEntityManager(){
        return entityManager;
    }

    @Override
    public void save(T entity) {
        entityManager.persist(entity);
    }

    @Override
    public void update(T entity) {
        entityManager.merge(entity);
    }

    @Override
    public void delete(T entity) {
        entityManager.remove(entity);
    }

    @Override
    public T findById(PK pk) {
        return (T) entityManager.find(getTypeClass(), pk);
    }

    @Override
    public List<T> findAll() {
        return entityManager.createQuery("FROM " + getTypeClass().getName())
                .getResultList();
    }

    private Class<?> getTypeClass() {
        return (Class<?>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[1];
    }

    @Override
    public void deleteByIds(List<T> entities) {
        if (entities != null && !entities.isEmpty()) {
            for (T entity : entities) {
                delete(entityManager.merge(entity));
            }
        }
    }

}

