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
import javax.swing.JComboBox;


public class VentanaLiga extends JFrame {

	private JPanel contentPane;
	private Liga liga;
	private Equipo equipo;
	private JTextField textField;
	private JTextField textField_2;
	private final JButton btnNewButton = new JButton("Modificar");
	private VentanaEquipo frameEquipo;
	private JComboBox<Equipo> comboBox;
	/**
	 * Create the frame.
	 */
	public VentanaLiga(Liga ligaModificar) {
		liga = ligaModificar;
		setTitle("Ventana Liga");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 308);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 50, 290, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNombreDeLa = new JLabel("Nombre de la Liga");
		lblNombreDeLa.setBounds(10, 25, 128, 14);
		contentPane.add(lblNombreDeLa);
		
		JLabel lblEquipoAModificar = new JLabel("Equipo a Modificar");
		lblEquipoAModificar.setBounds(10, 88, 128, 14);
		contentPane.add(lblEquipoAModificar);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setText("0");
		textField_2.setBounds(325, 50, 128, 20);
		/*Añadimos el numero de equipos*/
		textField_2.setText(String.valueOf(liga.getNumEquipos()));
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNumeroDeEqipos = new JLabel("Numero de eqipos");
		lblNumeroDeEqipos.setBounds(325, 25, 128, 14);
		contentPane.add(lblNumeroDeEqipos);
		JButton btnNewButton = new JButton("Modificar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openEquipoWindow(liga.getEquipo(comboBox.getSelectedIndex()),true);
			}
		});
		btnNewButton.setBounds(133, 198, 129, 23);
		contentPane.add(btnNewButton);
		/*Creo el combobox para almacenar los equipos*/
		comboBox = new JComboBox<Equipo>();
		comboBox.setBounds(10, 113, 252, 20);
		contentPane.add(comboBox);
		
		
		JButton btnNewButton_1 = new JButton("+");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				liga.newEquipo();
				openEquipoWindow(liga.getEquipo(liga.getNumEquipos()-1),false);
			}
		});
		btnNewButton_1.setBounds(10, 198, 52, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("-");
		btnNewButton_2.setBounds(71, 198, 52, 23);
		contentPane.add(btnNewButton_2);
	}
	private void openEquipoWindow(Equipo equipo,boolean modifica)
	{
		frameEquipo = new VentanaEquipo (equipo,this.comboBox,modifica);
		frameEquipo.setVisible(true);
		frameEquipo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	
}
