import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VentanaLiga extends JFrame {

	private JPanel contentPane;
	private Liga liga;
	private Equipo equipo;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private final JButton btnNewButton = new JButton("Modificar");
	private VentanaEquipo frameEquipo;

	/**
	 * Create the frame.
	 */
	public VentanaLiga(Liga ligaModificar) {
		liga = ligaModificar;
		setTitle("Ventana Liga");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 417, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 50, 128, 20);
		/*Añadimos el nombre de la liga*/
		textField.setText(String.valueOf(liga.getNombreLiga()));
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNombreDeLa = new JLabel("Nombre de la Liga");
		lblNombreDeLa.setBounds(10, 25, 128, 14);
		contentPane.add(lblNombreDeLa);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 113, 128, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEquipoAModificar = new JLabel("Equipo a Modificar");
		lblEquipoAModificar.setBounds(10, 88, 128, 14);
		contentPane.add(lblEquipoAModificar);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setText("0");
		textField_2.setBounds(236, 50, 128, 20);
		/*Añadimos el numero de equipos*/
		textField_2.setText(String.valueOf(liga.getNumEquipos()));
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNumeroDeEqipos = new JLabel("Numero de eqipos");
		lblNumeroDeEqipos.setBounds(236, 25, 128, 14);
		contentPane.add(lblNumeroDeEqipos);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaEquipo frameEquipo = new VentanaEquipo(liga.getEquipo(Integer.valueOf(textField_1.getText())));
				frameEquipo.setVisible(true);
				frameEquipo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			}
		});
		btnNewButton.setBounds(9, 168, 129, 23);
		contentPane.add(btnNewButton);
	}
}
