package ejemplos;

import java.util.ArrayList;

import poo.Consola;
import poo.Monitor;

public class MantenimientoMonitores {
	private static int contadorId = 4;
	
	private static final ArrayList<Monitor> monitores = new ArrayList<Monitor>();

	public static void main(String[] args) {
		// Introducimos datos de prueba
		monitores.add(new Monitor(1, 640, 480, 12, "Negro"));
		monitores.add(new Monitor(2, 1200, 1024, 15, "Gris"));
		monitores.add(new Monitor(3, 1920, 1080, 20, "Rojo"));

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
		return Consola.pedirEntero("Dime la opción que deseas");
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

	private static void buscar() {
		String color = Consola.pedirTexto("Dime qué color quieres buscar");

		mostrarCabecera();
		for (Monitor monitor : monitores) {
			if (monitor.getColor().equals(color)) {
				mostrarLinea(monitor);
			}
		}
	}

	private static void insertar() {
		Monitor m = pedirDatosMonitor(contadorId);
		monitores.add(m);
		
		contadorId++;
	}

	private static void modificar() {
		int id = Consola.pedirEntero("Dime el id a modificar");
		
		Monitor m = pedirDatosMonitor(id);
		
		int contador = 0;
		
		for(Monitor monitor: monitores) {
			if(monitor.getId() == id) {
				monitores.set(contador, m);
				break;
			}
			
			contador++;
		}
	}

	private static void borrar() {
		int id = Consola.pedirEntero("Dime el id a borrar");
		
		for(Monitor monitor: monitores) {
			if(monitor.getId() == id) {
				monitores.remove(monitor);
				break;
			}
		}
	}

	private static void mostrarCabecera() {
		System.out.printf("%5s %5s %5s %8s %-20s\n", "Id", "Ancho", "Alto", "Diagonal", "Color");
	}

	private static void mostrarLinea(Monitor monitor) {
		System.out.printf("%5s %5s %5s %5s    %-20s\n", monitor.getId(), monitor.getAncho(), monitor.getAlto(), monitor.getDiagonal(),
				monitor.getColor());
	}

	private static Monitor pedirDatosMonitor(int id) {
		int ancho = Consola.pedirEntero("Ancho");
		int alto = Consola.pedirEntero("Alto");
		int pulgadas = Consola.pedirEntero("Pulgadas");
		String color = Consola.pedirTexto("Color");
		
		Monitor m = new Monitor(id, ancho, alto, pulgadas, color);
		return m;
	}
}
