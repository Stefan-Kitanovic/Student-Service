package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class ButtonColumnStudent extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, MouseListener{

	private static final long serialVersionUID = 8942329594111104057L;
	
	private JTable table;
	private JButton renderbutton;
	private JButton editorbutton;
	
	private boolean isEditorActive = false;
	
	public ButtonColumnStudent (JTable table, int column) {
		this.table = table;
		this.table.getColumnModel().getColumn(column).setCellRenderer(this);
		this.table.getColumnModel().getColumn(column).setCellEditor(this);
		this.table.addMouseListener(this);
		
		this.renderbutton = new JButton("Prikaži");
		this.editorbutton = new JButton("Prikaži");
		
		this.editorbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fireEditingStopped();
				new StudentPrikaziFrame();
			}
		});
		
		this.isEditorActive = false;
		
	}

	@Override
	public Object getCellEditorValue() {
		return null;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {

		return this.editorbutton;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		
		return this.renderbutton;
	}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		if(table.isEditing() && table.getCellEditor() == this)
			this.isEditorActive = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(isEditorActive && table.isEditing())
			table.getCellEditor().stopCellEditing();
		isEditorActive = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
}
