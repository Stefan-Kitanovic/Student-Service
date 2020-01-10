package controller;

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

	}
	
	public void saveData() {
		ProfesorBaza.getInstance().saveProfesorBazaData();
	}
}
