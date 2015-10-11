package br.com.ngz.arch.repository.bean;

import br.com.ngz.arch.repository.AuthenticateRepository;
import java.lang.reflect.ParameterizedType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public abstract class AuthenticateRepositoryBean<T> implements AuthenticateRepository<T> {

    @PersistenceContext
    protected EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public T verificaLogin(String login, String password) {
        Query query = getEntityManager().createQuery(
                "FROM " + getTypeClass().getName() + " p "
                + "WHERE p.login = :login"
                + " and p.password = :password"
        );

        query.setParameter("login", login);
        query.setParameter("password", password);

        return (T) query.getSingleResult();
    }

    private Class<?> getTypeClass() {
        return (Class<?>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }
    
}
