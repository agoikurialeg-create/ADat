package pruebaAdat;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class textuAldaketa {
	public static File loremIpsum = new File(
			"C:\\Users\\2AM3-3\\eclipse-workspace\\pruebaAdat\\src\\pruebaAdat\\texto.txt");
	static Scanner scanner;
	static String loremString = "";
	public static String textuAldatua = "";
			

	public static void main(String[] args) {

		Scaner();

		System.out.println("Textu Originala: \n" + loremString);
		berridatzi();
	}

	static void Scaner() {
		try {
			scanner = new Scanner(loremIpsum);

			while (scanner.hasNextLine()) {
				loremString = loremString + scanner.nextLine() + "\n";

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void berridatzi() {
		loremIpsum.delete();
		File loremIpsumB = new File(
				"C:\\Users\\2AM3-3\\eclipse-workspace\\pruebaAdat\\src\\pruebaAdat\\texto.txt");
		String textuAldatua = loremString.replaceAll("a", "").replaceAll("A", "");
		System.out.println("Textu Aldatua: \n" + textuAldatua);

		
		try {
			FileWriter berridatzia = new FileWriter(loremIpsumB, false);
			berridatzia.write(textuAldatua);
			berridatzia.close();
			
		} catch (IOException e) {
		      e.printStackTrace();
		    }
	}
	
	

}
