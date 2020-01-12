package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.RowFilter;

import model.PredmetBaza;
import model.Profesor;
import model.ProfesorBaza;
import view.MainFrame;

public class ProfesorController {

private static ProfesorController instance = null;
	
	public static ProfesorController getInstance() {
		if (instance == null) {
			instance = new ProfesorController();
		}
		return instance;
	}
	
	private ProfesorController() {}
	
	public void addProfesor() {
		
	}
	
	public void editProfesor() {
		
	}
	
	public void deleteProfesor(int row) {
		if(row < 0)
			return;
		
		Profesor profesor = ProfesorBaza.getInstance().getRow(row);
		ProfesorBaza.getInstance().deleteProfesor(profesor.getBrojLicneKarte());
		MainFrame.getInstance().updateView();	
	}
	
	public void saveData() {
		ProfesorBaza.getInstance().saveProfesorBazaData();
	}
	
	public void filterProfesor(String searchResult) {
		String[] criteria = searchResult.split(";");	
		List<RowFilter<Object, Object>> filters = new ArrayList<RowFilter<Object, Object>>();
		
		for (String c : criteria) {
			String[] s = c.split(":", 2);
			
			int i = 0;
			for (String column : ProfesorBaza.getInstance().getColumns()) {
				if (s[0].equalsIgnoreCase(column)) {
					if (s.length == 2)
						filters.add(RowFilter.regexFilter(s[1], i));
				}
				i++;
			}
		}
		
		RowFilter<Object, Object> profesorFilter = RowFilter.andFilter(filters);
		MainFrame.getInstance().setProfesorSorter(profesorFilter);
	}
}
