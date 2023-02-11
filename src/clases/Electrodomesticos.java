package clases;

public class Electrodomesticos {
	
	private String nombre, img;
	private double kwhElectrodomestico, hUso;
	private int cantidad;
	
	
	//Constructor
	public Electrodomesticos(String nombre, String img, double kwhElectrodomestico, double hUso, int cantidad) {
		this.nombre = nombre;
		this.img = img;
		this.kwhElectrodomestico = kwhElectrodomestico;
		this.hUso = hUso;
		this.cantidad = cantidad;
	}


	//Get y Set

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}


	public double getKwhElectrodomestico() {
		return kwhElectrodomestico;
	}


	public void setKwhElectrodomestico(double kwhElectrodomestico) {
		this.kwhElectrodomestico = kwhElectrodomestico;
	}


	public double gethUso() {
		return hUso;
	}


	public void sethUso(double hUso) {
		this.hUso = hUso;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	
}
