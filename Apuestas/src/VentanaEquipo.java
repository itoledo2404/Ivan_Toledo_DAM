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
import javax.swing.JComboBox;

public class VentanaEquipo extends JFrame {
	
	private JPanel contentPane;
	//Creo el objeto equipo
	private Equipo equipo;
	private Liga liga;
	private VentanaLiga vLiga;
	private JComboBox jLiga;
	private JTextField txtEquipo;
	private JTextField txtGolesFavor;
	private JTextField txtGolesContra;
	private JTextField txtPartidosGanados;
	private JTextField txtPartidosPerdidos;
	private JButton btnGuardar;
	private boolean modifica;
	/**
	 * Create the frame.
	 */
	public VentanaEquipo(Equipo equipoAModificar,JComboBox jLigaprm,boolean modificaprm) {
		
		equipo=equipoAModificar;
		this.jLiga=jLigaprm;
		this.modifica=modificaprm;
		this.liga=liga;
		
		setTitle("Ventana Equipo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 529, 339);
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
		btnGuardarFichero.setBounds(71, 267, 129, 23);
		contentPane.add(btnGuardarFichero);
		
		JLabel lblNombreEquipo = new JLabel("Nombre Equipo");
		lblNombreEquipo.setBounds(10, 11, 109, 14);
		contentPane.add(lblNombreEquipo);
		
		txtEquipo = new JTextField();
		txtEquipo.setBounds(118, 8, 232, 20);
		contentPane.add(txtEquipo);
		txtEquipo.setColumns(10);
		
		JLabel lblGolesAFavor = new JLabel("Goles a Favor");
		lblGolesAFavor.setBounds(10, 57, 109, 14);
		contentPane.add(lblGolesAFavor);
		
		txtGolesFavor = new JTextField();
		txtGolesFavor.setColumns(10);
		txtGolesFavor.setBounds(118, 54, 232, 20);
		contentPane.add(txtGolesFavor);
		
		JLabel lblGolesEnContra = new JLabel("Goles en Contra");
		lblGolesEnContra.setBounds(10, 104, 109, 14);
		contentPane.add(lblGolesEnContra);
		
		txtGolesContra = new JTextField();
		txtGolesContra.setColumns(10);
		txtGolesContra.setBounds(118, 101, 232, 20);
		contentPane.add(txtGolesContra);
		
		JLabel lblPartidosGanados = new JLabel("Partidos Ganados");
		lblPartidosGanados.setBounds(10, 155, 109, 14);
		contentPane.add(lblPartidosGanados);
		
		txtPartidosGanados = new JTextField();
		txtPartidosGanados.setColumns(10);
		txtPartidosGanados.setBounds(118, 149, 232, 20);
		contentPane.add(txtPartidosGanados);
		
		JLabel lblPartidosPerdidos = new JLabel("Partidos Perdidos");
		lblPartidosPerdidos.setBounds(10, 201, 109, 14);
		contentPane.add(lblPartidosPerdidos);
		
		txtPartidosPerdidos = new JTextField();
		txtPartidosPerdidos.setColumns(10);
		txtPartidosPerdidos.setBounds(118, 198, 232, 20);
		contentPane.add(txtPartidosPerdidos);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				equipo.setGolesContra(Integer.valueOf(txtGolesFavor.getText()));
				equipo.setGolesFavor(Integer.valueOf(txtGolesContra.getText()));
				equipo.setNombre(txtEquipo.getText());
				equipo.setPartidosGanados(Integer.valueOf(txtPartidosGanados.getText()));
				equipo.setPartidosPerdidos(Integer.valueOf(txtPartidosPerdidos.getText()));
				
				if(!modifica)
				{
					jLiga.addItem(equipo);
					
					
				}else{
					Equipo equipoElegido=(Equipo)jLiga.getSelectedItem();
					equipoElegido.setNombre(equipo.getNombre());
				}


			}
		});
		btnGuardar.setBounds(388, 21, 116, 50);
		contentPane.add(btnGuardar);
	}
}
