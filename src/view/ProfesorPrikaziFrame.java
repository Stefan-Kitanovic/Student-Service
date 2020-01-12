package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.AbstractTableModel;

import model.PredmetBaza;
import model.ProfesorBaza;

public class ProfesorPrikaziFrame extends JFrame {

	private static final long serialVersionUID = -2541122323051462782L;

	public ProfesorPrikaziFrame() {		
		Dimension mainFrameSize = MainFrame.getInstance().getFrameSize();
		setSize(mainFrameSize.width/2, mainFrameSize.height/2);
		setResizable(false);
		setLayout(new BorderLayout());	
		setLocationRelativeTo(MainFrame.getInstance());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Spisak predmeta");
		setVisible(true);	

		AbstractTableModel abstractTable = new AbstractTableModel() {
			
			private static final long serialVersionUID = -5246492386659421409L;

			@Override
			public Object getValueAt(int row, int column) {
				return ProfesorBaza.getInstance().prikaziGetValueAt(row, column, MainFrame.getInstance().getSelectedProfesorRow());
			}
			
			@Override
			public int getRowCount() {
				return ProfesorBaza.getInstance().getPredmeti(MainFrame.getInstance().getSelectedProfesorRow()).size();
			}
			
			@Override
			public int getColumnCount() {
				return 2;
			}

			@Override
			public String getColumnName(int column) {
				return PredmetBaza.getInstance().getColumnName(column);
			}
			
			
		};
		
		JTable predmetiTable = new JTable();
		predmetiTable.setModel(abstractTable);
		
		JScrollPane predmetiPanel = new JScrollPane(predmetiTable);
		predmetiPanel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(50, 50, 50, 50), new EtchedBorder()));
		predmetiPanel.setBackground(Color.LIGHT_GRAY);
		this.add(predmetiPanel, BorderLayout.CENTER);
	}
}
