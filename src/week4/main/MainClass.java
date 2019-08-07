package week4.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import week3.database.Database;
import week3.model.Vertex;

public class MainClass extends JFrame implements ActionListener {

	public MainClass() {
		super("Main Frame");
		JPanel panel=new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JButton addVertex = new JButton("Add New Vertex");
		addVertex.addActionListener(this);
		addVertex.setActionCommand("Add");
		JButton viewAll = new JButton("View all Vertex");
		viewAll.addActionListener(this);
		viewAll.setActionCommand("viewall");
		JButton searchVertex = new JButton("Search Vertex");
		searchVertex.addActionListener(this);
		searchVertex.setActionCommand("search");
		panel.add(addVertex);
		panel.add(viewAll);
		panel.add(searchVertex);
		add(panel);
	
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

	public static void main(String[] args) throws SQLException {
		new MainClass();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getActionCommand().equals("Add")) {
			new AddVertex(this);
			setVisible(false);
			//dispose(); 
			
			 

		} else if (e.getActionCommand().equals("viewall")) {
			new ListAllVertex(this);
			setVisible(false);

		} else if (e.getActionCommand().equals("search")) {
			new SearchVertex(this);
			setVisible(false);
			
		}
	}
}
