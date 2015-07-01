public class StockPredictor {
	private String product;
	private int stockLevel;
	private int criticalStockLevel;
	private int StockReportDates;
	private int predictedDateStart;
	private int predictedDateEnd;
	private int predictivePeriod;

	String getProduct() {
		return product;
	}

	int getStockLevel() {
		return stockLevel;
	}

	int getCriticalStockLevel() {
		return criticalStockLevel;
	}

	void setPredictivePeriod(int predictivePeriod) {
		this.predictivePeriod = predictivePeriod;
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

	// Average out the stock levels between the predicted dates in order to
	// predict the drop in stock (over a set period)

}
