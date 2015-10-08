package br.com.ngz.rest;

import javax.ws.rs.core.Application;

/**
 *
 * Classe responsavel pela inicializacao da Aplicacao
 * Inicializa o servlet REST e substitui a declaração no web.xml
 * 
 * @author Anderson Noguez
 */
public abstract class BaseApplication extends Application {

//    public abstract Logger getLogger();
    
    protected abstract void init();
}