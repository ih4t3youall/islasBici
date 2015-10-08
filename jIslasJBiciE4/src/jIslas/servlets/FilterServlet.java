package jIslas.servlets;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebFilter(filterName = "AuthFilter", urlPatterns = { "*.xhtml"})
public class FilterServlet implements Filter {

	public FilterServlet() {
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		try {
			
			HttpServletRequest reqt = (HttpServletRequest) request;
			HttpServletResponse resp = (HttpServletResponse) response;
			HttpSession ses = reqt.getSession(false);
			
			String reqURI = reqt.getRequestURI();
			if (reqURI.indexOf("/index.xhtml") >= 0
					|| reqURI.indexOf("/registracion.xhtml") >= 0
					|| reqURI.indexOf("/public/") >= 0
					|| reqURI.indexOf("/resources/") >= 0
					|| reqURI.indexOf("estadisticas") >= 0
					|| reqURI.contains("javax.faces.resource")
					|| reqURI.contains("rest"))
			{
				chain.doFilter(request, response);
			} else if (reqURI.indexOf("/adminPages/") == -1
					&& (ses != null && ses.getAttribute("username") != null)) {
				chain.doFilter(request, response);
			} else {
				if (ses != null && ses.getAttribute("username") != null
						&& (Boolean) ses.getAttribute("admin")) {
					chain.doFilter(request, response);
				} else {
					FacesContext fc = FacesContext.getCurrentInstance();
					if (fc != null) {
						fc.addMessage(null, new FacesMessage(
								FacesMessage.SEVERITY_ERROR, "Acceso Denegado",
								"Por favor inicie session o registrese"));
					}
					resp.sendRedirect(reqt.getContextPath()
							+ "/faces/index.xhtml");
				}
			}
		} catch (Exception e) {
			System.out.println(e.getStackTrace().toString());
			System.out.println(e.getMessage());
			FacesContext fc = FacesContext.getCurrentInstance();
			if (fc != null) {
				fc.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Error de Procesamiento",
						"Ocurrieron Errores en el procesamiento"));
			}
		}
	}

	@Override
	public void destroy() {

	}
}