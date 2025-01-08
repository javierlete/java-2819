package bases;

import java.util.Scanner;

public class EntradaConsola {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("¿Cómo te llamas?");
		
		String nombre = sc.nextLine();
		
		System.out.println("Hola " + nombre);
		
		System.out.println("Dime un número");
		
		int num1 = sc.nextInt();
		
		System.out.println("Dime otro número");
		
		int num2 = sc.nextInt();
		
		int suma = num1 + num2;
		
		System.out.println("La suma es " + suma);
	}
}
