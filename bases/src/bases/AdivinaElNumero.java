package bases;

import java.util.Random;
import java.util.Scanner;

public class AdivinaElNumero {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String seguir;
		
		do {
			int pensado = inventarNumero();
			
//			System.out.println(pensado);
			
			int numero;
			do {
				numero = leerNumero(sc);

				mostrarResultado(pensado, numero);
			} while (pensado != numero);
			
			System.out.print("¿Quieres seguir jugando? (s/N) ");
			
			seguir = sc.nextLine();
		} while (seguir.equals("s"));
		
		System.out.println("Gracias por jugar");
	}

	private static int leerNumero(Scanner sc) {
		int numero;
		System.out.print("Dime un número: ");

		numero = sc.nextInt();
		sc.nextLine(); // Para limpiar el enter que queda detrás del número
		return numero;
	}

	private static void mostrarResultado(int pensado, int numero) {
		if (pensado > numero) {
			System.out.println("Es mayor");
		} else if (pensado < numero) {
			System.out.println("Es menor");
		} else {
			System.out.println("Has acertado");
		}
	}

	private static int inventarNumero() {
		return new Random().nextInt(1, 101);
	}
}
