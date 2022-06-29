package views;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class TableOperatorInformation extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String[] COLUMNS = {"ID_USUARIO","Numero de celular", "Valor de la recarga"};

	private TablePanel aspirants;

	public TableOperatorInformation(Object [][] dataOperator) {
		setBackground(Color.WHITE);
		aspirants = new TablePanel(dataOperator, COLUMNS);
		aspirants.setPreferredSize(new Dimension(800,700));
		add(aspirants);
	}
	
	public void setDataOperator(Object [][] dataOperator) {
		aspirants.setData(dataOperator, COLUMNS);
		revalidate();
		repaint();
	}
}
