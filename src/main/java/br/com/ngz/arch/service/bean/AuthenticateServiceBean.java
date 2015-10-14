package br.com.ngz.arch.service.bean;

import br.com.ngz.arch.base.Authenticavel;
import br.com.ngz.arch.service.AuthenticateService;

/**
 *
 * @author Anderson
 * @param <T>
 */
public abstract class AuthenticateServiceBean<T extends Authenticavel> implements AuthenticateService<T>{
    
    @Override
    public T verificaLogin(String login, String senha) {
        return (T) this.getDAO().verificaLogin(login, senha);
    }

    @Override
    public T verificaLogin(Authenticavel entityXML) {
        if (entityXML == null || entityXML.getLogin() == null && entityXML.getPassword() == null) {
            return null; //TODO refatorar para retornar mensagem de erro
        }
        return verificaLogin(entityXML.getLogin(), entityXML.getPassword());
    }

    @Override
    public boolean isAuthenticate(String login, String senha) {
        T authenticavel = this.verificaLogin(login, senha);
        if (authenticavel != null) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public boolean isAuthenticate(T entityXML) {
        if (entityXML == null || ((Authenticavel)entityXML).getLogin() == null && ((Authenticavel)entityXML).getPassword() == null) {
            return false; //TODO refatorar para retornar mensagem de erro
        }
        return isAuthenticate(((Authenticavel)entityXML).getLogin(), ((Authenticavel)entityXML).getPassword());
    }

}
