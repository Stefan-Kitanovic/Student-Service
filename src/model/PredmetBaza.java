package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PredmetBaza implements Serializable {

	private static final long serialVersionUID = 617024959849324035L;
	
	private static PredmetBaza instance = null;
	private static final String dataPath = "data/PredmetData.data";

	public static PredmetBaza getInstance() {
		if (instance == null) {
			instance = new PredmetBaza();
		}
		return instance;
	}
	
	private List<Predmet> predmeti;
	private List<String> columns;
	
	private PredmetBaza() {	
		predmeti = new ArrayList<Predmet>();
		columns = new ArrayList<String>();
		
		columns.add("Sifra");
		columns.add("Naziv");
		columns.add("Semestar");
		columns.add("Godina");
		columns.add("Profesor");
		columns.add("Studenti");
		
		File dataFile = new File(dataPath);
		
		if (dataFile.exists())
			predmeti = loadPredmetBazaData(dataFile);
		else {
			predmeti.add(new Predmet("test1", "test", Semestar.Letnji, Godina.IV, null, new ArrayList<Student>()));
			predmeti.add(new Predmet("test2", "test", Semestar.Letnji, Godina.IV, null, new ArrayList<Student>()));
			predmeti.add(new Predmet("test3", "test", Semestar.Letnji, Godina.IV, null, new ArrayList<Student>()));
			predmeti.add(new Predmet("test4", "test", Semestar.Letnji, Godina.IV, null, new ArrayList<Student>()));
			predmeti.add(new Predmet("test5", "test", Semestar.Letnji, Godina.IV, null, new ArrayList<Student>()));
		}
		
	}
		
	
	public void addPredmet(String sifraPredmeta, String nazivPredmeta, Semestar semestar, Godina godinaStudija,
			Profesor predmetniProfesor, List<Student> spisakStudenata) {
		predmeti.add(new Predmet(sifraPredmeta, nazivPredmeta, semestar, godinaStudija, predmetniProfesor, spisakStudenata));
	}
	
	public void editPredmet(int index, String sifraPredmeta, String nazivPredmeta, Semestar semestar, Godina godinaStudija,
			Profesor predmetniProfesor) {	
		
		Predmet predmet = predmeti.get(index); 
		
		predmet.setSifraPredmeta(sifraPredmeta);;		
		predmet.setNazivPredmeta(nazivPredmeta);
		predmet.setSemestar(semestar);
		predmet.setGodinaStudija(godinaStudija);
		predmet.setPredmetniProfesor(predmetniProfesor);
	}
	
	public void deletePredmet(String sifraPredmeta) {
		
		for (Predmet predmet : predmeti) {
			if (predmet.getSifraPredmeta().equals(sifraPredmeta)) {
				predmeti.remove(predmet);
				break;
			}
		}
	}
	
	public void addProfesorToPredmet(Profesor profesor, int row) {
		Predmet predmet = predmeti.get(row);
		predmet.setPredmetniProfesor(profesor);
	}
	
	public int getColumnCount() {
		return columns.size() - 1;
	}
	
	public List<Predmet> getPredmeti() {
		return predmeti;
	}
	
	public Boolean predmetExists(String sifraPredmeta) {
		
		for (Predmet predmet : predmeti)
			if (predmet.getSifraPredmeta().equalsIgnoreCase(sifraPredmeta.trim()))
				return true;
		
		return false;
	}
	
	public Predmet getRow(int row) {
		return predmeti.get(row);
	}
	
	public String getValueAt(int row, int column) {
		Predmet predmet = predmeti.get(row);
		
		switch (column) {
			case 0:
				return predmet.getSifraPredmeta();
			case 1:
				return predmet.getNazivPredmeta();
			case 2:
				if (predmet.getSemestar() == Semestar.Zimski)
					return Integer.toString((predmet.getGodinaStudija().ordinal()+1)*2 - 1);
				else
					return Integer.toString((predmet.getGodinaStudija().ordinal()+1)*2);
			case 3:
				return predmet.getGodinaStudija().toString();
			case 4:
				if (predmet.getPredmetniProfesor() == null)
					return "Nema profesora";
				else
					return predmet.getPredmetniProfesor().getPrezime() + " " + predmet.getPredmetniProfesor().getTitula() + " " + predmet.getPredmetniProfesor().getIme();
			case 5:
				return "Prikazi";
			default:
				return null;
		}
	}
	
	public String getColumnName(int index) {
		return columns.get(index);
	}
	
	public void savePredmetaBazaData() {

		try {
			FileOutputStream outFile = new FileOutputStream(dataPath);
			ObjectOutputStream out = new ObjectOutputStream(outFile);
			out.writeObject(predmeti);
			out.close();
			outFile.close();
			System.out.println("Predmeti sacuvani.");
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	@SuppressWarnings("unchecked")
	public List<Predmet> loadPredmetBazaData(File dataFile) {
		List<Predmet> ret = null;
		
		try {
			FileInputStream inFile = new FileInputStream(dataFile);
			ObjectInputStream in = new ObjectInputStream(inFile);
			ret = (List<Predmet>) in.readObject();
			in.close();
			inFile.close();
			System.out.println("Predmeti ucitani.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return ret;
	}
}
