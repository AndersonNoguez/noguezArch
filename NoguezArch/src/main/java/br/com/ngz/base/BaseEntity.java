package br.com.ngz.base;

import java.io.Serializable;

/**
 * Interface que todas entidades devem implementar
 * @author Anderson Noguez
 * @param <T>
 */

public interface BaseEntity<T extends Serializable> extends Model{
    
    /**
     * Retorna o Id da entidade
     * @return
     */
    T getId();  
    
    /**
     * Define o valor para o Id da entidade
     * @param id
     */
    void setId(T id);
}
