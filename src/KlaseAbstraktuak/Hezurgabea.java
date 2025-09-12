package KlaseAbstraktuak;

public class Hezurgabea extends Animalia{

	private EnumBaiEz oskola;

	public EnumBaiEz isOskola() {
		return oskola;
	}

	public void setOskola(EnumBaiEz oskola) {
		this.oskola = oskola;
	}

	public Hezurgabea(String izena, String tamaina, EnumBaiEz oskola) {
		super(izena, tamaina);
		this.oskola = oskola;
	}

	@Override
	public String toString() {
		return "Hezurgabea [Izena="+ super.getIzena()+ ", Tamaina="+ super.getTamaina()+ ", oskola=" + oskola + "]";
	}
	
	

}
