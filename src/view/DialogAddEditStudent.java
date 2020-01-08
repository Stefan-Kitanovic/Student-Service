package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.sun.istack.internal.Nullable;

import model.Godina;
import model.Status;
import model.Student;


public class DialogAddEditStudent extends JDialog {

	private static final long serialVersionUID = -5271396812269074473L;
	
	SimpleDateFormat sdf=new SimpleDateFormat("dd.MM.yyyy");

	public DialogAddEditStudent(Frame parent, Boolean adding, @Nullable Student s) {
		super(parent, "Dodavanje studenta", true);
		//adding - govori da li se radi o dodavanju(true) ili izmeni(false)
		
		if(adding)
			setIconImage(new ImageIcon("icons/add.png").getImage());
		else {
			setIconImage(new ImageIcon("icons/edit.png").getImage());
			setTitle("Izmena studenta");
		}
		setLayout(new BorderLayout(40,40));
		setSize(400, 425);
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
		if(!adding)
			ime.setText(s.getIme());
		pIme.add(lime);
		pIme.add(ime);
		
		//prezime
		JPanel pPrezime = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		JLabel lprezime = new JLabel("Prezime*");
		lprezime.setPreferredSize(dimLab);
		JTextField prezime = new JTextField();
		prezime.setPreferredSize(dimText);
		if(!adding)
			ime.setText(s.getPrezime());
		pPrezime.add(lprezime);
		pPrezime.add(prezime);
		
		//datumr
		JPanel pDatumr = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		JLabel ldatumr = new JLabel("Datum rodjenja*");
		ldatumr.setPreferredSize(dimLab);
		JFormattedTextField datumr = new JFormattedTextField(sdf);
		datumr.setPreferredSize(dimText);
		if(!adding)
			ime.setText(sdf.format(s.getDatumr()));
		pDatumr.add(ldatumr);
		pDatumr.add(datumr);
		
		//adresa
		JPanel pAdresa = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		JLabel ladresa = new JLabel("Adresa stanovanja*");
		ladresa.setPreferredSize(dimLab);
		JTextField adresa = new JTextField();
		adresa.setPreferredSize(dimText);
		if(!adding)
			ime.setText(s.getAdresa());
		pAdresa.add(ladresa);
		pAdresa.add(adresa);
		
		//telefon
		JPanel pTel = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		JLabel ltel = new JLabel("Broj telefona*");
		ltel.setPreferredSize(dimLab);
		JTextField tel = new JTextField();
		tel.setPreferredSize(dimText);
		if(!adding)
			ime.setText(s.getTel());
		pTel.add(ltel);
		pTel.add(tel);
		
		//index
		JPanel pIndex = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		JLabel lindex = new JLabel("Broj indeksa*");
		lindex.setPreferredSize(dimLab);
		JTextField index = new JTextField();
		index.setPreferredSize(dimText);
		if(!adding) {
			ime.setText(s.getIndex());
			ime.setEditable(false);
		}
		pIndex.add(lindex);
		pIndex.add(index);
		
		//datumu
		JPanel pDatumu = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		JLabel ldatumu = new JLabel("Datum upisa*");
		ldatumu.setPreferredSize(dimLab);
		JFormattedTextField datumu = new JFormattedTextField(sdf);
		datumu.setPreferredSize(dimText);
		if(!adding)
			ime.setText(sdf.format(s.getDatumu()));
		pDatumu.add(ldatumu);
		pDatumu.add(datumu);
		
		//Trenutna godina
		JPanel pGodina = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		JLabel lgodina = new JLabel("Trenutna godina studija*");
		lgodina.setPreferredSize(dimLab);
//		String god[] = {"I (Prva)", "II (Druga)", "III (Treca)", "IV (Cetvrta)"}; 
		JComboBox<Godina> godina = new JComboBox<Godina>(Godina.values());
		godina.setPreferredSize(dimText);
		if(!adding) {
			switch(s.getGodina()) {
			case I:
				godina.setSelectedIndex(0);
				break;
			case II:
				godina.setSelectedIndex(1);
				break;
			case III:
				godina.setSelectedIndex(2);
				break;
			case IV:
				godina.setSelectedIndex(3);
				break;
			}
		}
			
		pGodina.add(lgodina);
		pGodina.add(godina);
		
		//Status
		JRadioButton bu = new JRadioButton("Budžet", true);
		JRadioButton sf = new JRadioButton("Samofinansiranje");
		ButtonGroup status = new ButtonGroup();
		status.add(bu);
		status.add(sf);
		if(!adding) {
				if(s.getStatus() == Status.S) {
					bu.setSelected(false);
					sf.setSelected(true);
				}
		}
		
		//Prosek
		JPanel pProsek = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		JLabel lprosek = new JLabel("Prosek*");
		lprosek.setPreferredSize(dimLab);
		JTextField prosek = new JTextField();
		prosek.setPreferredSize(dimText);
		if(!adding)
			ime.setText(String.valueOf(s.getProsek()));
		pProsek.add(lprosek);
		pProsek.add(prosek);
		
		textPart.add(pIme);
		textPart.add(pPrezime);
		textPart.add(pDatumr);
		textPart.add(pAdresa);
		textPart.add(pTel);
		textPart.add(pIndex);
		textPart.add(pDatumu);
		textPart.add(pGodina);
		textPart.add(bu, new FlowLayout(FlowLayout.LEFT));
		textPart.add(sf, new FlowLayout(FlowLayout.LEFT));
		textPart.add(pProsek);
	
		JPanel buttonPart = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton ok = new JButton("Potvrdi");
		JButton close = new JButton("Odustani");
		
		buttonPart.add(ok);
		buttonPart.add(close);
		
		add(textPart, BorderLayout.CENTER);
		add(buttonPart, BorderLayout.SOUTH);
		
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}

}
