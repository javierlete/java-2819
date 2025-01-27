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
}
