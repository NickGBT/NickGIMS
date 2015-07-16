import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ProductModifierGUI extends JDialog {

	static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	static Date date = new Date();
	Calendar rightNow = Calendar.getInstance();
	private Product product;
	private ProductModifierGUI guiInstance;
	private boolean OK = false;
	
	public boolean WasOK()
	{
		return OK;
	}

	public Product getProduct() {

		// get the values from text boxes, integer values must be passed from a
		// string to an int
		product.setProductName(nameTextBox.getText());
		
		if (product.productName.matches("")){
			JOptionPane.showMessageDialog(null, "product name must be entered");
			return null;
		}
		product.setProductType(typeTextBox.getText());
		
		if (product.productType.matches("")){
			JOptionPane.showMessageDialog(null, "product type must be entered");
			return null;
		}
		product.setCost(Integer.parseInt(costTextBox.getText()));
		product.setStockLevel(Integer.parseInt(stockTextBox.getText()));
		product.setCriticalStockLevel(Integer.parseInt(criticalStockTextBox
				.getText()));
		product.setSupplier(supplierTextBox.getText());
		
		if (product.supplier.matches("")){
			JOptionPane.showMessageDialog(null, "product supplier must be entered");
			return null;
		}
		
		product.setDateLastUpdated(dateFormat.format(rightNow.getTime()));
		return product;
		

	}

	private JTextField nameTextBox;
	private JTextField typeTextBox;
	private JTextField costTextBox;
	private JTextField stockTextBox;
	private JTextField criticalStockTextBox;
	private JTextField supplierTextBox;
	private JButton okButton;
	private JButton cancelButton;

	public ProductModifierGUI(Product product) {
		guiInstance = this;
		this.product = product;

		this.prepareGUI();
	};

	public ProductModifierGUI() {
		guiInstance = this;
		product = new Product();

		this.prepareGUI();
	}
	private void prepareGUI() {
		this.setSize(1000, 200);

		this.setModal(true);

		this.setLayout(new GridLayout(0, 2));

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
		
		// this.add (new JButton("OK"));
		okButton = new JButton("OK");

		okButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				OK = true;
				guiInstance.dispose();
			}
		});
		

		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				guiInstance.dispose();
			}
		});
		
		this.add(okButton);

		this.add(cancelButton);
	}
}
