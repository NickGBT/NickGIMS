

public class StockControl {
	private String alertType;
	private String product;
	private int stockLevel;
	private int criticalStockLevel;
	private int previousStockLevel;
	private int changeInStockLevel;	 
	
	String getAlertType() {
		return alertType;
	}
	String getProduct() {
		
		return product;
		
	}
	int getStockLevel() {
		
		return stockLevel;
		
	}
	int getCriticalStockLevel() {
		
		return criticalStockLevel;
		
	}
	int getPreviousStockLevel() {
		
		return previousStockLevel;
		
	}
	int getChangeInStockLevel() {
		
		return changeInStockLevel;
		
	}
									
}
