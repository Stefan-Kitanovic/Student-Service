package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.AbstractTableModel;

import controller.PredmetController;
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setLayout(new BorderLayout());
		setVisible(true);
		
		int predmetRow = MainFrame.getInstance().getSelectedPredmetRow();
		
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
		
		JPanel buttonPart = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton delete = new JButton("Obrisi");
		JButton back = new JButton("Nazad");
		
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedTab = studenti.getSelectedRow();
				String index = (String) studenti.getValueAt(selectedTab, 0);
				PredmetController.getInstance().removeStudentfromPredmet(index, predmetRow);
			}
		});
		
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		buttonPart.add(delete);
		buttonPart.add(back);
		
		this.add(studentiPanel, BorderLayout.CENTER);
		this.add(buttonPart, BorderLayout.SOUTH);
	}
}
