package model;

import java.util.List;

public class Profesor {

	private String ime;
	private String prezime;
	private String datumRodjenja;
	private String adresaStanovanja;
	private String kontaktTelefon;
	private String emailAdresa;
	private String adresaKancelarije;
	private long brojLicneKarte;
	private String titula;
	private String zvanje;
	private List<Predmet> predmeti;
	
	public Profesor() {}

	public Profesor(String ime, String prezime, String datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String emailAdresa, String adresaKancelarije, long brojLicneKarte, String titula, String zvanje,
			List<Predmet> predmeti) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumRodjenja;
		this.adresaStanovanja = adresaStanovanja;
		this.kontaktTelefon = kontaktTelefon;
		this.emailAdresa = emailAdresa;
		this.adresaKancelarije = adresaKancelarije;
		this.brojLicneKarte = brojLicneKarte;
		this.titula = titula;
		this.zvanje = zvanje;
		this.predmeti = predmeti;
	}

	public String getIme() {
		return ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public String getDatumRodjenja() {
		return datumRodjenja;
	}

	public String getAdresaStanovanja() {
		return adresaStanovanja;
	}

	public String getKontaktTelefon() {
		return kontaktTelefon;
	}

	public String getEmailAdresa() {
		return emailAdresa;
	}

	public String getAdresaKancelarije() {
		return adresaKancelarije;
	}

	public long getBrojLicneKarte() {
		return brojLicneKarte;
	}

	public String getTitula() {
		return titula;
	}

	public String getZvanje() {
		return zvanje;
	}

	public List<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public void setDatumRodjenja(String datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public void setAdresaStanovanja(String adresaStanovanja) {
		this.adresaStanovanja = adresaStanovanja;
	}

	public void setKontaktTelefon(String kontaktTelefon) {
		this.kontaktTelefon = kontaktTelefon;
	}

	public void setEmailAdresa(String emailAdresa) {
		this.emailAdresa = emailAdresa;
	}

	public void setAdresaKancelarije(String adresaKancelarije) {
		this.adresaKancelarije = adresaKancelarije;
	}

	public void setBrojLicneKarte(long brojLicneKarte) {
		this.brojLicneKarte = brojLicneKarte;
	}

	public void setTitula(String titula) {
		this.titula = titula;
	}

	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}

	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}
	
}
