import javax.swing.JFrame;
import javax.swing.table.TableModel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class contacts extends JFrame {
	JScrollPane leftPanel;
	JPanel  rightPanel;
	
	private boolean DEBUG = false;
	
	public contacts() {
		String[] names = {
				"Fname", "Phone"
		};
		
		
		Object[][] list = { 
				{"Maina", "Semaje"}
				
		};
		
		JTable table = new JTable( list, names);
		table.setPreferredScrollableViewportSize(getMaximumSize());
		table.setFillsViewportHeight(true);
		
		leftPanel = new JScrollPane (table);
		leftPanel.setSize(250, 780);
		
		rightPanel = new JPanel();
		rightPanel.setSize(400, 780);
		rightPanel.setBackground(new java.awt.Color(192, 192, 192));
		
		add(leftPanel);
		add(rightPanel);
		setSize(780, 650);
		setResizable(false);
		setVisible(true);
		//pack();
	}
	
	
	public static void main(String[] args) {
		new contacts();
	}
	

}
