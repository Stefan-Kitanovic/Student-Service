package controller;

import model.Predmet;
import model.PredmetBaza;
import view.MainFrame;

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
	
	public void deletePredmet(int row) {
		if(row < 0)
			return;
		
		Predmet predmet = PredmetBaza.getInstance().getRow(row);
		PredmetBaza.getInstance().deletePredmet(predmet.getSifraPredmeta());
		MainFrame.getInstance().updateView();	
	}
	
	public void saveData() {
		PredmetBaza.getInstance().savePredmetaBazaData();
	}
	
}
