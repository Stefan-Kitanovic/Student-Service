package view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.PredmetController;
import controller.StudentController;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = -4390247854245253515L;
	
	private Dimension frameSize;
	private JTabbedPane tabbedPane;
	private Toolbar toolbar;
	private JPanel centerPanel;
	private StatusBar statusBar;
	private static String selectedTabName;
	private JTable predmetTable;
	
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
				PredmetController.getInstance().saveData();
//				StudentController.getInstance().saveData(); //Ne radi ucitavanje/cuvanje baze studenata
				System.exit(0);
			}
		});
	}
	
	public void updateView() {
		AbstractTableModelPredmet modelPredmet = (AbstractTableModelPredmet) predmetTable.getModel();
		
		modelPredmet.fireTableDataChanged();
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
		
		JScrollPane studentPanel = new JScrollPane(new StudentTable());
		studentPanel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(50, 50, 50, 50), new EtchedBorder()));
		studentPanel.setBackground(Color.LIGHT_GRAY);		
		tabbedPane.addTab("student", studentPanel);	
		
		JPanel profesoriPanel = new JPanel();
		profesoriPanel.setBackground(new Color(0, 255, 0));
		tabbedPane.addTab("profesor", profesoriPanel);
		
		predmetTable = new PredmetTable();
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
				} else {
					toolbar.setBtnAddStudentToPredmetVisible(false);
					toolbar.setBtnAddProfesorToPredmetVisible(false);
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
		setTitle("Studentska Sluzba");
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
		return predmetTable.getSelectedRow();
	}
	
}
