package blastGUI;

import javax.swing.JFrame;



//import blast.BlastController;

public class BlastNoGUIMain {
	
//	private static final String dataBaseFile = new String("yeast.aa");
//	private static final String dataBaseIndexes = new String("yeast.aa.indexs");
	
	public static void main(String args[]){
//	BlastController bCnt = new BlastController();
//		try{
//			String result = bCnt.blastQuery('p', dataBaseFile, 
//					dataBaseIndexes, (float) 0.9, "GKGKGKGKGK");
//			System.out.println(result);
//		} catch(Exception exc){
//			System.out.println("Error en la llamada: " + exc.toString());
//		}
		
		//Definición de la ventana de la interfaz gráfica:
		MiVentana v = new MiVentana();
		//La ponemos visible:
		v.setVisible(true);
		//Exito al cerrar la ventana:
		v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
