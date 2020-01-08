package view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = -4390247854245253515L;
	
	private Dimension frameSize;
	private JTabbedPane tabbedPane;
	private Toolbar toolbar;
	private JPanel centerPanel;
	private StatusBar statusBar;
	private JTable tableStudent;
	private static String selectedTabName;
	
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
	}
	
	
	private void initMenuBar() {
		this.setJMenuBar(new MenuBar(this));
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
		
		JPanel studentPanel = new JPanel();
		studentPanel.setBackground(new Color(255, 0, 0));		
		tabbedPane.addTab("student", studentPanel);	
		
		JPanel profesoriPanel = new JPanel();
		profesoriPanel.setBackground(new Color(0, 255, 0));
		tabbedPane.addTab("profesor", profesoriPanel);
		
		JPanel predmetiPanel = new JPanel();
		predmetiPanel.setBackground(new Color(0, 0, 255));
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
	
}
