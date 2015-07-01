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

	public void accessDB() throws Exception {

		try {
			ResultSet rs = null;
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = null;
			// create
			// System.out.println("Inserting records to table");
			stmt = conn.createStatement();
			String sql = "INSERT INTO Product" + "VALUES ()";
			stmt.executeUpdate(sql);
			System.out.println("Inserted records into the table...");

			// read
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql2 = "SELECT id, name";
			rs = stmt.executeQuery(sql2);
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int date = rs.getInt("date");
				int dateAdded = rs.getInt("dateAdded");
				System.out.println("ID: " + id + "name: " + name + ", date: "
						+ date + "Date added: " + dateAdded);
			}
			rs.close();

			// update
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql3 = "UPDATE Product " + "SET date = WHERE id in (1, 2)";
			stmt.executeUpdate(sql3);

			// delete
			System.out.println("Creating statement... ");
			stmt = conn.createStatement();
			String sql4 = "DELETE FROM" + "WHERE id = 1";
			stmt.executeUpdate(sql4);
		} catch (SQLException sqle) {
			sqle.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		System.out.println("Connection closed.");
	}

	public void insertToTable(int ProductID, String ProductName,
			String ProductType, String DateLastUpdated, int Cost,
			int StockLevel, int CriticalStockLevel, String Supplier) {

		System.out.println("Creating statement...");
		try {

			PreparedStatement stmt = null;

			try {
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
			} catch (SQLException e) {

			}

			String sql = "INSERT INTO product (productName, productType, productCost, productStockLevel, productCriticalStockLevel, dateLastUpdated, productSupplier)"
					+ "VALUES (? , ?, ?, ? , ?, ?, ?";
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, ProductName);
			stmt.setString(2, ProductType);
			stmt.setInt(3, Cost);
			stmt.setInt(4, StockLevel);
			stmt.setInt(5, CriticalStockLevel);
			stmt.setString(6, DateLastUpdated);

			stmt.executeUpdate();
			System.out.println("Inserted records into the table...");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

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
