package br.com.ngz.service;

import br.com.ngz.base.Authenticavel;
import javax.ejb.Local;

/**
 *
 * @author Anderson
 */
@Local
public interface AuthenticateService {

    Authenticavel verificaLogin(String login, String senha);

    Authenticavel verificaLogin(Authenticavel entityXML);

    boolean isAuthenticate(String login, String senha);

    boolean isAuthenticate(Authenticavel entityXML);

}
