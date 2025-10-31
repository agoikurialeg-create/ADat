package repasoAriketa2.Model;

public class Atezaina extends Jokalaria{

	public Atezaina(String izena, Double altuera, int zenbakia) {
		super(izena, altuera, zenbakia);
	}

	@Override
	public void jokatu() {
		System.out.println("Atezaina naiz");
	}
	
}
