package model;

import java.util.ArrayList;
import java.util.List;

public class PredmetBaza {

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
}
