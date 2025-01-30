package tiendaweb.controladores;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Autorizacion {
	public static boolean esAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String email = (String) request.getSession().getAttribute("email");

		if (email == null) {
			response.sendRedirect("login");
			return false;
		} else {
			return true;
		}
	}
}
