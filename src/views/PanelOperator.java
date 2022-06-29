package views;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelOperator extends JPanel{

	private static final long serialVersionUID = 1L;

	private TableOperatorInformation operatorInformation;
	private RechargePanel rechargePanel;

	private JLabel total;
	
	public PanelOperator(ActionListener l, Object [][] data,String title, double totalRecargas) {
		setLayout(new BorderLayout());
		operatorInformation = new TableOperatorInformation(data);
		rechargePanel = new RechargePanel(l);
		JLabel name = createLb(title, new Font("Arial", Font.BOLD, 30));
		add(name, BorderLayout.NORTH);
		add(operatorInformation, BorderLayout.CENTER);
		add(rechargePanel, BorderLayout.EAST);
		total = createLb("Total recargas :" + totalRecargas, new Font("Arial", Font.BOLD, 30));
		add(total, BorderLayout.SOUTH);
	}
	
	public String[] data(){
		return rechargePanel.data();
	}
	
	public void resetData() {
		rechargePanel.resetData();
	}
	
	public void update(Object [][] dataOperator, double value) {
		operatorInformation.setDataOperator(dataOperator);
		total.setText("Total Recargas : " + value);
		revalidate(); repaint();
	}
	
	private JLabel createLb(String txt, Font font) {
		JLabel lb = new JLabel(txt);
		lb.setFont(font);
		return lb;
	}
	
}
