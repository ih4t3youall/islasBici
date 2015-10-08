import jIslas.Utils.DAOFactory;
import jIslas.Utils.PersistentManagerFactory;
import jIslas.model.Administrador;
import jIslas.model.Alquiler;
import jIslas.model.Bicicleta;
import jIslas.model.Estacion;
import jIslas.model.EstadoBicicleta;
import jIslas.model.EstadoEstacion;
import jIslas.model.EstadoUsuario;
import jIslas.model.RegistroBicicleta;
import jIslas.model.RegistroEstacion;
import jIslas.model.RegistroUsuario;
import jIslas.model.Usuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.primefaces.model.diagram.endpoint.DotEndPoint;


public class PersistenciaAdmin{

	public static void doTest(){
		/// Pruebas de Altas
				Administrador admin = new Administrador();
				admin.setApellido("Administrador");
				admin.setDni(1112223333);
				admin.setDomicilio("falso");
				admin.seteMail("admin@jBici.com");
				admin.setUserName("admin");
				admin.setPassword("123456");
				DAOFactory.getPersonaDAO().altaAdministrador(admin);
				
				Bicicleta bicicleta = new Bicicleta();
				bicicleta.setEstado(EstadoBicicleta.APTAPARAUSO);
				bicicleta.setFechaDeIngreso(new Date());
				bicicleta.setIdentificador("sdfsd");
				
				int cantBicicletaAnt = DAOFactory.getBicicletaDAO().getBicicletas().size();
				
				DAOFactory.getBicicletaDAO().altaBicicleta(bicicleta);
				
				
				List<Usuario> lU = DAOFactory.getPersonaDAO().getUsuarios();
				for(Usuario u: lU){
					u.setEstado(EstadoUsuario.HABILITADO);
					 DAOFactory.getPersonaDAO().updateUsuario(u);
				}
				/// Pruebas de Altas
						Usuario persona = new Usuario();
						persona.setApellido("Persona 1");
						persona.setDni(3245466);
						persona.setDomicilio("usy");
						persona.setPassword("1234");
						persona.seteMail("p@.com");
						persona.setEstado(EstadoUsuario.DESHABILITADOTEM);
						int cantPersonaAnt = DAOFactory.getPersonaDAO().getUsuarios().size();
						
						DAOFactory.getPersonaDAO().altaUsuario(persona);
						
						
						Administrador administrador = new Administrador();
						administrador.setApellido("Persona 1");
						administrador.setDni(3245466);
						administrador.setDomicilio("pepe");
						administrador.seteMail("p@.com");
						int cantadministradorAnt = DAOFactory.getPersonaDAO().getAdministradores().size();
						
						DAOFactory.getPersonaDAO().altaAdministrador(administrador);
						
						
						
					
						Bicicleta bicicleta2 = new Bicicleta();
						bicicleta.setEstado(EstadoBicicleta.APTAPARAUSO);
						bicicleta.setFechaDeIngreso(new Date());
						bicicleta.setIdentificador("sdfsd");
						
						int cantBicicletaAnt2 = DAOFactory.getBicicletaDAO().getBicicletas().size();
						
						DAOFactory.getBicicletaDAO().altaBicicleta(bicicleta2);
						
						
						
						
						Estacion estacion = new Estacion();
						estacion.setEstado(EstadoEstacion.ENCONTRUCCION);
						estacion.setUbicacionX(33L);
						estacion.setUbicacionY(34L);
						estacion.setNombre("EStacion de Prueba");

						
						int cantEstacionesAnt = DAOFactory.getEstacionDAO().getEstaciones().size();
						
						DAOFactory.getEstacionDAO().altaEstacion(estacion);
						
						
						
						RegistroBicicleta registroBici = new RegistroBicicleta();
						registroBici.setOriginante(persona);
						registroBici.setEstado(EstadoBicicleta.DESUSO);
						registroBici.setFecha(new Date());
						registroBici.setBicicleta(bicicleta);
						int cantadRegBiciAnt = DAOFactory.getRegistroBicicletaDAO().getRegistroBicicletas().size();
						
						DAOFactory.getRegistroBicicletaDAO().altaRegistroBicicleta(registroBici);
						
						
						
						
						
						RegistroEstacion registroEsta = new RegistroEstacion();
						registroEsta.setEstado(EstadoEstacion.ENCONTRUCCION);
						registroEsta.setFecha(new Date());
						registroEsta.setEstacion(estacion);
						int cantidadRegEstAnt = DAOFactory.getRegistroEstacionDAO().getRegistroEstaciones().size();
						
						DAOFactory.getRegistroEstacionDAO().altaRegistroEstacion(registroEsta);
						
						
						
						RegistroUsuario registroUSU = new RegistroUsuario();
						registroUSU.setEstado(EstadoUsuario.DESHABILITADODEF);
						registroUSU.setFecha(new Date());
						registroUSU.setUsuario(persona);
						int cantadRegUSUAnt = DAOFactory.getRegistroUsuarioDAO().getRegistroUsuarios().size();
						
						DAOFactory.getRegistroUsuarioDAO().altaRegistroUsuario(registroUSU);
						
						
						
						Alquiler alquiler = new Alquiler();
						List<Bicicleta> bicis = new ArrayList<Bicicleta>();
						bicis.add(bicicleta);
						alquiler.setBicicletas(bicis);
						alquiler.setDestino(estacion);
						alquiler.setFechaDeAlquiler(new Date());
						alquiler.setOrigen(estacion);
						alquiler.setUsuario(persona);
						
						int cantadAlquileres = DAOFactory.getAlquilerDAO().getAlquileres().size();
						
						DAOFactory.getAlquilerDAO().altaAlquiler(alquiler);
						
						
						
						///Cierro la Session
						
						PersistentManagerFactory.getEntityManager().close();
				

	}
	public static void main(String[] args) throws Exception {
		doTest();
	}

}


