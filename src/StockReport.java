import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

public class StockReport {

	public static void generateReport() {
		// returns values from the arrayList
		Properties out = new Properties();

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		Date date = new Date();
		Calendar rightNow = Calendar.getInstance();

		for (Product p : Product.allProducts) {
			out.setProperty(p.getProductName(), p.getStockLevel() + "");

		}
		;
		try {
			out.store(
					new FileOutputStream(
							((dateFormat.format(rightNow.getTime())))
									+ " Report.txt"), "Generated stock report.");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
