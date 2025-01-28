package tiendaweb.controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/adminborrar")
public class AdminBorrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final String URL = "jdbc:sqlite:tiendaweb.sqlite";

	private static final String SQL_DELETE = "DELETE FROM productos WHERE id=";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Recoger información de la petición
		String id = request.getParameter("id");
		
//		Convertir la información recibida
//		Crear objetos en base a la información recibida
//		Ejecutar lógica de negocio
		try {
			Class.forName("org.sqlite.JDBC");

			try (Connection con = DriverManager.getConnection(URL); Statement st = con.createStatement()) {

				st.executeUpdate(SQL_DELETE + id);
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
