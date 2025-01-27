package tiendaweb.controladores;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tiendaweb.modelos.Producto;

@WebServlet("/adminproducto")
public class AdminProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String URL = "jdbc:sqlite:tiendaweb.sqlite";
	private static final String SQL_SELECT = "SELECT * FROM productos WHERE id=";
	
	private static final String SQL_INSERT = "INSERT INTO productos (nombre, precio, descuento) VALUES ('%s', %s, %s)";
	private static final String SQL_UPDATE = "UPDATE productos SET nombre='%s', precio=%s, descuento=%s WHERE id=%s";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		Recoger información de la petición
		String id = request.getParameter("id");

//		Convertir la información recibida
//		Crear objetos en base a la información recibida
//		Ejecutar lógica de negocio

		if (id != null) {
			try {
				Class.forName("org.sqlite.JDBC");

				try (Connection con = DriverManager.getConnection(URL);
						Statement st = con.createStatement();
						ResultSet rs = st.executeQuery(SQL_SELECT + id)) {

					if (rs.next()) {
						Producto producto = new Producto(rs.getLong("id"), rs.getString("nombre"), rs.getDouble("precio"),
								rs.getDouble("descuento"));
//						Preparar los objetos para la siguiente vista
						request.setAttribute("producto", producto);
					}
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		Saltar a la siguiente vista
		request.getRequestDispatcher("vistas/adminproducto.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		Recoger información de la petición
		String sId = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String sPrecio = request.getParameter("precio");
		String sDescuento = request.getParameter("descuento");
		
//		Convertir la información recibida
		Long id = Long.parseLong(sId);
		Double precio = Double.parseDouble(sPrecio);
		Double descuento = Double.parseDouble(sDescuento);
		
//		Crear objetos en base a la información recibida
		Producto producto = new Producto(id, nombre, precio, descuento);
		
//		Ejecutar lógica de negocio
		try {
			Class.forName("org.sqlite.JDBC");

			try (Connection con = DriverManager.getConnection(URL);
					Statement st = con.createStatement()) {

				String sql = String.format(SQL_UPDATE, producto.getNombre(), producto.getPrecio(), producto.getDescuento(), producto.getId());
				st.executeUpdate(sql);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		Preparar los objetos para la siguiente vista
//		Saltar a la siguiente vista
		response.sendRedirect("adminlistado");
	}
}
