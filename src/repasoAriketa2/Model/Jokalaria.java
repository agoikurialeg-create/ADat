package repasoAriketa2.Model;

import java.io.Serializable;

public abstract class Jokalaria implements Serializable{	
	private String Izena;
	private Double Altuera;
	private int Zenbakia;
	
	public String getIzena() {
		return Izena;
	}
	public void setIzena(String izena) {
		Izena = izena;
	}
	public Double getAltuera() {
		return Altuera;
	}
	public void setAltuera(Double altuera) {
		Altuera = altuera;
	}
	public int getZenbakia() {
		return Zenbakia;
	}
	public void setZenbakia(int zenbakia) {
		Zenbakia = zenbakia;
	}
	@Override
	public String toString() {
		return "Jokalaria [Izena=" + Izena + ", Altuera=" + Altuera + ", Zenbakia=" + Zenbakia + "]";
	}
	public Jokalaria(String izena, Double altuera, int zenbakia) {
		super();
		Izena = izena;
		Altuera = altuera;
		Zenbakia = zenbakia;
	}
	
	public abstract void jokatu();
	public  void mugitu() {}

}
