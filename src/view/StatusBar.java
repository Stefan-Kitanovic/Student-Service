package view;

import java.awt.FlowLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class StatusBar extends JMenuBar{
	
	private static final long serialVersionUID = -7960319300551657388L;
	
	public StatusBar() {
		JLabel name = new JLabel("Studentska služba");
		DateFormat df = new SimpleDateFormat("HH:mm      dd-MM-yyyy.   ");
		Date date = new Date();
		JLabel time = new JLabel(df.format(date));
		
		JPanel leftSide = new JPanel();
		leftSide.setLayout(new FlowLayout(FlowLayout.LEFT));
		leftSide.add(name);
		
		add(leftSide);
		
		JPanel rightSide = new JPanel();
		rightSide.setLayout(new FlowLayout(FlowLayout.RIGHT));
		rightSide.add(time);
		
		add(rightSide);
	}
	
}
