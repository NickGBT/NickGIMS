
public class StockPredictor {
	private String product;
	private int stockLevel;
	private int criticalStockLevel;
	private int StockReportDates;
	private int predictedDateStart;
	private int predictedDateEnd;
	String getProduct() {
		return product;
	}
	int getStockLevel() {
		return stockLevel;
	}
	int getCriticalStockLevel() {
		return criticalStockLevel;
	}
	int getStockReportDates() {
		return StockReportDates;
	}
	void setPredictedDateStart(int predictedDateStart) {
		this.predictedDateStart = predictedDateStart;
	}
	void setPredictedDateEnd(int predictedDateEnd) {
		this.predictedDateEnd = predictedDateEnd;
	}
	
	

}
