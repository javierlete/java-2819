package tiendaweb.controladores;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tiendaweb.modelos.Producto;

@WebServlet("/listado")
public class ListadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Recoger información de la petición
//		Convertir la información recibida
//		Crear objetos en base a la información recibida
//		Ejecutar lógica de negocio
		ArrayList<Producto> productos = new ArrayList<Producto>();
		
		productos.add(new Producto(1L, "Producto 1", 12.12, 1.0));
		productos.add(new Producto(2L, "Producto 2", 22.12, 2.0));
		productos.add(new Producto(3L, "Producto 3", 32.12, 3.0));
		productos.add(new Producto(4L, "Producto 4", 42.12, 4.0));
		
//		Preparar los objetos para la siguiente vista
		request.setAttribute("productos", productos);
		
//		Saltar a la siguiente vista
		request.getRequestDispatcher("vistas/listado.jsp").forward(request, response);
	}
}
