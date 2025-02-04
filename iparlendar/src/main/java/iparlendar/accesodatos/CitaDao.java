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

	private static final String SQL_INSERT = """
			INSERT INTO citas 
				(asunto, inicio, fin, prioridad, descripcion, usuarios_id)
			VALUES
				('%s', '%s', '%s', '%s', '%s', %s)";
			""";

	private static final String SQL_UPDATE = """
			UPDATE citas 
			SET 
				asunto='%s', inicio='%s', fin='%s', prioridad='%s', descripcion='%s', usuarios_id=%s 
			WHERE 
				id=%s
			""";

	private static final String SQL_BORRAR = "DELETE FROM citas WHERE id=";

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
		try (Statement st = Globales.BASE_DE_DATOS.obtenerSentencia();
				ResultSet rs = st.executeQuery(SQL_SELECT_ID + id)) {

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
			throw new RuntimeException("Error al buscar el id de cita " + id, e);
		}
	}

	public static void insertar(Cita cita) {
		try (Statement st = Globales.BASE_DE_DATOS.obtenerSentencia()) {

			String sql = String.format(SQL_INSERT, cita.getAsunto(), cita.getInicio(), cita.getFin(),
					cita.getPrioridad(), cita.getDescripcion(), cita.getUsuario().getId());
			st.executeUpdate(sql);

		} catch (SQLException e) {
			throw new RuntimeException("Error al insertar una cita " + cita, e);
		}
	}

	public static void modificar(Cita cita) {
		try (Statement st = Globales.BASE_DE_DATOS.obtenerSentencia()) {

			String sql = String.format(SQL_UPDATE, cita.getAsunto(), cita.getInicio(), cita.getFin(),
					cita.getPrioridad(), cita.getDescripcion(), cita.getUsuario().getId(), cita.getId());
			st.executeUpdate(sql);

		} catch (SQLException e) {
			throw new RuntimeException("Error al modificar la cita " + cita, e);
		}
	}

	public static void borrar(Long id) {
		try (Statement st = Globales.BASE_DE_DATOS.obtenerSentencia()) {

			st.executeUpdate(SQL_BORRAR + id);

		} catch (SQLException e) {
			throw new RuntimeException("Error al borrar la cita " + id, e);
		}
	}
}
