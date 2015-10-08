package jIslas.converters;

import jIslas.Utils.DAOFactory;
import jIslas.model.Estacion;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter("estacionConverter")
public class EstacionConverter implements Converter{

    private List<Estacion> objects;

    public EstacionConverter(){
        this.objects = DAOFactory.getEstacionDAO().getEstaciones();
    }

    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getMyObject(value);
    }

    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null) {
            return null;
        }
        return String.valueOf(((Estacion) value).getId()).toString();
    }

    public Estacion getMyObject(String id) {
       for (Estacion estacion : objects) {
            if(estacion.getId().equals(Long.valueOf(id))) {
                return estacion;
            }
        }
        return null;
    }

}