package br.com.ngz.base;

import java.io.Serializable;

/**
 * Interface que todas entidades devem implementar
 * @author Anderson Noguez
 * @param <PK>
 */

public interface BaseEntity<PK extends Serializable> extends Model{
    
    /**
     * Retorna o Id da entidade
     * @return
     */
    PK getId();  
    
    /**
     * Define o valor para o Id da entidade
     * @param id
     */
    void setId(PK id);
}
