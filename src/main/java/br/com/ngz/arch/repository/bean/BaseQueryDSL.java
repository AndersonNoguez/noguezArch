package br.com.ngz.arch.repository.bean;

import br.com.ngz.arch.base.Model;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.EntityPath;
import com.mysema.query.types.Predicate;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author anoguez
 * @param <E>
 * @param <I>
 * @param <Q>
 */
public abstract class BaseQueryDSL<E extends Model, I extends Serializable, Q extends EntityPath<E>> extends BaseDAO<E, I>{
    protected abstract Q getRoot();
    protected abstract List<Predicate> getWhere(HashMap<String,Object> mapParameters);
    
    /**
     * Adiciona a clausula where na query
     * @param query
     * @param mapParameters
     */
    protected void addWhere(JPAQuery query, HashMap<String,Object> mapParameters) {
        List<Predicate> predicates = getWhere(mapParameters);
        if (!predicates.isEmpty()) {
            query = (predicates.size() == 1) ? query.where(predicates.get(0)) : query.where(predicates.toArray(new Predicate[0]));
        }
    }
    
}
