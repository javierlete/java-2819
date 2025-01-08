package bases;

public class TiposDeDatos {
	public static void main(String[] args) {
		int i; // Por defecto vale 0

		i = 10;

		int j = 5;

		int suma = i + j;

		System.out.println(suma);

		double d1 = 5.6;
		double d2 = 6.7;

		System.out.println(d1 + d2);

		char c = 'g';

		System.out.println(c);

		boolean b = true;

		System.out.println(b);

		b = false;

		System.out.println(b);

		String nombre = "Javier";

		System.out.println("Hola " + nombre);

		System.out.println(nombre.charAt(1));

		System.out.println(nombre.length());

		System.out.println(nombre.substring(0, 4));

		String nolose = null;

		System.out.println(nolose);

		nolose = "Pepe";

		System.out.println(nolose);
	}
}
