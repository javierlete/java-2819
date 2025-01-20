package bases;

import java.sql.*;

public class JdbcEjemplo {
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:sqlite:basesdedatos/monitores.sqlite";

		String sqlSelect = "SELECT * FROM monitores";
		String sqlSelectId = "SELECT * FROM monitores WHERE id=";
		String sqlSelectColorPlantilla = "SELECT * FROM monitores WHERE color='%s'";

		String sqlInsertPlantilla = """
				INSERT INTO monitores
					(ancho, alto, diagonal, color)
				VALUES
					(%s, %s, %s, '%s');
				""";

		String sqlUpdatePlantilla = """
				UPDATE monitores
				SET ancho=%s, alto=%s, diagonal=%s, color='%s'
				WHERE id=%s
				""";
		
		String sqlDelete = "DELETE FROM monitores WHERE id=";

		Connection con = DriverManager.getConnection(url);
		Statement st = con.createStatement();
		
		// SELECT
		ResultSet rs = st.executeQuery(sqlSelect);

		while (rs.next()) {
			System.out.printf("%5s %5s %5s %5s %s\n", rs.getString(1), rs.getString(2), rs.getString(3),
					rs.getString(4), rs.getString(5));
		}

		System.out.println();

		// SELECT por id
		int id = 2;

		rs = st.executeQuery(sqlSelectId + id);

		if (rs.next()) {
			System.out.printf("%5s %5s %5s %5s %s\n", rs.getString("id"), rs.getString("ancho"), rs.getString("alto"),
					rs.getString("diagonal"), rs.getString("color"));
		}

		// SELECT por color
		String color = "Gris";

		String sqlSelectColor = String.format(sqlSelectColorPlantilla, color);

		System.out.println(sqlSelectColor);

		rs = st.executeQuery(sqlSelectColor);

		while (rs.next()) {
			System.out.printf("%5s %5s %5s %5s %s\n", rs.getString("id"), rs.getString("ancho"), rs.getString("alto"),
					rs.getString("diagonal"), rs.getString("color"));
		}

		// INSERT
		String sqlInsert = String.format(sqlInsertPlantilla, 1920, 1080, 21, "Gris");

		int numeroRegistrosCambiados = st.executeUpdate(sqlInsert);

		System.out.println(numeroRegistrosCambiados);

		// UPDATE
		String sqlUpdate = String.format(sqlUpdatePlantilla, 2000, 1000, 30, "Rosa", 6);

		numeroRegistrosCambiados = st.executeUpdate(sqlUpdate);

		System.out.println(numeroRegistrosCambiados);
		
		// DELETE
		numeroRegistrosCambiados = st.executeUpdate(sqlDelete + 8);
		
		System.out.println(numeroRegistrosCambiados);
	}
}
