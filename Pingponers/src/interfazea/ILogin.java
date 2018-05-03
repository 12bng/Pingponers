package interfazea;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Kodea.Main;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ILogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ILogin frame = new ILogin();
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
	public ILogin() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 271, 215);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblIzena = new JLabel("Izena:");
		lblIzena.setBounds(27, 28, 46, 14);
		panel.add(lblIzena);
		
		textField = new JTextField();
		textField.setBounds(114, 25, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblPasahitza = new JLabel("Pasahitza:");
		lblPasahitza.setBounds(27, 62, 64, 14);
		panel.add(lblPasahitza);
		
		textField_1 = new JTextField();
		textField_1.setBounds(114, 59, 86, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSartu = new JButton("Sartu");
		btnSartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Main.getMain().login(textField.getText(), textField_1.getText())) {
					dispose();
				}
			}
		});
		btnSartu.setBounds(27, 121, 89, 23);
		panel.add(btnSartu);
		
		JButton btnErabiltzaileBerria = new JButton("Berria");
		btnErabiltzaileBerria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnErabiltzaileBerria.setBounds(138, 121, 89, 23);
		panel.add(btnErabiltzaileBerria);
	}
}
