package jIslas.DAO;

import jIslas.model.RegistroUsuario;

import java.util.List;

public interface RegistroUsuarioDAO {
	public List<RegistroUsuario> getRegistroUsuarios();

	public RegistroUsuario getRegistroUsuarioById(Long id);

	public void altaRegistroUsuario(RegistroUsuario registroUsuario);

	public void updateRegistroUsuario(RegistroUsuario registroUsuario);

	public void eliminarRegistroUsuario(RegistroUsuario registroUsuario);

}
