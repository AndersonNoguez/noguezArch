package br.com.ngz.arch.repository.bean;

import br.com.ngz.arch.repository.GenericDAO;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Anderson Noguez
 * @param <T>
 * @param <PK>
 */
public abstract class BaseDAO<T, PK> implements GenericDAO<T, PK> {

    static final Logger LOGGER = Logger.getLogger(BaseDAO.class.getName());

    @PersistenceContext
    protected EntityManager entityManager;

    public EntityManager getEntityManager() {
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

    /**
     * Retorna um único elemento a partir de uma query JPA. O método define os
     * parâmetros para a query (caso necessário), e executa a operação de
     * getSingleResult da query informada, retornando um único elemento.
     *
     * @param query a query JPA a ser executada.
     * @param parametersMap mapa de parâmetros (opcional).
     * @return instância da entidade encontrada ou null em caso de falhas.
     */
    protected T getSingleResult(Query query, Map<String, Object> parametersMap) {
        try {
            addQueryParameters(query, parametersMap);
            T entity = (T) query.getSingleResult();
            entityManager.flush();
            return entity;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }

    /**
     * Adiciona parâmetros à uma query JPA. O método seta na query os parâmetros
     * presentes no mapa informado, caso o mapa não esteja vazio ou nulo.
     *
     * @param query a query JPA que receberá os parâmetros.
     * @param parametersMap o mapa de parâmetros a serem setados.
     */
    private void addQueryParameters(Query query, Map<String, Object> parametersMap) {
        if (parametersMap != null && !parametersMap.isEmpty()) {
            for (Map.Entry<String, Object> entry : parametersMap.entrySet()) {
                query.setParameter(entry.getKey(), entry.getValue());
            }
        }
    }

}
