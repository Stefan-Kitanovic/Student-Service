package model;

import java.io.Serializable;
import java.util.List;

public class Predmet implements Serializable{

	private static final long serialVersionUID = 7178432169091971489L;
	
	private String sifraPredmeta;
	private String nazivPredmeta;
	private Semestar semestar;
	private Godina godinaStudija;
	private Profesor predmetniProfesor;
	private List<Student> spisakStudenata;
	
	public Predmet() {}
	
	public Predmet(String sifraPredmeta, String nazivPredmeta, Semestar semestar, Godina godinaStudija,
			Profesor predmetniProfesor, List<Student> spisakStudenata) {
		super();
		this.sifraPredmeta = sifraPredmeta;
		this.nazivPredmeta = nazivPredmeta;
		this.semestar = semestar;
		this.godinaStudija = godinaStudija;
		this.predmetniProfesor = predmetniProfesor;	
		this.spisakStudenata = spisakStudenata;
	}
	
	public String getSifraPredmeta() {
		return sifraPredmeta;
	}
	
	public String getNazivPredmeta() {
		return nazivPredmeta;
	}
	
	public Semestar getSemestar() {
		return semestar;
	}
	
	public Godina getGodinaStudija() {
		return godinaStudija;
	}
	
	public Profesor getPredmetniProfesor() {
		return predmetniProfesor;
	}
	
	public void setSifraPredmeta(String sifraPredmeta) {
		this.sifraPredmeta = sifraPredmeta;
	}
	
	public void setNazivPredmeta(String nazivPredmeta) {
		this.nazivPredmeta = nazivPredmeta;
	}
	
	public void setSemestar(Semestar semestar) {
		this.semestar = semestar;
	}
	
	public void setGodinaStudija(Godina godinaStudija) {
		this.godinaStudija = godinaStudija;
	}
	
	public void setPredmetniProfesor(Profesor predmetniProfesor) {
		this.predmetniProfesor = predmetniProfesor;
	}

	public List<Student> getSpisakStudenata() {
		return spisakStudenata;
	}

	public void setSpisakStudenata(List<Student> spisakStudenata) {
		this.spisakStudenata = spisakStudenata;
	}
	
}
