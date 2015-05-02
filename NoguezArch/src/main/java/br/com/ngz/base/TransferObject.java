package br.com.ngz.base;

import java.io.Serializable;

/**
 * Interface que todos TO's devem implementar
 * para garantir sua serialização
 * @author andersonNoguez
 * @param <T>
 */
public interface TransferObject<T extends Serializable> extends BaseEntity<T>{
}
