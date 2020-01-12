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
import model.StudentBaza;

public class PredmetPrikaziFrame extends JFrame{

	private static final long serialVersionUID = 748616629370132832L;

	public PredmetPrikaziFrame() {
		setTitle("Spisak Studenata koji polazu");
		
		Dimension mainSize = MainFrame.getInstance().getFrameSize();
		setSize(mainSize.width/2, mainSize.height/2);
		setResizable(false);
		setLocationRelativeTo(MainFrame.getInstance());

		setLayout(new BorderLayout());
		setVisible(true);
		
		AbstractTableModel lista = new AbstractTableModel() {
	
			private static final long serialVersionUID = 4924378962324172769L;

			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				return PredmetBaza.getInstance().StudentListgetValueAt(rowIndex, columnIndex, MainFrame.getInstance().getSelectedPredmetRow());
			}
			
			@Override
			public int getRowCount() {
				return PredmetBaza.getInstance().getStudentList(MainFrame.getInstance().getSelectedPredmetRow()).size();
			}
			
			@Override
			public int getColumnCount() {
				return 3;
			}
			
			@Override
			public String getColumnName(int column) {
				return StudentBaza.getInstance().getColumnName(column);
			}
		};
		
		JTable studenti = new JTable();
		studenti.setModel(lista);
		
		JScrollPane studentiPanel = new JScrollPane(studenti);
		studentiPanel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(50, 50, 50, 50), new EtchedBorder()));
		studentiPanel.setBackground(Color.LIGHT_GRAY);
		this.add(studentiPanel, BorderLayout.CENTER);
	}
}
