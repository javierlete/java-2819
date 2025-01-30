package tiendaweb.controladores;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tiendaweb.accesodatos.ProductoDao;
import tiendaweb.modelos.Producto;

@WebServlet("/adminlistado")
public class AdminListadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Recoger información de la petición
//		Convertir la información recibida
//		Crear objetos en base a la información recibida
//		Ejecutar lógica de negocio
		
		String email = (String)request.getSession().getAttribute("email");
		
		if(email == null) {
			response.sendRedirect("login");
			return;
		}
		
		ArrayList<Producto> productos = ProductoDao.obtenerProductos();
		
//		Preparar los objetos para la siguiente vista
		request.setAttribute("productos", productos);
		
//		Saltar a la siguiente vista
		request.getRequestDispatcher("vistas/adminlistado.jsp").forward(request, response);
	}
}
