package KlaseAbstraktuak;

public class Hezurduna extends Animalia {
	
	private int HezurKop;

	public int getHezurKop() {
		return HezurKop;
	}

	public void setHezurKop(int hezurKop) {
		this.HezurKop = hezurKop;
	}

	public Hezurduna(String izena, String tamaina, int hezurKop) {
		super(izena, tamaina);
		HezurKop = hezurKop;
	}

	@Override
	public String toString() {
		return "Hezurduna [Izena="+ super.getIzena()+ ", Tamaina="+ super.getTamaina()+", HezurKop=" + HezurKop + "]";
	}
	

}
