package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controller.ProfesorController;
import model.Predmet;
import model.Profesor;
import model.ProfesorBaza;

public class DialogAddEditProfesor extends JDialog{

	private static final long serialVersionUID = 594374276025785515L;
	
	SimpleDateFormat sdf=new SimpleDateFormat("dd.MM.yyyy.");
	
	public DialogAddEditProfesor(boolean adding, int row) {
		super(MainFrame.getInstance(), "Dodavanje profesora", true);
		
		Profesor p = new Profesor();
		
		if(adding)
			setIconImage(new ImageIcon("icons/add.png").getImage());
		else {
			setIconImage(new ImageIcon("icons/edit.png").getImage());
			setTitle("Izmena profesora");
			p = ProfesorBaza.getInstance().getProfesori().get(row);
		}
		
		setLayout(new BorderLayout(40,40));
		setSize(400, 455);
		setResizable(false);
		setLocationRelativeTo(MainFrame.getInstance());
		
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
		if(!adding)
			ime.setText(p.getIme());
		pIme.add(lime);
		pIme.add(ime);
		
		//prezime
		JPanel pPrezime = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lprezime = new JLabel("Prezime*");
		lprezime.setPreferredSize(dimLab);
		JTextField prezime = new JTextField();
		prezime.setPreferredSize(dimText);
		if(!adding)
			prezime.setText(p.getPrezime());
		pPrezime.add(lprezime);
		pPrezime.add(prezime);
		
		//datumRodjenja
		JPanel pDatumRodjenja = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel ldatumRodjenja = new JLabel("Datum rodjenja*");
		ldatumRodjenja.setPreferredSize(dimLab);
		JFormattedTextField datumRodjenja = new JFormattedTextField(getDateMask("##.##.####."));
		datumRodjenja.setPreferredSize(dimText);
		if(!adding)
			datumRodjenja.setText(sdf.format(p.getDatumRodjenja()));
		pDatumRodjenja.add(ldatumRodjenja);
		pDatumRodjenja.add(datumRodjenja);
				
		//adresaStanovanja
		JPanel pAdresaStanovanja = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel ladresaStanovanja = new JLabel("Adresa stanovanja*");
		ladresaStanovanja.setPreferredSize(dimLab);
		JTextField adresaStanovanja = new JTextField();
		adresaStanovanja.setPreferredSize(dimText);
		if(!adding)
			adresaStanovanja.setText(p.getAdresaStanovanja());
		pAdresaStanovanja.add(ladresaStanovanja);
		pAdresaStanovanja.add(adresaStanovanja);
				
				
		//kontaktTelefon
		JPanel pKontaktTelefon = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lkontaktTelefon = new JLabel("Kontakt telefon*");
		lkontaktTelefon.setPreferredSize(dimLab);
		JTextField kontaktTelefon = new JTextField();
		kontaktTelefon.setPreferredSize(dimText);
		if(!adding)
			kontaktTelefon.setText(p.getKontaktTelefon());
		pKontaktTelefon.add(lkontaktTelefon);
		pKontaktTelefon.add(kontaktTelefon);
				
		//emailAdresa
		JPanel pEmailAdresa = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lemailAdresa = new JLabel("E-mail*");
		lemailAdresa.setPreferredSize(dimLab);
		JTextField emailAdresa = new JTextField();
		emailAdresa.setPreferredSize(dimText);
		if(!adding)
			emailAdresa.setText(p.getEmailAdresa());
		pEmailAdresa.add(lemailAdresa);
		pEmailAdresa.add(emailAdresa);
		
		//adresaKancelarije
		JPanel pAdresaKancelarije = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel ladresaKancelarije = new JLabel("Adresa kancelarije*");
		ladresaKancelarije.setPreferredSize(dimLab);
		JTextField adresaKancelarije = new JTextField();
		adresaKancelarije.setPreferredSize(dimText);
		if(!adding)
			adresaKancelarije.setText(p.getAdresaKancelarije());
		pAdresaKancelarije.add(ladresaKancelarije);
		pAdresaKancelarije.add(adresaKancelarije);
				
		//brojLicneKarte
		JPanel pBrojLicneKarte = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lbrojLicneKarte = new JLabel("Br. licne karte*");
		lbrojLicneKarte.setPreferredSize(dimLab);
		JTextField brojLicneKarte = new JTextField();
		brojLicneKarte.setPreferredSize(dimText);
		if(!adding) {
			brojLicneKarte.setText(p.getBrojLicneKarte());
			brojLicneKarte.setEnabled(false);
		}
		JLabel lbrLicneExists = new JLabel("Br. licne karte vec postoji!");
		lbrLicneExists.setVisible(false);
		
		pBrojLicneKarte.add(lbrojLicneKarte);
		pBrojLicneKarte.add(brojLicneKarte);
				
		//titula
		JPanel pTitula = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel ltitula = new JLabel("Titula*");
		ltitula.setPreferredSize(dimLab);
		JTextField titula = new JTextField();
		titula.setPreferredSize(dimText);
		if(!adding)
			titula.setText(p.getTitula());
		pTitula.add(ltitula);
		pTitula.add(titula);
				
		//zvanje
		JPanel pZvanje = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lzvanje = new JLabel("Zvanje*");
		lzvanje.setPreferredSize(dimLab);
		JTextField zvanje = new JTextField();
		zvanje.setPreferredSize(dimText);
		if(!adding)
			zvanje.setText(p.getZvanje());
		pZvanje.add(lzvanje);
		pZvanje.add(zvanje);
		
		//Lista predmeta
		List<Predmet> predmeti = p.getPredmeti();
				
		textPart.add(pIme);
		textPart.add(pPrezime);
		textPart.add(pDatumRodjenja);
		textPart.add(pAdresaStanovanja);
		textPart.add(pKontaktTelefon);
		textPart.add(pEmailAdresa);
		textPart.add(pAdresaKancelarije);
		textPart.add(pBrojLicneKarte);
		textPart.add(lbrLicneExists);
		textPart.add(pTitula);
		textPart.add(pZvanje);
		
		JPanel buttonPart = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		JButton ok = new JButton("Potvrdi");
		JButton close = new JButton("Odustani");
		
		buttonPart.add(ok);
		if(adding)
			ok.setEnabled(false);
		buttonPart.add(close);
		
		add(textPart, BorderLayout.CENTER);
		add(buttonPart, BorderLayout.SOUTH);
		
		KeyListener fix = new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(adding && ProfesorBaza.getInstance().exists(brojLicneKarte.getText())) {
					ok.setEnabled(false);
					lbrLicneExists.setVisible(true);
				}else if(ime.getText().trim().isEmpty() || prezime.getText().trim().isEmpty() ||
					adresaStanovanja.getText().trim().isEmpty() || kontaktTelefon.getText().trim().isEmpty() ||
					emailAdresa.getText().trim().isEmpty() || adresaKancelarije.getText().trim().isEmpty() ||
					brojLicneKarte.getText().trim().isEmpty() || titula.getText().trim().isEmpty() ||
					zvanje.getText().trim().isEmpty()) {
					ok.setEnabled(false);
					lbrLicneExists.setVisible(false);
				}else if(!adding && ProfesorBaza.getInstance().exists(brojLicneKarte.getText())) {
					ok.setEnabled(false);
					lbrLicneExists.setVisible(true);
				}else {
					ok.setEnabled(true);
					lbrLicneExists.setVisible(false);
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {}
		};
		
		ime.addKeyListener(fix);
		prezime.addKeyListener(fix);
		adresaStanovanja.addKeyListener(fix);
		kontaktTelefon.addKeyListener(fix);
		emailAdresa.addKeyListener(fix);
		adresaKancelarije.addKeyListener(fix);
		brojLicneKarte.addKeyListener(fix);
		titula.addKeyListener(fix);
		zvanje.addKeyListener(fix);
		
		
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Date datumRodjenjaDate = new Date();
				try {
					datumRodjenjaDate = sdf.parse(datumRodjenja.getText());
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				Profesor pr = new Profesor();
				
				pr.setIme(ime.getText());
				pr.setPrezime(prezime.getText());
				pr.setDatumRodjenja(datumRodjenjaDate);
				pr.setAdresaStanovanja(adresaStanovanja.getText());
				pr.setKontaktTelefon(kontaktTelefon.getText());
				pr.setEmailAdresa(emailAdresa.getText());
				pr.setAdresaKancelarije(adresaKancelarije.getText());
				pr.setBrojLicneKarte(brojLicneKarte.getText());
				pr.setTitula(titula.getText());
				pr.setZvanje(zvanje.getText());
				
				if(adding) {
					pr.setPredmeti(new ArrayList<Predmet>());
					ProfesorController.getInstance().addProfesor(pr);
				}else {
					pr.setPredmeti(predmeti);
					ProfesorController.getInstance().editProfesor(pr);
				}
				dispose();
			}
		});
		
		close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
		}
	
	private MaskFormatter getDateMask(String format) {
		MaskFormatter mask = null;
		try {
			mask = new MaskFormatter(format);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		mask.setPlaceholder("01.01.1950.");
		
		return mask;
}
}
