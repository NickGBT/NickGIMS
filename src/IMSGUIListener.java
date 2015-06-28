import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTable;

class IMSGUIListener implements ActionListener{
	private JTable productTable;
	private IMSGUI referencedGUI;
	public IMSGUIListener(JTable productTable, IMSGUI referencedGUI){
		this.productTable = productTable;
		this.referencedGUI = referencedGUI;
	}
	@Override
	public void actionPerformed (ActionEvent ae){
				
		String command = ae.getActionCommand();
		
		switch (command) {
		
		case "Add": ;
				
		ProductModifierGUI modifier = new ProductModifierGUI();
		
		modifier.setVisible(true);
		
		
		Product.allProducts.add(modifier.getProduct());
		
		break;
		
		case "Edit": ;
		
		ProductModifierGUI editor = new ProductModifierGUI(Product.allProducts.get(productTable.getSelectedRow()));
				
		editor.setVisible(true);
		
		Product.allProducts.set(productTable.getSelectedRow(), editor.getProduct());
		
		break;
		
		case "Generate Report": productTable.getSelectedRow();
		
		StockReport.generateReport();
		
		break;
		}
		//calls the referenced GUI and updates the table once the modifier gui is closed.
		referencedGUI.updateTable();
	}
}
