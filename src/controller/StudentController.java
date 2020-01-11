package controller;

import javax.swing.JOptionPane;

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
		if(!StudentBaza.getInstance().addStudent(s)) {
			String message = String.format("Student %s vec postoji!", s.getIndex());
			JOptionPane.showMessageDialog(MainFrame.getInstance(), message);
		}
		MainFrame.getInstance().updateView();
	}
	
	public void editStudent(Student s) {
		StudentBaza.getInstance().editStudent(s);
		MainFrame.getInstance().updateView();
	}

	public void deleteStudent() {
	
	}
	
	public void saveData() {
		StudentBaza.getInstance().saveStudentDataBase();
	}
}
