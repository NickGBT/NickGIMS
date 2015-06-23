import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;


class IMSGUIListener implements ActionListener{
	@Override
	public void actionPerformed (ActionEvent ae){
		JLabel statusLabel = new JLabel();
		String command = ae.getActionCommand();
		switch (command) {
		case "OK": statusLabel.setText("OK!");
		break;
		}
	}
}
