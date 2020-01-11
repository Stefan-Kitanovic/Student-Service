package view;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import model.PredmetBaza;

public class AbstractTableModelPredmet extends AbstractTableModel {

	private static final long serialVersionUID = 2312401778786703057L;

	@Override
	public int getColumnCount() {
		return PredmetBaza.getInstance().getColumnCount() + 1;
	}

	@Override
	public int getRowCount() {
		return PredmetBaza.getInstance().getPredmeti().size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		return PredmetBaza.getInstance().getValueAt(row, column);
	}

	@Override
	public String getColumnName(int column) {
		if (column >= PredmetBaza.getInstance().getColumnCount())
			return "Studenti";
		return PredmetBaza.getInstance().getColumnName(column);
	}

	@Override
	public Class<?> getColumnClass(int column) {
		switch(column) {
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
				return String.class;
			case 5: 
				return JButton.class;
			default: 
				return null;
		}
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		return column == 5;
	}
	
	
}
