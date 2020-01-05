package view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

public class MainFrame extends JFrame {

	private Dimension frameSize;
	private JTabbedPane tabbedPane;
	private JPanel menuBarToolBarPanel;
	
	private static MainFrame instance = null;
	
	public static MainFrame getInstance() {
		if (instance == null) {
			instance = new MainFrame();
		}
		return instance;
	}
	
	private MainFrame() {
		initFrame();
		initMenuBarTooBarPanel();
		initTabbedPanel();	
		
	}
	
	
	
	
	private void initMenuBarTooBarPanel() {
		menuBarToolBarPanel = new JPanel();
		menuBarToolBarPanel.setPreferredSize(new Dimension(frameSize.width,(int) (frameSize.height*0.15)));
		this.add(menuBarToolBarPanel, BorderLayout.NORTH);
	}

	private void initTabbedPanel() {		
		tabbedPane = new JTabbedPane();		
		
		JPanel studentPanel = new JPanel();
		studentPanel.setBackground(new Color(255, 0, 0));		
		tabbedPane.addTab(null, studentPanel);	
		
		JPanel profesoriPanel = new JPanel();
		profesoriPanel.setBackground(new Color(0, 255, 0));
		tabbedPane.addTab(null, profesoriPanel);
		
		JPanel predmetiPanel = new JPanel();
		predmetiPanel.setBackground(new Color(0, 0, 255));
		tabbedPane.addTab(null, predmetiPanel);		
		

		JLabel lab = new JLabel();
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
		
		this.add(tabbedPane, BorderLayout.CENTER);
	}
	
	private void initFrame() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frameSize = new Dimension((int) (screenSize.width*0.75), (int) (screenSize.height*0.75));

		setSize(frameSize);
		setTitle("Studentska Sluzba");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Postavlja prozor na centar ekrana
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
