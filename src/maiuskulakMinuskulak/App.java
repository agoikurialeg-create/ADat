package maiuskulakMinuskulak;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class App {
	public static void main(String[] args) {
        String txtNormala = "C:\\Users\\2AM3-3\\git\\ADat\\src\\maiuskulakMinuskulak\\normala.txt";
        String txtAldatua = "C:\\Users\\2AM3-3\\git\\ADat\\src\\maiuskulakMinuskulak\\aldatuta.txt";

        try (FileReader fr = new FileReader(txtNormala);
             FileWriter fw = new FileWriter(txtAldatua)) {

            int c;
            while ((c = fr.read()) != -1) {
                char caracter = (char) c;
                if (Character.isUpperCase(caracter)) {
                    caracter = Character.toLowerCase(caracter);
                } else if (Character.isLowerCase(caracter)) {
                    caracter = Character.toUpperCase(caracter);
                }
                fw.write(caracter);
            }

            System.out.println("Ondo aldatu da eta " + txtAldatua + " fitxategian gorde da.");

        } catch (IOException e) {
            System.out.println("Errorea: " + e.getMessage());
        }
    }

}
