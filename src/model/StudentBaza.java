package model;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.table.AbstractTableModel;

public class StudentBaza extends AbstractTableModel {

	private static final long serialVersionUID = 3646946754707848800L;
	
	private static String[] columnName = {"Index", "Ime", "Prezime", "Datum rodjenja", "Adresa", "Telefon", "E-mail", "Datum upisa", "Godina studija", "Status", "Prosek",};
	private static Class<?>[] columnType= {String.class, String.class, String.class, Date.class, String.class, String.class, String.class, Date.class, String.class, Status.class, Long.class};
	private ArrayList<Student> studenti = new ArrayList<Student>();
	
	@Override
	public int getRowCount() {
		return studenti.size();
	}

	@Override
	public int getColumnCount() {
		return columnName.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Student student = studenti.get(rowIndex);
		
		switch(columnIndex) {
		case 0:
			return student.getIndex();
		case 1:
			return student.getIme();
		case 2:
			return student.getPrezime();
		case 3:
			return student.getDatumr();
		case 4:
			return student.getAdresa();
		case 5:
			return student.getTel();
		case 6:
			return student.getEmail();
		case 7:
			return student.getDatumu();
		case 8:
			return student.getGodina();
		case 9:
			return student.getStatus();
		case 10:
			return student.getProsek();
		case 11:
			return "Prikazi predmete";
		}
		return null;
	}
	
	@Override
	public String getColumnName(int column) {
		return columnName[column];
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return columnType[columnIndex];
	}
	
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		super.setValueAt(aValue, rowIndex, columnIndex);
	}

}
