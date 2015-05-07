package br.com.ngz.base;

import java.io.Serializable;

/**
 * Interface que todos TO's devem implementar
 * para garantir sua serialização
 * @author andersonNoguez
 * @param <PK>
 */
public interface TransferObject<PK extends Serializable> extends BaseEntity<PK>{
}
