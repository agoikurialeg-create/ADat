package repasoAriketa1;

public class Animalia {
	private String Id;
	private String Izena;
	private String Tamaina;
	
	public Animalia(String id, String izena, String tamaina) {
		super();
		Id = id;
		Izena = izena;
		Tamaina = tamaina;
	}
	@Override
	public String toString() {
		return "Animalia [Id=" + Id + ", Izena=" + Izena + ", Tamaina=" + Tamaina + "]";
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
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
	
}
