import java.io.Serializable;


public class Liga implements Serializable {
	private int numEquipos;
	private Equipo equipos[];
	private String  nombreLiga;
	
	//creo el constructor Liga
	public Liga() {
		numEquipos = 20;
		equipos = new Equipo [numEquipos];
		nombreLiga = "Liga Futbol Española";
		for (int i=0;i<numEquipos;i++ )
		{
			equipos[i] = new Equipo();
		}
	}
	//creo una sobrecarga del constructor Liga con los parametros necesarios
	public Liga (int numero,String nombre)
	{
		numEquipos = numero;
		nombreLiga = nombre;
		equipos = new Equipo [numEquipos];
		for (int i=0;i<numEquipos;i++ )
		{
			equipos[i] = new Equipo();
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

		return equipos[posicion];

	}
	//metodo para pasar valor del array Equipo getEquipo
	public void setEquipo(Equipo equipo,int posicion)

	{
		equipos[posicion]=equipo;
	}

}
