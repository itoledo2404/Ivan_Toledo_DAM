import java.awt.EventQueue;


public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Equipo equipo = new Equipo ("default",0,0,0,0);
					VentanaEquipo frame = new VentanaEquipo(equipo);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
