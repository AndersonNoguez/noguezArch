package br.com.ngz.service.bean;

import br.com.ngz.base.Authenticavel;
import br.com.ngz.repository.AuthenticateRepository;
import br.com.ngz.service.AuthenticateService;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Anderson
 */
@Stateless
public abstract class AuthenticateServiceBean implements AuthenticateService{

    @EJB
    private AuthenticateRepository authenticateRepository;
    
    @Override
    public Authenticavel verificaLogin(String login, String senha) {
        return (Authenticavel) this.authenticateRepository.verificaLogin(login, senha);
    }

    @Override
    public Authenticavel verificaLogin(Authenticavel entityXML) {
        if (entityXML == null || entityXML.getLogin() == null && entityXML.getPassword() == null) {
            return null; //TODO refatorar para retornar mensagem de erro
        }
        return verificaLogin(entityXML.getLogin(), entityXML.getPassword());
    }

    @Override
    public boolean isAuthenticate(String login, String senha) {
        Authenticavel authenticavel = this.verificaLogin(login, senha);
        if (authenticavel != null) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public boolean isAuthenticate(Authenticavel entityXML) {
        if (entityXML == null || entityXML.getLogin() == null && entityXML.getPassword() == null) {
            return false; //TODO refatorar para retornar mensagem de erro
        }
        return isAuthenticate(entityXML.getLogin(), entityXML.getPassword());
    }

}
