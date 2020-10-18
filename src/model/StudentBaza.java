package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

public class StudentBaza extends JTable implements Serializable{

	private static final long serialVersionUID = 3646946754707848800L;
	
	final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
	private static final File studentDB = new File("data/StudentData.data");
	
	private static StudentBaza instance = null;
	
	public static StudentBaza getInstance() {
		if(instance == null)
			instance = new StudentBaza();
		return instance;
	}
	
	private static String[] columnName = {"Index", "Ime", "Prezime", "Datum rodjenja", "Adresa", "Telefon", "E-mail", "Datum upisa", "Godina studija", "Status", "Prosek",};
	private List<Student> studenti = new ArrayList<Student>();
	
	private StudentBaza() {
		
		if(studentDB.exists())
			studenti = loadStudentDataBase();
		else {
			try {
				studenti.add(new Student("Luka", "Jovanovic", sdf.parse("01.01.2000."), "Karadjordjeva 83, Novi Sad", "021/333-555", "luka.jovanovic@mailinator.com", "RA 1/2019", sdf.parse("01.07.2019."), Godina.I, Status.B, 0, new ArrayList<Predmet>()));
				studenti.add(new Student("Sofija", "Petrovic", sdf.parse("16.05.2000."), "Milosa Pocerca 55, Sabac", "015/343-356", "sofija.petrovic@mailinator.com", "RA 5/2019", sdf.parse("11.07.2019."), Godina.I, Status.B, 0, new ArrayList<Predmet>()));
				studenti.add(new Student("Stefan", "Nikolic", sdf.parse("18.03.2000."), "Knez Mihajlova 16, Beograd", "011/9234-857", "stefan.nikolic@mailinator.com", "RA 3/2019", sdf.parse("03.07.2019."), Godina.I, Status.B, 0, new ArrayList<Predmet>()));
				studenti.add(new Student("Dunja", "Ilic", sdf.parse("11.11.2000."), "Petefi Sandora 15, Novi Sad", "021/433-958", "dunja.ilic@mailinator.com", "RA 2/2019", sdf.parse("01.07.2019."), Godina.I, Status.S, 0, new ArrayList<Predmet>()));
				studenti.add(new Student("Lazar", "Djordjevic", sdf.parse("03.12.2000."), "Josip Broz Tito 13, Subotica", "024/333-559", "lazar.djordjevic@mailinator.com", "RA 4/2019", sdf.parse("06.07.2019."), Godina.I, Status.S, 0, new ArrayList<Predmet>()));
				
				studenti.add(new Student("Sara", "Pavlovic", sdf.parse("03.12.1999."), "Vojvode Misica 23, Sabac", "015/313-061", "sara.pavlovic@mailinator.com", "RA 3/2018", sdf.parse("01.07.2018."), Godina.II, Status.B, 0, new ArrayList<Predmet>()));
				studenti.add(new Student("Vuk", "Markovic", sdf.parse("03.12.1999."), "Temerinska 133, Novi Sad", "021/351-091", "vuk.markovic@mailinator.com", "RA 15/2018", sdf.parse("11.07.2018."), Godina.II, Status.B, 0, new ArrayList<Predmet>()));
				studenti.add(new Student("Teodora", "Popovic", sdf.parse("03.12.1998."), "Surepova 15, Sabac", "015/324-500", "teodora.popovic@mailinator.com", "RA 133/2017", sdf.parse("03.07.2017."), Godina.II, Status.S, 0, new ArrayList<Predmet>()));
				studenti.add(new Student("Filip", "Stojanovic", sdf.parse("03.12.1998."), "Francuska 113, Beograd", "011/2333-900", "filip.stojanovic@mailinator.com", "RA 122/2017", sdf.parse("02.07.2017."), Godina.II, Status.S, 0, new ArrayList<Predmet>()));
				studenti.add(new Student("Ana", "Zivkovic", sdf.parse("03.12.1998."), "Kralja Petra 20, Novi Sad", "021/231-114", "ana.zivkovic@mailinator.com", "RA 201/2017", sdf.parse("04.07.2017."), Godina.II, Status.S, 0, new ArrayList<Predmet>()));
				
				studenti.add(new Student("Viktor", "Jankovic", sdf.parse("03.12.1998."), "Gogoljeva 3, Novi Sad", "021/135-463", "viktor.jankovic@mailinator.com", "RA 1/2017", sdf.parse("01.07.2017."), Godina.III, Status.B, 0, new ArrayList<Predmet>()));
				studenti.add(new Student("Petra", "Todorovic", sdf.parse("03.12.1998."), "Njegoseva 2, Novi Sad", "021/903-463", "petra.todorovic@mailinator.com", "RA 5/2017", sdf.parse("12.07.2017."), Godina.III, Status.B, 0, new ArrayList<Predmet>()));
				studenti.add(new Student("Andrej", "Stankovic", sdf.parse("03.12.1998."), "Radoja Domanovica 5, Novi Sad", "021/731-067", "andrej.stankovic@mailinator.com", "RA 33/2017", sdf.parse("19.07.2017."), Godina.III, Status.B, 0, new ArrayList<Predmet>()));
				studenti.add(new Student("Mila", "Ristic", sdf.parse("03.12.1997."), "Vojvode Stepe 183, Beograd", "011/4333-800", "mila.ristic@mailinator.com", "RA 152/2016", sdf.parse("15.07.2016."), Godina.III, Status.S, 0, new ArrayList<Predmet>()));
				studenti.add(new Student("Pavle", "Kostic", sdf.parse("03.12.1997."), "Crnotravska 13, Beograd", "011/3130-007", "pavle.kostic@mailinator.com", "RA 104/2016", sdf.parse("06.07.2016."), Godina.III, Status.S, 0, new ArrayList<Predmet>()));
				
				studenti.add(new Student("Lena", "Kovacevic", sdf.parse("03.12.1997."), "Bulevar Oslobodjenja 143, Novi Sad", "021/5333-801", "lena.kovacevic@mailinator.com", "RA 1/2016", sdf.parse("01.07.2016."), Godina.IV, Status.B, 0, new ArrayList<Predmet>()));
				studenti.add(new Student("Filip", "Zivkovic", sdf.parse("03.12.1997."), "1300 Kaplara , Sabac", "015/333-500", "filip.zivkovic@mailinator.com", "RA 5/2016", sdf.parse("21.07.2016."), Godina.IV, Status.B, 0, new ArrayList<Predmet>()));
				studenti.add(new Student("Tara", "Dimitrijevic", sdf.parse("03.12.1996."), "Milovana Glisica , Valjevo", "014/303-007", "tara.dimitrijevic@mailinator.com", "RA 33/2015", sdf.parse("23.07.2015."), Godina.IV, Status.S, 0, new ArrayList<Predmet>()));
				studenti.add(new Student("Vasilije", "Micic", sdf.parse("03.12.1996."), "Vuka Karadzica , Loznica", "015/101-909", "vasilije.micic@mailinator.com", "RA 102/2015", sdf.parse("04.07.2015."), Godina.IV, Status.S, 0, new ArrayList<Predmet>()));
				studenti.add(new Student("Lenka", "Jovic", sdf.parse("03.12.1997."), "Bulevar Mihajla Pupina , Novi Sad", "021/431-500", "lenka.jovic@mailinator.com", "RA 244/2016", sdf.parse("07.07.2016."), Godina.IV, Status.S, 0, new ArrayList<Predmet>()));
			}catch (ParseException e) {
				e.printStackTrace();
			}
			
			
		}
	}
	
	@Override
	public int getRowCount() {
		return studenti.size();
	}

	@Override
	public int getColumnCount() {
		return columnName.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Student student = studenti.get(rowIndex);
		
		switch(columnIndex) {
		case 0:
			return student.getIndex();
		case 1:
			return student.getIme();
		case 2:
			return student.getPrezime();
		case 3:
			return sdf.format(student.getDatumr());
		case 4:
			return student.getAdresa();
		case 5:
			return student.getTel();
		case 6:
			return student.getEmail();
		case 7:
			return sdf.format(student.getDatumu());
		case 8:
			return student.getGodina().toString();
		case 9:
			return student.getStatus().toString();
		case 10:
			double pr = student.getProsek();
			if(pr == 0)
				return "nema prosek";
			else
				return pr;
		case 11:
			return "Detaljnije";
		}
		return null;
	}
	
	@Override
	public String getColumnName(int column) {
		return columnName[column];
	}

	public List<Student> getStudenti(){
		return studenti;
	}
	
	public boolean studentExists(String index) {
		for(Student student : studenti) {
			if(index.trim().equalsIgnoreCase(student.getIndex()))
				return true;
		}
		return false;
	}
	
	public Student getById(String id) {
		for(Student student : studenti) {
			if(id.trim().equalsIgnoreCase(student.getIndex()))
				return student;
		}
		return null;
	}
	
	public int getStudentRow(String id) {
		for(Student student : studenti) {
			if(id.trim().equalsIgnoreCase(student.getIndex()))
				return studenti.indexOf(student);
		}
		return 0;
	}
	
	public void addStudent(Student s) {
		studenti.add(s);
	}
	
	public void editStudent(Student s) {
		for(Student student : studenti) {
			if(student.getIndex().equals(s.getIndex())) {
				student.setIme(s.getIme());
				student.setPrezime(s.getPrezime());
				student.setDatumr(s.getDatumr());
				student.setAdresa(s.getAdresa());
				student.setTel(s.getTel());
				student.setEmail(s.getEmail());
				student.setGodina(s.getGodina());
				student.setStatus(s.getStatus());
				student.setProsek(s.getProsek());
				break;
			}
		}
	}
	
	public void deleteStudent(String index) {
		
		for(Student student : studenti) {
			if(student.getIndex().equals(index)) {
				studenti.remove(student);
				break;
			}
		}
	}
	
	public void assignPredmetToStudent(Student s, Predmet p) {
		List<Predmet> predmeti = s.getPredmeti();
		predmeti.add(p);
		s.setPredmeti(predmeti);
	}
	
	public void removePredmetFromStudent(Student s, Predmet p) {
		List<Predmet> predmeti = s.getPredmeti();
		predmeti.remove(p);
		studenti.get(getStudentRow(s.getIndex())).setPredmeti(predmeti);
	}
	
	public List<Predmet> getPredmetiList(int row) {
		return studenti.get(row).getPredmeti();
	}
	
	public String PredmetListgetValueAt(int row, int column, int index) {
		Predmet predmet = getPredmetiList(index).get(row);
		
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
			default:
				return null;
		}
	}
	
	public void saveStudentDataBase() {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream(studentDB));
			out.writeObject(studenti);
			System.out.println("Studenti sacuvani");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@SuppressWarnings("unchecked")
	public List<Student> loadStudentDataBase(){
		List<Student> retVal = null;
		
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream(studentDB));
			retVal = (List<Student>) in.readObject();
			System.out.println("Studenti ucitani");
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return retVal;
	}
}
