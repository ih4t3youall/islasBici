package validatorsUI;

import jIslas.Utils.DAOFactory;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class NoRepetidoValidator implements Validator {

    @Override
    public void validate(FacesContext arg0, UIComponent arg1, Object arg2)
            throws ValidatorException {
    	if(!DAOFactory.getPersonaDAO().validarUsuarioByUserName((String)arg2)){
    		
    	    throw new ValidatorException(new FacesMessage(
                    "Debe elegir otro nombre de usuario, el actual esta en uso por otro usuario"));
        }
    }
}