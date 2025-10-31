package repasoAriketa2.Model;

public class Defentsa extends Jokalaria{

	public Defentsa(String izena, Double altuera, int zenbakia) {
		super(izena, altuera, zenbakia);
	}

	@Override
	public void jokatu() {
		System.out.println("Defentsa naiz");
	}

}
