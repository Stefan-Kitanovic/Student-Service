package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

import com.sun.glass.events.KeyEvent;

import controller.PredmetController;
import model.PredmetBaza;

public class Toolbar extends JToolBar {

	private static final long serialVersionUID = 3857751384023571451L;

	private JButton btnAddStudentToPredmet;
	private JButton btnAddProfesorToPredmet;
	private JButton btnNew;
	private JButton btnEdit;
	private JButton btnDelete;
	private JButton btnSearch;
	private JButton btnRemoveProfesorFromPredmet;
	
	public Toolbar(int height) {		
		super(SwingConstants.HORIZONTAL);
		int width = height;
		
		JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));		
		JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
	
		Action addNew = new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				switch(MainFrame.getInstance().getSelectedTab()) {
				case 0:
					DialogAddEditStudent dialogStudent = new DialogAddEditStudent(true, null);
					dialogStudent.setVisible(true);
					break;
				case 1:
					//Operacije sa profesorima
					break;
				case 2:
					DialogAddEditPredmet dialogPredmet = new DialogAddEditPredmet(true, MainFrame.getInstance().getSelectedPredmetRow());
					dialogPredmet.setVisible(true);
					break;
			}
				
			}
		};
		
		btnNew = new JButton(addNew);
		btnNew.setIcon(new ImageIcon(new ImageIcon("icons/add.png").getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH)));
		
		btnNew.getActionMap().put("addNew", addNew);
		btnNew.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK), "addNew");
		
		Action edit = new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				switch(MainFrame.getInstance().getSelectedTab()) {
				case 0:
					//Operacije sa studentima
					break;
				case 1:
					//Operacije sa profesorima
					break;
				case 2:
					if (MainFrame.getInstance().getSelectedPredmetRow() < 0)
						break;
					
					DialogAddEditPredmet dialogPredmet = new DialogAddEditPredmet(false, MainFrame.getInstance().getSelectedPredmetRow());
					dialogPredmet.setVisible(true);
					break;
			}
				
			}
		};
		
		btnEdit = new JButton(edit);
		btnEdit.setIcon(new ImageIcon(new ImageIcon("icons/edit.png").getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH)));	
		
		btnEdit.getActionMap().put("edit", edit);
		btnEdit.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK), "edit");
		
		Action delete = new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				switch(MainFrame.getInstance().getSelectedTab()) {
				case 0:
					//Operacije sa studentima
					break;
				case 1:
					//Operacije sa profesorima
					break;
				case 2:
					int row = MainFrame.getInstance().getSelectedPredmetRow();
					PredmetController.getInstance().deletePredmet(row);
					break;
			}
				
			}
		};
		
		btnDelete = new JButton(delete);
		btnDelete.setIcon(new ImageIcon(new ImageIcon("icons/delete.png").getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH)));
		
		btnDelete.getActionMap().put("delete", delete);
		btnDelete.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK), "delete");
		
		Action addStudentToPredmet = new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (MainFrame.getInstance().getSelectedTab() == 2) {
					
				}
				
			}
		};
		
		btnAddStudentToPredmet = new JButton(addStudentToPredmet);
		btnAddStudentToPredmet.setIcon(new ImageIcon(new ImageIcon("icons/add.png").getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH)));
		btnAddStudentToPredmet.setToolTipText("Dodavanje studenta na izabrani predmet");
		btnAddStudentToPredmet.setVisible(false);
		
		btnAddStudentToPredmet.getActionMap().put("addStudentToPredmet", addStudentToPredmet);
		btnAddStudentToPredmet.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK), "addStudentToPredmet");

		Action addProfesorToPredmet = new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (MainFrame.getInstance().getSelectedTab() == 2) {
					if (MainFrame.getInstance().getSelectedPredmetRow() < 0)
						return;
					
					if (PredmetBaza.getInstance().getRow(MainFrame.getInstance().getSelectedPredmetRow()).getPredmetniProfesor() != null) {
						JOptionPane.showMessageDialog(MainFrame.getInstance(), "Predmet vec ima profesora!");
					} else {
						DialogAddProfesorToPredmet dialogProfesorToPredmet = new DialogAddProfesorToPredmet(MainFrame.getInstance().getSelectedPredmetRow());
						dialogProfesorToPredmet.setVisible(true);						
					}
					
				}
				
			}
		};
		
		btnAddProfesorToPredmet = new JButton(addProfesorToPredmet);
		btnAddProfesorToPredmet.setIcon(new ImageIcon(new ImageIcon("icons/add.png").getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH)));
		btnAddProfesorToPredmet.setToolTipText("Dodavanje profesora na izabrani predmet");
		btnAddProfesorToPredmet.setVisible(false);
		
		btnAddProfesorToPredmet.getActionMap().put("addProfesorToPredmet", addProfesorToPredmet);
		btnAddProfesorToPredmet.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK), "addProfesorToPredmet");
		
		Action removeProfesorFromPredmet = new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (MainFrame.getInstance().getSelectedTab() == 2) {
					if (MainFrame.getInstance().getSelectedPredmetRow() < 0)
						return;
					
					PredmetBaza.getInstance().removeProfesorFromPredmet(MainFrame.getInstance().getSelectedPredmetRow());
				}			
			}
		};
		
		btnRemoveProfesorFromPredmet = new JButton(removeProfesorFromPredmet);
		btnRemoveProfesorFromPredmet.setIcon(new ImageIcon(new ImageIcon("icons/close.png").getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH)));
		btnRemoveProfesorFromPredmet.setToolTipText("Uklanjanje profesora sa izabranog predmeta");
		btnRemoveProfesorFromPredmet.setVisible(false);
		
		btnRemoveProfesorFromPredmet.getActionMap().put("removeProfesorFromPredmet", removeProfesorFromPredmet);
		btnRemoveProfesorFromPredmet.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK), "removeProfesorFromPredmet");
		
		btnSearch = new JButton();
		btnSearch.setIcon(new ImageIcon(new ImageIcon("icons/search.png").getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH)));
		btnSearch.setToolTipText("Pretraga");
		
		JTextField searchBar = new JTextField();
		searchBar.setPreferredSize(new Dimension(5*width, height));
		
		setTooltips();
		
		leftPanel.add(btnNew);
		leftPanel.add(btnEdit);
		leftPanel.add(btnDelete);
		leftPanel.add(btnAddStudentToPredmet);
		leftPanel.add(btnAddProfesorToPredmet);
		leftPanel.add(btnRemoveProfesorFromPredmet);
		
		rightPanel.add(searchBar);
		rightPanel.add(btnSearch);
		
		add(leftPanel);
		add(rightPanel);
	}

	public void setBtnAddStudentToPredmetVisible(Boolean flag) {
		this.btnAddStudentToPredmet.setVisible(flag);
	}

	public void setBtnAddProfesorToPredmetVisible(Boolean flag) {
		this.btnAddProfesorToPredmet.setVisible(flag);
	}
	
	public void setBtnRemoveProfesorFromPredmet(Boolean flag) {
		this.btnRemoveProfesorFromPredmet.setVisible(flag);
	}
	
	public void setTooltips() {
		btnNew.setToolTipText("Dodavanje novog " + MainFrame.getSelectedTabName() + "a u sistem");
		btnEdit.setToolTipText("Izmena postojeceg " + MainFrame.getSelectedTabName() + "a u sistemu");
		btnDelete.setToolTipText("Brisanje " + MainFrame.getSelectedTabName() + "a iz sistema");
	}
	
}
