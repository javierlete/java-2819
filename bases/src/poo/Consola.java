package poo;

import java.util.Scanner;

public class Consola {
	private static final Scanner sc = new Scanner(System.in);

	/**
	 * Imprimir una línea como en un System.out.println
	 * @param mensaje texto a imprimir
	 */
	public static void pl(String mensaje) {
		System.out.println(mensaje);
	}
	
	public static void p(String mensaje) {
		System.out.print(mensaje);
	}
	
	public static void pf(String formato, Object... args) {
		System.out.printf(formato, args);
	}
	
	public static String pedirTexto(String mensaje) {
		p(mensaje + ": ");
		return sc.nextLine();
	}
	
	public static int pedirEntero(String mensaje) {
		boolean equivocado = true;
		
		int entero = 0;
		
		do {
			String texto = pedirTexto(mensaje);

			try {
				entero = Integer.parseInt(texto);
				equivocado = false;
			} catch (NumberFormatException e) {
				pl("No es un entero válido");
			} 
		} while (equivocado);
		
		return entero;
	}
}
