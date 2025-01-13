package poo;

public class ProporcionPrueba {
	public static void main(String[] args) {
		Proporcion p = new Proporcion(1280, 720);
		
		System.out.println(p);
		
		System.out.println(p.getRelacion());
		
		System.out.println(p.getAspecto());
		
		double suma = 0.1 + 0.2;
		
		System.out.println(suma);
		
		System.out.println(suma == 0.3);
		
		System.out.println(suma > 0.299999999999 && suma <= 0.3000000000001);
	}
}
