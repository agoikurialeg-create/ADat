package futbol.Model;

public class Futbolista {
	public String NAN;
	public String Izena;
	public String Abizena;
	public int Soldata;
	public int IdTaldea;
	public String getNAN() {
		return NAN;
	}
	public void setNAN(String nAN) {
		NAN = nAN;
	}
	public String getIzena() {
		return Izena;
	}
	public void setIzena(String izena) {
		Izena = izena;
	}
	public String getAbizena() {
		return Abizena;
	}
	public void setAbizena(String abizena) {
		Abizena = abizena;
	}
	public int getSoldata() {
		return Soldata;
	}
	public void setSoldata(int soldata) {
		Soldata = soldata;
	}
	public int getIdTaldea() {
		return IdTaldea;
	}
	public void setIdTaldea(int idTaldea) {
		IdTaldea = idTaldea;
	}
	public Futbolista(String nAN, String izena, String abizena, int soldata, int idTaldea) {
		super();
		NAN = nAN;
		Izena = izena;
		Abizena = abizena;
		Soldata = soldata;
		IdTaldea = idTaldea;
	}
	public Futbolista() {
		super();
	}
	
	public Futbolista(String nAN, String izena, String abizena) {
		super();
		NAN = nAN;
		Izena = izena;
		Abizena = abizena;
	}
	@Override
	public String toString() {
		return "Futbolista [NAN=" + NAN + ", Izena=" + Izena + ", Abizena=" + Abizena + ", Soldata=" + Soldata
				+ ", IdTaldea=" + IdTaldea + "]";
	}
	
	
}
