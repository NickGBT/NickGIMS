import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseConnection {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/myurl";
	
	static final String USER = "username";
	static final String PASS = "password";
	
	public void accessDB(){
		Connection conn = null;
		Statement stmt = null;
		try{
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Connecting to database...");
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		
		//create
		System.out.println("Inserting records to table");
		stmt = conn.createStatement();
		String sql = "INSERT INTO Languages" + "VALUES ()";
		stmt.executeUpdate(sql);
		System.out.println("Inserted records into the table...");
		
		//read
		System.out.println("Creating statement...");
		stmt = conn.createStatement();
		String sql2 = "SELECT id, name";
		ResultSet rs = stmt.executeQuery(sql2);
		while (rs.next()){
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int date = rs.getInt("date");
			int dateAdded = rs.getInt("dateAdded");
			System.out.println("ID: " + id + "name: " + name + ", date: " + date + "Date added: " + dateAdded);
		}
		rs.close();
		
		//update
		System.out.println("Creating statement...");
		stmt = conn.createStatement();
		String sql3 = "UPDATE Languages " + "SET date = WHERE id in (1, 2)";
		stmt.executeUpdate(sql3);
		
		//delete
		System.out.println("Creating statement... ");
		stmt = conn.createStatement();
		String sql4 = "DELETE FROM" + "WHERE id = 1";
		stmt.executeUpdate(sql4);
		}	catch (SQLException sqle) {
			sqle.printStackTrace();
			
		}	catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn !=null) conn.close();				
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		System.out.println("Connection closed.");
	}
}
