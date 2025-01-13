package poo;

import java.util.ArrayList;

public class MonitorPrueba {
	public static void main(String[] args) {
		Monitor m1;
		
		m1 = new Monitor();
		
		m1.setAlto(1400);
		m1.setAncho(1600);
		m1.setDiagonal(20);
		
		m1.setColor("Gris");
		
		System.out.println("m1 = " + m1);
		
		System.out.println(m1.getAncho());
		System.out.println(m1.getNumeroPixels());
		
		Monitor m2 = new Monitor(1280, 720, 15, "Negro");
		
		System.out.println(m2.getAncho());
		
		System.out.println(m2.getNumeroPixels());
		
		System.out.println(m2);
		
		ArrayList<Monitor> almacen = new ArrayList<Monitor>();
		
		almacen.add(m1);
		almacen.add(m2);
		
		int total = 0;
		
		for(Monitor monitor: almacen) {
			System.out.println(monitor);
			total += monitor.getNumeroPixels();
		}
		
		System.out.println("El número de pixels totales es " + total);
	}
}
