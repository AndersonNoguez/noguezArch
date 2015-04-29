package br.com.ngz.base;

import br.com.ngz.service.CrudService;
import br.com.ngz.utils.JSFUtils;
import java.util.List;
import javax.faces.application.FacesMessage;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author anoguez
 * @param <T> Entidade principal
 */
public abstract class BaseBeanAction<T> implements BaseInterfaceBean<T> {

    public BaseBeanAction() {
    }
    
    @Override
    public void init() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void store() throws Exception {
        try {
            beforeStore();
            getService().save(getBean());
            JSFUtils.addMessage("registroCadastrado", "");
            resetFields();
        } catch (Exception e) {
            JSFUtils.addErrorMessage("registroNaoCadastrado", "");
        }

    }

    @Override
    public void deleteByIds() {
        try {
            if (getSelectedItens().isEmpty()) {
                JSFUtils.addMessage(FacesMessage.SEVERITY_WARN, "nenhumRegistroSelecionado", "");
                return;
            }

            getService().deleteByIds(getSelectedItens());
            JSFUtils.addMessage("registroExcluido", "");
        } catch (Exception e) {
            JSFUtils.addErrorMessage("registroNaoExcluido", "");
        }
    }

    @Override
    public void onRowEdit(RowEditEvent event) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onRowCancel(RowEditEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    protected abstract CrudService getService();
    
    protected abstract T getBean();

    protected abstract List<T> getSelectedItens();
    
    protected abstract void beforeStore();

}
