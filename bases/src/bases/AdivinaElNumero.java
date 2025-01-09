package bases;

import java.util.Random;
import java.util.Scanner;

public class AdivinaElNumero {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String seguir;
		
		do {
			int pensado = new Random().nextInt(1, 101);
			
//			System.out.println(pensado);
			
			int numero;
			do {
				System.out.print("Dime un número: ");

				numero = sc.nextInt();
				sc.nextLine(); // Para limpiar el enter que queda detrás del número

				if (pensado > numero) {
					System.out.println("Es mayor");
				} else if (pensado < numero) {
					System.out.println("Es menor");
				} else {
					System.out.println("Has acertado");
				}
			} while (pensado != numero);
			
			System.out.print("¿Quieres seguir jugando? (s/N) ");
			
			seguir = sc.nextLine();
		} while (seguir.equals("s"));
		
		System.out.println("Gracias por jugar");
	}
}
