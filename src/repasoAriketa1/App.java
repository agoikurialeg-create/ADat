package repasoAriketa1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class App {
static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int aukera;
		do {
			System.out.println("\nEgunon, zer egin nahi dozu?");
			System.out.println("\n---------MENUA---------");
			System.out.println("1. Animali berria sortu");
			System.out.println("2. Animali guztiak bistaratu");
			System.out.println("3. Itxi");
			aukera = Integer.parseInt(scan.nextLine());
			switch(aukera) {
			case 1:
				gordeAnimalia();
				break;
			case 2:
				bistaratuAnimalia();
				break;
			case 3:
				System.out.println("Agur!");
				break;
			default: System.out.println("Aukera okerra! Sartu zenbaki bat.");
			}
		}while(aukera !=3);
		
	}
	
	public static void gordeAnimalia() {
		System.out.println("\n---------Animalia gehitu---------");
		System.out.println("Pertsona gehitzeko hurrengo datuak bete behar dituzu:");
		System.out.println("1.ID:");
		int id = Integer.parseInt(scan.nextLine());
		System.out.println("2. Izena:");
		String izena = scan.nextLine();
		System.out.println("3.Tamaña:");
		String tamaina = scan.nextLine();
		//TEXTU FITXATEGIA
		File animaliaktxt = new File(
				"C:\\\\Users\\\\2AM3-3\\\\git\\\\ADat\\\\src\\\\repasoAriketa1\\\\animaliak.txt");
		try (FileWriter fw = new FileWriter(animaliaktxt, true); BufferedWriter bw = new BufferedWriter(fw)) {

			    bw.write(id + "," + izena + "," + tamaina);
			    bw.newLine(); 

			    System.out.println("Animalia gehitu da textu fitxategian");

			} catch (IOException e) {
			    e.printStackTrace();
			}
		//FITXATEGI BITARRA
		try (RandomAccessFile raf = new RandomAccessFile("C:\\Users\\2AM3-3\\git\\ADat\\src\\repasoAriketa1\\animaliak.bit", "rw")) { 
			raf.seek(raf.length());
			raf.writeInt(id);
			raf.writeUTF(izena);
			raf.writeUTF(tamaina);
			
			System.out.println("Animalia ondo gorde da bitar fitxategian.");
		} catch (IOException | NumberFormatException e ) {
			System.out.println("Errorea pertsona bitar fitxategian gordetzean: " + e.getMessage());
		}
		
	}
	
	public static void bistaratuAnimalia() {
		//TEXTU FITXATEGIA
		File animaliaktxt = new File("C:\\Users\\2AM3-3\\git\\ADat\\src\\repasoAriketa1\\animaliak.txt");

		    System.out.println("\n---------Animali zerrenda testu fitxategian---------");
		    
		    if (!animaliaktxt.exists() || animaliaktxt.length() == 0) {
		        System.out.println("Ez dago animaliarik");
		        return;
		    }

		    try (BufferedReader br = new BufferedReader(new FileReader(animaliaktxt))) {
		        String line;
		        while ((line = br.readLine()) != null) {
		            String[] parts = line.split(",");
		            if (parts.length == 3) {
		                int irakurritakoId = Integer.parseInt(parts[0]);
		                String irakurritakoIzena = parts[1];
		                String irakurritakoTamaina = parts[2];

		                System.out.println("\n------------------");
		                System.out.println("ID: " + irakurritakoId);
		                System.out.println("Izena: " + irakurritakoIzena);
		                System.out.println("Tamaina: " + irakurritakoTamaina);
		            }
		        }
		    } catch (IOException e) {
		        System.out.println("Errorea testu fitxategia irakurtzean: " + e.getMessage());
		    }
		
		//FITXATEGI BITARRA
		try (RandomAccessFile raf = new RandomAccessFile("C:\\Users\\2AM3-3\\git\\ADat\\src\\repasoAriketa1\\animaliak.bit", "r")) { 
			System.out.println("\n---------Animali zerrenda fitxategi bitarrean---------");
			if(raf.length() == 0) {
				System.out.println("Ez dago pertsonarik");
				return;
			}
			raf.seek(0);
			
			while(raf.getFilePointer() < raf.length()) {
				int irakurritakoId = raf.readInt();
				String irakurritakoIzena = raf.readUTF();
				String irakurritakoTamaina = raf.readUTF();
				
				System.out.println("\n------------------");
				System.out.println("ID: " + irakurritakoId);
				System.out.println("Izena: " + irakurritakoIzena);
				System.out.println("Tamaña: " + irakurritakoTamaina);
			}
			
		} catch (IOException | NumberFormatException e ) {
			// TODO: handle exception
		}
	}
}
