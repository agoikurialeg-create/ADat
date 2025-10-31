package repasoAriketa2;

import repasoAriketa2.Model.*;
import java.io.*;
import java.util.*;

public class Main {
    private static final String FITXATEGIA = "C:\\Users\\2AM3-3\\git\\ADat\\src\\repasoAriketa2\\jokalariak.obj";
    private static ArrayList<Jokalaria> jokalariZerrenda = new ArrayList<>();
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        jokalariZerrenda = irakurriBitarrean();

        int aukera;

        do {
            System.out.println("\n----- MENUA -----");
            System.out.println("1. Sortu jokalaria");
            System.out.println("2. Gorde");
            System.out.println("3. Jokalari guztiak bistaratu");
            System.out.println("4. Jokalari mota bakoitza kontatu");
            System.out.println("5. Irten");
            System.out.print("Aukeratu: ");
            aukera = Integer.parseInt(scan.nextLine());

            switch (aukera) {
                case 1:
                    sortuJokalaria();
                    break;
                case 2:
                    gordeBitarrean();
                    break;
                case 3:
                    bistaratuJokalariak();
                    break;
                case 4:
                    kontatuMotaBakoitza();
                    break;
                case 5:
                    System.out.println("Agur!");
                    break;
                default:
                    System.out.println("Aukera okerra! Sartu zenbaki bat.");
            }

        } while (aukera != 5);
    }

    private static void sortuJokalaria() {
        System.out.print("Izena: ");
        String izena = scan.nextLine();
        System.out.print("Altuera (m): ");
        Double altuera = Double.parseDouble(scan.nextLine());
        System.out.print("Zenbakia: ");
        int zenbakia = Integer.parseInt(scan.nextLine());

        System.out.println("Zein motatako jokalaria da?");
        System.out.println("1. Atezaina");
        System.out.println("2. Defentsa");
        System.out.println("3. Aurrelaria");
        int mota = Integer.parseInt(scan.nextLine());

        Jokalaria j = null;
        switch (mota) {
            case 1:
                j = new Atezaina(izena, altuera, zenbakia);
                break;
            case 2:
                j = new Defentsa(izena, altuera, zenbakia);
                break;
            case 3:
                j = new Aurrelaria(izena, altuera, zenbakia);
                break;
            default:
                System.out.println("Mota okerra!");
                return;
        }

        jokalariZerrenda.add(j);
        System.out.println("Jokalaria gehitu da zerrendara!");
    }

    private static void gordeBitarrean() {
        if (jokalariZerrenda.isEmpty()) {
            System.out.println("Ez dago jokalaririk gordetzeko.");
            return;
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FITXATEGIA))) {
            oos.writeObject(jokalariZerrenda);
            System.out.println("Jokalari guztiak gorde dira fitxategian!");
        } catch (IOException e) {
            System.out.println("Errorea fitxategian gordetzean: " + e.getMessage());
        }
    }

    private static void bistaratuJokalariak() {
        ArrayList<Jokalaria> irakurritakoak = irakurriBitarrean();
        if (irakurritakoak.isEmpty()) {
            System.out.println("Ez dago jokalaririk fitxategian.");
            return;
        }

        System.out.println("\n--- Jokalari guztiak ---");
        for (Jokalaria j : irakurritakoak) {
            System.out.println(j);
            j.jokatu();
        }
    }

    private static void kontatuMotaBakoitza() {
        ArrayList<Jokalaria> irakurritakoak = irakurriBitarrean();
        if (irakurritakoak.isEmpty()) {
            System.out.println("Ez dago jokalaririk fitxategian.");
            return;
        }

        int atezainak = 0;
        int defentsak = 0;
        int aurrelariak = 0;

        for (Jokalaria j : irakurritakoak) {
            if (j instanceof Atezaina)
                atezainak++;
            else if (j instanceof Defentsa)
                defentsak++;
            else if (j instanceof Aurrelaria)
                aurrelariak++;
        }

        System.out.println("\n--- Jokalari motak ---");
        System.out.println("Atezainak: " + atezainak);
        System.out.println("Defentsak: " + defentsak);
        System.out.println("Aurrelariak: " + aurrelariak);
    }

    private static ArrayList<Jokalaria> irakurriBitarrean() {
        File fitx = new File(FITXATEGIA);
        if (!fitx.exists())
            return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fitx))) {
            Object obj = ois.readObject();
            ArrayList<Jokalaria> lista = new ArrayList<>();

            if (obj instanceof ArrayList<?>) {
                for (Object element : (ArrayList<?>) obj) {
                    if (element instanceof Jokalaria) {
                        lista.add((Jokalaria) element);
                    }
                }
            }

            return lista;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Errorea fitxategia irakurtzean: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
