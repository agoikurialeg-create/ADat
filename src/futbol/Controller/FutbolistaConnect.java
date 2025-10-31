package futbol.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import futbol.Model.Futbolista;



public class FutbolistaConnect {
	private Connection conexion() {
		String url = "jdbc:mysql://localhost:3306/futbol";
        String username = "root";
        String password = "";
        Connection connection	 = null;
        try {
        	connection = DriverManager.getConnection(url, username, password);
            //System.out.println("Datu basera konektatuta");
            
        } catch (SQLException e) {
            System.out.println("Errorea konektatzen " + e.getMessage());
        }
 
		return connection;
	}
	public Futbolista getFutbolistaIDtik(String id) throws SQLException {
		Connection con = conexion();
		Statement st = con.createStatement();
		String consulta= "SELECT * FROM futbolistas WHERE dni='"+id+"';";
        ResultSet resultSet = (ResultSet) st.executeQuery(consulta);
        Futbolista fut=new Futbolista();
        while (resultSet.next()) {
            String izena = resultSet.getString("nombre");
            String abizenak= resultSet.getString("apellido");
            fut = new Futbolista(id, izena, abizenak);
        }
		return fut;
	}
	public void futbolistaSortu(Futbolista fut) throws SQLException {
		Connection con = conexion();
		Statement st = con.createStatement();
		String consulta= "INSERT INTO futbolistas "
				+ "(DNI, nombre, apellido,salario,idEquipo) "
				+ "VALUES ('"+fut.getNAN()+"', '"+fut.getIzena()+"', '"+fut.getAbizena()+"', '"+fut.getSoldata()+"', '"+fut.getIdTaldea()+"');";
        
		boolean emaitza=st.execute(consulta);
		System.out.println(emaitza);
		
		System.out.println("Futbolista ondo sortu da!!");
	
		
	
		con.close();
	}
	public void futbolistaEzabatu(String NANFut) throws SQLException {
		Connection con = conexion();
		Statement st = con.createStatement();
		String consulta= "DELETE FROM usuarios WHERE id='"+NANFut+"'";
        
		st.execute(consulta);
		
		
	}
	public ArrayList<Futbolista> getFutbolistak() throws SQLException {
		Connection con = conexion();
		Statement st = con.createStatement();
		String consulta= "SELECT * FROM futbolistas;";
        ResultSet resultSet = (ResultSet) st.executeQuery(consulta);
		ArrayList<Futbolista> futbolistaList=new ArrayList<Futbolista>();
        Futbolista fut=new Futbolista();
        System.out.println("AAAAAAA");

        System.out.println(resultSet);
        System.out.println("BBBBBBBBBB");

        while (resultSet.next()) {
            
        	
            System.out.println(resultSet.next());

        	
        	fut =new Futbolista();
        
        	
            
            fut.setNAN(resultSet.getString("dni"));
            fut.setIzena(resultSet.getString("nombre"));
            fut.setAbizena(resultSet.getString("apellido"));
            fut.setSoldata(resultSet.getInt("salario"));
            fut.setIdTaldea(resultSet.getInt("idEquipo"));
            futbolistaList.add(fut);
            //System.out.println(futbolistaList.toString());
        }
		return futbolistaList;
	}

}
	

