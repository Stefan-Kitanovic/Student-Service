package controller;

import java.util.List;

import model.Godina;
import model.Predmet;
import model.PredmetBaza;
import model.Profesor;
import model.Semestar;
import model.Student;
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
	
	public void addPredmet(String sifraPredmeta, String nazivPredmeta, Semestar semestar, Godina godinaStudija,
			Profesor predmetniProfesor, List<Student> spisakStudenata) {
		PredmetBaza.getInstance().addPredmet(sifraPredmeta, nazivPredmeta, semestar, godinaStudija, predmetniProfesor, spisakStudenata);
		MainFrame.getInstance().updateView();
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
