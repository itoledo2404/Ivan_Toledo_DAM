import java.awt.EventQueue;


public class Principal {

	public static void main(String[] args) {
		// Abrimos la VentanaLiga
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					/*A�adimos una liga y sus equipos al contructorde la clase liga*/
					Liga Liga = new Liga (20,"Liga Espa�ola");
					VentanaLiga frame = new VentanaLiga(Liga);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
