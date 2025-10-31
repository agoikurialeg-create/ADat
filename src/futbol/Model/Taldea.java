package futbol.Model;

public class Taldea {
	private int idTaldea;
    private String izena;
    private String hiria;
    
	public int getIdTaldea() {
		return idTaldea;
	}
	public void setIdTaldea(int idTaldea) {
		this.idTaldea = idTaldea;
	}
	public String getIzena() {
		return izena;
	}
	public void setIzena(String izena) {
		this.izena = izena;
	}
	public String getHiria() {
		return hiria;
	}
	public void setHiria(String hiria) {
		this.hiria = hiria;
	}
	public Taldea(int idTaldea, String izena, String hiria) {
		super();
		this.idTaldea = idTaldea;
		this.izena = izena;
		this.hiria = hiria;
	}
	public Taldea() {
		super();
	}
	@Override
	public String toString() {
		return "Taldea [idTaldea=" + idTaldea + ", izena=" + izena + ", hiria=" + hiria + "]";
	}
    
	
    
}
