package jIslas.beans;

import jIslas.Utils.DAOFactory;
import jIslas.model.Administrador;
import jIslas.model.EstadoUsuario;
import jIslas.model.Persona;
import jIslas.model.Usuario;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name ="usuariosBean")
@RequestScoped
public class UsuariosBean {
	
	List<Usuario> usuarios = null; 
	
	Usuario usarioSeleccionado;
	
	@PostConstruct
    public void init() {
		usuarios = DAOFactory.getPersonaDAO().getUsuarios();
    }
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
 
    public Usuario getUsuarioSeleccionado() {
        return usarioSeleccionado;
    }
 
    public void setUsuarioSeleccionado(Usuario usuario) {
        this.usarioSeleccionado = usuario;
    }
     
    public String eliminar(Persona usuario){
    	if(usuario instanceof Usuario){
    		 if(((Usuario) usuario).getEstado().equals(EstadoUsuario.HABILITADO)){
    			 ((Usuario) usuario).setEstado(EstadoUsuario.DESHABILITADODEF);
    		 }else{
    			 ((Usuario) usuario).setEstado(EstadoUsuario.HABILITADO);
    		 }
    		 DAOFactory.getPersonaDAO().updateUsuario((Usuario)usuario);
    	}else{
    		DAOFactory.getPersonaDAO().eliminarAdministrador((Administrador)usuario);
    	}
    	return "administrarUsuarios";
    }
    
	

}
