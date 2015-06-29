import java.util.ArrayList;


public class RandomStockViewer {
	
	private static ArrayList<Product> productList;
	
	private static RandomStock randomStockNumber;
	
	
	
	@SuppressWarnings("null")
	public static void productStockDecrementer(){
	
	for (int i = 0; i < productList.size(); i++){
		
		Product p = null;
		
		RandomStock randomStockNumber = null;
		
		p.stockLevel = p.stockLevel - randomStockNumber.stockLevelDecrement;
		
		productList.set(p.stockLevel, p);
	}
	
}
}
