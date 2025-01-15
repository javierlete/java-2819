package bases;

import java.util.Scanner;

public class Condicionales {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Dime un número");

		int numeroElegido = sc.nextInt();
		
		sc.close();

		sc = null;
		
		if (numeroElegido > 5) {
			System.out.println("Es mayor que 5");
		} else if (numeroElegido < 5) {
			System.out.println("Es menor que 5");
		} else {
			System.out.println("Es igual a 5");
		}

		switch (numeroElegido) {
		case 1:
			System.out.println("Uno");
			break;
		case 2:
			System.out.println("Dos");
			break;
		default:
			System.out.println("Otro número");
		}
		
	}
}
