import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class Product {
	private String productName;
	private String productType;
	private String supplier;
	private int productID;
	int stockLevel;
	private int criticalStockLevel;
	private String dateAdded;
	private String dateLastUpdated;
	private int cost;
	
	//Creating arraylist for the products within the product class
	
	public static ArrayList <Product> allProducts = new ArrayList <Product>();

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public void setStockLevel(int stockLevel) {
		this.stockLevel = stockLevel;
	}

	public void setCriticalStockLevel(int criticalStockLevel) {
		this.criticalStockLevel = criticalStockLevel;
	}

	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}

	public void setDateLastUpdated(String dateLastUpdated) {
		this.dateLastUpdated = dateLastUpdated;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public static void setAllProducts(ArrayList<Product> allProducts) {
		Product.allProducts = allProducts;
	}

	public String getProductName() {
		return productName;
	}

	public String getProductType() {
		return productType;
	}

	public String getSupplier() {
		return supplier;
	}

	public int getProductID() {
		return productID;
	}

	public int getStockLevel() {
		return stockLevel;
	}

	public int getCriticalStockLevel() {
		return criticalStockLevel;
	}

	public String getDateAdded() {
		return dateAdded;
	}

	public String getDateLastUpdated() {
		return dateLastUpdated;
	}

	public int getCost() {
		return cost;
	}

	//arraylist containing the product objects
	public static ArrayList<Product> getAllProducts() {
		return allProducts;
	}
	
	//creates the product object to be called and created through the IMSGUI class or the ProductModifier class
	

	
}
