package poo;

import java.util.Scanner;

public class Consola {
	private static final Scanner sc = new Scanner(System.in);

	public static String pedirTexto(String mensaje) {
		System.out.print(mensaje + ": ");
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
				System.out.println("No es un entero válido");
			} 
		} while (equivocado);
		
		return entero;
	}
}
