package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProfesorBaza implements Serializable {

	private static final long serialVersionUID = 3329925050709610806L;
	
	final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
	private static ProfesorBaza instance = null;
	private static final String dataPath = "data/ProfesorData.data";

	public static ProfesorBaza getInstance() {
		if (instance == null) {
			instance = new ProfesorBaza();
		}
		return instance;
	}
	
	private List<Profesor> profesori;
	private List<String> columns;
	
	private ProfesorBaza() {
		profesori = new ArrayList<Profesor>();
		columns = new ArrayList<String>();
		
		columns.add("Ime");
		columns.add("Prezime");
		columns.add("Datum rodjenja");
		columns.add("Adresa");
		columns.add("Telefon");
		columns.add("E-mail");
		columns.add("Kancelarija");
		columns.add("Br. licne karte");
		columns.add("Titula");
		columns.add("Zvanje");
		columns.add("Predmeti");
		
		File dataFile = new File(dataPath);
		
		if (dataFile.exists()) {
			profesori = loadProfesorBazaData(dataFile);
		} else {
			try {
				profesori.add(new Profesor("Aleksa", "Petković", sdf.parse("15.01.1965."), "Temerinska 15, Novi Sad", "021/334-990", "aleksa.petkovic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, MI 105", "007198721", "Prof. dr", "Redovni profesor", new ArrayList<Predmet>()));
				profesori.add(new Profesor("Jana", "Lazarević", sdf.parse("25.02.1963."), "Jovana Cvijića 26, Novi Sad", "021/435-891", "jana.lazarevic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, Nastavni blok 206", "008431903", "Prof. dr", "Redovni profesor", new ArrayList<Predmet>()));
				profesori.add(new Profesor("Nađa", "Aleksić", sdf.parse("23.03.1973."), "Gundulićeva 75, Novi Sad", "021/730-172", "nadja.aleksic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, NTP 307", "005671007", "dr", "Vanredni profesor", new ArrayList<Predmet>()));
				profesori.add(new Profesor("Đorđe", "Spasojević", sdf.parse("24.08.1978."), "Šekspirova 44, Novi Sad", "021/514-893", "djordje.spasojevic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, MI 118", "009999331", "dr", "Vanredni profesor", new ArrayList<Predmet>()));
				profesori.add(new Profesor("Elena", "Milenković", sdf.parse("08.11.1985."), "Tolstojeva 52, Novi Sad", "021/834-901", "elena.milenkovic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, Nastavni blok 217", "003330976", "dr", "Docent", new ArrayList<Predmet>()));
				profesori.add(new Profesor("Teodor", "Mladenović", sdf.parse("14.12.1983."), "Jovana Subotića 33, Novi Sad", "021/441-007", "teodor.mladenovic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, NTP M35", "007441998", "dr", "Docent", new ArrayList<Predmet>()));
							
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void addProfesor(String ime, String prezime, Date datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String emailAdresa, String adresaKancelarije, String brojLicneKarte, String titula, String zvanje,
			List<Predmet> predmeti) {
		profesori.add(new Profesor(ime, prezime, datumRodjenja, adresaStanovanja, kontaktTelefon, emailAdresa, adresaKancelarije, brojLicneKarte, titula, zvanje, predmeti));
	}
	
	public void editProfesor(String ime, String prezime, Date datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String emailAdresa, String adresaKancelarije, String brojLicneKarte, String titula, String zvanje,
			List<Predmet> predmeti) {
		
		for (Profesor profesor : profesori) {
			if (profesor.getBrojLicneKarte().equals(brojLicneKarte)) {
				profesor.setIme(ime);
				profesor.setPrezime(prezime);
				profesor.setDatumRodjenja(datumRodjenja);
				profesor.setAdresaStanovanja(adresaStanovanja);
				profesor.setKontaktTelefon(kontaktTelefon);
				profesor.setEmailAdresa(emailAdresa);
				profesor.setAdresaKancelarije(adresaKancelarije);
				profesor.setTitula(titula);
				profesor.setZvanje(zvanje);
				profesor.setPredmeti(predmeti);
				break;
			}		
		}
	}
	
	public void deleteProfesor(String brojLicneKarte) {
		
		for (Profesor profesor : profesori) {
			if (profesor.getBrojLicneKarte().equals(brojLicneKarte)) {
				profesori.remove(profesor);
				break;
			}
		}
	}
	
	public void assignPredmetToProfesor(Predmet predmet, Profesor profesor) {
		List<Predmet> predmeti = profesor.getPredmeti();
		if (!predmeti.contains(predmet))
			predmeti.add(predmet);
		
		profesori.get(getProfesorRow(profesor.getBrojLicneKarte())).setPredmeti(predmeti);
	}
	
	public void removePredmetFromProfesor(Predmet predmet, Profesor profesor) {
		if (profesor != null) {
			List<Predmet> predmeti = profesor.getPredmeti();
			predmeti.remove(predmet);
			profesori.get(getProfesorRow(profesor.getBrojLicneKarte())).setPredmeti(predmeti);
		}
	}
	
	public List<Predmet> getPredmeti(int row) {
		return profesori.get(row).getPredmeti();
	}
	
	public int getColumnCount() {
		return columns.size() - 1;
	}
	
	public List<String> getColumns() {
		return columns;
	}
	
	public List<Profesor> getProfesori() {
		return profesori;
	}
	
	public Profesor getProfesorById(String brojLicneKarte) {
		for (Profesor profesor : profesori)
			if (profesor.getBrojLicneKarte().equals(brojLicneKarte.trim()))
				return profesor;
		
		return null;
	}
	
	public Profesor getRow(int row) {
		return profesori.get(row);
	}
	
	public Boolean exists(String brojLicneKarte) {
		
		for (Profesor profesor : profesori)
			if (profesor.getBrojLicneKarte().equals(brojLicneKarte.trim()))
				return true;
			
		return false;
	}
	
	public int getProfesorRow(String brojLicneKarte) {
		
		if (brojLicneKarte == null)
			return -1;
		
		for (Profesor profesor : profesori)
			if (profesor.getBrojLicneKarte().equals(brojLicneKarte))
				return profesori.indexOf(profesor);
				
		return -1;
	}
	
	public String getValueAt(int row, int column) {
		Profesor profesor = profesori.get(row);
		
		switch(column) {
			case 0: 
				return profesor.getIme();
			case 1:
				return profesor.getPrezime();
			case 2:
				return sdf.format(profesor.getDatumRodjenja());
			case 3:
				return profesor.getAdresaStanovanja();
			case 4:
				return profesor.getKontaktTelefon();
			case 5:
				return profesor.getEmailAdresa();
			case 6:
				return profesor.getAdresaKancelarije();
			case 7:
				return profesor.getBrojLicneKarte();
			case 8:
				return profesor.getTitula();
			case 9:
				return profesor.getZvanje();
			case 10:
				return "Prikazi";
			default:
				return null;
		}
		
	}
	
	public String prikaziGetValueAt(int row, int column, int index) {
		Predmet predmet = profesori.get(index).getPredmeti().get(row);
		
		switch(column) {
			case 0:
				return predmet.getSifraPredmeta();
			case 1:
				return predmet.getNazivPredmeta();
			default:
				return null;	
		}
	}
	
	public String getColumnName(int index) {
		return columns.get(index);
	}
	
	public void saveProfesorBazaData() {

		try {
			FileOutputStream outFile = new FileOutputStream(dataPath);
			ObjectOutputStream out = new ObjectOutputStream(outFile);
			out.writeObject(profesori);
			out.close();
			outFile.close();
			System.out.println("Profesori sacuvani.");
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	@SuppressWarnings("unchecked")
	public List<Profesor> loadProfesorBazaData(File dataFile) {
		List<Profesor> ret = null;
		
		try {
			FileInputStream inFile = new FileInputStream(dataFile);
			ObjectInputStream in = new ObjectInputStream(inFile);
			ret = (List<Profesor>) in.readObject();
			in.close();
			inFile.close();
			System.out.println("Profesori ucitani.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return ret;
	}
}
