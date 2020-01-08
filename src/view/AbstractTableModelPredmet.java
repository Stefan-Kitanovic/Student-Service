package view;

import javax.swing.table.AbstractTableModel;

import model.PredmetBaza;

public class AbstractTableModelPredmet extends AbstractTableModel {

	@Override
	public int getColumnCount() {
		return PredmetBaza.getInstance().getColumnCount();
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
	public String getColumnName(int index) {
		return PredmetBaza.getInstance().getColumnName(index);
	}

	
}
