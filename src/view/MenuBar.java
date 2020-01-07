package view;

import java.awt.Frame;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import com.sun.glass.events.KeyEvent;


public class MenuBar extends JMenuBar {

	private static final long serialVersionUID = -111659266189879540L;

	public MenuBar(Frame parent) {
		ImageIcon imgAdd = new ImageIcon("icons/add.png");
		ImageIcon imgClose = new ImageIcon("icons/close.png");
		ImageIcon imgEdit = new ImageIcon("icons/edit.png");
		ImageIcon imgDelete = new ImageIcon("icons/delete.png");
		ImageIcon imgHelp = new ImageIcon("icons/help.png");
		ImageIcon imgAbout = new ImageIcon("icons/about.png");
		
		//file
		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		JMenuItem miNew = new JMenuItem("New");
		miNew.setIcon(new ImageIcon(imgAdd.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH)));
		miNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		JMenuItem miClose = new JMenuItem("Close");
		miClose.setIcon(new ImageIcon(imgClose.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH)));
		miClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		
		file.add(miNew);
		file.add(miClose);
		
		//edit
		JMenu edit = new JMenu("Edit");
		edit.setMnemonic(KeyEvent.VK_E);
		JMenuItem miEdit = new JMenuItem("Edit");
		miEdit.setIcon(new ImageIcon(imgEdit.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH)));
		miEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		JMenuItem miDelete = new JMenuItem("Delete");
		miDelete.setIcon(new ImageIcon(imgDelete.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH)));
		miDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		
		edit.add(miEdit);
		edit.add(miDelete);
		
		//help
		JMenu help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_H);
		JMenuItem miHelp = new JMenuItem("Help");
		miHelp.setIcon(new ImageIcon(imgHelp.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH)));
		miHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		JMenuItem miAbout = new JMenuItem("About");
		miAbout.setIcon(new ImageIcon(imgAbout.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH)));
		miAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
		
		help.add(miHelp);
		help.add(miAbout);
		
		add(file);
		add(edit);
		add(help);
	}
}