package KlaseAbstraktuak;

public abstract class Animalia {
	
	private String Izena;
	private String Tamaina;
	
	public String getIzena() {
		return Izena;
	}
	public void setIzena(String izena) {
		Izena = izena;
	}
	public String getTamaina() {
		return Tamaina;
	}
	public void setTamaina(String tamaina) {
		Tamaina = tamaina;
	}
	
	public Animalia(String izena, String tamaina) {
		super();
		Izena = izena;
		Tamaina = tamaina;
	}
	@Override
	public String toString() {
		return "Animalia [Izena=" + Izena + ", Tamaina=" + Tamaina + "]";
	}
	
	

}
