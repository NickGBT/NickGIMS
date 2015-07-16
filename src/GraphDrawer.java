import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
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
public class GraphDrawer extends JPanel {

	private  int maxProduct = 450;
	private  final int prefW = 475;
	private  final int prefH = 500;
    private int labelPadding = 25;
	private  final int borderGap = 30;
	private  final Color graphColour = Color.red;
	private  final Color graphPointColour = new Color(150, 50, 50, 180);
	private  final Stroke graphStroke = new BasicStroke(3f);
	private Color gridColor = new Color(200, 200, 200, 200);
	private final int graphPointWidth = 6;
	private int yHatchCount = 14;
	private static int numberOfDays = 7;
	private List<Integer> stockLevels;
	public void SetOldStockLevels(Product p, List<Integer> stockLevels) 
	{
		this.stockLevels = stockLevels;
		maxProduct = (int)((float)stockLevels.get(0) * 1.1);
	}

	@Override
	protected void paintComponent(Graphics g) {
		if (stockLevels == null)
			return;
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
 
        double xScale = ((double) getWidth() - (2 * borderGap) - labelPadding) / (stockLevels.size() - 1);
        double yScale = ((double) getHeight() - 2 * borderGap - labelPadding) / (getMaxStockLevel() - getMinStockLevel());
 
        List<Point> graphPoints = new ArrayList<>();
        for (int i = 0; i < stockLevels.size(); i++) {
            int x1 = (int) (i * xScale + borderGap + labelPadding);
            int y1 = (int) ((getMaxStockLevel() - stockLevels.get(i)) * yScale + borderGap);
            graphPoints.add(new Point(x1, y1));
        }
 
        // draw white background
        g2.setColor(Color.WHITE);
        g2.fillRect(borderGap + labelPadding, borderGap, getWidth() - (2 * borderGap) - labelPadding, getHeight() - 2 * borderGap - labelPadding);
        g2.setColor(Color.BLACK);
 
        // create hatch marks and grid lines for y axis.
        for (int i = 0; i < yHatchCount + 1; i++) {
            int x0 = borderGap + labelPadding;
            int x1 = graphPointWidth + borderGap + labelPadding;
            int y0 = getHeight() - ((i * (getHeight() - borderGap * 2 - labelPadding)) / yHatchCount + borderGap + labelPadding);
            int y1 = y0;
            if (stockLevels.size() > 0) {
                g2.setColor(gridColor);
                g2.drawLine(borderGap + labelPadding + 1 + graphPointWidth, y0, getWidth() - borderGap, y1);
                g2.setColor(Color.BLACK);
                String yLabel = ((int) ((getMinStockLevel() + (getMaxStockLevel() - getMinStockLevel()) * ((i * 1.0) / yHatchCount)) * 100)) / 100.0 + "";
                FontMetrics metrics = g2.getFontMetrics();
                int labelWidth = metrics.stringWidth(yLabel);
                g2.drawString(yLabel, x0 - labelWidth - 5, y0 + (metrics.getHeight() / 2) - 3);
            }
            g2.drawLine(x0, y0, x1, y1);
        }
 
        // and for x axis
        for (int i = 0; i < stockLevels.size(); i++) {
            if (stockLevels.size() > 1) {
                int x0 = i * (getWidth() - borderGap * 2 - labelPadding) / (stockLevels.size() - 1) + borderGap + labelPadding;
                int x1 = x0;
                int y0 = getHeight() - borderGap - labelPadding;
                int y1 = y0 - graphPointWidth;
                if ((i % ((int) ((stockLevels.size() / 20.0)) + 1)) == 0) {
                    g2.setColor(gridColor);
                    g2.drawLine(x0, getHeight() - borderGap - labelPadding - 1 - graphPointWidth, x1, borderGap);
                    g2.setColor(Color.BLACK);
                    String xLabel = i + "";
                    FontMetrics metrics = g2.getFontMetrics();
                    int labelWidth = metrics.stringWidth(xLabel);
                    g2.drawString(xLabel, x0 - labelWidth / 2, y0 + metrics.getHeight() + 3);
                }
                g2.drawLine(x0, y0, x1, y1);
            }
        }
 
        // create x and y axes 
        g2.drawLine(borderGap + labelPadding, getHeight() - borderGap - labelPadding, borderGap + labelPadding, borderGap);
        g2.drawLine(borderGap + labelPadding, getHeight() - borderGap - labelPadding, getWidth() - borderGap, getHeight() - borderGap - labelPadding);
 
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
            int ovalW = graphPointWidth;
            int ovalH = graphPointWidth;
            g2.fillOval(x, y, ovalW, ovalH);
        }
    }

	public Dimension getPreferredSize() {
		return new Dimension(prefW, prefH);
	}
	
    private double getMinStockLevel() {
        double minStock = Double.MAX_VALUE;
        for (Integer stockLevel : stockLevels) {
            minStock = Math.min(minStock, stockLevel);
        }
        return minStock;
    }

    private double getMaxStockLevel() {
        double maxStock = Double.MIN_VALUE;
        for (Integer stockLevel : stockLevels) {
            maxStock = Math.max(maxStock, stockLevel);
        }
        return maxStock;
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
		GraphDrawer mainPanel = new GraphDrawer();
		mainPanel.SetOldStockLevels(p, stockLevels);
		JFrame frame = new JFrame("DrawGraph");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(mainPanel);
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}

}
