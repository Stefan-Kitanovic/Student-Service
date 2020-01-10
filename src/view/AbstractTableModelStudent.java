package view;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import model.StudentBaza;


public class AbstractTableModelStudent extends AbstractTableModel {

	private static final long serialVersionUID = 3885988949349175170L;
	
	public static String more = "Detaljnije";
	
	@Override
	public int getRowCount() {
		return StudentBaza.getInstance().getRowCount();
	}

	@Override
	public int getColumnCount() {
		return StudentBaza.getInstance().getColumnCount() + 1;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(columnIndex >= StudentBaza.getInstance().getColumnCount()) {
			JButton btn = new JButton("" + rowIndex); 
			return btn;
		}
		return StudentBaza.getInstance().getValueAt(rowIndex, columnIndex);
	}
	
	@Override
	public String getColumnName(int column) {
		if(column >= StudentBaza.getInstance().getColumnCount())
			return more;
		return StudentBaza.getInstance().getColumnName(column);
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch(columnIndex) {
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
		case 10:
			return String.class;
		case 11:
			return JButton.class;
		default:
			return null;
		}
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex == 11;
	}
}
