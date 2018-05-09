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
	private ButtonGroup jokuMota;
	private JButton btnSartu;
	private JButton btnErabiltzaileBerria;
	private JLabel lblIzena;
	private JLabel lblPasahitza;
	private JRadioButton rdbtnJokalariVsJokalari;
	private JRadioButton rdbtnJokalariVsIa;
	private JRadioButton rdbtnJokalariVsIa_1;
	private JLabel lblHizkuntza;
	private JLabel lblJokuMota;

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
		setBounds(100, 100, 523, 309);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		lblIzena = new JLabel("Izena:");
		lblIzena.setBounds(27, 54, 89, 14);
		panel.add(lblIzena);
		
		textField = new JTextField();
		textField.setBounds(141, 51, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		lblPasahitza = new JLabel("Pasahitza:");
		lblPasahitza.setBounds(27, 112, 89, 14);
		panel.add(lblPasahitza);
		
		textField_1 = new JTextField();
		textField_1.setBounds(141, 109, 86, 20);
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
		btnSartu.setBounds(27, 175, 89, 23);
		panel.add(btnSartu);
		
		btnErabiltzaileBerria = new JButton("Berria");
		btnErabiltzaileBerria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.getMain().createUser(textField.getText(), textField_1.getText());
			}
		});
		btnErabiltzaileBerria.setBounds(141, 175, 89, 23);
		panel.add(btnErabiltzaileBerria);
		
		rdbtnCastellano = new JRadioButton("Castellano");
		rdbtnCastellano.setBounds(310, 50, 109, 23);
		rdbtnCastellano.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eguneratu();
			}
		});
		panel.add(rdbtnCastellano);
		
		rdbtnEuskera = new JRadioButton("Euskera");
		rdbtnEuskera.setBounds(310, 76, 109, 23);
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
		
		rdbtnJokalariVsJokalari = new JRadioButton("Jokalari vs Jokalari");
		rdbtnJokalariVsJokalari.setBounds(310, 161, 148, 23);
		rdbtnJokalariVsJokalari.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eguneratu();
			}
		});
		panel.add(rdbtnJokalariVsJokalari);
		
		rdbtnJokalariVsIa = new JRadioButton("Jokalari vs IA erraza");
		rdbtnJokalariVsIa.setBounds(310, 187, 147, 23);
		rdbtnJokalariVsIa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eguneratu();
			}
		});
		panel.add(rdbtnJokalariVsIa);
		
		rdbtnJokalariVsIa_1 = new JRadioButton("Jokalari vs IA zaila");
		rdbtnJokalariVsIa_1.setBounds(310, 213, 147, 23);
		rdbtnJokalariVsIa_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eguneratu();
			}
		});
		panel.add(rdbtnJokalariVsIa_1);
		
		jokuMota = new ButtonGroup();
		jokuMota.add(rdbtnJokalariVsIa);
		jokuMota.add(rdbtnJokalariVsIa_1);
		jokuMota.add(rdbtnJokalariVsJokalari);
		rdbtnJokalariVsIa.setSelected(true);
		
		lblHizkuntza = new JLabel("HIZKUNTZA");
		lblHizkuntza.setBounds(331, 23, 88, 20);
		panel.add(lblHizkuntza);
		
		lblJokuMota = new JLabel("JOKU MOTA");
		lblJokuMota.setBounds(331, 131, 127, 23);
		panel.add(lblJokuMota);
	}
	
	private void eguneratu() {
		if (rdbtnCastellano.isSelected()) {
			btnSartu.setText("Entrar");
			btnErabiltzaileBerria.setText("Nuevo");
			lblIzena.setText("Nombre");
			lblPasahitza.setText("Contraseña");
			rdbtnJokalariVsIa.setText("Jugador vs IA fácil");
			rdbtnJokalariVsIa_1.setText("Jugador vs IA difícil");
			rdbtnJokalariVsJokalari.setText("Jugador vs Jugador");
			lblHizkuntza.setText("IDIOMA");
			lblJokuMota.setText("MODO DE JUEGO");
		}
		else if (rdbtnEuskera.isSelected()) {
			btnSartu.setText("Sartu");
			btnErabiltzaileBerria.setText("Berria");
			lblIzena.setText("Izena");
			lblPasahitza.setText("Pasahitza");
			rdbtnJokalariVsIa.setText("Jokalari vs IA erraza");
			rdbtnJokalariVsIa_1.setText("Jokalari vs IA zaila");
			rdbtnJokalariVsJokalari.setText("Jokalari vs Jokalari");
			lblHizkuntza.setText("HIZKUNTZA");
			lblJokuMota.setText("JOKU MOTA");
		}
		this.repaint();
	}
}
