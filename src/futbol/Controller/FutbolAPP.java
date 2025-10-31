package futbol.Controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import futbol.Model.Futbolista;
import futbol.Model.Taldea;
import futbol.Controller.FutbolistaConnect;
import futbol.Controller.TaldeaConnect;


public class FutbolAPP {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		int aukera = 0;
		FutbolistaConnect futcon = new FutbolistaConnect();
		TaldeaConnect talcon = new TaldeaConnect();
		Scanner sc = new Scanner(System.in);
		do {
			menuaErakutsi();
			aukera = Integer.parseInt(sc.nextLine());
			switch (aukera) {
			case 1:
				futbolariGuztiak(futcon);
				
				break;
			case 2:
				taldeGuztiak(talcon);
								break;
				
			case 3:
				futbolistaBerria(futcon, talcon);
				
				break;
				
			case 4:
				taldeBerria(talcon);
				
				break;
			case 5:
				System.out.println("Sartu ezazu ikusi nahi duzun jokalariaren ID-a");
				Scanner scan=new Scanner(System.in);
				String idJok=scan.nextLine();
				System.out.println(futcon.getFutbolistaIDtik(idJok));
				
				break;
				
			case 6:
				System.out.println("Sartu ezazu ikusi nahi duzun taldearen ID-a");
				scan=new Scanner(System.in);
				int idTal=Integer.parseInt(scan.nextLine());
				System.out.println(talcon.getTaldeaIDtik(idTal));
				break;
				
			case 7:
				System.out.println("Amaitu da programa");
				break;
			default:
				break;
			
			
			}
		} while (aukera != 7);

	}

	private static void taldeBerria(TaldeaConnect talcon) throws SQLException {
		Scanner scan=new Scanner(System.in);
		System.out.println("Sartu ezazu talde berriaren ID-a:");
		int idTaldea=Integer.parseInt(scan.nextLine());
		System.out.println("Sartu ezazu talde berriaren izena:");
		String izenTaldea=scan.nextLine();
		System.out.println("Sartu itzazu talde berriaren hiria:");
		String hiria=scan.nextLine();
		
		Taldea taldeSortu= new Taldea();
		taldeSortu.setIdTaldea(idTaldea);
		taldeSortu.setIzena(izenTaldea);
		taldeSortu.setHiria(hiria);
		talcon.taldeaSortu(taldeSortu);
	}

	private static void futbolistaBerria(FutbolistaConnect futcon, TaldeaConnect talcon) throws SQLException {
		Scanner scan=new Scanner(System.in);
		System.out.println("Sartu ezazu jokalari berriaren ID-a:");
		String idJokalari=scan.nextLine();
		System.out.println("Sartu ezazu jokalari berriaren izena:");
		String izenJokalari=scan.nextLine();
		System.out.println("Sartu itzazu jokalari berriaren abizenak:");
		String abizenJokalari=scan.nextLine();
		System.out.println("Sartu ezazu jokalari berriaren taldearen ID-a:");
		int taldeaJokalari=Integer.parseInt(scan.nextLine());
		for (int i=0;i<talcon.getTaldeak().size();i++) {
			if (taldeaJokalari==talcon.getTaldeak().get(i).getIdTaldea()) {
				Futbolista futSortu= new Futbolista();
				futSortu.setIdTaldea(taldeaJokalari);
				futSortu.setNAN(idJokalari);
				futSortu.setIzena(izenJokalari);
				futSortu.setAbizena(abizenJokalari);
				futcon.futbolistaSortu(futSortu);
				
			}else System.out.println("Taldea ez da esistitzen");
			
			
		}
	}

	private static void taldeGuztiak(TaldeaConnect talcon) throws SQLException {
		System.out.println("Hona talde guztien zerrenda:");
		for (int i=0;i<talcon.getTaldeak().size();i++) {
			System.out.println(talcon.getTaldeak().get(i).toString());
				
		}
	}

	private static void futbolariGuztiak(FutbolistaConnect futcon) throws SQLException {
		System.out.println("Hona futbolari guztien zerrenda:");
		for (int i=0;i<futcon.getFutbolistak().size();i++) {
			System.out.println(futcon.getFutbolistak().get(i).toString());
				
		}
	}

	private static void menuaErakutsi() {
		System.out.println("Ondo etorria futbolarien DDBBra!!");
		System.out.println("Zer egin nahi duzu?");
		System.out.println("1- Jokalari guztiak ikusi");
		System.out.println("2- Taldeak ikusi");
		System.out.println("3- Jokalari bat gehitu");
		System.out.println("4- Talde bat gehitu");
		System.out.println("5- Jokalaria erakutsi ID-a emanda");
		System.out.println("6- Taldea erakutsi ID-a emanda");
		System.out.println("7- IRTEN");


		
	}

}
