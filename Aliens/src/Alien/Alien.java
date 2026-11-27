package Alien;

public class Alien {

	private int tamanio;
	private String color;
	private int numeroOjos;
	private int numeroBrazos;
	private int numeroPies;
	private double precioExtremidad;
	private double precioOjo;
	private double precioCuerpo;
	private double precioTotal = 0;

	public Alien(int tamanio, String color) {
		if (tamanio < 5) {
			this.tamanio = 5;
		} else if (tamanio > 30) {
			this.tamanio = 30;
		} else {
			this.tamanio = tamanio;
		}

		this.color = color;

		this.precioCuerpo = this.tamanio * 0.20;
		this.precioExtremidad = this.tamanio * 0.10;
		this.precioOjo = this.tamanio * 0.05;
	}

	public int getTamanio() {
		return tamanio;
	}

	public String getColor() {
		return color;
	}

	public int getNumeroOjos() {
		return numeroOjos;
	}

	public int getNumeroBrazos() {
		return numeroBrazos;
	}

	public int getNumeroPies() {
		return numeroPies;
	}

	public double getPrecioExtremidad() {
		return precioExtremidad;
	}

	public double getPrecioOjo() {
		return precioOjo;
	}

	public double getPrecioCuerpo() {
		return precioCuerpo;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void calcularPrecioTotal() {
		int extremidades = this.numeroBrazos + this.numeroPies;
		this.precioTotal = this.precioCuerpo + (extremidades * this.precioExtremidad)
				+ (this.numeroOjos * this.precioOjo);
	}

	public boolean agregarBrazos(int cantidad) {
		if (cantidad > 0 && (this.numeroBrazos + this.numeroPies + cantidad <= 10)) {
			this.numeroBrazos += cantidad;
			calcularPrecioTotal();
			return true;
		}
		return false;
	}

	public boolean agregarPiernas(int cantidad) {
		if (cantidad > 0 && (this.numeroBrazos + this.numeroPies + cantidad <= 10)) {
			this.numeroPies += cantidad;
			calcularPrecioTotal();
			return true;
		}
		return false;
	}

	public boolean agregarOjos(int cantidad) {
		int maxOjos;
		if (this.tamanio <= 10) {
			maxOjos = 3;
		} else if (this.tamanio <= 20) {
			maxOjos = 5;
		} else {
			maxOjos = 7;
		}

		if (cantidad > 0 && (this.numeroOjos + cantidad <= maxOjos)) {
			this.numeroOjos += cantidad;
			calcularPrecioTotal();
			return true;
		}
		return false;
	}

	public void imprimir() {
		System.out.println("=== Datos del Alien ===");
		System.out.println("Tamaño: " + tamanio + " cm");
		System.out.println("Color: " + color);
		System.out.println("Número de ojos: " + numeroOjos);
		System.out.println("Número de brazos: " + numeroBrazos);
		System.out.println("Número de pies: " + numeroPies);
		System.out.println("Precio del cuerpo: $" + precioCuerpo);
		System.out.println("Precio de extremidad: $" + precioExtremidad);
		System.out.println("Precio de ojo: $" + precioOjo);
		System.out.println("Precio total: $" + precioTotal);
		System.out.println("=======================");
	}
}
