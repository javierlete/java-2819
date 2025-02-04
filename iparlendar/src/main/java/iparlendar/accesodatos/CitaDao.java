package iparlendar.accesodatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;

import iparlendar.modelos.Cita;
import iparlendar.modelos.Usuario;

public class CitaDao {
	
	private static String SQL_SELECT = """
			SELECT *
			FROM citas, usuarios
			WHERE usuarios_id = usuarios.id
			""";
	private static final String SQL_SELECT_ID = SQL_SELECT + " AND citas.id=";

	public static ArrayList<Cita> obtenerTodas() {
		try (Statement st = Globales.BASE_DE_DATOS.obtenerSentencia(); ResultSet rs = st.executeQuery(SQL_SELECT)) {
			ArrayList<Cita> citas = new ArrayList<Cita>();

			while (rs.next()) {
				Long id = rs.getLong("id");
				String asunto = rs.getString("asunto");
				String sInicio = rs.getString("inicio");
				String sFin = rs.getString("fin");
				String prioridad = rs.getString("prioridad");
				String descripcion = rs.getString("descripcion");
				
				Long idUsuario = rs.getLong("usuarios_id");
				String nombre = rs.getString("nombre");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String rol = rs.getString("rol");

				LocalDateTime inicio = LocalDateTime.parse(sInicio);
				LocalDateTime fin = LocalDateTime.parse(sFin);

				Usuario usuario = new Usuario(idUsuario, nombre, email, password, rol, null);

				Cita cita = new Cita(id, asunto, inicio, fin, prioridad, descripcion, usuario);

				citas.add(cita);
			}

			return citas;
		} catch (SQLException e) {
			throw new RuntimeException("Error en la búsqueda de todas las citas", e);
		}
	}

	public static Cita obtenerPorId(Long id) {
		try (Statement st = Globales.BASE_DE_DATOS.obtenerSentencia(); ResultSet rs = st.executeQuery(SQL_SELECT_ID + id)) {

			Cita cita = null;
			
			if (rs.next()) {
				String asunto = rs.getString("asunto");
				String sInicio = rs.getString("inicio");
				String sFin = rs.getString("fin");
				String prioridad = rs.getString("prioridad");
				String descripcion = rs.getString("descripcion");
				
				Long idUsuario = rs.getLong("usuarios_id");
				String nombre = rs.getString("nombre");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String rol = rs.getString("rol");

				LocalDateTime inicio = LocalDateTime.parse(sInicio);
				LocalDateTime fin = LocalDateTime.parse(sFin);

				Usuario usuario = new Usuario(idUsuario, nombre, email, password, rol, null);

				cita = new Cita(id, asunto, inicio, fin, prioridad, descripcion, usuario);
				
				System.out.println(cita);
			}
			
			return cita;

		} catch (SQLException e) {
			throw new RuntimeException("Error en la búsqueda de todas las citas", e);
		}
	}
}
