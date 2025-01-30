package tiendaweb.controladores;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tiendaweb.modelos.Usuario;

public class Autorizacion {
	public static boolean estaAutenticado(HttpServletRequest request) {
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");

		return usuario != null;
	}
	
	public static boolean esAdmin(HttpServletRequest request) throws IOException {
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");

		if (usuario == null || !usuario.getRol().equals("ADMIN")) {
			return false;
		} else {
			return true;
		}
	}
	
	public static boolean esAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");

		if (usuario == null || !usuario.getRol().equals("ADMIN")) {
			response.sendRedirect("login");
			return false;
		} else {
			return true;
		}
	}
}
