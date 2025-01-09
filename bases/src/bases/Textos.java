package bases;

public class Textos {
	public static void main(String[] args) {
		String texto = "Hola a todos";

		System.out.println(texto.charAt(0));

		String telefono = "123456789l";

		String exprTelefono = "^\\d{9}$";

		if (telefono.matches(exprTelefono)) {
			System.out.println("Es un teléfono");
		} else {
			System.out.println("No es un teléfono");
		}

		if (telefono.length() == 9) {
		} else {
			System.out.println("El teléfono está mal");
		}

		for (int i = 0; i < telefono.length(); i++) {
			if (telefono.charAt(i) < '0' || telefono.charAt(i) > '9') {
				System.out.println("El teléfono está mal");
				break;
			}
		}

		System.out.println("FIN");
	}
}
