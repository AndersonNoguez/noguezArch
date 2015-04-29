package br.com.ngz.base;

import org.primefaces.event.RowEditEvent;

/**
 *
 * @author andersonNoguez
 */
public interface BaseInterfaceBean<T> {
 
    public void init();
    // Salva os dados
    public void store() throws Exception;
    // Limpa os campos do formulário
    public void resetFields();
    // Apaga um ou mais registros pelos ids
    public void deleteByIds();
    // Edição grid
    public void onRowEdit (RowEditEvent event) throws Exception;
    // Cancelamento de edição da grid
    public void onRowCancel(RowEditEvent event);
}
