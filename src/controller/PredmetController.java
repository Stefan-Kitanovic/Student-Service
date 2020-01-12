package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.RowFilter;

import com.sun.javafx.collections.MappingChange.Map;

import model.Godina;
import model.Predmet;
import model.PredmetBaza;
import model.Profesor;
import model.ProfesorBaza;
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
	
	public void editPredmet(int row, String sifraPredmeta, String nazivPredmeta, Semestar semestar, Godina godinaStudija,
			Profesor predmetniProfesor) {
		PredmetBaza.getInstance().editPredmet(row, sifraPredmeta, nazivPredmeta, semestar, godinaStudija, predmetniProfesor);
		if(row < 0)
			return;
			
		MainFrame.getInstance().updateView();
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
	
	public void addProfesorToPredmet(String brojLicneKarte, int row) {
		Profesor profesor = ProfesorBaza.getInstance().getProfesorById(brojLicneKarte);
		PredmetBaza.getInstance().addProfesorToPredmet(profesor, row);
		MainFrame.getInstance().updateView();	
	}
	
	public void removeProfesorFromPredmet(int row) {
		PredmetBaza.getInstance().removeProfesorFromPredmet(row);
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
					filters.add(RowFilter.regexFilter(s[1], i));
				}
				i++;
			}
		}
		
		RowFilter<Object, Object> predmetFilter = RowFilter.andFilter(filters);
		MainFrame.getInstance().setPredmetSorter(predmetFilter);
	}
}
