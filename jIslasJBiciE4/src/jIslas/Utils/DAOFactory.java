package jIslas.Utils;

import jIslas.DAO.AlquilerDAO;
import jIslas.DAO.BicicletaDAO;
import jIslas.DAO.EstacionDAO;
import jIslas.DAO.EstadisticasDAO;
import jIslas.DAO.PersonaDAO;
import jIslas.DAO.RegistroBicicletaDAO;
import jIslas.DAO.RegistroEstacionDAO;
import jIslas.DAO.RegistroUsuarioDAO;
import jIslas.DAOImpl.AlquilerDAOImpl;
import jIslas.DAOImpl.BicicletaDAOImpl;
import jIslas.DAOImpl.EstacionDAOImpl;
import jIslas.DAOImpl.EstadisticasDaoImpl;
import jIslas.DAOImpl.PersonaDAOImpl;
import jIslas.DAOImpl.RegistroBicicletaDAOImpl;
import jIslas.DAOImpl.RegistroEstacionDAOImpl;
import jIslas.DAOImpl.RegistroUsuarioDAOImpl;

public class DAOFactory {
	static final AlquilerDAO alquilerDao = new AlquilerDAOImpl();
	public static AlquilerDAO getAlquilerDAO(){
		return alquilerDao;
	}
	static final BicicletaDAO bicicletaDAO = new BicicletaDAOImpl();
	public static BicicletaDAO getBicicletaDAO(){
		return bicicletaDAO;
	}
	static final EstacionDAO estacionDAO = new EstacionDAOImpl();
	public static EstacionDAO getEstacionDAO(){
		return estacionDAO;
	}
	static final PersonaDAO personaDAO = new PersonaDAOImpl();
	public static PersonaDAO getPersonaDAO(){
		return personaDAO;
	}
	static final RegistroBicicletaDAO registroBicicletaDAO = new RegistroBicicletaDAOImpl();
	public static RegistroBicicletaDAO getRegistroBicicletaDAO(){
		return registroBicicletaDAO;
	}
	static final RegistroEstacionDAO registroEstacionDAO = new RegistroEstacionDAOImpl();
	public static RegistroEstacionDAO getRegistroEstacionDAO(){
		return registroEstacionDAO;
	}
	static final RegistroUsuarioDAO registroUsuarioDAO = new RegistroUsuarioDAOImpl();
	public static RegistroUsuarioDAO getRegistroUsuarioDAO(){
		return registroUsuarioDAO;
	}
	static final EstadisticasDAO estadisticasDao = new EstadisticasDaoImpl();
	public static EstadisticasDAO getEstadisticasDao(){
		return estadisticasDao;
	}

}
