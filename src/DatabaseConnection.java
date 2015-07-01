import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/imsdatabase";
	static final String USER = "root";
	static final String PASS = "";

	static Connection conn = null;

	public static void connectToDatabase() {

		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void insertDatabase(Product p) {
		try {
			Statement s = conn.createStatement();
			s.executeUpdate("INSERT INTO `imsdatabase`.`products` (`id`, `name`, `type`, `date_added`, `date_last_updated`, `cost`, `stock_level`, `critical_stock_level`, `supplier`) "
					+ "VALUES (NULL, '"
					+ p.getProductName()
					+ "', '"
					+ p.getProductType()
					+ "', NULL, '"
					+ p.getDateLastUpdated()
					+ "', '"
					+ p.getCost()
					+ "', '"
					+ p.getStockLevel()
					+ "', "
					+ "'"
					+ p.getCriticalStockLevel()
					+ "', '"
					+ p.getSupplier()
					+ "');");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void updateDatabase(Product p) {
		try {
			Statement s = conn.createStatement();
			s.executeUpdate("UPDATE WHERE `imsdatabase`.`products` (`id`, `name`, `type`, `date_added`, `date_last_updated`, `cost`, `stock_level`, `critical_stock_level`, `supplier`) "
					+ "VALUES (NULL, '"
					+ p.getProductName()
					+ "', '"
					+ p.getProductType()
					+ "', NULL, '"
					+ p.getDateLastUpdated()
					+ "', '"
					+ p.getCost()
					+ "', '"
					+ p.getStockLevel()
					+ "', "
					+ "'"
					+ p.getCriticalStockLevel()
					+ "', '"
					+ p.getSupplier()
					+ "');");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void updateIMSGUI() {

	}

	/*
	 * public static void readFromTable(int ProductID, String ProductName,
	 * String ProductType, String DateLastUpdated, int Cost, int StockLevel, int
	 * CriticalStockLevel, String Supplier) {
	 * 
	 * System.out.println("Creating statement..."); try { stmt =
	 * conn.createStatement(); String sql = "INSERT INTO product" + "VALUES (" +
	 * ProductID + ", " + ProductName + ", " + ProductType + ", " +
	 * DateLastUpdated + ", " + Cost + ", " + StockLevel + ", " +
	 * CriticalStockLevel + ", " + Supplier + ")"; stmt.executeUpdate(sql);
	 * System.out.println("Inserted records into the table...");
	 * 
	 * } catch (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 */

}
