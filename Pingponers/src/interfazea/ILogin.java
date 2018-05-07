package interfazea;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Kodea.Main;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class ILogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JRadioButton rdbtnCastellano;
	private JRadioButton rdbtnEuskera;
	private ButtonGroup lengoaia;
	private JButton btnSartu;
	private JButton btnErabiltzaileBerria;
	private JLabel lblIzena;
	private JLabel lblPasahitza;

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
		setBounds(100, 100, 458, 215);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		lblIzena = new JLabel("Izena:");
		lblIzena.setBounds(27, 28, 89, 14);
		panel.add(lblIzena);
		
		textField = new JTextField();
		textField.setBounds(141, 25, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		lblPasahitza = new JLabel("Pasahitza:");
		lblPasahitza.setBounds(27, 62, 89, 14);
		panel.add(lblPasahitza);
		
		textField_1 = new JTextField();
		textField_1.setBounds(141, 59, 86, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		btnSartu = new JButton("Sartu");
		btnSartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Main.getMain().login(textField.getText(), textField_1.getText())) {
					if (rdbtnCastellano.isSelected()) {
						Main.getMain().setLengoaia("Castellano");
					}
					else if (rdbtnEuskera.isSelected()) {
						Main.getMain().setLengoaia("Euskera");
					}
					dispose();
				}
			}
		});
		btnSartu.setBounds(27, 121, 89, 23);
		panel.add(btnSartu);
		
		btnErabiltzaileBerria = new JButton("Berria");
		btnErabiltzaileBerria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.getMain().createUser(textField.getText(), textField_1.getText());
			}
		});
		btnErabiltzaileBerria.setBounds(138, 121, 89, 23);
		panel.add(btnErabiltzaileBerria);
		
		rdbtnCastellano = new JRadioButton("Castellano");
		rdbtnCastellano.setBounds(300, 24, 109, 23);
		rdbtnCastellano.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eguneratu();
			}
		});
		panel.add(rdbtnCastellano);
		
		rdbtnEuskera = new JRadioButton("Euskera");
		rdbtnEuskera.setBounds(300, 58, 109, 23);
		rdbtnEuskera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eguneratu();
			}
		});
		panel.add(rdbtnEuskera);
		
		lengoaia = new ButtonGroup();
		lengoaia.add(rdbtnCastellano);
		lengoaia.add(rdbtnEuskera);
		rdbtnEuskera.setSelected(true);
	}
	
	private void eguneratu() {
		if (rdbtnCastellano.isSelected()) {
			btnSartu.setText("Entrar");
			btnErabiltzaileBerria.setText("Nuevo");
			lblIzena.setText("Nombre");
			lblPasahitza.setText("Contraseña");
		}
		else if (rdbtnEuskera.isSelected()) {
			btnSartu.setText("Sartu");
			btnErabiltzaileBerria.setText("Berria");
			lblIzena.setText("Izena");
			lblPasahitza.setText("Pasahitza");
		}
		this.repaint();
	}
}
