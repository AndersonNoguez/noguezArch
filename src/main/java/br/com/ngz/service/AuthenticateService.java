package br.com.ngz.service;

import br.com.ngz.base.Authenticavel;
import javax.ejb.Local;

/**
 *
 * @author Anderson
 * @param <T>
 */
@Local
public interface AuthenticateService<T> {

    T verificaLogin(String login, String senha);

    T verificaLogin(Authenticavel entityXML);

    boolean isAuthenticate(String login, String senha);

    boolean isAuthenticate(T entityXML);

}
