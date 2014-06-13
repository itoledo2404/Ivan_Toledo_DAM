import java.io.Serializable;
import java.util.ArrayList;

public class Liga implements Serializable {
	private int numEquipos;
	/*Insertamos el ArrayList*/
	private ArrayList<Equipo> equipos=new ArrayList<Equipo>();
	private String  nombreLiga;
	
	//creo el constructor Liga
	public Liga() {
		numEquipos=0;
		nombreLiga = "Liga Futbol Espa�ola";
		
	}
	//creo una sobrecarga del constructor Liga con los parametros necesarios
	public Liga (int numero,String nombre)
	{
		numEquipos = numero;
		nombreLiga = nombre;
		for (int i=0;i<numEquipos;i++ )
		{
			/*A�adimos nuestros equipos al Array List*/
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
	/*Metodo para borrar un equip�*/
	public void deleteEquipo(int posicion)

 	{
		
		equipos.remove(posicion);

 	}

 	


}
