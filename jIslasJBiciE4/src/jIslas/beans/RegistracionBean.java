package jIslas.beans;

import jIslas.Utils.DAOFactory;
import jIslas.model.Administrador;
import jIslas.model.Persona;
import jIslas.model.Sexo;
import jIslas.model.Usuario;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "registracion")
@SessionScoped
public class RegistracionBean {

	private Persona usuario;
	private String password2;
	private String password;

	public RegistracionBean() {
		HttpSession session = SessionBean.getSession();
		if (session != null && session.getAttribute("usuario") != null) {
			this.usuario = (Persona) session.getAttribute("usuario");
		}else{
			this.usuario = new Usuario();
		}

	}
	/**
	 * Utilizado cuando se da de alta desde el perfil administrador otro administrador. 
	 */
	public void iniciarRegistracionAdmin(){
		this.usuario = new Administrador();
	}

	public SelectItem[] getSexos() {
		SelectItem[] items = new SelectItem[Sexo.values().length];
		int i = 0;
		for (Sexo g : Sexo.values()) {
			items[i++] = new SelectItem(g, g.getLabel());
		}
		return items;
	}

	public Persona getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNombre() {
		return usuario.getNombre();
	}

	public void setNombre(String nombre) {
		this.usuario.setNombre(nombre);
	}

	public String getApellido() {
		return this.usuario.getApellido();
	}

	public void setApellido(String apellido) {
		this.usuario.setApellido(apellido);
	}

	public String getDomicilio() {
		return this.usuario.getDomicilio();
	}

	public void setDomicilio(String domicilio) {
		this.usuario.setDomicilio(domicilio);
	}

	public Integer getDni() {
		return this.usuario.getDni();
	}

	public void setDni(Integer dni) {
		this.usuario.setDni(dni);
	}

	public String getUserName() {
		return this.usuario.getUserName();
	}

	public void setUserName(String userName) {
		this.usuario.setUserName(userName);
	}

	public String getTelefono() {
		return this.usuario.getTelefono();
	}

	public void setTelefono(String telefono) {
		this.usuario.setTelefono(telefono);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String passsword) {
		password = passsword;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String passsword) {
		password2 = passsword;
	}

	public Sexo getSexo() {
		return this.usuario.getSexo();
	}

	public void setSexo(Sexo sexo) {
		this.usuario.setSexo(sexo);
	}

	public Date getFechaDeNacimiento() {
		return this.usuario.getFechaDeNacimiento();
	}

	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.usuario.setFechaDeNacimiento(fechaDeNacimiento);
	}

	public String geteMail() {
		return this.usuario.geteMail();
	}

	public void seteMail(String eMail) {
		this.usuario.seteMail(eMail);
	}

	public String registrar() {
		try {
			if(this.usuario instanceof Usuario){
			this.usuario.setPassword("1234");
			DAOFactory.getPersonaDAO().altaUsuario((Usuario) this.usuario);
			FacesContext
					.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(
									FacesMessage.SEVERITY_WARN,
									"La contraseña autogenerada para usted es '1234'",
									"Por favor ingrese recuerdela, puede modificarla desde su perfil"));
			HttpSession session = SessionBean.getSession();
			session.setAttribute("username", this.usuario.getUserName());
			session.setAttribute("usuario", this.usuario);
			return "usuario";
			
			}else{
				DAOFactory.getPersonaDAO()
				.altaAdministrador((Administrador) this.usuario);
				FacesContext
				.getCurrentInstance()
				.addMessage(
						null,
						new FacesMessage(
								FacesMessage.SEVERITY_WARN,
								"El usuario a sido agregado con contraseña '1234'",
								"Por favor, informeselá al nuevo administrador"));
	
				return "admin";
			}
		} catch (Exception e) {
			return "fracaso";
		}
	}

	public void modificarUsuario() {
		try {
			boolean actualizar = chequearContraseña();

			if (actualizar) {
				boolean mostrarMensajeContrasenasOk = false;
				if (password != null && !password.isEmpty()) {
					this.usuario.setPassword(password);
					mostrarMensajeContrasenasOk = true;
				}
				if(this.usuario instanceof Usuario){
					DAOFactory.getPersonaDAO()
					.updateUsuario((Usuario) this.usuario);
			
				}else{
					DAOFactory.getPersonaDAO()
					.updateAdministrador((Administrador) this.usuario);
				}
				FacesContext
						.getCurrentInstance()
						.addMessage(
								null,
								new FacesMessage(
										FacesMessage.SEVERITY_INFO,
										"Los datos del perfil de usuario han sido modificados correctamente",
										null));
				if (mostrarMensajeContrasenasOk) {
					FacesContext
							.getCurrentInstance()
							.addMessage(
									null,
									new FacesMessage(
											FacesMessage.SEVERITY_INFO,
											"La contraseñas de usuario ha sido actualizada correctamente",
											null));

				}
			}
		} catch (Exception e) {
			FacesContext
					.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(
									FacesMessage.SEVERITY_ERROR,
									"Hubo un error al intentar actualizar los datos del perfil de usuario",
									null));

		} finally {
			password = "";
			password2 = "";

		}

	}
	
	private boolean chequearContraseña() {
		boolean valido = false;
		if (password != null) {
			if (password.equals(password2)) {
				valido = true;
			} else {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Las contraseñas ingresadas no coinciden",
								"Por favor ingrese una nueva Contraseña"));
			}
		} else if (password2 != null) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Las contraseñas ingresadas no coinciden",
							"Por favor ingrese una nueva Contraseña"));

		}
		return valido;
	}
}
