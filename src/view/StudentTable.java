package view;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;


public class StudentTable extends JTable{

	private static final long serialVersionUID = 1029156741381290239L;

	public StudentTable() {
		AbstractTableModelStudent bazaStudent = new AbstractTableModelStudent();
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(bazaStudent);
	}
}
