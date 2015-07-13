import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//GUI for the IMS, using swing and JFrames/JPanels to create the interface.
public class IMSGUI {
	// add components to gui
	public JFrame mainBox;
	private JLabel frameLabel;
	public JLabel statusLabel;
	private JPanel controlPanel;
	private JButton addButton;
	private JButton editButton;
	private JButton generateReportButton;
	private JButton showGraphButton;
	private JButton refreshButton;
	private JButton generateStockOrderButton;
	private ArrayList<Product> productList;
	private JScrollPane scrollPane;
	private JTable productTable;
	private DefaultTableModel productTableModel;
	private IMSGUIListener buttonListener;

	public IMSGUI(ArrayList<Product> productList) {

		this.productList = productList;
		prepareGUI();
	}

	private void prepareGUI() {

		mainBox = new JFrame("Inventory Management System");
		mainBox.setSize(950, 500);
		mainBox.setLayout(new GridLayout(3, 0)); // layout setter
		mainBox.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		RandomStockViewer guiStockViewer = new RandomStockViewer();

		// adding the components to the GUI
		frameLabel = new JLabel("", JLabel.CENTER);

		// sets the table model for the JTable
		productTableModel = new DefaultTableModel();

		// adding columns for the JTable
		productTableModel.addColumn("ID");
		productTableModel.addColumn("Name");
		productTableModel.addColumn("Type");
		productTableModel.addColumn("Date Added");
		productTableModel.addColumn("Last Updated");
		productTableModel.addColumn("Cost");
		productTableModel.addColumn("Stock Level");
		productTableModel.addColumn("Critical Stock Level");
		productTableModel.addColumn("Supplier");

		// adding the JTable
		productTable = new JTable(productTableModel);

		// setting minimum width for the table columns
		productTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		productTable.getColumnModel().getColumn(0).setPreferredWidth(27);
		productTable.getColumnModel().getColumn(1).setPreferredWidth(100);
		productTable.getColumnModel().getColumn(2).setPreferredWidth(100);
		productTable.getColumnModel().getColumn(3).setPreferredWidth(100);
		productTable.getColumnModel().getColumn(4).setPreferredWidth(100);
		productTable.getColumnModel().getColumn(5).setPreferredWidth(100);
		productTable.getColumnModel().getColumn(6).setPreferredWidth(150);
		productTable.getColumnModel().getColumn(7).setPreferredWidth(150);
		productTable.getColumnModel().getColumn(8).setPreferredWidth(100);
		
		// Adding the buttonListener
		buttonListener = new IMSGUIListener(productTable, this, guiStockViewer);

		// Adding the scrollPane for the productTable
		scrollPane = new JScrollPane(productTable);

		// Adding buttons
		addButton = new JButton("Add");
		addButton.addActionListener(buttonListener);
		editButton = new JButton("Edit");
		editButton.addActionListener(buttonListener);
		generateReportButton = new JButton("Generate Report");
		generateReportButton.addActionListener(buttonListener);
		showGraphButton = new JButton("Show graph");
		showGraphButton.addActionListener(buttonListener);
		refreshButton = new JButton("Refresh table");
		refreshButton.addActionListener(buttonListener);
		generateStockOrderButton = new JButton("Generate stock order");
		generateStockOrderButton.addActionListener(buttonListener);
		controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());

		// Adding components to the mainBox, scrollPane for the JTable.
		mainBox.add(scrollPane);
		mainBox.add(frameLabel);
		mainBox.add(controlPanel);
		mainBox.add(guiStockViewer);
		controlPanel.add(addButton);
		controlPanel.add(editButton);
		controlPanel.add(generateReportButton);
		controlPanel.add(refreshButton);
		controlPanel.add(generateStockOrderButton);
		controlPanel.add(showGraphButton);
		controlPanel.setSize(600, 100);
		mainBox.setVisible(true);

	}

	JFrame getMainBox() {

		return mainBox;

	}

	public IMSGUI getGUI() {
		return this;
	}

	public IMSGUI() {
		prepareGUI();
	}

	// Main method to call the arrayList and other components.
	public static void main(String args[]) {
		DatabaseConnection.connectToDatabase();
		IMSGUI sD = new IMSGUI(Product.allProducts);
	}

	// Calls the table and refreshes the list
	public void updateTable() {

		productTableModel.setRowCount(0);
		// loops through all the rows in the table to refresh them
		for (Product p : productList) {

			productTableModel.addRow(new Object[] { p.getProductID(),
					p.getProductName(), p.getProductType(), p.getDateAdded(),
					p.getDateLastUpdated(), p.getCost(), p.getStockLevel(),
					p.getCriticalStockLevel(), p.getSupplier() });

		}

	}

	public static void belowThresholdAlert(Product p) {

		if (p.getStockLevel() < p.getCriticalStockLevel()) {

			JOptionPane
					.showMessageDialog(

							null,
							"ProductID: "
									+ p.getProductID()
									+ ", "
									+ p.getProductName()
									+ "'s Stock: "
									+ p.getStockLevel()
									+ " is below the critical stock level!, please order new stock.");

		}
	}

	public static void stockIncreased(Product p) {
		
	}

}
