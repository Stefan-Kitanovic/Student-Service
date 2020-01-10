package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.Timer;

public class StatusBar extends JMenuBar{
	
	private static final long serialVersionUID = -7960319300551657388L;
	
	public StatusBar() {
		JLabel name = new JLabel("Studentska služba");
		JLabel time = new JLabel();
		
		Timer timer = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Date date = new Date();
				DateFormat df = new SimpleDateFormat("HH:mm:ss      dd.MM.yyyy.   ");
				time.setText(df.format(date));
			}
		});
		
		timer.start();
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
