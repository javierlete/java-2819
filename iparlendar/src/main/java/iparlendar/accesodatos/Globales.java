package iparlendar.accesodatos;

import bibliotecas.BaseDeDatos;

public class Globales {
	private static final String DRIVER = "org.sqlite.JDBC";
	private static final String URL = "jdbc:sqlite:iparlendar.sqlite";
	private static final String USER = "";
	private static final String PASS = "";

	public static final BaseDeDatos BASE_DE_DATOS = new BaseDeDatos(DRIVER, URL, USER, PASS);
}
