package views;


import javax.swing.*;

import controllers.Events;

import java.awt.*;
import java.awt.event.ActionListener;

public class RechargePanel extends MyGridPanel {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//	String name, String id, Program program, double criticalReadingScore, double mathScore,
//	double socialStudiesScore, double naturalScienceScore, double englishScore
//	
	private JTextField idTxt;
	private JTextField phoneTxt;
	private JTextField valueTxt;
	private JButton addBtn;

	public RechargePanel(ActionListener listener) {
		setBackground(Color.decode("#FDFEFE"));
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
		setPreferredSize(new Dimension(400, 0));
		initComponents(listener);
	}

	private void initComponents(ActionListener listener) {
		initTitle();
		initProcessIdTxt();
		initProcessPhone();
		initProcessValue();
		initButtons(listener, Events.ACCEPT_ADD.name());
	}

	private void initTitle() {
		String title = "Recargar";
		JLabel titleLb = createLb(title, new Font("Arial", Font.BOLD, 20));
		addComponent(new JLabel(" "), 0, 0, 11, 0.1);
		addComponent(titleLb, 2, 1, 4, 0.2);
		addComponent(new JLabel(" "), 0, 3, 11, 0.1);
	}

	private void initProcessIdTxt() {
		JLabel id = createLb(" Id Cliente: ", new Font("Arial", Font.BOLD, 14));
		addComponent(id, 2, 5, 2, 0.1);
		idTxt = new JTextField();
		idTxt.setFont(new Font("Arial", Font.PLAIN, 13));
		idTxt.setText("");
		addComponent(idTxt, 4, 5, 6, 0.1);
		addComponent(new JLabel(" "), 0, 6, 11, 0.1);
	}

	private void initProcessPhone() {
		JLabel timeLb = createLb(" Numero Telefonico: ", new Font("Arial", Font.BOLD, 14));
		addComponent(timeLb, 2, 7, 2, 0.1);
		phoneTxt = new JTextField();
		phoneTxt.setFont(new Font("Arial", Font.PLAIN, 13));
		phoneTxt.setText("");
		addComponent(phoneTxt, 4, 7, 6, 0.1);
		addComponent(new JLabel(" "), 0, 8, 11, 0.1);
	}

	private void initProcessValue() {
		JLabel timeLb = createLb(" Valor de la recarga: ", new Font("Arial", Font.BOLD, 14));
		addComponent(timeLb, 2, 9, 2, 0.1);
		valueTxt = new JTextField();
		valueTxt.setFont(new Font("Arial", Font.PLAIN, 13));
		valueTxt.setText("");
		addComponent(valueTxt, 4, 9, 6, 0.1);
		addComponent(new JLabel(" "), 0, 10, 11, 0.1);
	}


	private void initButtons(ActionListener listener, String acceptEvent) {
		String addBtnTxt = "Agregar";
		addBtn = createBtn(addBtnTxt, Color.decode("#27AE60"), listener, acceptEvent);
		addComponent(addBtn, 3, 21, 2, 0.12);
	}

	private JLabel createLb(String txt, Font font) {
		JLabel lb = new JLabel(txt);
		lb.setFont(font);
		return lb;
	}

	private JButton createBtn(String txt, Color color, ActionListener listener, String command) {
		JButton btn = new JButton(txt);
		btn.addActionListener(listener);
		btn.setActionCommand(command);
		return btn;
	}

	public void resetData() {
		idTxt.setText("");
		phoneTxt.setText("");
		valueTxt.setText("");
	}
	
	public String[] data() {
		return new String[] { idTxt.getText(), phoneTxt.getText(), valueTxt.getText() };
	}

}
