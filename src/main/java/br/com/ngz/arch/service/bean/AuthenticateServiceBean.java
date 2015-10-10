package br.com.ngz.arch.service.bean;

import br.com.ngz.arch.base.Authenticavel;
import br.com.ngz.arch.repository.AuthenticateRepository;
import br.com.ngz.arch.service.AuthenticateService;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Anderson
 */
@Stateless
public class AuthenticateServiceBean<T> implements AuthenticateService<T>{

    @EJB
    private AuthenticateRepository<T> authenticateRepository;
    
    @Override
    public T verificaLogin(String login, String senha) {
        return (T) this.authenticateRepository.verificaLogin(login, senha);
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
