
import java.awt.Component;

import javax.swing.*;

public class StockControl {
	private String alertType;
	private String product;
	private int stockLevel;
	private int criticalStockLevel;
	private int previousStockLevel;
	private int changeInStockLevel;
	
	private IMSGUI imsGUI;
	 
	
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
	
	public void belowThresholdAlert() {
		
		if (stockLevel < criticalStockLevel){
			
			JOptionPane.showMessageDialog(imsGUI.getMainBox(), stockLevel + " is below the critical stock level!, please order new stock.");
			
		}
								
	}

}
