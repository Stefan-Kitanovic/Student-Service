package model;

public class Predmet {

	private String sifraPredmeta;
	private String nazivPredmeta;
	private String semestar;
	private String godinaStudija;
	private Profesor predmetniProfesor;
	//private List<Student> spisakStudenata;
	
	public Predmet() {}
	
	public Predmet(String sifraPredmeta, String nazivPredmeta, String semestar, String godinaStudija,
			Profesor predmetniProfesor) {
		super();
		this.sifraPredmeta = sifraPredmeta;
		this.nazivPredmeta = nazivPredmeta;
		this.semestar = semestar;
		this.godinaStudija = godinaStudija;
		this.predmetniProfesor = predmetniProfesor;		
	}
	
	public String getSifraPredmeta() {
		return sifraPredmeta;
	}
	
	public String getNazivPredmeta() {
		return nazivPredmeta;
	}
	
	public String getSemestar() {
		return semestar;
	}
	
	public String getGodinaStudija() {
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
	
	public void setSemestar(String semestar) {
		this.semestar = semestar;
	}
	
	public void setGodinaStudija(String godinaStudija) {
		this.godinaStudija = godinaStudija;
	}
	
	public void setPredmetniProfesor(Profesor predmetniProfesor) {
		this.predmetniProfesor = predmetniProfesor;
	}
	
}
