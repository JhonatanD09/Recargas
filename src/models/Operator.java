package models;

import java.util.ArrayList;

public class Operator {

	private String name;
	private ArrayList<Client> clients;
	
	public Operator(String name) {
		this.name = name;
		this.clients = new ArrayList<>();
	}
	
	public void add(Client client) {
		clients.add(client);
	}
	
	public double calculateValue() {
		double result = 0;
		for (Client client : clients) {
			result += client.getAmount();
		}
		return result;
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Client> getClients() {
		return clients;
	}
	
	
}
