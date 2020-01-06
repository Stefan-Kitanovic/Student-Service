package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class Toolbar extends JToolBar {

	public Toolbar(int height) {		
		super(SwingConstants.HORIZONTAL);
		int width = height;
		
		JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		JButton btnNew = new JButton();
		btnNew.setIcon(new ImageIcon(new ImageIcon("icons/add.png").getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH)));
		
		JButton btnEdit = new JButton();
		btnEdit.setIcon(new ImageIcon(new ImageIcon("icons/edit.png").getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH)));
		
		JButton btnDelete = new JButton();
		btnDelete.setIcon(new ImageIcon(new ImageIcon("icons/delete.png").getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH)));
		
		leftPanel.add(btnNew);
		leftPanel.add(btnEdit);
		leftPanel.add(btnDelete);
		
		JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		JButton btnSearch = new JButton();
		btnSearch.setIcon(new ImageIcon(new ImageIcon("icons/search.png").getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH)));
		
		JTextField searchBar = new JTextField();
		searchBar.setPreferredSize(new Dimension(5*width, height));
		
		rightPanel.add(searchBar);
		rightPanel.add(btnSearch);
		
		add(leftPanel);
		add(rightPanel);
	}
	
}
