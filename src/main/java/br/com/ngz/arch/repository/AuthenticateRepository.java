package br.com.ngz.arch.repository;

/**
 *
 * @author Anderson
 * @param <T>
 */
public interface AuthenticateRepository<T> {

    T verificaLogin(String login, String senha);

}
