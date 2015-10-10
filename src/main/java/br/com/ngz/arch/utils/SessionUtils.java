package br.com.ngz.arch.utils;

import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author anderson
 */
@ManagedBean
@SessionScoped
@Stateless
public class SessionUtils {

    FacesContext context;
    HttpSession session;
    
    public SessionUtils() {
        this.context = FacesContext.getCurrentInstance();
        this.session = (HttpSession) context.getExternalContext().getSession(false);
    }

    
    
//    public Pessoa getUsuarioLogado(){
//        return (Pessoa)getSession().getAttribute("pessoa");
//    }
    
    public FacesContext getFacesContext() {  
        return FacesContext.getCurrentInstance();  
    }  
      
    public HttpSession getSession() {  
        return (HttpSession) getFacesContext().getExternalContext().getSession(false);  
    }  
      
    public HttpServletRequest getRequestSession() {  
        return (HttpServletRequest) getFacesContext().getExternalContext().getRequest();  
    }  
    
}
