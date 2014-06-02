import java.awt.EventQueue;


public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Liga Liga = new Liga ();
					VentanaLiga frame = new VentanaLiga(Liga);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
