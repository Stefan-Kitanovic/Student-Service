package controller;

import model.StudentBaza;

public class StudentController {

	private static StudentController instance = null;
	
	public static StudentController getInstance() {
		if(instance == null)
			instance = new StudentController();
		return instance;
	}
	
	public StudentController() {}
	
	public void addStudent() {
		
	}
	
	public void editStudent() {
		
	}

	public void deleteStudent() {
	
	}
	
	public void saveData() {
		StudentBaza.getInstance().saveStudentDataBase();
	}
}
