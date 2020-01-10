package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import model.Status;

public class Student implements Serializable{
	
	private static final long serialVersionUID = 6106609854706792973L;
	
	private String ime;
	private String prezime;
	private Date datumr;
	private String adresa;
	private String tel;
	private String email;
	private String index;
	private Date datumu;
	private Godina godina;
	private Status status;
	private double prosek;
	private List<Predmet> predmeti;
	
	
	public Student(String ime, String prezime, Date datumr, String adresa, String tel, String email, String index,
			Date datumu, Godina godina, Status status, double prosek, List<Predmet> predmeti) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.datumr = datumr;
		this.adresa = adresa;
		this.tel = tel;
		this.email = email;
		this.index = index;
		this.datumu = datumu;
		this.godina = godina;
		this.status = status;
		this.prosek = prosek;
		this.predmeti = predmeti;
	}


	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public Date getDatumr() {
		return datumr;
	}

	public void setDatumr(Date datumr) {
		this.datumr = datumr;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public Date getDatumu() {
		return datumu;
	}

	public void setDatumu(Date datumu) {
		this.datumu = datumu;
	}

	public Godina getGodina() {
		return godina;
	}

	public void setGodina(Godina godina) {
		this.godina = godina;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public double getProsek() {
		return prosek;
	}

	public void setProsek(double prosek) {
		this.prosek = prosek;
	}

	public List<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}
	
	
}
