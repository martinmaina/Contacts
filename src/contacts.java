import javax.swing.JFrame;
import java.sql.*;
import javax.swing.table.TableModel;
import Resources.*;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class contacts extends JFrame {
	JScrollPane leftPanel;
	JPanel  rightPanel;
	JPanel topAdd;
	JLabel topAddLabel1, topAddLabel2, rightPanelProfile;
	JTextField search;
	JButton add, topAddCancel, topAddAdd;
	JComboBox emailType, phoneType;
	private boolean DEBUG = false;
	
	public contacts() {
		
		topAdd = new JPanel();
		topAdd.setBounds(0, 0, 780, 35);
		topAdd.setBackground(Color.BLUE);
		topAdd.setVisible(false);
	Object[][] data = {
			{
				"Martin"
			}
	};
		String[] columnName = {
				"Contact Name"
		};
		
		JTable table = new JTable(data, columnName);
		table.setShowGrid(false);
		add = new JButton(new ImageIcon("/root/eclipse-workspace/Contacts/src/Resources/addP.png"));
		add.setSize(35, 35);
		add.setToolTipText("Add A new Contact");
		add.addActionListener((ActionEvent evt) -> {
			search.setVisible(false);
			add.setVisible(false);
			topAdd.setVisible(true);
		});
		search = new JTextField("Search Contact By name");
		search.setForeground(Color.GRAY);
		search.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (search.getText().equals("Search Contact By name")) {
					search.setText("");
					search.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (search.getText().isEmpty()) {
					search.setForeground(Color.GRAY);
					search.setText("Search Contact By name");
					
		
				}
			}
			
		});
	
		
		search.setBounds(35, 0, 215, 35);
		leftPanel = new JScrollPane (table);
		leftPanel.setBounds(0, 35, 250, 780);
		
		rightPanel = new JPanel();
		rightPanel.setSize(400, 760);
		rightPanel.setBackground(new java.awt.Color(192, 192, 192));
		
		add(topAdd);
		add(add);
		add(search);
		add(leftPanel);
		add(rightPanel);
		setTitle("Contacts");
		setSize(780, 650);
		setResizable(false);
		setDefaultCloseOperation(1);
		setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		new contacts();
	}
	
	private void connection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CONTACTS", "root", "");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select fname, phone from CONTACTS");
			
		}
		
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e, "Warning", JOptionPane.ERROR_MESSAGE, null);
		}
	}

}

