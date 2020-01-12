package controller;

import model.Predmet;
import model.PredmetBaza;
import model.Student;
import model.StudentBaza;
import view.MainFrame;

public class StudentController {

	private static StudentController instance = null;
	
	public static StudentController getInstance() {
		if(instance == null)
			instance = new StudentController();
		return instance;
	}
	
	public StudentController() {}
	
	public void addStudent(Student s) {
		StudentBaza.getInstance().addStudent(s);
		MainFrame.getInstance().updateView();
	}
	
	public void editStudent(Student s) {
		StudentBaza.getInstance().editStudent(s);
		MainFrame.getInstance().updateView();
	}

	public void deleteStudent(int row) {
		Student s = StudentBaza.getInstance().getStudenti().get(row);
		StudentBaza.getInstance().deleteStudent(s.getIndex());
		MainFrame.getInstance().updateView();
	}
	
	public void saveData() {
		StudentBaza.getInstance().saveStudentDataBase();
	}
	
	public void addStudentToPredmet(String index, int row) {
		Student s = StudentBaza.getInstance().getById(index);
		Predmet p = PredmetBaza.getInstance().getPredmeti().get(row);
		StudentBaza.getInstance().assignPredmetToStudent(s, p);
		PredmetBaza.getInstance().assignStudentToPredmet(s, p);
		MainFrame.getInstance().updateView();
	}
}
