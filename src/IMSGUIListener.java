import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JTable;

class IMSGUIListener implements ActionListener {
	private JTable productTable;
	private IMSGUI referencedGUI;
	RandomStockViewer graph;

	public IMSGUIListener(JTable productTable, IMSGUI referencedGUI,
			RandomStockViewer graph) {

		this.productTable = productTable;

		this.referencedGUI = referencedGUI;

		this.graph = graph;

	}

	@Override
	public void actionPerformed(ActionEvent ae) {

		String command = ae.getActionCommand();

		switch (command) {

		case "Add":
			;

			ProductModifierGUI modifier = new ProductModifierGUI();

			modifier.setVisible(true);

			Product.allProducts.add(modifier.getProduct());

			DatabaseConnection.insertDatabase(modifier.getProduct());
			
			break;

		case "Edit":
			;

			ProductModifierGUI editor = new ProductModifierGUI(
					Product.allProducts.get(productTable.getSelectedRow()));

			editor.setVisible(true);

			DatabaseConnection.updateDatabase(editor.getProduct());

			Product.allProducts.set(productTable.getSelectedRow(),
					editor.getProduct());

			break;

		case "Generate Report":
			productTable.getSelectedRow();

			StockReport.generateReport();

			break;

		case "Show graph":
			List<Integer> stockLevels = new ArrayList<Integer>();
			int x = productTable.getSelectedRow();
			Random r = new Random();
			Product p = new Product();
			p.setStockLevel(Product.allProducts.get(productTable
					.getSelectedRow()).stockLevel);
			
			stockLevels.add(p.getStockLevel());
			
			for (int i = 0; i < 14; i++) {
				int lvl = Math.max(0, p.getStockLevel()
						- (int) (Math.random() * 10));
				p.setStockLevel(lvl);
				stockLevels.add(lvl);
			}
			graph.SetOldStockLevels(p, stockLevels);
			graph.repaint();
			break;

		case "Refresh table":
			;

			DatabaseConnection.updateIMSGUI();

			break;

		case "Generate stock order":
			;

			productTable.getSelectedRow();

			StockOrder.generateStockOrder();

			break;
		}

		// calls the referenced GUI and updates the table once the modifier gui
		// is closed.
		referencedGUI.updateTable();
	}
}
