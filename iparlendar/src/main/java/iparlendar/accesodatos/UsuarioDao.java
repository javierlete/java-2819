package iparlendar.accesodatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import iparlendar.modelos.Usuario;

public class UsuarioDao {
	
	private static final String SQL_SELECT = "SELECT * FROM usuarios";
	private static final String SQL_SELECT_EMAIL = SQL_SELECT + " WHERE email='%s'";

	public static ArrayList<Usuario> obtenerTodos() {
		try (Statement st = Globales.BASE_DE_DATOS.obtenerSentencia();
				ResultSet rs = st.executeQuery(SQL_SELECT)) {
			ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
			
			while(rs.next()) {
				usuarios.add(new Usuario(rs.getLong("id"), rs.getString("nombre"), rs.getString("email"), rs.getString("password"), rs.getString("rol"), null));
			}
			
			return usuarios;
		} catch (SQLException e) {
			throw new RuntimeException("No se han podido obtener los usuarios", e);
		}
	}

	public static Usuario obtenerPorEmail(String email) {
		String sql = String.format(SQL_SELECT_EMAIL, email);
		try (Statement st = Globales.BASE_DE_DATOS.obtenerSentencia();
				ResultSet rs = st.executeQuery(sql)) {
			
			Usuario usuario = null;
			
			if(rs.next()) {
				usuario = new Usuario(rs.getLong("id"), rs.getString("nombre"), rs.getString("email"), rs.getString("password"), rs.getString("rol"), null);
			}
			
			return usuario;
		} catch (SQLException e) {
			throw new RuntimeException("No se han podido obtener los usuarios", e);
		}
	}
	
}
