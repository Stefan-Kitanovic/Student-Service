package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

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

import controller.StudentController;

public class DialogAddStudent extends JDialog {

	private static final long serialVersionUID = -5271396812269074473L;

	public DialogAddStudent(Frame parent) {
		super(parent, "Dodavanje studenta", true);
		
		setIconImage(new ImageIcon("icons/add.png").getImage());
		setLayout(new BorderLayout(40,40));
		setSize(400, 375);
		setResizable(false);
		setLocationRelativeTo(parent);
		
		JPanel textPart = new JPanel(); 
		textPart.setLayout(new BoxLayout(textPart, BoxLayout.Y_AXIS));
		
		Dimension dimLab = new Dimension(150, 20);
		Dimension dimText = new Dimension(200, 20);
		
		//ime
		JPanel pIme = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		JLabel lime = new JLabel("Ime*");
		lime.setPreferredSize(dimLab);
		JTextField ime = new JTextField();
		ime.setPreferredSize(dimText);
		pIme.add(lime);
		pIme.add(ime);
		
		//prezime
		JPanel pPrezime = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		JLabel lprezime = new JLabel("Prezime*");
		lprezime.setPreferredSize(dimLab);
		JTextField prezime = new JTextField();
		prezime.setPreferredSize(dimText);
		pPrezime.add(lprezime);
		pPrezime.add(prezime);
		
		//datumr
		JPanel pDatumr = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		JLabel ldatumr = new JLabel("Datum rodjenja*");
		ldatumr.setPreferredSize(dimLab);
		JTextField datumr = new JTextField();
		datumr.setPreferredSize(dimText);
		pDatumr.add(ldatumr);
		pDatumr.add(datumr);
		
		//adresa
		JPanel pAdresa = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		JLabel ladresa = new JLabel("Adresa stanovanja*");
		ladresa.setPreferredSize(dimLab);
		JTextField adresa = new JTextField();
		adresa.setPreferredSize(dimText);
		pAdresa.add(ladresa);
		pAdresa.add(adresa);
		
		//telefon
		JPanel pTel = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		JLabel ltel = new JLabel("Broj telefona*");
		ltel.setPreferredSize(dimLab);
		JTextField tel = new JTextField();
		tel.setPreferredSize(dimText);
		pTel.add(ltel);
		pTel.add(tel);
		
		//index
		JPanel pIndex = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		JLabel lindex = new JLabel("Broj indeksa*");
		lindex.setPreferredSize(dimLab);
		JTextField index = new JTextField();
		index.setPreferredSize(dimText);
		pIndex.add(lindex);
		pIndex.add(index);
		
		//Trenutna godina
		JPanel pGodina = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		JLabel lgodina = new JLabel("Trenutna godina studija*");
		lgodina.setPreferredSize(dimLab);
		String god[] = {"I (Prva)", "II (Druga)", "III (Treca)", "IV (Cetvrta)"}; 
		JComboBox godina = new JComboBox(god);
		godina.setPreferredSize(dimText);
		pGodina.add(lgodina);
		pGodina.add(godina);
		
		//Status
		JRadioButton b = new JRadioButton("Budžet");
		JRadioButton s = new JRadioButton("Samofinansiranje");
		ButtonGroup status = new ButtonGroup();
		status.add(b);
		status.add(s);
		b.setSelected(true);
		
		textPart.add(pIme);
		textPart.add(pPrezime);
		textPart.add(pDatumr);
		textPart.add(pAdresa);
		textPart.add(pTel);
		textPart.add(pIndex);
		textPart.add(pGodina);
		textPart.add(b, new FlowLayout(FlowLayout.LEFT));
		textPart.add(s, new FlowLayout(FlowLayout.LEFT));
	
		JPanel buttonPart = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton ok = new JButton("Potvrdi");
		JButton close = new JButton("Odustani");
		
		buttonPart.add(ok);
		buttonPart.add(close);
		
		add(textPart, BorderLayout.CENTER);
		add(buttonPart, BorderLayout.SOUTH);
	}

}
