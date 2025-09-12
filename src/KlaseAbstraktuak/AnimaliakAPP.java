package KlaseAbstraktuak;

import java.util.ArrayList;

public class AnimaliakAPP {
	public static void main(String[] args) {
		Hezurduna h1 = new Hezurduna("Txakurra", "1", 300);
		Hezurduna h2 = new Hezurduna("Elefantea", "3", 500);
		Hezurgabea h3 = new Hezurgabea("Barraskiloa", "0,1", EnumBaiEz.BAI);
		
		ArrayList<Animalia> animalialist = new ArrayList<Animalia>();
		animalialist.add(h1);
		animalialist.add(h2);
		animalialist.add(h3);
		int dun = 0,gabe = 0;
		for(Animalia  animalia : animalialist) {
			System.out.println(animalia);
			if(animalia instanceof Hezurduna) {
				dun++;
			}else {gabe++;}
		}
		
		System.out.println("Hezurdunak: " + dun + " // Hezurgabeak: " + gabe);
		
		
	}
}
