package tiendaweb.controladores;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tiendaweb.accesodatos.ProductoDao;
import tiendaweb.modelos.Producto;

@WebServlet("/adminproducto")
public class AdminProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (Autorizacion.esAdmin(request, response)) {
//			Recoger información de la petición
			String sId = request.getParameter("id");

//			Convertir la información recibida
			Long id = sId != null ? Long.parseLong(sId) : null;

//			Crear objetos en base a la información recibida
//			Ejecutar lógica de negocio

			if (id != null) {
				Producto producto = ProductoDao.obtenerPorId(id);

//				Preparar los objetos para la siguiente vista
				request.setAttribute("producto", producto);
			}
//			Saltar a la siguiente vista
			request.getRequestDispatcher("vistas/adminproducto.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (Autorizacion.esAdmin(request, response)) {
//			Recoger información de la petición
			String sId = request.getParameter("id");
			String nombre = request.getParameter("nombre");
			String sPrecio = request.getParameter("precio");
			String sDescuento = request.getParameter("descuento");

//			Convertir la información recibida
			Long id = sId.isBlank() ? null : Long.parseLong(sId);
			Double precio = Double.parseDouble(sPrecio);
			Double descuento = Double.parseDouble(sDescuento);

//			Crear objetos en base a la información recibida
			Producto producto = new Producto(id, nombre, precio, descuento);

//			Ejecutar lógica de negocio
			if (id == null) {
				ProductoDao.insertar(producto);
			} else {
				ProductoDao.modificar(producto);
			}

//			Preparar los objetos para la siguiente vista
//			Saltar a la siguiente vista
			response.sendRedirect("adminlistado");
		}
	}
}
