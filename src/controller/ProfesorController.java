package controller;

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
}
