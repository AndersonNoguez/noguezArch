package br.com.ngz.arch.converter;

import br.com.ngz.arch.base.BaseEntity;
import java.util.Map;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Anderson Noguez
 */
@FacesConverter(forClass = BaseEntity.class, value = "baseEntity")
public class SimpleEntityConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
        if (value != null) {
            return this.getAttributesFrom(component).get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext ctx, UIComponent component, Object value) {

        if (value != null && !"".equals(value)) {

            BaseEntity entity = (BaseEntity) value;

            // adiciona item como atributo do componente
            this.addAttribute(component, entity);

            Integer codigo = (Integer) entity.getId();
            if (codigo != null) {
                return String.valueOf(codigo);
            }
        }

        return (String) value;
    }

    protected void addAttribute(UIComponent component, BaseEntity o) {
        String key = o.getId().toString(); // codigo do tipo como chave neste caso
        this.getAttributesFrom(component).put(key, o);
    }

    protected Map<String, Object> getAttributesFrom(UIComponent component) {
        return component.getAttributes();
    }
}
