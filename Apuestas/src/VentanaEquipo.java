import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;

public class VentanaEquipo extends JFrame {
	
	private JPanel contentPane;
	//Creo el objeto equipo
	private Equipo equipo;
	/**
	 * Create the frame.
	 */
	public VentanaEquipo(Equipo equipoAModificar) {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
					// env�a el registro como salida
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
		btnGuardarFichero.setBounds(295, 228, 129, 23);
		contentPane.add(btnGuardarFichero);
	}
}
