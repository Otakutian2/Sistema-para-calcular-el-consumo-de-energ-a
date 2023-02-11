package clases;

public class Paises {
	
	//Atributos
	
	private String nombre;
	private double T_IGV, KloWattsNegocio, KloWattsHogar;
	String T_Moneda;
	
	//Constructor
	public Paises(String nombre, double t_IGV, double kloWattsNegocio, double kloWattsHogar, String t_Moneda) {
		this.nombre = nombre;
		this.T_IGV = t_IGV;
		this.KloWattsNegocio = kloWattsNegocio;
		this.KloWattsHogar = kloWattsHogar;
		this.T_Moneda = t_Moneda;
	}
	
	//Get y set
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getT_IGV() {
		return T_IGV;
	}
	public void setT_IGV(double t_IGV) {
		T_IGV = t_IGV;
	}
	public double getKloWattsNegocio() {
		return KloWattsNegocio;
	}
	public void setKloWattsNegocio(double kloWattsNegocio) {
		KloWattsNegocio = kloWattsNegocio;
	}
	public double getKloWattsHogar() {
		return KloWattsHogar;
	}
	public void setKloWattsHogar(double kloWattsHogar) {
		KloWattsHogar = kloWattsHogar;
	}
	public String getT_Moneda() {
		return T_Moneda;
	}
	public void setT_Moneda(String t_Moneda) {
		T_Moneda = t_Moneda;
	}
	
	
	
	
}
