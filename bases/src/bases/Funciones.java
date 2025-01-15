package bases;

import java.util.Scanner;

public class Funciones {
	public static void main(String[] args) {
		repetir(50);
		repetir(2);
		repetir(12);
		
		int n = 5;
		repetir(n);
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Dime cuántas veces quieres repetir: ");
		
		int numero = sc.nextInt();
		
		repetir(numero);
		
		System.out.println(sumar(3, 4));
		
		sc.close();
	}

	private static int sumar(int a, int b) {
		return a + b;
	}
	
	private static void repetir(int repeticiones) {
		for(int n = 1; n <= repeticiones; n++) {
			System.out.print(n);
		}
		
		System.out.println();
	}
}
