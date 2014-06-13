import java.io.Serializable;
import java.util.ArrayList;
//Librerias de conexion a la DB
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class Liga implements Serializable {
	private int numEquipos;
	/*Insertamos el ArrayList*/
	private ArrayList<Equipo> equipos=new ArrayList<Equipo>();
	private String  nombreLiga;
	private int idLiga;
	
	//DB Herramientas de Administracion
	private Connection conexion = null; //mamnejador de conexion
	private Statement instruccion = null;// gestor de instrucciones
	private ResultSet conjuntoResultados = null;// gestor de resultados

	//creo el constructor Liga
	public Liga(Connection conexion, String nomLigaAModificar ) {
		numEquipos=0;
		nombreLiga = "";
		this.conexion=conexion;
        leerLiga();
       
	}
	//creo una sobrecarga del constructor Liga con los parametros necesarios
	public Liga (Connection conexion,int numero,String nombre)
	{
		numEquipos = numero;
		nombreLiga = nombre;
		for (int i=0;i<numEquipos;i++ )
		{
			/*Añadimos nuestros equipos al Array List*/
			equipos.add(new Equipo());
		}
		
	}
	//metodo para leer valor al attr NumEquipos
	public int getNumEquipos() {
		return numEquipos;
	}
	//metodo para pasar valor al attr NumEquipos
	public void setNumEquipos(int numEquipos) {
		this.numEquipos = numEquipos;
	}
	//metodo para leer valor al attr getNombreLiga
	public String getNombreLiga() {
		return nombreLiga;
	}
	//metodo para pasar valor al attr getNombreLiga
	public void setNombreLiga(String nombreLiga) {
		this.nombreLiga = nombreLiga;
	}
	//metodo para leer valor del array Equipo getEquipo
	public Equipo getEquipo(int posicion)
	{
		return equipos.get(posicion);
	}
	/*Metodo para crear un nuevo equipo*/
	public void newEquipo()

	{
		equipos.add(new Equipo());
		numEquipos++;
    }
	/*Metodo para borrar un equipò*/
	public void deleteEquipo(int posicion)

 	{
		
		equipos.remove(posicion);

 	}
	//Gestion insert y select de la BD
	public void newEquipoDB(Equipo equipo)
	{
		try{
			// consulta la base de datos
			instruccion = (Statement) conexion.createStatement();
			// insercion en base de datos
			String sql_inst="INSERT INTO equipos ( idLiga,nombreEquipo,golesFavor,golesEnContra,partidosGanados,partidosPerdidos )";
			sql_inst=sql_inst+ "VALUES( "+idLiga+",'"+equipo.getNombre()+"',"+equipo.getGolesFavor()+","+equipo.getGolesContra()+","+equipo.getPartidosGanados()+","+equipo.getPartidosPerdidos()+")";
			System.out.println(sql_inst);
			instruccion.executeUpdate(sql_inst);
		}catch( SQLException excepcionSql ){
		excepcionSql.printStackTrace();
		}// fin
	}
	private void leerLiga(){
		try{
			// consulta la base de datos
			instruccion = (Statement) conexion.createStatement();
			conjuntoResultados = instruccion.executeQuery("SELECT idLiga,nombre,numEquipos FROM ligas LIMIT 1");
			conjuntoResultados.next();
			// Almacenar liga
			this.idLiga=(int)conjuntoResultados.getObject("idLiga");
			this.nombreLiga=(String)conjuntoResultados.getObject("nombre");
			this.numEquipos=(int)conjuntoResultados.getObject("numEquipos");
		}catch( SQLException excepcionSql ){
		excepcionSql.printStackTrace();
		}// fin
	}


}
