package tiendaweb.controladores;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/adminproducto")
public class AdminProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Recoger información de la petición
//		Convertir la información recibida
//		Crear objetos en base a la información recibida
//		Ejecutar lógica de negocio
//		Preparar los objetos para la siguiente vista
//		Saltar a la siguiente vista
		request.getRequestDispatcher("vistas/adminproducto.jsp").forward(request, response);
	}
}
