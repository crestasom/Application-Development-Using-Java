package week4.main;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import week4.database.Database;
import week4.model.Vertex;

public class AddVertex extends JFrame implements ActionListener {

	JPanel panel1;
	JLabel nameLbl, latLabel, longLbl;
	JTextField name, lati, longi;
	JButton add, cancel;
	Database db;
	MainClass obj;

	public AddVertex(MainClass obj) {

		super("Add New Vertex");
		this.obj = obj;
		try {
			db = new Database();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initializeAll();
		pack();
		setVisible(true);

	}

	public void initializeAll() {
		// TODO Auto-generated method stub
		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(4, 2));

		nameLbl = new JLabel("Name: ");
		panel1.add(nameLbl);
		name = new JTextField(10);
		panel1.add(name);

		latLabel = new JLabel("Latitude: ");
		panel1.add(latLabel);
		lati = new JTextField(10);
		panel1.add(lati);

		longLbl = new JLabel("Name: ");
		panel1.add(longLbl);
		longi = new JTextField(10);
		panel1.add(longi);

		add = new JButton("Add");
		add.addActionListener(this);
		panel1.add(add);

		cancel = new JButton("Cancel");
		cancel.addActionListener(this);
		panel1.add(cancel);

		add(panel1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource().equals(add)) {
			String n = name.getText();
			double latCode = Double.parseDouble(lati.getText());
			double longCode = Double.parseDouble(longi.getText());
			Vertex v = new Vertex(n, latCode, longCode);
			try {
				db.addVertex(v);
				JOptionPane.showMessageDialog(null, "Vertex has been successfully added");
				setVisible(false);
				db.close();
				obj.setVisible(true);
				dispose();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else if (e.getSource().equals(cancel)) {
			setVisible(false);
			obj.setVisible(true);
			db.close();
			dispose();
		}
	}
	
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		System.out.println("closing connection");
		db.close();
	}

}
