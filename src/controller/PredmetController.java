package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.RowFilter;


import model.Godina;
import model.Predmet;
import model.PredmetBaza;
import model.Profesor;
import model.ProfesorBaza;
import model.Semestar;
import model.Student;
import model.StudentBaza;
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
		
		if (predmetniProfesor != null) {
			ProfesorBaza.getInstance().assignPredmetToProfesor(new Predmet(sifraPredmeta, nazivPredmeta, semestar, godinaStudija, predmetniProfesor, spisakStudenata), predmetniProfesor);
		}
		
		MainFrame.getInstance().updateView();
	}
	
	public void editPredmet(int row, String sifraPredmeta, String nazivPredmeta, Semestar semestar, Godina godinaStudija,
			Profesor predmetniProfesor) {
		if(row < 0)
			return;
		
		if (predmetniProfesor != null) {
			Profesor currentProfesor = PredmetBaza.getInstance().getRow(MainFrame.getInstance().getSelectedPredmetRow()).getPredmetniProfesor();
			ProfesorBaza.getInstance().removePredmetFromProfesor(PredmetBaza.getInstance().getRow(row), currentProfesor);
			ProfesorBaza.getInstance().assignPredmetToProfesor(PredmetBaza.getInstance().getRow(row), predmetniProfesor);			
		}
		
		PredmetBaza.getInstance().editPredmet(row, sifraPredmeta, nazivPredmeta, semestar, godinaStudija, predmetniProfesor);
		MainFrame.getInstance().updateView();
	}
	
	public void deletePredmet(int row) {
		if(row < 0)
			return;
		
		Predmet predmet = PredmetBaza.getInstance().getRow(row);
		ProfesorBaza.getInstance().removePredmetFromProfesor(predmet, predmet.getPredmetniProfesor());
		PredmetBaza.getInstance().deletePredmet(predmet.getSifraPredmeta());
		MainFrame.getInstance().updateView();	
	}
	
	public void saveData() {
		PredmetBaza.getInstance().savePredmetaBazaData();
	}
	
	public void addProfesorToPredmet(String brojLicneKarte, int row) {
		Profesor profesor = ProfesorBaza.getInstance().getProfesorById(brojLicneKarte);
		ProfesorBaza.getInstance().assignPredmetToProfesor(PredmetBaza.getInstance().getRow(row), profesor);
		PredmetBaza.getInstance().addProfesorToPredmet(profesor, row);
		MainFrame.getInstance().updateView();	
	}
	
	public void removeProfesorFromPredmet(int predmetRow) {
		Predmet predmet = PredmetBaza.getInstance().getRow(predmetRow);
		ProfesorBaza.getInstance().removePredmetFromProfesor(predmet, predmet.getPredmetniProfesor());
		PredmetBaza.getInstance().removeProfesorFromPredmet(predmetRow);
		MainFrame.getInstance().updateView();	
	}
	
	public void filterPredmet(String searchResult) {
		String[] criteria = searchResult.split(";");	
		List<RowFilter<Object, Object>> filters = new ArrayList<RowFilter<Object, Object>>();
		
		for (String c : criteria) {
			String[] s = c.split(":", 2);
			
			int i = 0;
			for (String column : PredmetBaza.getInstance().getColumns()) {
				if (s[0].equalsIgnoreCase(column)) {
					if (s.length == 2)
						filters.add(RowFilter.regexFilter("^" + s[1] + "$", i));
				}
				i++;
			}
		}
		
		RowFilter<Object, Object> predmetFilter = RowFilter.andFilter(filters);
		MainFrame.getInstance().setPredmetSorter(predmetFilter);
	}
	
	public void removeStudentfromPredmet(String sIndex, int predRow) {
		Student s = StudentBaza.getInstance().getById(sIndex);
		Predmet p = PredmetBaza.getInstance().getPredmeti().get(predRow);
		StudentBaza.getInstance().removePredmetFromStudent(s, p);
		PredmetBaza.getInstance().removeStudentFromPredmet(s, p);
		MainFrame.getInstance().updateView();
	}
}
