package poo;

public class MonitorProporcion {
	private Proporcion medidas = new Proporcion(0, 0);

	private int diagonal;

	private String color;

	public MonitorProporcion(int ancho, int alto, int diagonal, String color) {
		super();
		
		medidas.setAlto(alto);
		medidas.setAncho(ancho);
		
		this.diagonal = diagonal;
		this.color = color;
	}

	public MonitorProporcion() {

	}

	public Proporcion getMedidas() {
		return medidas;
	}

	public void setMedidas(Proporcion medidas) {
		this.medidas = medidas;
	}

	public int getAncho() {
		return medidas.getAncho();
	}

	public void setAncho(int ancho) {
		if (ancho < 0) {
			throw new IllegalArgumentException("No puedes poner anchos negativos");
		}

		medidas.setAncho(ancho);
	}

	public int getAlto() {
		return medidas.getAlto();
	}

	public void setAlto(int alto) {
		medidas.setAlto(alto);
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
		return medidas.getAncho() * medidas.getAlto();
	}

	public String getAspecto() {
		return medidas.getAspecto();
	}
	
	@Override
	public String toString() {
		return "Monitor [ancho=" + medidas.getAncho() + ", alto=" + medidas.getAlto() + ", diagonal=" + diagonal + ", color=" + color + "]";
	}
}
