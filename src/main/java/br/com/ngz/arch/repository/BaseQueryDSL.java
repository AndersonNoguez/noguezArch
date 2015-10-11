package br.com.ngz.arch.repository;

import br.com.ngz.arch.base.Model;
import com.mysema.query.types.EntityPath;
import java.io.Serializable;

/**
 *
 * @author anoguez
 * @param <E>
 * @param <I>
 * @param <Q>
 */
public abstract class BaseQueryDSL<E extends Model, I extends Serializable, Q extends EntityPath<E>> extends BaseDAO<E, I>{
    protected abstract Q getRoot();
}
