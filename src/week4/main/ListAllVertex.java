package week4.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import week4.database.Database;
import week4.model.Vertex;

public class ListAllVertex extends JFrame implements ActionListener {
	DefaultTableModel vertexModel;
	JTable vertexTable;
	JScrollPane scroll;
	List<Vertex> vList;
	Database db;
	MainClass obj;

	public ListAllVertex(MainClass obj) {
		super("All Vertex List");
		this.obj = obj;
		TitledBorder title = new TitledBorder("Vertex List:");
		String columnNames[] = { "ID", "Name", "Latitude", "Longitude" };
		vertexModel = new DefaultTableModel(columnNames, 30);
		vertexTable = new JTable(vertexModel);
		try {
			db = new Database();
			vList = db.getAllVertex();
			int i = 0;
			for (Vertex v : vList) {
				vertexModel.insertRow(i++, new Object[] { v.getId(), v.getName(), v.getLatitude(), v.getLongitude() });
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		scroll = new JScrollPane(vertexTable);
		scroll.setBorder(title);
		add(scroll);

		JMenuBar menubar = new JMenuBar();
		JMenu menu = new JMenu("File");
		JMenuItem menuItem = new JMenuItem("Back");
		menuItem.addActionListener(this);
		menu.add(menuItem);
		menubar.add(menu);
		setJMenuBar(menubar);

		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		setVisible(false);
		obj.setVisible(true);
		db.close();
		dispose();
	}

}
