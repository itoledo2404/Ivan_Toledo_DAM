import java.io.Serializable;


public class Liga implements Serializable {
	private int numEquipos;
	private Equipo equipos[];
	private String  nombreLiga;
	public Liga() {
		// TODO Auto-generated constructor stub
		numEquipos = 20;
		equipos = new Equipo [numEquipos];
		nombreLiga = "Liga Futbol Española";
		for (int i=0;i<numEquipos;i++ )
		{
			equipos[i] = new Equipo();
		}
	}
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

	public int getNumEquipos() {
		return numEquipos;
	}
	public void setNumEquipos(int numEquipos) {
		this.numEquipos = numEquipos;
	}
	public String getNombreLiga() {
		return nombreLiga;
	}
	public void setNombreLiga(String nombreLiga) {
		this.nombreLiga = nombreLiga;
	}
	public Equipo getEquipo(int posicion)
	{

		return equipos[posicion];

	}

	public void setEquipo(Equipo equipo,int posicion)

	{
		equipos[posicion]=equipo;
	}

}
