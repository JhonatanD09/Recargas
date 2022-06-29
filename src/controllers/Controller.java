package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Manager;
import models.Operator;
import views.FrameWindows;

public class Controller implements ActionListener {

	private Manager manager;
	private FrameWindows frameWindows;

	public Controller() {
		manager = new Manager();
		frameWindows = new FrameWindows(this);
		frameWindows.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Events.valueOf(e.getActionCommand())) {
		case CLARO:
			Operator claro = manager.getClaroOperator();
			frameWindows.changeOperator(manager.operatorInfo(claro.getClients()),claro.getName(), claro.calculateValue());
			break;
		case ETB:
			Operator etb = manager.getETBOperator();
			frameWindows.changeOperator(manager.operatorInfo(etb.getClients()),etb.getName(), etb.calculateValue());
			break;
		case MOVISTAR:
			Operator movistar = manager.getMovistarOperator();
			frameWindows.changeOperator(manager.operatorInfo(movistar.getClients()),movistar.getName(), movistar.calculateValue());
			break;
		case TIGO:
			Operator tigo = manager.getTigoOperator();
			frameWindows.changeOperator(manager.operatorInfo(tigo.getClients()),tigo.getName(), tigo.calculateValue());
			break;
		case ACCEPT_ADD:
			String name = frameWindows.getOperatorName();
			manager.addRecharge(frameWindows.data(), name);
			Operator operator = manager.getActualOperator(name);
			frameWindows.resetData();
			frameWindows.updateTable(manager.operatorInfo(operator.getClients()), operator.calculateValue());
			manager.writeData();
			break;
		}
	}

	public static void main(String[] args) {
		new Controller();
	}

}
