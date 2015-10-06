package br.com.ngz.repository;

import br.com.ngz.base.Authenticavel;

/**
 *
 * @author Anderson
 */
public interface AuthenticateRepository {

    Authenticavel verificaLogin(String login, String senha);

}
