package Arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import clases.Paises;

public  class ArregloPaises {
	
	private  ArrayList<Paises> paises = new ArrayList<Paises>();
	
	
	//Constructor

	public ArregloPaises() {
		paises = new ArrayList<Paises>();
		cargarPaises();
	}
	//Adicionar 
	
	public void adicionar(Paises x){
		paises.add(x);
		grabarPaises();
	}
	//Tamaño
	public int tamanio(){
		return paises.size();
	}
	//Obtener
	public Paises obtener(int i){
		return paises.get(i);
	}
	
	//Buscar mediante nobmre

	public Paises buscar(String Nombre){
		Paises x;
		for(int i = 0; i < tamanio(); i++){
			x=obtener(i);
			if(x.getNombre().equals(Nombre))
				return x;
		}
		return null;
	}
	
	//Eliminar objetos
	public void eliminar(Paises x){
		paises.remove(x);
		grabarPaises();
	}
	
	//Actualizar
	
	public void actualizarArchivo(){
		grabarPaises();
	}
	
	//Grabar Paises
	
	private void grabarPaises(){
		try {
			PrintWriter pw;
			String linea;
			Paises x;
			//Crear el archivo de texto
			pw = new PrintWriter(new FileWriter("Pais.txt"));
			for(int i = 0; i<tamanio(); i++){
				x = obtener(i);
				/*String nombre, double t_IGV, double kloWattsNegocio, double kloWattsHogar, String t_Moneda*/
				linea = x.getNombre() + ";" + 
						x.getT_IGV() + ";" +
						x.getKloWattsNegocio() + ";" + 
						x.getKloWattsHogar() + ";" +
						x.getT_Moneda();
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
		}
	}
	
	//Cargar paises
	
	private void cargarPaises(){
		try {
			BufferedReader br;
			String linea, nombre, t_Moneda;
			String[] s;
			double t_IGV, kloWattsNegocio, kloWattsHogar;
			br = new BufferedReader(new FileReader("Pais.txt"));
			
			while((linea = br.readLine()) != null){
				s = linea.split(";");
				nombre = s[0].trim();
				t_IGV = Double.parseDouble(s[1].trim());
				kloWattsNegocio = Double.parseDouble(s[2].trim());
				kloWattsHogar = Double.parseDouble(s[3].trim());
				t_Moneda = s[4].trim();
				
				adicionar(new Paises(nombre, t_IGV, kloWattsNegocio, kloWattsHogar, t_Moneda));
			}
			br.close();
		} catch (Exception e) {
		
		}
	}

}