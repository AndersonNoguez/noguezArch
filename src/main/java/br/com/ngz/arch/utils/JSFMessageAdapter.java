package br.com.ngz.arch.utils;

import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class JSFMessageAdapter {

    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("messages");

    private JSFMessageAdapter() {
    }

    public static void addMessage(FacesMessage.Severity severity, String keySummary, String keyDetail) {
        FacesMessage message = new FacesMessage(severity, getMensagem(keySummary), keyDetail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public static void addMessage(String keySummary, String keyDetail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, getMensagem(keySummary), keyDetail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public static void addErrorMessage(String keySummary, String keyDetail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, getMensagem(keySummary), keyDetail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public static String getMensagem(String key) {
        return resourceBundle.getString(key);
    }
}
