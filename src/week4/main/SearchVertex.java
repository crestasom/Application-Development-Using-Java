package week4.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import week4.database.Database;
import week4.model.Vertex;

public class SearchVertex extends JFrame implements ActionListener {

	Database db;
	JPanel mainPanel, panel1;
	JLabel searchByLbl, idLbl, nameLbl, latLbl, longLbl;
	JComboBox<String> searchBy;
	JTextField searchByInput;
	MainClass obj;
	JButton search, back;

	public SearchVertex(MainClass obj) {
		super("Search Vertex");
		this.obj = obj;
		try {
			db = new Database();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initializeAllComponent();
		add(mainPanel);
		pack();

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void initializeAllComponent() {
		// TODO Auto-generated method stub
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

		panel1 = new JPanel();
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
		searchByLbl = new JLabel("Search By");
		panel1.add(searchByLbl);

		searchBy = new JComboBox<String>();
		searchBy.addItem("Id");
		searchBy.addItem("Name");
		panel1.add(searchBy);

		searchByInput = new JTextField(10);
		panel1.add(searchByInput);

		search = new JButton("Search");
		search.addActionListener(this);
		panel1.add(search);

		mainPanel.add(panel1);

		idLbl = new JLabel("ID: ");
		mainPanel.add(idLbl);

		nameLbl = new JLabel("Name: ");
		mainPanel.add(nameLbl);

		latLbl = new JLabel("Latitude: ");
		mainPanel.add(latLbl);

		longLbl = new JLabel("Longitude: ");
		mainPanel.add(longLbl);

		back = new JButton("Go back");
		back.addActionListener(this);
		mainPanel.add(back);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource().equals(search)) {
			int choice = searchBy.getSelectedIndex();
			switch (choice) {
			case 0:
				int id = Integer.parseInt(searchByInput.getText());
				try {

					Vertex v = db.getVertex(id);
					if (v != null) {
						idLbl.setText("ID: " + v.getId());
						nameLbl.setText("Name: " + v.getName());
						latLbl.setText("Latitude: " + v.getLatitude());
						longLbl.setText("Longitude: " + v.getLongitude());
					} else {
						JOptionPane.showMessageDialog(null, "No vertex found with such id");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 1:
				String input = searchByInput.getText();
				try {
					Vertex v = db.getVertexByName(input);
					if (v != null) {
						idLbl.setText("ID: " + v.getId());
						nameLbl.setText("Name: " + v.getName());
						latLbl.setText("Latitude: " + v.getLatitude());
						longLbl.setText("Longitude: " + v.getLongitude());
					} else {
						JOptionPane.showMessageDialog(null, "No vertex found with such name");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}

		} else if (arg0.getSource().equals(back)) {
			setVisible(false);
			obj.setVisible(true);
			db.close();
			dispose();
		}
	}
}
