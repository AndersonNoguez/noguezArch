package br.com.ngz.arch.repository.bean;

import br.com.ngz.arch.base.Authenticavel;
import br.com.ngz.arch.repository.AuthenticateRepository;
import br.com.ngz.arch.repository.BaseQueryDSL;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.EntityPath;
import java.io.Serializable;
import javax.persistence.Query;

public abstract class AuthenticateRepositoryBean<E extends Authenticavel, PK extends Serializable, Q extends EntityPath<E>> extends BaseQueryDSL<E, PK, Q> implements AuthenticateRepository<E> {

    @Override
    public E verificaLogin(String login, String password) {
        Q root = getRoot();
        JPAQuery query = new JPAQuery(entityManager);
        query = query.from(root);
        Query queryJPA = query.createQuery(root);
        return (E) queryJPA.getSingleResult();
    }

}
