import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

public class StockReport {

	public static void generateReport() {
		// returns values from the arrayList
		Properties out = new Properties();

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		Calendar rightNow = Calendar.getInstance();

		for (Product p : Product.allProducts) {
			out.setProperty("Product Name: " + p.getProductName() + "\t\t" + " Product Stock Level: " + p.getStockLevel() + "", p.getDateLastUpdated());

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

//DataOutputStream dataOut = new DataOutputStream(new FileOutputStream((dateFormat.format(rightNow.getTime()))+ " Report.txt"));
//dataOut.writeUTF("    Stock Report for " + (dateFormat.format(rightNow.getTime())));
//dataOut.writeUTF("Product Name: " + p.getProductName() + "\t\t\t" + "Product Type: "+ p.getProductType() + "\t\t\t"+ "Stock Level: " + p.getStockLevel());