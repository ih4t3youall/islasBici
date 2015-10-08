package jIslas.DAOImpl;

import jIslas.DAO.PersonaDAO;
import jIslas.model.Administrador;
import jIslas.model.Persona;
import jIslas.model.Usuario;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PersonaDAOImpl implements PersonaDAO {
	private GenericDao genericDao = new GenericDao();

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> getUsuarios() {
		return (List<Usuario>) (List<?>) (getGenericDao().getAll(Usuario.class));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Administrador> getAdministradores() {
		return (List<Administrador>) (List<?>) (getGenericDao()
				.getAll(Administrador.class));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Persona> getPersonas() {

		return (List<Persona>) (List<?>) (getGenericDao().getAll(Persona.class));
	}

	@Override
	public Usuario getUsuarioById(Long id) {
		return (Usuario) getGenericDao().getObjectById(Persona.class, id);
	}

	@Override
	public Administrador getAdministradorById(Long id) {
		return (Administrador) getGenericDao().getObjectById(
				Administrador.class, id);
	}

	@Override
	public void altaUsuario(Usuario usuario) {
		getGenericDao().alta(usuario);

	}

	@Override
	public void altaAdministrador(Administrador persona) {
		getGenericDao().alta(persona);

	}

	public GenericDao getGenericDao() {
		return genericDao;
	}

	public void setGenericDao(GenericDao genericDao) {
		this.genericDao = genericDao;
	}

	@Override
	public void updateUsuario(Usuario persona) {
		getGenericDao().update(persona);
	}

	@Override
	public void updateAdministrador(Administrador persona) {
		getGenericDao().update(persona);
	}

	@Override
	public void eliminarUsuario(Usuario persona) {
		getGenericDao().eliminar(persona);

	}

	@Override
	public void eliminarAdministrador(Administrador persona) {
		getGenericDao().eliminar(persona);

	}

	@Override
	public Usuario getUsuarioByCredential(String userName, String password) {
		EntityManager em = getGenericDao().getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		List<Usuario> lU = (List<Usuario>) em.createQuery(
				"from Usuario u where u.userName ='" + userName
						+ "' and u.password='" + password + "'")
				.getResultList();
		Usuario result = null;
		if (lU.size() > 0) {
			result = lU.get(0);
		}
		et.commit();
		return result;
	}
	@Override
	public Boolean validarUsuarioByUserName(String userName) {
		EntityManager em = getGenericDao().getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		List<Usuario> lU = (List<Usuario>) em.createQuery(
				"from Usuario u where u.userName ='" + userName + "'")
				.getResultList();

		et.commit();
		if (lU.size() > 0) {
			return false;
		} else{
			return true;
		}
	}

	@Override
	public Administrador getAdminByCredential(String userName, String password) {
		EntityManager em = getGenericDao().getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		List<Administrador> lA = (List<Administrador>) em.createQuery(
				"from Administrador u where u.userName ='" + userName
						+ "' and u.password='" + password + "'")
				.getResultList();
		Administrador result = null;
		if (lA.size() > 0) {
			result = lA.get(0);
		}
		et.commit();
		return result;
	}

}
