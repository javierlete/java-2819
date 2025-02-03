package bibliotecas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDeDatos {
	
	private String driver;
	private String url;
	private String user;
	private String password;
	
	public BaseDeDatos(String driver, String url, String user, String password) {
		super();
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.password = password;
	}

	public Statement obtenerSentencia() {
		try {
			Class.forName(driver);

			Connection con = DriverManager.getConnection(url, user, password);
			return con.createStatement();
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException("No se ha podido conectar con la base de datos", e);
		}
	}
}
