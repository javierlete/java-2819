package iparlendar.accesodatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;

import bibliotecas.BaseDeDatos;
import iparlendar.modelos.Cita;
import iparlendar.modelos.Usuario;

public class CitaDao {
	private static String DRIVER = "org.sqlite.JDBC";
	private static String URL = "jdbc:sqlite:iparlendar.sqlite";
	private static String USER = "";
	private static String PASS = "";

	private static BaseDeDatos baseDeDatos = new BaseDeDatos(DRIVER, URL, USER, PASS);

	private static String SQL_SELECT = "SELECT * FROM citas";
	
	public static ArrayList<Cita> obtenerTodas() {
		try (Statement st = baseDeDatos.obtenerSentencia();
				ResultSet rs = st.executeQuery(SQL_SELECT)) {
			ArrayList<Cita> citas = new ArrayList<Cita>();
			
			while(rs.next()) {
				Long id = rs.getLong("id");
				String asunto = rs.getString("asunto");
				String sInicio = rs.getString("inicio");
				String sFin = rs.getString("fin");
				String prioridad = rs.getString("prioridad");
				String descripcion = rs.getString("descripcion");
				Long idUsuario = rs.getLong("usuarios_id");
				
				LocalDateTime inicio = LocalDateTime.parse(sInicio);
				LocalDateTime fin = LocalDateTime.parse(sFin);
				
				Usuario usuario = new Usuario(idUsuario, null, null, null, null, null);
				
				Cita cita = new Cita(id, asunto, inicio, fin, prioridad, descripcion, usuario);
				
				citas.add(cita);
			}
			
			return citas;
		} catch (SQLException e) {
			throw new RuntimeException("Error en la búsqueda de todas las citas", e);
		}
	}
}
