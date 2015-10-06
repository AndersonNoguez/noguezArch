package br.com.ngz.base;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author andersonNoguez
 * @param <T> Entidade principal
 */
public class BaseCriteria<T> {

    private CriteriaBuilder criteriaBuilder;
    private CriteriaQuery criteriaQuery;

    public BaseCriteria(EntityManager em) {
        this.criteriaBuilder = em.getCriteriaBuilder();
    }

    CriteriaBuilder getCriteriaBuilder() {
        return criteriaBuilder;
    }

//    CriteriaQuery<(1)Person> criteria = builder.createQuery( Person.class );
//Root<Person> personRoot = criteria.from( Person.class );
//criteria.selec(2)t( personRoot );
//criteria.where(3)( builder.equal( personRoot.get( Person_.eyeColor ), "brown" ) );
//List<Person> people = em.createQuery( criteria ).getResultList();
    public CriteriaQuery<T> createCriteria(T entity) {
        return (CriteriaQuery<T>) getCriteriaBuilder().createQuery(entity.getClass());
    }

    public Root addFrom(T entity, CriteriaQuery cq) {
        return cq.from(entity.getClass());
    }

    public void select(Root root, CriteriaQuery cq) {
        cq.select(root);
    }

    public void addWhere(CriteriaQuery cq) {
        cq.where();
    }

}
