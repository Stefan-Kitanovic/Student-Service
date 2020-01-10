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
			loadStudentDataBase();
		else {
			try {
				studenti.add(new Student("Luka", "Jovanovic", sdf.parse("01.01.2000."), "Karadjordjeva 83, Novi Sad", "021/333-555", "luka.jovanovic@mailinator.com", "RA 1/2019", sdf.parse("01.07.2019."), Godina.I, Status.B, 0, new ArrayList<Predmet>()));
				studenti.add(new Student("Sofija", "Petrovic", sdf.parse("16.05.2000."), "Milosa Pocerca 55, Sabac", "015/343-356", "sofija.petrovic@mailinator.com", "RA 5/2019", sdf.parse("11.07.2019."), Godina.I, Status.B, 0, new ArrayList<Predmet>()));
				studenti.add(new Student("Stefan", "Nikolic", sdf.parse("18.03.2000."), "Knez Mihajlova 16, Beograd", "011/9234-857", "stefan.nikolic@mailinator.com", "RA 3/2019", sdf.parse("03.07.2019."), Godina.I, Status.B, 0, new ArrayList<Predmet>()));
				studenti.add(new Student("Dunja", "Ilic", sdf.parse("11.11.2000."), "Petefi Sandora 15, Novi Sad", "021/433-958", "dunja.ilic@mailinator.com", "RA 2/2019", sdf.parse("01.07.2019."), Godina.I, Status.S, 0, new ArrayList<Predmet>()));
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
			return student.getGodina();
		case 9:
			return student.getStatus();
		case 10:
			return student.getProsek();
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
