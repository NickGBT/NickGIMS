import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class StockReport {

	public static void generateReport(){
		//returns values from the arrayList
		Properties out = new Properties();
		
		for (Product p : Product.allProducts){
			out.setProperty(p.getProductName(), p.getStockLevel()+"");
			
		};
		try {
			out.store(new FileOutputStream("Report.txt"), "Generated stock report.");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
