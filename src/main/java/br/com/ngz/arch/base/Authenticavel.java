package br.com.ngz.arch.base;

import java.io.Serializable;

/**
 *
 * @author Anderson
 * @param <PK>
 */
public interface Authenticavel<PK extends Serializable> extends BaseEntity<PK> {

    String getLogin();

    void setLogin(String login);

    String getPassword();

    void setPassword(String password);

}
