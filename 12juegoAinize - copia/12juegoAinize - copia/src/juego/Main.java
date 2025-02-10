
package juego;

import java.awt.EventQueue;

import jugarPartida.AulaView;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				AulaView frame = new AulaView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
		/* creamos un par de objetos pa probar
		ObjetoDTO diario = new ObjetoDTO("Diario", " es el día a día de la víctima");
		ObjetoDTO lapizPapel = new ObjetoDTO("Lapiz y papel", " para apuntar lo que sea necesario");

		InventarioView inventario = new InventarioView();
		inventario.agregarObjeto(lapizPapel);
		inventario.agregarObjeto(diario);
		
		inventario.mostrarInventario();

	}
}*/
