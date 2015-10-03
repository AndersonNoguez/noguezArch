package br.com.ngz.repository.bean;

import br.com.ngz.base.Authenticavel;
import br.com.ngz.repository.AuthenticateRepository;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class AuthenticateRepositoryBean implements AuthenticateRepository {

    @PersistenceContext
    protected EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public Authenticavel verificaLogin(String login, String password) {
        Query query = getEntityManager().createQuery(
                "FROM " + Authenticavel.class.getName() + " p "
                + "WHERE p.login = :login"
                + " and p.password = :password"
        );

        query.setParameter("login", login);
        query.setParameter("password", password);

        return (Authenticavel) query.getSingleResult();
    }

}
