/*
 * Susana Cano Mar�n
 * Ingenieria de Softwere Avanzado
 */

package blastGUI;

import javax.swing.JFrame;





public class BlastNoGUIMain {
	
	public static void main(String args[]){
		
		//Definici�n de la ventana de la interfaz gr�fica:
		MiVentana v = new MiVentana();
		//La ponemos visible:
		v.setVisible(true);
		//Exito al cerrar la ventana:
		v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
