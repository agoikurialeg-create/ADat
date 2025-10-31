package menuInteraktiboa;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.NumberFormat;
import java.util.Scanner;

public class App {
	
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int aukera;
		do {
			System.out.println("\nEgunon, zer egin nahi dozu?");
			System.out.println("\n---------MENUA---------");
			System.out.println("1. Pertsona berria sortu");
			System.out.println("2. Pertsona guztiak bistaratu");
			System.out.println("3. Itxi");
			aukera = Integer.parseInt(scan.nextLine());
			switch(aukera) {
			case 1:
				gordePertsona();
				break;
			case 2:
				bistaratuPertsona();
				break;
			case 3:
				System.out.println("Agur!");
				break;
			default: System.out.println("Aukera okerra! Sartu zenbaki bat.");
			}
		}while(aukera !=3);
		
	}
	
	public static void gordePertsona() {
		System.out.println("\n---------Pertsona gehitu---------");
		System.out.println("Pertsona gehitzeko hurrengo datuak bete behar dituzu:");
		System.out.println("1.ID:");
		int id = Integer.parseInt(scan.nextLine());
		System.out.println("2. Izena:");
		String izena = scan.nextLine();
		System.out.println("3.Soldata:");
		double soldata = Double.parseDouble(scan.nextLine());
		
		try (RandomAccessFile raf = new RandomAccessFile("C:\\Users\\2AM3-3\\git\\ADat\\src\\menuInteraktiboa\\pertsonak.dat", "rw")) { 
			raf.seek(raf.length());
			raf.writeInt(id);
			raf.writeUTF(izena);
			raf.writeDouble(soldata);
			
			System.out.println("Pertsona ondo gorde da.");
		} catch (IOException | NumberFormatException e ) {
			System.out.println("Errorea pertsona gordetzean: " + e.getMessage());
		}
		
	}
	
	public static void bistaratuPertsona() {
		try (RandomAccessFile raf = new RandomAccessFile("C:\\Users\\2AM3-3\\git\\ADat\\src\\menuInteraktiboa\\pertsonak.dat", "rw")) { 
			System.out.println("\n---------Pertsona zerrenda---------");
			if(raf.length() == 0) {
				System.out.println("Ez dago pertsonarik");
				return;
			}
			raf.seek(0);
			
			while(raf.getFilePointer() < raf.length()) {
				int irakurritakoId = raf.readInt();
				String irakurritakoIzena = raf.readUTF();
				double irakurritakoSoldata = raf.readDouble();
				
				System.out.println("\n------------------");
				System.out.println("ID: " + irakurritakoId);
				System.out.println("Izena: " + irakurritakoIzena);
				System.out.println("Soldata: " + irakurritakoSoldata);
			}
			
		} catch (IOException | NumberFormatException e ) {
			// TODO: handle exception
		}
	}
	
	
	
	
}
