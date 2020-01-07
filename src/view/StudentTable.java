package view;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import model.Student;
import model.StudentBaza;

public class StudentTable extends JTable{

	private static final long serialVersionUID = 1029156741381290239L;

	public StudentTable(ArrayList<Student> studenti) {
		StudentBaza bazaStudent = new StudentBaza();
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(bazaStudent);
	}
}
