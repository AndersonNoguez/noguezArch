package br.com.ngz.arch.service;

import br.com.ngz.arch.base.Authenticavel;
import br.com.ngz.arch.repository.AuthenticateRepository;
import javax.ejb.Local;

/**
 *
 * @author Anderson
 * @param <T>
 */
@Local
public interface AuthenticateService<T> {

    public abstract AuthenticateRepository getDAO();
    
    T verificaLogin(String login, String senha);

    T verificaLogin(Authenticavel entityXML);

    boolean isAuthenticate(String login, String senha);

    boolean isAuthenticate(T entityXML);

}
