/*
 * Susana Cano Marín
 * Ingenieria de Softwere Avanzado
 */

package blastGUI;

import javax.swing.JFrame;





public class BlastNoGUIMain {
	
	public static void main(String args[]){
		
		//Definición de la ventana de la interfaz gráfica:
		MiVentana v = new MiVentana();
		//La ponemos visible:
		v.setVisible(true);
		//Exito al cerrar la ventana:
		v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
