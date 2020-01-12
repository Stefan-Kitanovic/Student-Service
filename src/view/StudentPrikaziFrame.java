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

public class StudentPrikaziFrame extends JFrame{

	private static final long serialVersionUID = 2804542279194763471L;

	public StudentPrikaziFrame() {
		setTitle("Spisak predmeta koji slusa");
		
		Dimension mainSize = MainFrame.getInstance().getFrameSize();
		setSize(mainSize.width/2, mainSize.height/2);
		setResizable(false);
		setLocationRelativeTo(MainFrame.getInstance());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setLayout(new BorderLayout());
		setVisible(true);
		
		AbstractTableModel lista = new AbstractTableModel() {
	
			private static final long serialVersionUID = 4920014538863114054L;

			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				return StudentBaza.getInstance().PredmetListgetValueAt(rowIndex, columnIndex, MainFrame.getInstance().getSelectedStudentRow());
			}
			
			@Override
			public int getRowCount() {
				return StudentBaza.getInstance().getPredmetiList(MainFrame.getInstance().getSelectedStudentRow()).size();
			}
			
			@Override
			public int getColumnCount() {
				return 3;
			}
			
			@Override
			public String getColumnName(int column) {
				return PredmetBaza.getInstance().getColumnName(column);
			}
		};
		
		JTable predmeti = new JTable();
		predmeti.setModel(lista);
		
		JScrollPane predmetiPanel = new JScrollPane(predmeti);
		predmetiPanel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(50, 50, 50, 50), new EtchedBorder()));
		predmetiPanel.setBackground(Color.LIGHT_GRAY);
		this.add(predmetiPanel, BorderLayout.CENTER);
	}
}
