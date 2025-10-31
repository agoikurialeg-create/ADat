package kutxabank.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import kutxabank.Model.db.Konexioa;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        menuaErakutsi();    
    }

    private static void menuaErakutsi() {
        int aukera;
        do {
            System.out.println("\nEgunon, zer egin nahi dozu?");
            System.out.println("\n---------MENUA---------");
            System.out.println("1. Erabiltzaile baten dirua bistariatu");
            System.out.println("2. Inprimatu bezeroen izenak");
            System.out.println("3. Erabiltzaile bat gehitu");
            System.out.println("4. Erabiltzaile baten datuak aldatu");
            System.out.println("5. Erabiltzaile bat ezabatu");
            System.out.println("6. Erabiltzaile guztien datuak atera");
            System.out.println("7. Itxi");
            System.out.println("-----------------------\n");
            aukera = Integer.parseInt(scan.nextLine());
            
            switch(aukera) {
                case 1: diruaBistaratu(); break;
				case 2: inprimatuIzenak(); break;
                case 3: erabiltzaileBatGehitu(); break;
                case 4: erabiltzaileBatAldatu(); break;
                case 5: erabiltzaileBatEzabatu(); break;
                case 6: erabiltzaileGuztienDatuakAtera(); break;
                case 7: System.out.println("Agur!"); break;
                default: System.out.println("Aukera okerra! Sartu zenbaki bat.");
            }
        } while(aukera != 7);
    }

    private static void diruaBistaratu() {
        System.out.println("===========Erabiltzaile baten dirua bistariatu===========");
        System.out.println("Zein da dirua bistaratu nahi duzun erabiltzailearen izena?");
        String izena = scan.nextLine();

        Connection con = Konexioa.getKonexioa();
        try {
            PreparedStatement ps = con.prepareStatement(
                "SELECT kantitatea FROM erabiltzaile_mugimenduak WHERE izena = ?"
            );
            ps.setString(1, izena);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) { 
                int kant = rs.getInt("kantitatea");
                System.out.println(izena + "ren diru kopurua " + kant + " da.");
            } else {
                System.out.println("Ez da aurkitu erabiltzailea: " + izena);
            }
            System.out.println("==========================================================");
        } catch(SQLException e){
            System.out.println("Errorea: " + e.getMessage());
        }
    }

    private static void erabiltzaileBatGehitu() {
        System.out.println("===========Erabiltzaile bat gehitu===========");
        System.out.println("Sartu erabiltzailearen izena:");
        String izena = scan.nextLine();
        System.out.println("Sartu erabiltzailearen diru kopurua:");
        int kantitatea = Integer.parseInt(scan.nextLine());

        Connection con = Konexioa.getKonexioa();
        try {
            String sql = "INSERT INTO erabiltzaile_mugimenduak (timestamp, izena, kantitatea) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now()));
            ps.setString(2, izena);
            ps.setInt(3, kantitatea);

            ps.executeUpdate();
            System.out.println("Erabiltzailea gehitu da: " + izena);
            System.out.println("==========================================================");
        } catch (SQLException e) {
            System.out.println("Errorea: " + e.getMessage());
        }
    }

    private static void inprimatuIzenak() {
        Connection con = Konexioa.getKonexioa();
        ArrayList<String> bezeroZerrenda = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT izena FROM erabiltzaile_mugimenduak");
            while(rs.next()) {
                bezeroZerrenda.add(rs.getString("izena"));
            }
        } catch(SQLException e) {
            System.out.println("Errorea: " + e.getMessage());
        }
        System.out.println(bezeroZerrenda);
    }

    private static void erabiltzaileBatAldatu() {
        System.out.println("===========Erabiltzaile baten datuak aldatu===========");
        System.out.println("Sartu aldatu nahi duzun erabiltzailearen izena:");
        String izena = scan.nextLine();

        Connection con = Konexioa.getKonexioa();
        try {
            PreparedStatement psCheck = con.prepareStatement(
                "SELECT * FROM erabiltzaile_mugimenduak WHERE izena = ?"
            );
            psCheck.setString(1, izena);
            ResultSet rs = psCheck.executeQuery();

            if (!rs.next()) {
                System.out.println("Ez da aurkitu erabiltzailea: " + izena);
                System.out.println("==========================================================");
                return;
            }

            System.out.println("Sartu erabiltzailearen izen berria (edo sakatu ENTER ez aldatzeko):");
            String izenaBerria = scan.nextLine();
            if (izenaBerria.isEmpty()) izenaBerria = izena;

            System.out.println("Sartu diru kantitate berria (edo sakatu ENTER ez aldatzeko):");
            String kantitateaSartu = scan.nextLine();
            int kantitateaBerria = kantitateaSartu.isEmpty() ? rs.getInt("kantitatea") : Integer.parseInt(kantitateaSartu);

            PreparedStatement psUpdate = con.prepareStatement(
                "UPDATE erabiltzaile_mugimenduak SET izena = ?, kantitatea = ? WHERE izena = ?"
            );
            psUpdate.setString(1, izenaBerria);
            psUpdate.setInt(2, kantitateaBerria);
            psUpdate.setString(3, izena);
            psUpdate.executeUpdate();

            System.out.println("Erabiltzailearen datuak aldatu dira: " + izenaBerria);
            System.out.println("==========================================================");
        } catch (SQLException e) {
            System.out.println("Errorea: " + e.getMessage());
        }
    }

    private static void erabiltzaileBatEzabatu() {
        System.out.println("===========Erabiltzaile bat ezabatu===========");
        System.out.println("Sartu ezabatu nahi duzun erabiltzailearen izena:");
        String izena = scan.nextLine();

        Connection con = Konexioa.getKonexioa();
        try {
            PreparedStatement psCheck = con.prepareStatement(
                "SELECT * FROM erabiltzaile_mugimenduak WHERE izena = ?"
            );
            psCheck.setString(1, izena);
            ResultSet rs = psCheck.executeQuery();

            if (!rs.next()) {
                System.out.println("Ez da aurkitu erabiltzailea: " + izena);
                System.out.println("==========================================================");
                return;
            }

            PreparedStatement psDelete = con.prepareStatement(
                "DELETE FROM erabiltzaile_mugimenduak WHERE izena = ?"
            );
            psDelete.setString(1, izena);
            psDelete.executeUpdate();

            System.out.println("Erabiltzailea ezabatu da: " + izena);
            System.out.println("==========================================================");
        } catch (SQLException e) {
            System.out.println("Errorea: " + e.getMessage());
        }
    }

    private static void erabiltzaileGuztienDatuakAtera() {
        Connection con = Konexioa.getKonexioa();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM erabiltzaile_mugimenduak ORDER BY izena");

            System.out.println("===========Erabiltzaile Guztien Datuak===========");
            System.out.printf("%-20s %-20s %-10s%n", "IZENA", "DATA", "KANTITATEA");
            System.out.println("--------------------------------------------------------");

            while (rs.next()) {
                String izena = rs.getString("izena");
                Timestamp data = rs.getTimestamp("timestamp");
                int kantitatea = rs.getInt("kantitatea");

                System.out.printf("%-20s %-20s %-10d%n", izena, data.toLocalDateTime(), kantitatea);
            }
            System.out.println("==========================================================");
        } catch (SQLException e) {
            System.out.println("Errorea: " + e.getMessage());
        }
    }
}
