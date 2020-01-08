package controller;

import model.PredmetBaza;

public class PredmetController {

private static PredmetController instance = null;
	
	public static PredmetController getInstance() {
		if (instance == null) {
			instance = new PredmetController();
		}
		return instance;
	}
	
	private PredmetController() {}
	
	public void addPredmet() {
		
	}
	
	public void editPredmet() {
		
	}
	
	public void deletePredmet() {
		
	}
	
	public void saveData() {
		PredmetBaza.getInstance().savePredmetaBazaData();
	}
	
}
