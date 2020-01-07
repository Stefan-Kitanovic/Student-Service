package controller;


public class StudentController {

	private static StudentController instance = null;
	
	public static StudentController getInstance() {
		if(instance == null)
			instance = new StudentController();
		return instance;
	}
	
	public StudentController() {}
	
	public void addStudent() {
		
	}
	
	public void editStudent() {
		
	}

	public void removeStudent() {
	
	}
}
