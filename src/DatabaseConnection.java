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
					+ "VALUES (NULL, '"+p.getProductName()+"', '"+p.getProductType()+"', NULL, '"+p.getDateLastUpdated()+"', '"+p.getCost()+"', '"+p.getStockLevel()+"', "
							+ "'"+p.getCriticalStockLevel()+"', '"+p.getSupplier()+"');");
			updateIMSGUI();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void updateDatabase(Product p) {
		try {
			Statement s = conn.createStatement();

			s.executeUpdate("UPDATE `imsdatabase`.`products` "
					+ "SET `name` ='"+p.getProductName()+"', `type` ='"+p.getProductType()+"', `cost`='"+p.getCost()+"', `stock_level`='"+p.getStockLevel()+"', "
							+ "`critical_stock_level`='"+p.getCriticalStockLevel()+"', `supplier`='"+p.getSupplier()+"' WHERE `id` = '"+p.getProductID()+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void updateIMSGUI() {
		try {
			Statement s = conn.createStatement();
				ResultSet rs = s.executeQuery("SELECT * FROM `imsdatabase`.`products`");
				Product.allProducts.clear();
				while(rs.next()){
					Product p = new Product();
					p.setProductID(rs.getInt("id"));
					p.setProductName(rs.getString("name"));
					p.setProductType(rs.getString("type"));
					p.setDateAdded(rs.getString("date_added"));
					p.setDateLastUpdated(rs.getString("date_last_updated"));
					p.setCost(rs.getInt("cost"));
					p.setStockLevel(rs.getInt("stock_level"));
					p.setCriticalStockLevel(rs.getInt("critical_stock_level"));
					p.setSupplier(rs.getString("supplier"));
					Product.allProducts.add(p);
					IMSGUI.belowThresholdAlert(p);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
