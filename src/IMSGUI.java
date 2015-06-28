import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;


//GUI for the IMS, using swing and JFrames/JPanels to create the interface.
public class IMSGUI{
	//add components to gui
	private JFrame mainBox;
	private JLabel frameLabel;
	public JLabel statusLabel;
	private JPanel controlPanel;
	private JButton addButton;
	private JButton editButton;
	private JButton generateReportButton;
	private ArrayList<Product> productList;
	private JScrollPane scrollPane;
	private JTable productTable;
	private DefaultTableModel productTableModel;
	private IMSGUIListener buttonListener;
	public IMSGUI (ArrayList<Product> productList){
		
		this.productList = productList;
		prepareGUI();
	}
	
	private void prepareGUI() {
		
		mainBox= new JFrame("Inventory Management System");
		mainBox.setSize(500, 500);
		mainBox.setLayout(new GridLayout(3,3)); //layout setter		
		//adding the components to the GUI
		frameLabel = new JLabel("",JLabel.CENTER);
		statusLabel = new JLabel("",JLabel.CENTER);
		statusLabel.setSize(200,50);
		//sets the table model for the JTable
		productTableModel = new DefaultTableModel();
		
		//adding columns for the JTable
		productTableModel.addColumn("ID"); 
		productTableModel.addColumn("Name"); 
		productTableModel.addColumn("Date Added"); 
		productTableModel.addColumn("Last Updated"); 
		productTableModel.addColumn("Cost"); 
		productTableModel.addColumn("Stock Level"); 
		productTableModel.addColumn("Critical Stock Level");
		productTableModel.addColumn("Supplier");
		productTable = new JTable(productTableModel);
		buttonListener = new IMSGUIListener(productTable, this);
		scrollPane = new JScrollPane(productTable);
		addButton = new JButton("Add");
		addButton.addActionListener(buttonListener);
		editButton = new JButton("Edit");
		editButton.addActionListener(buttonListener);
		generateReportButton = new JButton("Generate Report");
		generateReportButton.addActionListener(buttonListener);
		controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());
		mainBox.add(scrollPane);
		mainBox.add(frameLabel);
		mainBox.add(statusLabel);
		mainBox.add(controlPanel);
		controlPanel.add(addButton);
		controlPanel.add(editButton);
		controlPanel.add(generateReportButton);
		controlPanel.setSize(450,450);
		mainBox.setVisible(true);

	}
	
	public IMSGUI(){prepareGUI();}
	
	public static void main (String args[]){
		IMSGUI sD = new IMSGUI(Product.allProducts);
	}
	
	public void updateTable() {
		productTableModel.setRowCount(0);
		for (Product p : productList){
			
			productTableModel.addRow(new Object []{p.getProductID(), p.getProductName(),p.getDateAdded(),p.getDateLastUpdated(),p.getCost(),p.getStockLevel(),p.getCriticalStockLevel(),p.getSupplier()});
			
		}
	}
	
}
