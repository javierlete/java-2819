package tiendaweb.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import tiendaweb.modelos.Producto;

// CRUD: Create Read Update Delete
// DAO:  Data Access Object

public class ProductoDao {
	private static final String URL = "jdbc:sqlite:tiendaweb.sqlite";
	private static final String USER = "";
	private static final String PASS = "";

	private static final String SQL_SELECT = "SELECT * FROM productos";
	private static final String SQL_SELECT_ID = "SELECT * FROM productos WHERE id=";

	private static final String SQL_INSERT = "INSERT INTO productos (nombre, precio, descuento) VALUES ('%s', %s, %s)";
	private static final String SQL_UPDATE = "UPDATE productos SET nombre='%s', precio=%s, descuento=%s WHERE id=%s";
	private static final String SQL_DELETE = "DELETE FROM productos WHERE id=";

	private static Statement obtenerSentencia() {
		try {
			Class.forName("org.sqlite.JDBC");

			Connection con = DriverManager.getConnection(URL, USER, PASS);
			return con.createStatement();
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException("No se ha podido conectar con la base de datos", e);
		}
	}

	public static ArrayList<Producto> obtenerProductos() {
		ArrayList<Producto> productos = new ArrayList<Producto>();

		try (Statement st = obtenerSentencia(); ResultSet rs = st.executeQuery(SQL_SELECT)) {

			while (rs.next()) {
				productos.add(new Producto(rs.getLong("id"), rs.getString("nombre"), rs.getDouble("precio"),
						rs.getDouble("descuento")));
			}

			return productos;

		} catch (SQLException e) {
			throw new RuntimeException("No se han podido obtener los productos", e);
		}
	}

	public static Producto obtenerPorId(Long id) {
		try (Statement st = obtenerSentencia(); ResultSet rs = st.executeQuery(SQL_SELECT_ID + id)) {

			if (rs.next()) {
				return new Producto(rs.getLong("id"), rs.getString("nombre"), rs.getDouble("precio"),
						rs.getDouble("descuento"));

			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException("No se ha podido obtener el producto " + id, e);
		}
	}

	public static void insertar(Producto producto) {
		try (Statement st = obtenerSentencia()) {
			String sql = String.format(SQL_INSERT, producto.getNombre(), producto.getPrecio(), producto.getDescuento());

			st.executeUpdate(sql);
		} catch (SQLException e) {
			throw new RuntimeException("No se ha podido insertar el producto " + producto, e);
		}
	}

	public static void modificar(Producto producto) {
		try (Statement st = obtenerSentencia()) {
			String sql = String.format(SQL_UPDATE, producto.getNombre(), producto.getPrecio(), producto.getDescuento(),
					producto.getId());

			st.executeUpdate(sql);
		} catch (SQLException e) {
			throw new RuntimeException("No se ha podido modificar el producto " + producto, e);
		}
	}

	public static void borrar(Long id) {
		try (Statement st = obtenerSentencia()) {
			st.executeUpdate(SQL_DELETE + id);
		} catch (SQLException e) {
			throw new RuntimeException("No se ha podido borrar el producto " + id, e);
		}
	}
}
