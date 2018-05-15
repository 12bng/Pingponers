package interfazea;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import konektorea.DBKudeatzailea;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Ranking extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ranking frame = new Ranking();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ranking() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		String[] columnNames = {"Erabiltzailea", "Puntuak"};
		ResultSet rs = DBKudeatzailea.getInstantzia().execSQL("select * from Puntuazioak order by puntuazioa desc limit 10");
		Object[][] data = new Object[10][2];
		try {
			for (int i=0; rs.next(); i++) {
				data[i][0] = rs.getString(2);
				data[i][1] = rs.getString(3);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		table = new JTable(data, columnNames);
		scrollPane.setViewportView(table);
	}

}
