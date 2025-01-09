package bases;

import java.util.ArrayList;

public class Colecciones {
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();

		al.add("Hola");
		al.add("Qué");
		al.add("Tal");

		System.out.println(al);

		for (int i = 0; i < al.size(); i++) {
			String dato = al.get(i);
			
			System.out.println("Posición " + i + " = " + dato);
		}

		// for..each
		for (String dato : al) {
			System.out.println(dato);
		}
	}
}
