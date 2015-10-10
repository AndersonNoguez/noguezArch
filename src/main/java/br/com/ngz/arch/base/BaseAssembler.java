package br.com.ngz.arch.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Interface de base para construção dos assemblers
 *
 * @author andersonNoguez
 * @param <T> TO
 * @param <M> Model
 */
public abstract class BaseAssembler<T, M> implements Serializable {

    /**
     * Cria uma TO a partir de um Model.
     *
     * @param model
     * @return TO
     */
    public abstract T createTO(final M model);

    /**
     * Cria um Model a partir de um TO.
     *
     * @param transferObject
     * @return model
     */
    public abstract M createModel(final T transferObject);

    /**
     * Cria uma lista de Model
     *
     * @param listTO
     * @return listM
     */
    public List<M> createModelList(final List<T> listTO) {
        List<M> listModel = new ArrayList<>();

        for (T to : listTO) {
            listModel.add(createModel(to));
        }

        return listModel;
    }

    /**
     * Cria uma lista de TO
     *
     * @param listModel
     * @return listTO
     */
    public List<T> createTOList(final List<M> listModel) {
        List<T> listTO = new ArrayList<>();

        for (M model : listModel) {
            listTO.add(createTO(model));
        }

        return listTO;
    }
}
