
public class Product {
	private String productName;
	private String productType;
	private String supplier;
	private int productID;
	private int stockLevel;
	private int criticalStockLevel;
	private int dateAdded;
	private int dateLastUpdated;
	private int cost;
	String getSupplier() {
		return supplier;
	}
	int getDateAdded() {
		return dateAdded;
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
