package ejemplos;

import static poo.Consola.pedirEntero;
import static poo.Consola.pedirTexto;
import static poo.Consola.pf;
import static poo.Consola.pl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MantenimientoMonitoresJdbcPuro {

	private static final String URL = "jdbc:sqlite:basesdedatos/monitores.sqlite";

	private static final String SQL_SELECT = "SELECT * FROM monitores";
	// private static final String SQL_SELECT_ID = "SELECT * FROM monitores WHERE id=";
	private static final String SQL_SELECT_COLOR_PLANTILLA = "SELECT * FROM monitores WHERE color='%s'";

	private static final String SQL_INSERT_PLANTILLA = """
			INSERT INTO monitores
				(ancho, alto, diagonal, color)
			VALUES
				(%s, %s, %s, '%s');
			""";

	private static final String SQL_UPDATE_PLANTILLA = """
			UPDATE monitores
			SET ancho=%s, alto=%s, diagonal=%s, color='%s'
			WHERE id=%s
			""";

	private static final String SQL_DELETE = "DELETE FROM monitores WHERE id=";

	private static Statement st;

	public static void main(String[] args) throws SQLException {
		Connection con = DriverManager.getConnection(URL);
		st = con.createStatement();

		boolean salir = true;

		do {
			// Mostrar un menú
			mostrarMenu();
			// Pedir una opción
			int opcion = pedirOpcion();
			// Procesar opción
			procesar(opcion);
			// Si no me han dicho salir, repetir desde "Mostrar un menú"
			salir = opcion == 0;
		} while (!salir);
	}

	private static void mostrarMenu() {
		pl("""
				MENU
				====

				1. Listado
				2. Buscar por color
				3. Insertar
				4. Modificar
				5. Borrar

				0. Salir

				""");
	}

	private static int pedirOpcion() {
		return pedirEntero("Dime la opción que deseas");
	}

	private static void procesar(int opcion) throws SQLException {
		switch (opcion) {
		case 1:
			listado();
			break;
		case 2:
			buscar();
			break;
		case 3:
			insertar();
			break;
		case 4:
			modificar();
			break;
		case 5:
			borrar();
			break;
		case 0:
			pl("Gracias por usar la aplicación");
			break;
		default:
			pl("Opción no reconocida");
		}
	}

	private static void listado() throws SQLException {
		mostrarCabecera();

		ResultSet rs = st.executeQuery(SQL_SELECT);

		while (rs.next()) {
			mostrarLinea(rs);
		}
	}

	private static void buscar() throws SQLException {
		String color = pedirTexto("Dime qué color quieres buscar");

		String sqlSelectColor = String.format(SQL_SELECT_COLOR_PLANTILLA, color);

		ResultSet rs = st.executeQuery(sqlSelectColor);

		mostrarCabecera();
		while (rs.next()) {
			mostrarLinea(rs);
		}
	}

	private static void insertar() throws SQLException {
		int ancho = pedirEntero("Ancho");
		int alto = pedirEntero("Alto");
		int pulgadas = pedirEntero("Pulgadas");
		String color = pedirTexto("Color");
		
		String sqlInsert = String.format(SQL_INSERT_PLANTILLA, ancho, alto, pulgadas, color);
		
		st.executeUpdate(sqlInsert);
	}

	private static void modificar() throws SQLException {
		int id = pedirEntero("Dime el id a modificar");

		int ancho = pedirEntero("Ancho");
		int alto = pedirEntero("Alto");
		int pulgadas = pedirEntero("Pulgadas");
		String color = pedirTexto("Color");

		String sqlUpdate = String.format(SQL_UPDATE_PLANTILLA, ancho, alto, pulgadas, color, id);
		
		st.executeUpdate(sqlUpdate);
	}

	private static void borrar() throws SQLException {
		int id = pedirEntero("Dime el id a borrar");

		st.executeUpdate(SQL_DELETE + id);
	}

	private static void mostrarCabecera() {
		pf("%5s %5s %5s %8s %-20s\n", "Id", "Ancho", "Alto", "Diagonal", "Color");
	}

	private static void mostrarLinea(ResultSet rs) throws SQLException {
		pf("%5s %5s %5s %5s    %-20s\n", rs.getString("id"), rs.getString("ancho"), rs.getString("alto"),
				rs.getString("diagonal"), rs.getString("color"));
	}

}
