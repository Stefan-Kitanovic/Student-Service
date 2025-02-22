package view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import controller.PredmetController;
import controller.ProfesorController;
import controller.StudentController;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = -4390247854245253515L;
	
	private Dimension frameSize;
	private JTabbedPane tabbedPane;
	private Toolbar toolbar;
	private JPanel centerPanel;
	private StatusBar statusBar;
	private static String selectedTabName;
	private JTable studentTable;
	private JTable predmetTable;
	private JTable profesorTable;
	private TableRowSorter<TableModel> predmetSorter;
	private TableRowSorter<TableModel> profesorSorter;
	
	private static MainFrame instance = null;
	
	public static MainFrame getInstance() {
		if (instance == null) {
			instance = new MainFrame();
		}
		return instance;
	}
	
	private MainFrame() {
		initFrame();
		
		initMenuBar();
		initTabbedPanel();	
		initToolbar();
		initStatusBar();
		validate();
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				ProfesorController.getInstance().saveData();
				PredmetController.getInstance().saveData();
				StudentController.getInstance().saveData();
				System.exit(0);
			}
		});
	}
	
	public void updateView() {
		AbstractTableModelPredmet modelPredmet = (AbstractTableModelPredmet) predmetTable.getModel();
		AbstractTableModelStudent modelStudent = (AbstractTableModelStudent) studentTable.getModel();
		AbstractTableModelProfesor modelProfesor = (AbstractTableModelProfesor) profesorTable.getModel();
		
		modelProfesor.fireTableDataChanged();
		modelPredmet.fireTableDataChanged();
		modelStudent.fireTableDataChanged();
		validate();
	}
	
	private void initMenuBar() {
		this.setJMenuBar(new MenuBar());
	}
	
	private void initStatusBar() {
		statusBar = new StatusBar();
		this.add(statusBar, BorderLayout.SOUTH);
		
	}

	private void initToolbar() {
		toolbar = new Toolbar((int) (frameSize.height*0.05));	
		this.add(toolbar, BorderLayout.NORTH);
	}

	private void initTabbedPanel() {		
		centerPanel = new JPanel(new BorderLayout());
		tabbedPane = new JTabbedPane();		
		
		studentTable = new StudentTable();
		JScrollPane studentPanel = new JScrollPane(studentTable);
		studentPanel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(50, 50, 50, 50), new EtchedBorder()));
		studentPanel.setBackground(Color.LIGHT_GRAY);		
		tabbedPane.addTab("student", studentPanel);	
		
		profesorTable = new ProfesorTable();
		profesorSorter = new TableRowSorter<TableModel>(profesorTable.getModel());
		profesorTable.setRowSorter(profesorSorter);
		JScrollPane profesoriPanel = new JScrollPane(profesorTable);
		profesoriPanel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(50, 50, 50, 50), new EtchedBorder()));
		profesoriPanel.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("profesor", profesoriPanel);
		
		predmetTable = new PredmetTable();
		predmetSorter = new TableRowSorter<TableModel>(predmetTable.getModel());
		predmetTable.setRowSorter(predmetSorter);
		JScrollPane predmetiPanel = new JScrollPane(predmetTable);
		predmetiPanel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(50, 50, 50, 50), new EtchedBorder()));
		predmetiPanel.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("predmet", predmetiPanel);	
		

		JLabel lab = new JLabel("student");
		lab.setPreferredSize(new Dimension(150, 50));	
		lab.setText("Studenti");
		lab.setHorizontalAlignment(SwingConstants.CENTER);
		lab.setVerticalAlignment(SwingConstants.CENTER);
		tabbedPane.setTabComponentAt(0, lab);
		
		lab = new JLabel();
		lab.setPreferredSize(new Dimension(150, 50));	
		lab.setText("Profesori");
		lab.setHorizontalAlignment(SwingConstants.CENTER);
		lab.setVerticalAlignment(SwingConstants.CENTER);
		tabbedPane.setTabComponentAt(1, lab);
		
		lab = new JLabel();
		lab.setPreferredSize(new Dimension(150, 50));	
		lab.setText("Predmeti");
		lab.setHorizontalAlignment(SwingConstants.CENTER);
		lab.setVerticalAlignment(SwingConstants.CENTER);
		tabbedPane.setTabComponentAt(2, lab);
		
		selectedTabName = tabbedPane.getTitleAt(tabbedPane.getSelectedIndex());
		
		tabbedPane.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				if (tabbedPane.getSelectedIndex() == 2) {
					toolbar.setBtnAddStudentToPredmetVisible(true);
					toolbar.setBtnAddProfesorToPredmetVisible(true);
					toolbar.setBtnRemoveProfesorFromPredmet(true);
				} else {
					toolbar.setBtnAddStudentToPredmetVisible(false);
					toolbar.setBtnAddProfesorToPredmetVisible(false);
					toolbar.setBtnRemoveProfesorFromPredmet(false);
				}
				
				selectedTabName = tabbedPane.getTitleAt(tabbedPane.getSelectedIndex());
				toolbar.setTooltips();
			}
		});
		
		centerPanel.add(tabbedPane, BorderLayout.CENTER);
		this.add(centerPanel, BorderLayout.CENTER);
	}
	
	private void initFrame() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frameSize = new Dimension((int) (screenSize.width*0.75), (int) (screenSize.height*0.75));

		setResizable(false);
		setSize(frameSize);
		setTitle("Studentska Slu�ba");
		setIconImage(new ImageIcon("icons/appLogo.png").getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Postavlja prozor na centar ekrana
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public int getSelectedTab() {
		return tabbedPane.getSelectedIndex();
	}
	
	public static String getSelectedTabName() {
		return selectedTabName;
	}
	
	public int getSelectedPredmetRow() {
		if (predmetTable.getSelectedRow() >= 0)
			return predmetTable.convertRowIndexToModel(predmetTable.getSelectedRow());
		else
			return predmetTable.getSelectedRow();
	}
	
	public int getSelectedStudentRow() {
		if (studentTable.getSelectedRow() >= 0)
			return studentTable.convertColumnIndexToModel(studentTable.getSelectedRow());
		else
			return studentTable.getSelectedRow();
	}
	
	public int getSelectedProfesorRow() {
		if (profesorTable.getSelectedRow() >= 0)
			return profesorTable.convertRowIndexToModel(profesorTable.getSelectedRow());
		else
			return profesorTable.getSelectedRow();
	}
	
	public Dimension getFrameSize() {
		return frameSize;
	}
	
	public void setPredmetSorter(RowFilter<Object, Object> filter) {
		predmetSorter.setRowFilter(filter);
	}
	
	public void setProfesorSorter(RowFilter<Object, Object> filter) {
		profesorSorter.setRowFilter(filter);
	}
}
