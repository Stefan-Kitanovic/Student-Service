package main;

import controller.PredmetController;
import controller.ProfesorController;
import model.PredmetBaza;
import model.ProfesorBaza;
import model.StudentBaza;
import view.MainFrame;

public class MainApp {

	public static void main(String[] args) {
		StudentBaza.getInstance();
		ProfesorBaza.getInstance();
		PredmetBaza.getInstance();
		
		ProfesorController.getInstance();
		PredmetController.getInstance();
		
		MainFrame.getInstance();		
	}

}
