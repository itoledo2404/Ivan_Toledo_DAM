import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaEquipo extends JFrame {
	
	private JPanel contentPane;
	//Creo el objeto equipo
	private Equipo equipo;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	/**
	 * Create the frame.
	 */
	public VentanaEquipo(Equipo equipoAModificar) {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//Creacion del equipo
		equipo = equipoAModificar;
		
		JButton btnGuardarFichero = new JButton("Guardar Fichero");
		btnGuardarFichero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//genero el objeto salida para la escritura del fichero
				ObjectOutputStream salida; 
				try
				{
					// abre el archivo
					salida = new ObjectOutputStream (new FileOutputStream ("clientes.ser"));
					// envía el registro como salida
					salida.writeObject( equipo );
					// cierra el archivo
					if ( salida != null )
						salida.close();
				}//fin de try
				catch ( IOException ioException )
				{
				 System.err.println( "Error al abrir el archivo." );
				} // fin de catch
			}
		});
		btnGuardarFichero.setBounds(295, 267, 129, 23);
		contentPane.add(btnGuardarFichero);
		
		JLabel lblNombreEquipo = new JLabel("Nombre Equipo");
		lblNombreEquipo.setBounds(10, 11, 109, 14);
		contentPane.add(lblNombreEquipo);
		
		textField = new JTextField();
		textField.setBounds(118, 8, 232, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblGolesAFavor = new JLabel("Goles a Favor");
		lblGolesAFavor.setBounds(10, 57, 109, 14);
		contentPane.add(lblGolesAFavor);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(118, 54, 232, 20);
		contentPane.add(textField_1);
		
		JLabel lblGolesEnContra = new JLabel("Goles en Contra");
		lblGolesEnContra.setBounds(10, 104, 109, 14);
		contentPane.add(lblGolesEnContra);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(118, 101, 232, 20);
		contentPane.add(textField_2);
		
		JLabel lblPartidosGanados = new JLabel("Partidos Ganados");
		lblPartidosGanados.setBounds(10, 155, 109, 14);
		contentPane.add(lblPartidosGanados);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(118, 149, 232, 20);
		contentPane.add(textField_3);
		
		JLabel lblPartidosPerdidos = new JLabel("Partidos Perdidos");
		lblPartidosPerdidos.setBounds(10, 201, 109, 14);
		contentPane.add(lblPartidosPerdidos);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(118, 198, 232, 20);
		contentPane.add(textField_4);
	}
}
