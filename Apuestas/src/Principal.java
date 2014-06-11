import java.awt.EventQueue;


public class Principal {

	public static void main(String[] args) {
		// Abrimos la VentanaLiga
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
