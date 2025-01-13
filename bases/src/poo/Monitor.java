package poo;

public class Monitor {
	private int ancho;
	private int alto;

	private int diagonal;
	
	private String color;

	public Monitor(int ancho, int alto, int diagonal, String color) {
		super();
		this.ancho = ancho;
		this.alto = alto;
		this.diagonal = diagonal;
		this.color = color;
	}
	
	public Monitor() {
		
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		if(ancho < 0) {
			throw new IllegalArgumentException("No puedes poner anchos negativos");
		}
		
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public int getDiagonal() {
		return diagonal;
	}

	public void setDiagonal(int diagonal) {
		this.diagonal = diagonal;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public int getNumeroPixels() {
		return ancho * alto;
	}

	@Override
	public String toString() {
		return "Monitor [ancho=" + ancho + ", alto=" + alto + ", diagonal=" + diagonal + ", color=" + color + "]";
	}
}
