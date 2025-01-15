package ejemplos;

import java.util.ArrayList;
import java.util.Scanner;

import poo.Monitor;

public class MantenimientoMonitores {
	private static final Scanner sc = new Scanner(System.in);

	private static final ArrayList<Monitor> monitores = new ArrayList<Monitor>();

	public static void main(String[] args) {
		// Introducimos datos de prueba
		monitores.add(new Monitor(640, 480, 12, "Negro"));
		monitores.add(new Monitor(1200, 1024, 15, "Gris"));
		monitores.add(new Monitor(1920, 1080, 20, "Rojo"));

		boolean salir = true;

		do {
			// Mostrar un menú
			mostrarMenu();
			// Pedir una opción
			int opcion = pedirOpcion();
			// Procesar opción
			procesar(opcion);
			// Si no me han dicho salir, repetir desde "Mostrar un menú"
			salir = opcion == 0;
		} while (!salir);
	}

	private static void mostrarMenu() {
		System.out.println("""
				MENU
				====

				1. Listado
				2. Buscar por color
				3. Insertar
				4. Modificar
				5. Borrar

				0. Salir

				""");
	}

	private static int pedirOpcion() {
		System.out.print("Dime la opción que deseas: ");

		int resultado = sc.nextInt();
		sc.nextLine();
		
		return resultado;
	}

	private static void procesar(int opcion) {
		switch (opcion) {
		case 1:
			listado();
			break;
		case 2:
			buscar();
			break;
		case 3:
			insertar();
			break;
		case 4:
			modificar();
			break;
		case 5:
			borrar();
			break;
		case 0:
			System.out.println("Gracias por usar la aplicación");
			break;
		default:
			System.out.println("Opción no reconocida");
		}
	}

	private static void listado() {
		mostrarCabecera();
		for (Monitor monitor : monitores) {
			mostrarLinea(monitor);
		}
	}

	private static void mostrarCabecera() {
		System.out.printf("%5s %5s %8s %-20s\n", "Ancho", "Alto", "Diagonal", "Color");
	}

	private static void mostrarLinea(Monitor monitor) {
		System.out.printf("%5s %5s %5s    %-20s\n", monitor.getAncho(), monitor.getAlto(), monitor.getDiagonal(),
				monitor.getColor());
	}

	private static void buscar() {
		System.out.print("Dime qué color quieres buscar: ");
		String color = sc.nextLine();

		mostrarCabecera();
		for (Monitor monitor : monitores) {
			if (monitor.getColor().equals(color)) {
				mostrarLinea(monitor);
			}
		}
	}

	private static void insertar() {
		System.out.print("Ancho: ");
		int ancho = sc.nextInt();
		
		System.out.print("Alto: ");
		int alto = sc.nextInt();
		
		System.out.print("Pulgadas: ");
		int pulgadas = sc.nextInt();
		sc.nextLine();
		
		System.out.print("Color: ");
		String color = sc.nextLine();
		
		Monitor m = new Monitor(ancho, alto, pulgadas, color);
		
		monitores.add(m);
	}

	private static void modificar() {
		// TODO Auto-generated method stub

		// monitores.set(0, m);
	}

	private static void borrar() {
		// TODO Auto-generated method stub

		// monitores.remove(0);
	}
}
