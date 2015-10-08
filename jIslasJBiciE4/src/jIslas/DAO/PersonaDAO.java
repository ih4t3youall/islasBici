package jIslas.DAO;

import jIslas.model.Administrador;
import jIslas.model.Persona;
import jIslas.model.Usuario;

import java.util.List;

public interface PersonaDAO {
	public List<Usuario> getUsuarios();

	public List<Administrador> getAdministradores();

	public List<Persona> getPersonas();

	public Usuario getUsuarioById(Long id);
	
	public Administrador getAdministradorById(Long id);

	public void altaUsuario(Usuario persona);
	
	public void altaAdministrador(Administrador persona);

	public void updateUsuario(Usuario persona);
	
	public void updateAdministrador(Administrador persona);
	
	public void eliminarUsuario(Usuario persona);
	
	public void eliminarAdministrador(Administrador persona);
	
	public Usuario getUsuarioByCredential(String userName, String password);

	public Administrador getAdminByCredential(String userName, String password);
	
	public Boolean validarUsuarioByUserName(String userName) ;
}
