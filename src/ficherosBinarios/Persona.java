package ficherosBinarios;

import java.io.Serializable;

public class Persona implements Serializable{

	private String izena;
	private int adina;
	private String emaila;
	
	public Persona() {}
	
	public Persona(String izena, int adina, String emaila) {
		this.izena = izena;
		this.adina = adina;
		this.emaila = emaila;
	}
	
	public String getNombre() {
		return izena;
	}
	
	public void setNombre(String izena) {
		this.izena = izena;
	}
	
	public int getAdina() {
		return adina;
	}
	
	public void setAdina(int adina) {
		this.adina = adina;
	}
	
	public String getEmaila() {
		return emaila;
	}
	
	public void setEmaila(String emaila) {
		this.emaila = emaila;
	}
	
}
