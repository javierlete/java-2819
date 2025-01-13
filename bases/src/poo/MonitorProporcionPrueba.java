package poo;

import java.util.ArrayList;

public class MonitorProporcionPrueba {
	public static void main(String[] args) {
		MonitorProporcion m1;
		
		m1 = new MonitorProporcion();
		
		m1.setAlto(1400);
		m1.setAncho(1600);
		m1.setDiagonal(20);
		
		m1.setColor("Gris");
		
		System.out.println("m1 = " + m1);
		
		System.out.println(m1.getAncho());
		System.out.println(m1.getNumeroPixels());
		
		MonitorProporcion m2 = new MonitorProporcion(1280, 720, 15, "Negro");
		
		System.out.println(m2.getAncho());
		
		System.out.println(m2.getNumeroPixels());
		
		System.out.println(m2);
		
		ArrayList<MonitorProporcion> almacen = new ArrayList<MonitorProporcion>();
		
		almacen.add(m1);
		almacen.add(m2);
		
		int total = 0;
		
		for(MonitorProporcion monitor: almacen) {
			System.out.println(monitor);
			System.out.println(monitor.getAspecto());
			total += monitor.getNumeroPixels();
		}
		
		System.out.println("El número de pixels totales es " + total);
	}
}
