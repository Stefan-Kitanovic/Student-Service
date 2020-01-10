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
		
		File data = new File("data/PredmetData.data");
		
		if (data.exists())
			predmeti = loadPredmetBazaData();
		else {
			predmeti.add(new Predmet("test1", "test", "test", Godina.IV, new Profesor("test", "test", "1-2-34", "test test", "test", "test@test", "test 123", 123, "test", "test", new ArrayList<Predmet>()), new ArrayList<Student>()));
			predmeti.add(new Predmet("test2", "test", "test", Godina.IV, new Profesor("test", "test", "1-2-34", "test test", "test", "test@test", "test 123", 123, "test", "test", new ArrayList<Predmet>()), new ArrayList<Student>()));
			predmeti.add(new Predmet("test3", "test", "test", Godina.IV, new Profesor("test", "test", "1-2-34", "test test", "test", "test@test", "test 123", 123, "test", "test", new ArrayList<Predmet>()), new ArrayList<Student>()));
			predmeti.add(new Predmet("test4", "test", "test", Godina.IV, new Profesor("test", "test", "1-2-34", "test test", "test", "test@test", "test 123", 123, "test", "test", new ArrayList<Predmet>()), new ArrayList<Student>()));
			predmeti.add(new Predmet("test5", "test", "test", Godina.IV, new Profesor("test", "test", "1-2-34", "test test", "test", "test@test", "test 123", 123, "test", "test", new ArrayList<Predmet>()), new ArrayList<Student>()));
		}
		
	}
		
	
	public void addPredmet(String sifraPredmeta, String nazivPredmeta, String semestar, Godina godinaStudija,
			Profesor predmetniProfesor, List<Student> spisakStudenata) {
		predmeti.add(new Predmet(sifraPredmeta, nazivPredmeta, semestar, godinaStudija, predmetniProfesor, spisakStudenata));
	}
	
	public void editPredmet(String sifraPredmeta, String nazivPredmeta, String semestar, Godina godinaStudija,
			Profesor predmetniProfesor, List<Student> spisakStudenata) {	
		
		for (Predmet predmet : predmeti) {
			if (predmet.getSifraPredmeta().equals(sifraPredmeta)) {				
				predmet.setNazivPredmeta(nazivPredmeta);
				predmet.setSemestar(semestar);
				predmet.setGodinaStudija(godinaStudija);
				predmet.setPredmetniProfesor(predmetniProfesor);
				predmet.setSpisakStudenata(spisakStudenata);
				break;
			}
		}
	}
	
	public void deletePredmet(String sifraPredmeta) {
		
		for (Predmet predmet : predmeti) {
			if (predmet.getSifraPredmeta().equals(sifraPredmeta)) {
				predmeti.remove(predmet);
				break;
			}
		}
	}
	
	public int getColumnCount() {
		return columns.size();
	}
	
	public List<Predmet> getPredmeti() {
		return predmeti;
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
			return predmet.getSemestar();
		case 3:
			return predmet.getGodinaStudija().toString();
		case 4:
			return predmet.getPredmetniProfesor().getIme() + " " + predmet.getPredmetniProfesor().getPrezime();
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
			FileOutputStream outFile = new FileOutputStream("data/PredmetData.data");
			ObjectOutputStream out = new ObjectOutputStream(outFile);
			out.writeObject(predmeti);
			out.close();
			outFile.close();
			System.out.println("Predmeti sacuvani.");
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public List<Predmet> loadPredmetBazaData() {
		List<Predmet> ret = null;
		
		try {
			FileInputStream inFile = new FileInputStream("data/PredmetData.data");
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
