import javax.swing.*;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//GUI for the IMS, using swing and JFrames/JPanels to create the interface.
public class IMSGUI extends JFrame {
	//add components to gui
	private JFrame mainBox;
	private JLabel frameLabel;
	public JLabel statusLabel;
	private JPanel controlPanel;
	private JButton okButton;
	private void prepareGUI() {
		mainBox= new JFrame("Inventory Management System");
		mainBox.setSize(500, 500);
		mainBox.setLayout(new GridLayout(3,3)); //layout setter
		frameLabel = new JLabel("",JLabel.CENTER);
		statusLabel = new JLabel("",JLabel.CENTER);
		statusLabel.setSize(200,50);
		okButton = new JButton("OK");
		controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());
		mainBox.add(frameLabel);
		mainBox.add(statusLabel);
		mainBox.add(controlPanel);
		controlPanel.add(okButton);
		controlPanel.setSize(450,450);
		mainBox.setVisible(true);
		mainBox.addWindowListener(new WindowAdapter() {
			private void showEvent() {
			frameLabel.setText("Clicky, Clicky");
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				okButton.addActionListener(new IMSGUIListener());
				controlPanel.add(okButton); 
			}
			public void windowClose(WindowEvent windowEvent){
				System.exit(0);
			}
		});

		//adds labels & panels to the JFrame
	}
	public IMSGUI(){prepareGUI();}
	
	private void showEvent() {
		frameLabel.setText("IMS window view");
		frameLabel.setText("Clicky, Clicky");
		JButton okButton2 = new JButton("OK2");
		okButton.setActionCommand("OK");
		okButton.addActionListener(new IMSGUIListener());
		controlPanel.add(okButton2);
	}
	
	public static void main (String args[]){
		IMSGUI sD = new IMSGUI();
		sD.showEvent();
	}
	
}
