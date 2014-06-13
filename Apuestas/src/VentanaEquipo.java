import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;
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
	//Objetos gestion fichero
	private ObjectOutputStream salida;
	private ObjectInputStream entrada;
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
		JButton btnNewButton = new JButton("Guardar archivo");
 		btnNewButton.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent arg0) {
 				guardarEquipo();
 				guardarEnFichero();
 			}
 		});
 		btnNewButton.setBounds(92, 267, 125, 23);
 		contentPane.add(btnNewButton);
 		
 		JButton btnLeer = new JButton("Leer Archivo");
 		btnLeer.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				recuperarFichero();
 				txtEquipo.setText(equipo.getNombre());
 				txtGolesContra.setText(String.valueOf(equipo.getGolesContra()));
 			}
 		});
 		btnLeer.setBounds(230, 267, 116, 23);
 		contentPane.add(btnLeer);
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Lanzo metodo guardar
				guardarEquipo();
				
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
		//LLamo al metodo leerEquipo para rellenar la ventana con los datos del equipo
		 leerEquipo();
		
	}
	//Metodo para guardar en el objeto equipo
 	private void guardarEquipo(){
 		equipo.setGolesContra(Integer.valueOf(txtGolesFavor.getText()));
		equipo.setGolesFavor(Integer.valueOf(txtGolesContra.getText()));
		equipo.setNombre(txtEquipo.getText());
		equipo.setPartidosGanados(Integer.valueOf(txtPartidosGanados.getText()));
		equipo.setPartidosPerdidos(Integer.valueOf(txtPartidosPerdidos.getText()));
		
 	}
 	
 	//Metodo para leer el objeto equipo
 	private void leerEquipo(){
 		txtGolesFavor.setText(String.valueOf(equipo.getGolesContra()));
 		txtGolesContra.setText(String.valueOf(equipo.getGolesFavor()));
 		txtPartidosGanados.setText(String.valueOf(equipo.getPartidosGanados()));
 		txtPartidosPerdidos.setText(String.valueOf(equipo.getPartidosPerdidos()));
  		
 		//Creacion del equipo
 		equipo=new Equipo("",0,0,0,0);
  	}
  	
  	private void guardarEnFichero(){
 		
  		try
  		{
  			// abrimos el archivo
 			salida = new ObjectOutputStream(new FileOutputStream( "clientes.ser"));
 		   //creamos el registro como salida
  			salida.writeObject(equipo); 
  			if( salida != null)
  				salida.close();
  			System.err.println("Error al abrir el archivo.");
  		}
  		catch( IOException ioException )
 		{
 			System.err.println("Error por excepcion.");
 		}
  	}
 			
 
 	private void recuperarFichero(){
 		try
 		{
 			// abrimos el archivo
 			entrada = new ObjectInputStream(new FileInputStream( "clientes.ser") );
 			//creamos el registro como salida
 			equipo=(Equipo) entrada.readObject(); 
 			if( entrada != null)
 				entrada.close();
 		}
 		catch( IOException ioException )
 		{
 			System.err.println("Error al abrir el archivo.");
 		}catch(ClassNotFoundException clException){
 			System.err.println("Error al crear la clase");
 		}
 		
 	}
}
