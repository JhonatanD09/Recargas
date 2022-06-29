package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


import controllers.Events;

public class FrameWindows extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private ActionListener listener;
	private JPanel auxPanel;
	private PanelOperator operator;
	private String  operatorName;
	
	public FrameWindows(ActionListener l) {
		this.listener = l;
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		add(options(), BorderLayout.WEST);
		auxPanel = new JPanel();
		auxPanel.setBackground(Color.WHITE);
		add(auxPanel, BorderLayout.CENTER);
	}
	
	public void changeOperator(Object[][] data, String title, double totalValue) {
		auxPanel.removeAll();
		operator = new PanelOperator(listener, data, title, totalValue);
		operatorName = title;
		auxPanel.add(operator);
		revalidate();
		repaint();
	}
	
	private JPanel options() {
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new GridLayout(4, 1,10,70));
		jPanel.setBackground(Color.WHITE);
		jPanel.add(editButton("/img/claro.png", Events.CLARO.name()));
		jPanel.add(editButton("/img/movistar.png", Events.MOVISTAR.name()));
		jPanel.add(editButton("/img/tigo.png", Events.TIGO.name()));
		jPanel.add(editButton("/img/etb.png", Events.ETB.name()));
		return jPanel;
	}
	
	private JButton editButton(String urlImg, String actionCommand ) {
		JButton button = new JButton();
		button.setIcon(new ImageIcon(getClass().getResource(urlImg)));
		button.setActionCommand(actionCommand);
		button.addActionListener(listener);
		button.setBorderPainted(false);
		button.setBorder(BorderFactory.createLineBorder(getForeground(), 1, true));
		button.setBackground(Color.WHITE);
		button.setPreferredSize(new Dimension(150,0));
		return button;
	}
	
	public void resetData() {
		operator.resetData();
	}
	
	public String[] data () {
		return operator.data();
	}
	
	public void updateTable(Object [][] dataOperator, double value) {
		operator.update(dataOperator , value);
	}

	public String getOperatorName() {
		return operatorName;
	}
}
