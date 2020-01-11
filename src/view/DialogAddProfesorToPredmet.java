package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.PredmetController;
import model.ProfesorBaza;

public class DialogAddProfesorToPredmet extends JDialog {

	private static final long serialVersionUID = 6382890848383168943L;

	public DialogAddProfesorToPredmet(int row) {
		super(MainFrame.getInstance(), "Predmet - dodavanje profesora", true);
		
		setLayout(new BorderLayout());
		
		Dimension mainFrameSize = MainFrame.getInstance().getFrameSize();
		int dialogWidth = (int) (mainFrameSize.width*0.3);
		int dialogHeight = (int) (mainFrameSize.height*0.2);
		
		setSize(dialogWidth, dialogHeight);
		setResizable(false);
		setLocationRelativeTo(MainFrame.getInstance());
		
		Dimension dimLabel = new Dimension((int) (dialogWidth*0.4), 20);
		Dimension dimText = new Dimension((int) (dialogWidth*0.5), 20);
		
		
		JPanel panelButtons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton buttonOdustani = new JButton("Odustani");
		JButton buttonPotvrdi = new JButton("Potvrdi");
		
		buttonPotvrdi.setEnabled(false);
		
		
		JPanel panelTop = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		JLabel labelBrojLicneKarte = new JLabel("Broj licne karte profesora*");
		labelBrojLicneKarte.setPreferredSize(dimLabel);
		
		JTextField textFieldBrojLicneKarte = new JTextField();
		textFieldBrojLicneKarte.setPreferredSize(dimText);
		
		textFieldBrojLicneKarte.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {}
			
			@Override
			public void keyReleased(KeyEvent e) {
				String brojLicneKarte = textFieldBrojLicneKarte.getText();
				
				if (brojLicneKarte.isEmpty() || !ProfesorBaza.getInstance().exists(brojLicneKarte)) {
					buttonPotvrdi.setEnabled(false);
				} else {
					buttonPotvrdi.setEnabled(true);
				}		
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {}
		});
		
		buttonOdustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		buttonPotvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String brojLicneKarte = textFieldBrojLicneKarte.getText();
				PredmetController.getInstance().addProfesorToPredmet(brojLicneKarte, row);
				
				dispose();
			}
		});
		
		panelTop.add(labelBrojLicneKarte);
		panelTop.add(textFieldBrojLicneKarte);		
		panelButtons.add(buttonOdustani);
		panelButtons.add(buttonPotvrdi);	
		
		add(panelTop, BorderLayout.CENTER);
		add(panelButtons, BorderLayout.SOUTH);
	}
}
