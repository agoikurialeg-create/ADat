// package futbol.Connect;
package futbol.Controller;

import java.sql.*;
import java.util.ArrayList;
import futbol.Model.Taldea;

public class TaldeaConnect {

    private Connection conexion() {
        String url = "jdbc:mysql://localhost:3306/futbol";
        String username = "root";
        String password = "";
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Errorea konektatzen " + e.getMessage());
            return null;
        }
    }

    public ArrayList<Taldea> getTaldeak() throws SQLException {
        ArrayList<Taldea> list = new ArrayList<>();
        String sql = "SELECT idEquipo, nombre, ciudad FROM equipos";
        try (Connection con = conexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Taldea t = new Taldea(
                    rs.getInt("idEquipo"),
                    rs.getString("nombre"),
                    rs.getString("ciudad")
                );
                list.add(t);
            }
        }
        return list;
    }

    public Taldea getTaldeaIDtik(int id) throws SQLException {
        String sql = "SELECT idEquipo, nombre, ciudad FROM equipos WHERE idEquipo = ?";
        try (Connection con = conexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Taldea(
                        rs.getInt("idEquipo"),
                        rs.getString("nombre"),
                        rs.getString("ciudad")
                    );
                }
            }
        }
        return null; // ez da aurkitu
    }

    public boolean existitzenDa(int id) throws SQLException {
        String sql = "SELECT 1 FROM equipos WHERE idEquipo = ?";
        try (Connection con = conexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }

    public void taldeaSortu(Taldea t) throws SQLException {
        String sql = "INSERT INTO equipos (idEquipo, nombre, ciudad) VALUES (?,?,?)";
        try (Connection con = conexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, t.getIdTaldea());
            ps.setString(2, t.getIzena());
            ps.setString(3, t.getHiria());
            ps.executeUpdate();
            System.out.println("Taldea ondo sortu da!!");
        }
    }
}
