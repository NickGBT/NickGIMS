import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

public class StockOrder {

	public static void generateStockOrder() {
		// returns values from the arrayList that are at the critical stock leve
		Properties out = new Properties();

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		Calendar rightNow = Calendar.getInstance();

		for (Product p : Product.allProducts) {
			if (p.getCriticalStockLevel() >= p.stockLevel) {

				out.setProperty(p.getProductName(), p.getStockLevel() + "");
			}

		}
		;
		try {
			out.store(
					new FileOutputStream(
							((dateFormat.format(rightNow.getTime())))
									+ " Stock Order.txt"), "Generated stock report.");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
