package kutxabank.Model;

import java.time.LocalDateTime;

public class Pertsona {
	public String Izena;
	public LocalDateTime Data;
	public int Kantitatea;
	
	public Pertsona(String izena, LocalDateTime data, int kantitatea) {
		this.Izena = izena;
		this.Data = data;
		this.Kantitatea = kantitatea;
	}
	@Override
	public String toString() {
		return "Pertsona [izena=" + Izena + ", data=" + Data + ", kantitatea=" + Kantitatea + "]";
	}
	public String getIzena() {
		return Izena;
	}
	public void setIzena(String izena) {
		this.Izena = izena;
	}
	public LocalDateTime getData() {
		return Data;
	}
	public void setData(LocalDateTime data) {
		this.Data = data;
	}
	public int getKantitatea() {
		return Kantitatea;
	}
	public void setKantitatea(int kantitatea) {
		this.Kantitatea = kantitatea;
	}
}
