package br.com.ngz.arch.repository;

import br.com.ngz.arch.base.Model;

/**
 *
 * @author Anderson
 * @param <E>
 */
public interface AuthenticateRepository<E extends Model> {

    E verificaLogin(String login, String senha);

}
