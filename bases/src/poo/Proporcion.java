package poo;

public class Proporcion {
	private int ancho;
	private int alto;

	public Proporcion(int ancho, int alto) {
		super();
		this.ancho = ancho;
		this.alto = alto;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public double getRelacion() {
		return (double) alto / (double) ancho;
	}

	public String getAspecto() {
		if (getRelacion() == 0.5625) {// if(getRelacion() >= 0.5624 && getRelacion() <= 0.5626) {
			return "16:9";
		} else {
			return "NI IDEA";
		}
	}

	@Override
	public String toString() {
		return "Proporcion [ancho=" + ancho + ", alto=" + alto + "]";
	}

}
