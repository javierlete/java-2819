package tiendaweb.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import tiendaweb.modelos.Usuario;

// CRUD: Create Read Update Delete
// DAO:  Data Access Object

public class UsuarioDao {
	private static final String URL = "jdbc:sqlite:tiendaweb.sqlite";
	private static final String USER = "";
	private static final String PASS = "";

	private static final String SQL_SELECT_EMAIL = "SELECT * FROM usuarios WHERE email='%s'";

	private static Statement obtenerSentencia() {
		try {
			Class.forName("org.sqlite.JDBC");

			Connection con = DriverManager.getConnection(URL, USER, PASS);
			return con.createStatement();
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException("No se ha podido conectar con la base de datos", e);
		}
	}

	public static Usuario obtenerPorEmail(String email) {
		String sql = String.format(SQL_SELECT_EMAIL, email);
		try (Statement st = obtenerSentencia(); ResultSet rs = st.executeQuery(sql)) {

			if (rs.next()) {
				return new Usuario(rs.getLong("id"), rs.getString("email"), rs.getString("password"),
						rs.getString("rol"));

			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException("No se ha podido obtener el usuario " + email, e);
		}
	}
}
