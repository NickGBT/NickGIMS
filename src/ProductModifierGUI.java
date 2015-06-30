import java.awt.Dimension;
import java.awt.GridLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ProductModifierGUI extends JDialog {

	static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	static Date date = new Date();
	Calendar rightNow = Calendar.getInstance();
	private Product product;

	public Product getProduct() {

		// get the values from text boxes, integer values must be passed from a
		// string to an int
		product.setProductName(nameTextBox.getText());
		product.setProductType(typeTextBox.getText());
		product.setCost(Integer.parseInt(costTextBox.getText()));
		product.setStockLevel(Integer.parseInt(stockTextBox.getText()));
		product.setCriticalStockLevel(Integer.parseInt(criticalStockTextBox
				.getText()));
		product.setSupplier(supplierTextBox.getText());
		product.setDateLastUpdated(dateFormat.format(rightNow.getTime()));
		return product;

	}

	private JFrame mainBox;
	private JTextField nameTextBox;
	private JTextField typeTextBox;
	private JTextField costTextBox;
	private JTextField stockTextBox;
	private JTextField criticalStockTextBox;
	private JTextField supplierTextBox;

	public ProductModifierGUI(Product product) {

		this.product = product;

		this.prepareGUI();

	};

	public ProductModifierGUI() {

		product = new Product();

		mainBox = new JFrame();

		mainBox.setLayout(new GridLayout(3, 0));

		this.prepareGUI();

	}

	private void prepareGUI() {

		this.setSize(1000, 200);

		this.setModal(true);

		this.setLayout(new GridLayout(3, 3));

		this.add(new JLabel("Name"));
		nameTextBox = new JTextField(product.getProductName());
		this.add(nameTextBox);
		nameTextBox.setPreferredSize(new Dimension(100, 15));

		this.add(new JLabel("Type"));
		typeTextBox = new JTextField(product.getProductType());
		this.add(typeTextBox);
		typeTextBox.setPreferredSize(new Dimension(100, 15));

		this.add(new JLabel("Cost"));
		costTextBox = new JTextField(product.getCost() + "");
		this.add(costTextBox);
		costTextBox.setPreferredSize(new Dimension(100, 15));

		this.add(new JLabel("Stock Level"));
		stockTextBox = new JTextField(product.getStockLevel() + "");
		this.add(stockTextBox);
		stockTextBox.setPreferredSize(new Dimension(100, 15));

		this.add(new JLabel("Critical Stock Level"));
		criticalStockTextBox = new JTextField(product.getCriticalStockLevel()
				+ "");
		this.add(criticalStockTextBox);
		criticalStockTextBox.setPreferredSize(new Dimension(100, 15));

		this.add(new JLabel("Supplier"));
		supplierTextBox = new JTextField(product.getSupplier());
		this.add(supplierTextBox);
		supplierTextBox.setPreferredSize(new Dimension(100, 15));

	}

}
