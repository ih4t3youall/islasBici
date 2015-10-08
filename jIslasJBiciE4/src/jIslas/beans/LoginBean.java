package jIslas.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import jIslas.Utils.DAOFactory;
import jIslas.Utils.PersistentManagerFactory;
import jIslas.model.Administrador;
import jIslas.model.Alquiler;
import jIslas.model.Bicicleta;
import jIslas.model.Estacion;
import jIslas.model.EstadoBicicleta;
import jIslas.model.EstadoEstacion;
import jIslas.model.EstadoUsuario;
import jIslas.model.Persona;
import jIslas.model.RegistroBicicleta;
import jIslas.model.RegistroEstacion;
import jIslas.model.RegistroUsuario;
import jIslas.model.Usuario;
@ManagedBean(name="login")
@SessionScoped
public class LoginBean {
	private String userId;
	private String password;
	private Persona persona;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String usserId) {
		this.userId = usserId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String ingresar() {
		try {
			Usuario usu= DAOFactory.getPersonaDAO().getUsuarioByCredential(userId,password);
			if(usu != null){
				if(usu.getEstado().equals(EstadoUsuario.HABILITADO)){
				setPersona(usu);
				 HttpSession session = SessionBean.getSession();
		            session.setAttribute("username", userId);
		            session.setAttribute("usuario", usu);
		            session.setAttribute("admin", false);
		           return "usuario";
				}else{
					FacesContext.getCurrentInstance().addMessage(
			                null,
			                new FacesMessage(FacesMessage.SEVERITY_ERROR,
			                        "Su usuario esta deshabilitado",
			                        "Por favor contactese con el administrador"));
				
					return "fracaso";
				}
			} else{
				Administrador admin= DAOFactory.getPersonaDAO().getAdminByCredential(userId,password);
				if(admin != null){
					setPersona(admin);
					 HttpSession session = SessionBean.getSession();
			            session.setAttribute("username", userId);
			            session.setAttribute("usuario", admin);
			            session.setAttribute("admin", true);
					return "admin";
				} 
			}
			
		} catch (Exception e) {
			System.out.println(e.getStackTrace().toString());
			System.out.println(e.getMessage());
			return "fracaso";
		}
	
        FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(FacesMessage.SEVERITY_WARN,
                        "Nombre de usuario y Contraseña Incorrecto",
                        "Por favor ingrese la Nombre de usuario y Contraseña"));
	
		return "fracaso";
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public String logout() {
        HttpSession session = SessionBean.getSession();
        session.invalidate();
        return "login";
    }
	public String crearModelo() {
		/// Pruebas de Altas
		Administrador admin = new Administrador();
		admin.setApellido("Administrador");
		admin.setDni(1112223333);
		admin.setDomicilio("falso");
		admin.seteMail("admin@jBici.com");
		admin.setUserName("admin");
		admin.setPassword("12345");
		DAOFactory.getPersonaDAO().altaAdministrador(admin);
		
		Bicicleta bicicleta = new Bicicleta();
		bicicleta.setEstado(EstadoBicicleta.APTAPARAUSO);
		bicicleta.setFechaDeIngreso(new Date());
		bicicleta.setIdentificador("sdfsd");
		
				
		DAOFactory.getBicicletaDAO().altaBicicleta(bicicleta);
		bicicleta.setFechaDeIngreso(new Date());
		DAOFactory.getBicicletaDAO().updateBicicleta(bicicleta);
		
		
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
				
				Usuario persona1 = new Usuario();
				persona.setApellido("Persona 3");
				persona.setDni(3245466);
				persona.setDomicilio("usy");
				persona.setPassword("1234");
				persona.seteMail("p@.com");
				persona.setEstado(EstadoUsuario.DESHABILITADOTEM);
				
				
				DAOFactory.getPersonaDAO().altaUsuario(persona1);
				persona1.setApellido("joseses");
				
				DAOFactory.getPersonaDAO().updateUsuario(persona1);
				
				DAOFactory.getPersonaDAO().eliminarUsuario(persona1);
				
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
				bicicleta2=new Bicicleta();
				bicicleta.setEstado(EstadoBicicleta.APTAPARAUSO);
				bicicleta.setFechaDeIngreso(new Date());
				bicicleta.setIdentificador("sdfsd");
				DAOFactory.getBicicletaDAO().altaBicicleta(bicicleta2);
				
				bicicleta2.setFechaDeIngreso(new Date());
				DAOFactory.getBicicletaDAO().updateBicicleta(bicicleta2);
				DAOFactory.getBicicletaDAO().eliminarBicicleta(bicicleta2);
				
				
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
				
				
				DAOFactory.getAlquilerDAO().altaAlquiler(alquiler);
				alquiler.setFechaDeDevolucion(new Date());
				DAOFactory.getAlquilerDAO().updateAlquiler(alquiler);
				
				FacesContext fc = FacesContext.getCurrentInstance();
				if (fc != null) {
					fc.addMessage(null, new FacesMessage(
							FacesMessage.SEVERITY_INFO, "Se generaron datos",
							"Los datos fueron auditados para las pruebas"));
				}
        return "login";
    }

}
