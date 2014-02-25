import java.io.Serializable;;

public class Equipo implements Serializable{
	
	//Declaro los atributos del equipo
	
	private String nombreEquipo;
	private int golesFavor;
	private int golesEnContra;
	private int partidosGanados;
	private int partidosPerdidos;
	//creo el constructor equipo con los parametros necesarios
	public Equipo(String nom, int golesF, int golesC, int partidosG, int partidosP ) {
		// TODO Auto-generated constructor stub
		//inicializo los atributos
		nombreEquipo = nom;
		golesFavor = golesF;
		golesEnContra = golesC;
		partidosGanados = partidosG;
		partidosPerdidos = partidosP;
	}
	//metodo para pasar valor al attr nombreEquipo
	public void setNombre(String nom ){
		nombreEquipo = nom;
	}
	//metodo para devolver el valor de nombreEquipo
	public String getNombre(){	
		return nombreEquipo;
	}
	//metodo para pasar valor al attr golesFavor
	public void setGolesFavor(int golesF ){
		golesFavor = golesF;
	}
	//metodo para devolver el valor de golesFavor
	public int getGolesFavor(){	
		return golesFavor;
	}
	//metodo para pasar valor al attr golesEnContra
	public void setGolesContra(int golesC ){
		golesEnContra = golesC;
	}
	//metodo para devolver el valor de golesEnContra
	public int getGolesContra(){	
		return golesEnContra ;
	}
	//metodo para pasar valor al attr partidosGanados
	public void setGolesPartidosGanados(int partidosG){
		partidosGanados = partidosG;
	}
	//metodo para devolver el valor de partidosGanados
	public int getGolesPartidosGanado(){	
		return partidosGanados;
	}
	//metodo para pasar valor al attr partidosPerdido
	public void setGolesPartidosPerdidos(int partidosP){
		partidosPerdidos = partidosP;
	}
	//metodo para devolver el valor de partidosPerdidos
	public int getGolesPartidosPerdidos(){
		return partidosPerdidos;
	}
	
}

