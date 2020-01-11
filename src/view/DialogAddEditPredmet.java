package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.PredmetController;
import model.Godina;
import model.Predmet;
import model.PredmetBaza;
import model.Profesor;
import model.ProfesorBaza;
import model.Semestar;
import model.Student;

public class DialogAddEditPredmet extends JDialog {

	private static final long serialVersionUID = 5534948947767869300L;
	
	SimpleDateFormat sdf=new SimpleDateFormat("dd.MM.yyyy.");
	
	public DialogAddEditPredmet(Boolean adding, int row) {
		super(MainFrame.getInstance(), "Dodavanje predmeta", true);
		
		Predmet predmet = new Predmet();
		
		if (adding) {
			setIconImage(new ImageIcon("icons/add.png").getImage());
		} else {
			setIconImage(new ImageIcon("icons/edit.png").getImage());
			setTitle("Izmena profesora");
				
			predmet = PredmetBaza.getInstance().getPredmeti().get(row);
		}
		
		Dimension mainFrameSize = MainFrame.getInstance().getFrameSize();
		int dialogWidth = (int) (mainFrameSize.width*0.3);
		int dialogHeight = (int) (mainFrameSize.height*0.4);
		
		
		setLayout(new BorderLayout(40, 40));
		setSize(dialogWidth, dialogHeight);
		setResizable(false);
		setLocationRelativeTo(MainFrame.getInstance());
		
		JPanel panelText = new JPanel();
		panelText.setLayout(new BoxLayout(panelText, BoxLayout.Y_AXIS));
		
		Dimension dimLabel = new Dimension((int) (dialogWidth*0.4), 20);
		Dimension dimText = new Dimension((int) (dialogHeight*0.5), 20);
		
		
		JPanel panelButtons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton buttonOdustani = new JButton("Odustani");
		JButton buttonPotvrdi = new JButton("Potvrdi");
		if (adding)
			buttonPotvrdi.setEnabled(false);
		
		panelButtons.add(buttonOdustani);
		panelButtons.add(buttonPotvrdi);
		
		
		
				
		//Sifra predmeta
		JPanel panelSifra = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		
		JLabel labelSifra = new JLabel("Sifra predmeta*");
		labelSifra.setPreferredSize(dimLabel);
		
		JTextField textFieldSifra = new JTextField();
		textFieldSifra.setPreferredSize(dimText);
		
		String sifraPredmeta = predmet.getSifraPredmeta();
		if (!adding)
			textFieldSifra.setText(sifraPredmeta);
		
		JLabel labelSifraExists = new JLabel("Sifra vec postoji!");
		labelSifraExists.setVisible(false);
		panelSifra.add(labelSifra);
		panelSifra.add(textFieldSifra);
		
		
		//Naziv
		JPanel panelNaziv = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		
		JLabel labelNaziv = new JLabel("Naziv predmeta*");
		labelNaziv.setPreferredSize(dimLabel);
		
		JTextField textFieldNaziv = new JTextField();
		textFieldNaziv.setPreferredSize(dimText);
		if (!adding)
			textFieldNaziv.setText(predmet.getNazivPredmeta());
				
		panelNaziv.add(labelNaziv);
		panelNaziv.add(textFieldNaziv);
		
		
		//Semestar
		JPanel panelSemestar = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelSemestar.setLayout(new BoxLayout(panelSemestar, BoxLayout.Y_AXIS));
		
		JRadioButton letnji = new JRadioButton("Letnji", true);
		JRadioButton zimski = new JRadioButton("Zimski");
		ButtonGroup semestar = new ButtonGroup();
		
		semestar.add(letnji);
		semestar.add(zimski);
		
		if (!adding) {
			if(predmet.getSemestar() == Semestar.Zimski) {
				zimski.setSelected(true);
				letnji.setSelected(false);
			}
		}
		
		panelSemestar.add(letnji, FlowLayout.LEFT);
		panelSemestar.add(zimski, FlowLayout.LEFT);
		
		//Godina studija
		JPanel panelGodina = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		
		JLabel labelGodina = new JLabel("Godina studija*");
		labelGodina.setPreferredSize(dimLabel);
		
		JComboBox<Godina> comboBoxGodina = new JComboBox<Godina>(Godina.values());
		comboBoxGodina.setPreferredSize(dimText);
		
		if (!adding)
			comboBoxGodina.setSelectedItem(predmet.getGodinaStudija());
		
		panelGodina.add(labelGodina);
		panelGodina.add(comboBoxGodina);
		
		//Predmetni profesor
		JPanel panelProfesor = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		JLabel labelProfesor = new JLabel("Predmetni profesor*");
		labelProfesor.setPreferredSize(dimLabel);
		
		
		JComboBox<String> comboBoxProfesor = new JComboBox<String>();
		comboBoxProfesor.setPreferredSize(dimText);
		comboBoxProfesor.addItem("Nema profesora");

		for (Profesor profesor : ProfesorBaza.getInstance().getProfesori())
			comboBoxProfesor.addItem(profesor.getPrezime() + " " + profesor.getTitula() + " " + profesor.getIme());
		
		comboBoxGodina.setSelectedIndex(0);
		if (!adding) {
			int profesorRow;
			if (predmet.getPredmetniProfesor() != null) {
				profesorRow = ProfesorBaza.getInstance().getProfesorRow(predmet.getPredmetniProfesor().getBrojLicneKarte());
				if (profesorRow != -1)
					comboBoxGodina.setSelectedIndex(profesorRow);			
			} else {
				comboBoxGodina.setSelectedIndex(0);
			}
							
		}
		
		KeyListener keyListener = new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {}
							
			@Override
			public void keyReleased(KeyEvent e) {
				if (textFieldSifra.getText().isEmpty() || textFieldNaziv.getText().isEmpty()) {
					buttonPotvrdi.setEnabled(false);
					labelSifraExists.setVisible(false);
					
				} else if ((adding && PredmetBaza.getInstance().predmetExists(textFieldSifra.getText()))) {
					buttonPotvrdi.setEnabled(false);
					labelSifraExists.setVisible(true);
					
				} else if (!adding && sifraPredmeta.equals(textFieldSifra.getText())) {
					buttonPotvrdi.setEnabled(true);
					labelSifraExists.setVisible(false);
					
				} else if (!adding && PredmetBaza.getInstance().predmetExists(textFieldSifra.getText())) {
					buttonPotvrdi.setEnabled(false);
					labelSifraExists.setVisible(true);
					
				} else {					
					buttonPotvrdi.setEnabled(true);		
					labelSifraExists.setVisible(false);
				}

			}
			
			@Override
			public void keyPressed(KeyEvent e) {}
		};
		
		buttonOdustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		buttonPotvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				List<Profesor> profesori = ProfesorBaza.getInstance().getProfesori();
				Profesor profesor;
				
				if (comboBoxProfesor.getSelectedIndex() == 0)
					profesor = null;
				else
					profesor = profesori.get(comboBoxProfesor.getSelectedIndex()-1);
				
				Semestar izabraniSemestar;
				
				if (letnji.isSelected())
					izabraniSemestar = Semestar.Letnji;
				else
					izabraniSemestar = Semestar.Zimski;
					
				if (adding) {
					PredmetController.getInstance().addPredmet(textFieldSifra.getText(), textFieldNaziv.getText(), izabraniSemestar, (Godina) comboBoxGodina.getSelectedItem(), profesor, new ArrayList<Student>());
				} else {
					PredmetController.getInstance().editPredmet(row, textFieldSifra.getText(), textFieldNaziv.getText(), izabraniSemestar, (Godina) comboBoxGodina.getSelectedItem(), profesor);
				}
				
				dispose();
			}
		});
		
		textFieldSifra.addKeyListener(keyListener);
		textFieldNaziv.addKeyListener(keyListener);
		
		panelProfesor.add(labelProfesor);
		panelProfesor.add(comboBoxProfesor);
		
		panelText.add(panelSifra);
		panelText.add(labelSifraExists);
		panelText.add(panelNaziv);
		panelText.add(panelGodina);
		panelText.add(panelSemestar);
		panelText.add(panelProfesor);
				
		add(panelText, BorderLayout.CENTER);
		add(panelButtons, BorderLayout.SOUTH);
		
	}
}
