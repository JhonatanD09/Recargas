package models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class Manager {

	private ArrayList<Operator> operators;
	File operatorsFile = new File("operators.json");
	
	public Manager() {
		operators = new ArrayList<>(); 
		readData();
	}
	
	
	public Operator getMovistarOperator() {
		return operators.get(0);
	}
	public Operator getClaroOperator() {
		return operators.get(1);
	}
	public Operator getTigoOperator() {
		return operators.get(2);
	}
	public Operator getETBOperator() {
		return operators.get(3);
	}
	
	public void addRecharge(String[] data, String operatorName) {
	
		for (Operator operator :operators) {
			if (operator.getName().equalsIgnoreCase(operatorName)) {
				operator.add(new Client(Long.parseLong(data[0]), Long.parseLong(data[1]),
						Double.parseDouble(data[2])));
			}
		}
	}
	
	public Operator getActualOperator(String name) {
		for (Operator operator :operators) {
			if (operator.getName().equalsIgnoreCase(name)) {
				return operator;
			}
		}
		return null;
	}
	
	public ArrayList<Operator> getOperators() {
		return operators;
	}
	
	public Object[][] operatorInfo(ArrayList<Client> clients ) {
		Object[][] processInfo = new Object[clients.size()][3];
		for (int i = 0; i < clients.size(); i++) {
			processInfo[i][0] = clients.get(i).getId();
			processInfo[i][1] = clients.get(i).getPhoneNumber();
			processInfo[i][2] = clients.get(i).getAmount();
		}
		return processInfo;
	}
	
	
	public void writeData() {
		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
		String jsonProgramList = prettyGson.toJson(operators);
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(operatorsFile))) {
		    bw.write(jsonProgramList);
		    System.out.println("Fichero creado");
		} catch (IOException ex) {
		    ex.getMessage();
		}
	}
	
	public void readData() {
		String stringProgramList = "";
		try (BufferedReader br = new BufferedReader(new FileReader(operatorsFile))) {
		    String linea;
		    while ((linea = br.readLine()) != null) {
		        stringProgramList += linea;
		    }
		} catch (FileNotFoundException ex) {
		    System.out.println(ex.getMessage());
		} catch (IOException ex) {
		    System.out.println(ex.getMessage());
		}
		
		Gson gson = new Gson();
		Type operatorsList = new TypeToken<ArrayList<Operator>>(){}.getType();	
		operators = gson.fromJson(stringProgramList, operatorsList);
	}
	
}
