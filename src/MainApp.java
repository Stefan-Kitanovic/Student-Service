import controller.PredmetController;
import model.PredmetBaza;
import view.MainFrame;

public class MainApp {

	public static void main(String[] args) {	
		PredmetBaza.getInstance();
		//PredmetController.getInstance();
		MainFrame.getInstance();		
	}

}
