package ficherosBinarios;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main {
	
	public static void main(String[] args) {
		
		File p1File = new File("C:\\Users\\2AM3-3\\eclipse-workspace\\ProyectoAdat\\src\\ficherosBinarios\\p1.bit");
		File p2File = new File("C:\\Users\\2AM3-3\\eclipse-workspace\\ProyectoAdat\\src\\ficherosBinarios\\p2.bit");
		File p3File = new File("C:\\Users\\2AM3-3\\eclipse-workspace\\ProyectoAdat\\src\\ficherosBinarios\\p3.bit");

		
		Persona p1 = new Persona ("Ane", 22, "ane@ane.ane");
		Persona p2 = new Persona ("Sofia", 23, "sofia@sofia.sofia");
		Persona p3 = new Persona ("Aitorch", 30, "aitorch@aitorch.aitorch");
		
		gordePertsona(p1, p1File);
		gordePertsona(p2, p2File);
		gordePertsona(p3, p3File);
		
	}
	
	public static void gordePertsona(Persona persona, File fitxategia) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fitxategia))){
			oos.writeObject(persona);
			oos.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
  