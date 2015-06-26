import java.time.LocalDateTime;
import java.util.Date;


public class Product {
	private String productName;
	private String productType;
	private String supplier;
	private int productID;
	private int stockLevel;
	private int criticalStockLevel;
	private LocalDateTime dateAdded;
	private int dateLastUpdated;
	private int cost;
	
	//creates the product object to be called and created through the IMSGUI class or the IMSGUIListener class
	
	String getSupplier() {
		return supplier;
	}
	void setDateAdded() {
		dateAdded = LocalDateTime.now();
	}
	int getDateLastUpdated() {
		return dateLastUpdated;
	}
	void setProductName(String productName) {
		this.productName = productName;
		
	}
	void setProductType(String productType) {
		this.productType = productType;
	}
	void setProductID(int productID) {
		this.productID = productID;
	}
	void setStockLevel(int stockLevel) {
		this.stockLevel = stockLevel;
	}
	void setCriticalStockLevel(int criticalStockLevel) {
		this.criticalStockLevel = criticalStockLevel;
	}
	void setCost(int cost) {
		this.cost = cost;
	}

	
}
