package view;

import javax.swing.table.AbstractTableModel;

import model.ProfesorBaza;

public class AbstractTableModelProfesor extends AbstractTableModel {

	private static final long serialVersionUID = -1406696593944639363L;

	@Override
	public int getColumnCount() {
		return ProfesorBaza.getInstance().getColumnCount();
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
	public String getColumnName(int index) {
		return ProfesorBaza.getInstance().getColumnName(index);
	}
}
