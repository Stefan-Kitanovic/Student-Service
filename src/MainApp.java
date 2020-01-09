import controller.PredmetController;
import model.PredmetBaza;
import model.StudentBaza;
import view.MainFrame;

public class MainApp {

	public static void main(String[] args) {
		StudentBaza.getInstance();
		PredmetBaza.getInstance();
		PredmetController.getInstance();
		MainFrame.getInstance();		
	}

}
