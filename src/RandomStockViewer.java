import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.*;

@SuppressWarnings("serial")
public class RandomStockViewer extends JPanel {

	private  final int maxProduct = 200;
	private  final int prefW = 800;
	private  final int prefH = 650;
	private  final int borderGap = 30;
	private  final Color graphColour = Color.red;
	private  final Color graphPointColour = new Color(150, 50, 50, 180);
	private  final Stroke graphStroke = new BasicStroke(3f);
	private final int graphPointWidth = 6;
	private final int yHatchCount = 10;
	private static int numberOfDays = 7;
	private List<Integer> stockLevels;
	private Product product;
	
	public void SetOldStockLevels(Product p, List<Integer> stockLevels) 
	{
		product = p;
		this.stockLevels = stockLevels;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (product == null){
			return;
		}				
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		double xScale = ((double) getWidth() - 2 * borderGap)
				/ (stockLevels.size() - 1);
		double yScale = ((double) getHeight() - 2 * borderGap)
				/ (maxProduct - 1);

		List<Point> graphPoints = new ArrayList<Point>();
		for (int i = 0; i < stockLevels.size(); i++) {
			int x1 = (int) (i * xScale + borderGap);
			int y1 = (int) ((maxProduct - stockLevels.get(i)) * yScale + borderGap);
			graphPoints.add(new Point(x1, y1));
		}

		// create x and y axes
		g2.drawLine(borderGap, getHeight() - borderGap, borderGap, borderGap);
		g2.drawLine(borderGap, getHeight() - borderGap, getWidth() - borderGap,
				getHeight() - borderGap);

		// create hatch marks for y axis.
		for (int i = 0; i < yHatchCount; i++) {
			int x0 = borderGap;
			int x1 = graphPointWidth + borderGap;
			int y0 = getHeight()
					- (((i + 1) * (getHeight() - borderGap * 2)) / yHatchCount + borderGap);
			int y1 = y0;
			g2.drawLine(x0, y0, x1, y1);
		}

		// and for x axis
		for (int i = 0; i < stockLevels.size() - 1; i++) {
			int x0 = (i + 1) * (getWidth() - borderGap * 2)
					/ (stockLevels.size() - 1) + borderGap;
			int x1 = x0;
			int y0 = getHeight() - borderGap;
			int y1 = y0 - graphPointWidth;
			g2.drawLine(x0, y0, x1, y1);
		}

		Stroke oldStroke = g2.getStroke();
		g2.setColor(graphColour);
		g2.setStroke(graphStroke);
		for (int i = 0; i < graphPoints.size() - 1; i++) {
			int x1 = graphPoints.get(i).x;
			int y1 = graphPoints.get(i).y;
			int x2 = graphPoints.get(i + 1).x;
			int y2 = graphPoints.get(i + 1).y;
			g2.drawLine(x1, y1, x2, y2);
		}

		g2.setStroke(oldStroke);
		g2.setColor(graphPointColour);
		for (int i = 0; i < graphPoints.size(); i++) {
			int x = graphPoints.get(i).x - graphPointWidth / 2;
			int y = graphPoints.get(i).y - graphPointWidth / 2;
			;
			int ovalW = graphPointWidth;
			int ovalH = graphPointWidth;
			g2.fillOval(x, y, ovalW, ovalH);
		}
	}

	public Dimension getPreferredSize() {
		return new Dimension(prefW, prefH);
	}

	protected static void showGraph() {
		List<Integer> stockLevels = new ArrayList<Integer>();
		Random r = new Random();
		Product p = new Product();
		p.setStockLevel(50);
		stockLevels.add(p.getStockLevel());
		for (int i = 0; i < numberOfDays; i++) {
			int lvl = Math.max(0, p.getStockLevel() - (int)(Math.random() * p.getStockLevel()));
			p.setStockLevel(lvl);
			stockLevels.add(lvl);
		}
		RandomStockViewer mainPanel = new RandomStockViewer();
		mainPanel.SetOldStockLevels(p, stockLevels);
		JFrame frame = new JFrame("DrawGraph");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(mainPanel);
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}
	
	public  void productStockDecrementer(Product p) {

		/*for (int i = 0; i < productList.size(); i++) {

			RandomStock randomStockNumber = null;

			p.stockLevel = p.stockLevel - randomStockNumber.stockLevelDecrement;

			productList.set(p.stockLevel, p);
		}*/

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				showGraph();
			}
		});
	}

}
