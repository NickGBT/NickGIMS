import javax.swing.*;

import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//GUI for the IMS, using swing and JFrames/JPanels to create the interface.
public class IMSGUI extends JFrame {
	private JFrame mainBox;
	private JLabel frameLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;
	private void prepareGUI() {
		mainBox= new JFrame("Inventory Management System");
		mainBox.setSize(500, 500);
		mainBox.setLayout(new GridLayout(2,2));
		frameLabel = new JLabel("",JLabel.CENTER);
		statusLabel = new JLabel("",JLabel.CENTER);
		statusLabel.setSize(200,50);
		mainBox.addWindowListener(new WindowAdapter() {
			public void
			windowClose(WindowEvent windowEvent){
				System.exit(0);
			}
		});
		controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());
		mainBox.add(frameLabel);
		mainBox.add(statusLabel);
		mainBox.add(controlPanel);
		mainBox.setVisible(true);
		
	}
	public IMSGUI(){prepareGUI();}
	
	private void showEvent() {
		frameLabel.setText("IMS window view");
	}
	
	public static void main (String args[]){
		IMSGUI sD = new IMSGUI();
		sD.showEvent();
	}
	
}
