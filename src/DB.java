import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB {
	public static void main(String args[]) throws SQLException{  
		//conexion
		Connection conn=null;
		String url="jdbc:mysql://localhost:3306/";
		String dbname="toadv2";
		String regla="?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String username="root";
		String pass="";
		
		try{  
		Class.forName("com.mysql.cj.jdbc.Driver");  
		conn=DriverManager.getConnection(url+dbname+regla,username,pass);  
		if (!conn.isClosed()) {
			System.out.println("Database conectada!!");
		}
		}catch(Exception e) {
			System.err.println("Exception"+e.getMessage());
		}
		finally {
			if (conn != null)
				System.out.println("DB, sigue conectada");
		}
		/*
		//INSERCION

	    String query = "INSERT INTO CINE(CinCod, CinNom, CinCiu, CinDir)"
	    		+ " VALUES (?,?,?,?)";
	    /*
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1,"1");
			stmt.setString(2,"CineMark");
			stmt.setString(3,"Arequipa");
			stmt.setString(4,"Av. Cine 123");
			int count = stmt.executeUpdate();
			System.out.println("Dato insertado, numero:"+count);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	     */
		//ACTUALIZACION
	    /*
		query="UPDATE CINE SET CinNom = ? WHERE CinCod =?";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setString(1, "CinePlanet");
		stmt.setString(2, "1");
		int count = stmt.executeUpdate();
		System.out.println("Actualizacion hecha, nro:"+count);
		*/
	    //CONSULTA
	    /*
	    query="SELECT * FROM CINE WHERE CinCod = ?";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setString(1, "1");
		ResultSet rs= stmt.executeQuery();
		while (rs.next()) {
			System.out.println("============================================");
			System.out.println("Codigo del Cine: "+ rs.getString("CinCod"));
			System.out.println("Nombre del Cine: "+ rs.getString("CinNom"));
			System.out.println("Ciudad del Cine: "+ rs.getString("CinCiu"));
			System.out.println("Direccion del Cine: "+ rs.getString("CinDir"));
			System.out.println("============================================");

		}
		rs.close();
		stmt.close();
		*/
	    //BORRADO
		/*
	    query = "DELETE FROM CINE WHERE CinCod = ?";
	    PreparedStatement stmt = conn.prepareStatement(query);
	    stmt.setString(1,"1");
	    int count = stmt.executeUpdate();
	    System.out.println("Eliminado. nro:"+count);
	    stmt.close();
	    
	    */
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}