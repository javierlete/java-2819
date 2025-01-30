package tiendaweb.controladores;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tiendaweb.accesodatos.ProductoDao;

@WebServlet("/adminborrar")
public class AdminBorrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		Recoger información de la petición
		String sId = request.getParameter("id");

//		Convertir la información recibida
		Long id = Long.parseLong(sId);
//		Crear objetos en base a la información recibida
//		Ejecutar lógica de negocio

		ProductoDao.borrar(id);

//		Preparar los objetos para la siguiente vista
//		Saltar a la siguiente vista
		response.sendRedirect("adminlistado");
	}
}
