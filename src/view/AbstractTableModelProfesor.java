package view;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import model.PredmetBaza;
import model.ProfesorBaza;

public class AbstractTableModelProfesor extends AbstractTableModel {

	private static final long serialVersionUID = -1406696593944639363L;

	@Override
	public int getColumnCount() {
		return ProfesorBaza.getInstance().getColumnCount() + 1;
	}

	@Override
	public int getRowCount() {
		return ProfesorBaza.getInstance().getProfesori().size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		return ProfesorBaza.getInstance().getValueAt(row, column);
	}

	@Override
	public String getColumnName(int column) {
		if (column >= ProfesorBaza.getInstance().getColumnCount())
			return "Predmeti";
		return ProfesorBaza.getInstance().getColumnName(column);
	}

	@Override
	public Class<?> getColumnClass(int column) {
		switch(column) {
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5: 
			case 6:
			case 7:
			case 8:
			case 9:
				return String.class;
			case 10:
				return JButton.class;
			default: 
				return null;
		}
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		return column == 10;
	}
	
	
}
