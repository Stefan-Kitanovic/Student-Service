package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.StudentController;
import model.PredmetBaza;
import model.StudentBaza;


public class DialogAddStudentToPredmet extends JDialog{

	private static final long serialVersionUID = -8048892395810344831L;

	public DialogAddStudentToPredmet(int row) {
		super(MainFrame.getInstance(), "Predmet - dodavanje studenta ", true);
		
		setLayout(new BorderLayout());
		
		Dimension mainFrameSize = MainFrame.getInstance().getFrameSize();
		int width = (int) (mainFrameSize.width*0.3);
		int height = (int) (mainFrameSize.height*0.2);
		
		setSize(width, height);
		setResizable(false);
		setLocationRelativeTo(MainFrame.getInstance());
		
		JPanel textPart = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		JLabel lindex = new JLabel("Indeks studenta *");
		lindex.setPreferredSize(new Dimension((int)(width*0.4), 20));
		JTextField index = new JTextField();
		index.setPreferredSize(new Dimension((int)(width*0.5), 20));
		
		
		JPanel buttonPart = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		JButton ok = new JButton("Potvrdi");
		JButton close = new JButton("Odustani");
		
		ok.setEnabled(false);
		
		KeyListener fix = new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {}
			
			@Override
			public void keyReleased(KeyEvent e) {
				String id = index.getText().trim();
				if(id.isEmpty() || !StudentBaza.getInstance().studentExists(id)){
					ok.setEnabled(false);
				}else if(StudentBaza.getInstance().getById(id).getGodina() != PredmetBaza.getInstance().getPredmeti().get(row).getGodinaStudija()) {
					ok.setEnabled(false);
				}else
					ok.setEnabled(true);	
			}
			
			@Override
			public void keyPressed(KeyEvent e) {}
		};
		
		index.addKeyListener(fix);
		
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				StudentController.getInstance().addStudentToPredmet(index.getText().trim(), row);
				dispose();
			}
		});
		
		close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
		textPart.add(lindex);
		textPart.add(index);
		
		buttonPart.add(ok);
		buttonPart.add(close);
		
		add(textPart, BorderLayout.CENTER);
		add(buttonPart, BorderLayout.SOUTH);
	}
}
