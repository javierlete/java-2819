package controladores;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelos.Monitor;

@WebServlet("/listado")
public class ListadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recoger información de la petición
		// Convertir la información recibida
		// Crear objetos en base a la información recibida
		// Ejecutar lógica de negocio

		try {
			Class.forName("org.sqlite.JDBC");

			String url = "jdbc:sqlite:monitores.sqlite";
			String sql = "SELECT * FROM monitores";

			try (Connection con = DriverManager.getConnection(url); Statement st = con.createStatement()) {

				ResultSet rs = st.executeQuery(sql);

				ArrayList<Monitor> monitores = new ArrayList<Monitor>();

				while (rs.next()) {
					monitores.add(new Monitor(rs.getInt("id"), rs.getInt("ancho"), rs.getInt("alto"),
							rs.getInt("diagonal"), rs.getString("color")));
				}

				// Preparar los objetos para la siguiente vista
				request.setAttribute("monitores", monitores);

				// Saltar a la siguiente vista
				request.getRequestDispatcher("vistas/listado.jsp").forward(request, response);

				return;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
