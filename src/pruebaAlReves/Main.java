package pruebaAlReves;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static File parrafosIni = new File(
			"C:\\Users\\2AM3-3\\eclipse-workspace\\pruebaAdat\\src\\pruebaAlReves\\texto.txt");
	static Scanner scanner;
	
	
	public static void main(String[] args) {
		List<String> parrafos = new ArrayList<>();
		try {
			scanner = new Scanner(parrafosIni);
			
			while(scanner.hasNextLine()) {
				parrafos.add(scanner.nextLine());
			}
			
			Collections.reverse(parrafos);
			
			parrafosIni.delete();
			File parrafosFi = new File(
					"C:\\Users\\2AM3-3\\eclipse-workspace\\pruebaAdat\\src\\pruebaAlReves\\texto.txt");
			try {
				FileWriter berridatzia = new FileWriter(parrafosFi, false);
				for(String linea : parrafos) {
				System.out.println(linea);
				berridatzia.write(linea + "\n");
			}
				berridatzia.close();
			}catch (IOException e) {
			      e.printStackTrace();
			    }
			
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}


}
