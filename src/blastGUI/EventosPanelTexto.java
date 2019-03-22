package blastGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class EventosPanelTexto extends PanelTexto2 implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox <String> comboSeq2;
	
	public EventosPanelTexto(JComboBox <String> cb) {
		this.comboSeq2 = cb;
	}
	
	public void actionPerformed(ActionEvent e) {

		String secun = null;
		comboSeq2.addItem(secun);
		for(int i = 0; i < comboSeq2.getComponentCount(); i++) {
			if(comboSeq2.getItemAt(i).equalsIgnoreCase(secun));
			comboSeq2.remove(i);
		}
	}
	
}




//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
//public void actionPerformed(ActionEvent ev) {
//
//	if(ev.getSource() == bBuscar){
//		ConsultasSQL consSql = new ConsultasSQL();
//		String txt = getPregunta();
//		try{
//			System.out.println(consSql.getBuscarDatosBD(txt));
//		}catch(Exception e){
//			System.out.println("La consulta no es válida.");
//		}
//	}else if(ev.getSource() == bSalir){ 
//		try{
//			Thread.sleep(1000);
//			System.exit(0);
//		}catch(Exception e){
//			System.exit(0);
//		}
//	}else if(ev.getSource() == bBorrar){ 
//		clearTxtField();
//	}
//}
//
//public void clearTxtField(){
//	pregunta.setText("");
//}
//
//
//public String getPregunta(){
//	String p;
//	p = pregunta.getText();
//	return p;
//}
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
//String sec = comboSeq.getEditor().getItem().toString().toUpperCase();
//comboSeq.addItem(sec);
//for(int i=0;i<comboSeq.getItemCount();i++){
//	if((comboSeq.getItemAt(i).equals(comboSeq.getItemAt(i+1)) && comboSeq.getItemAt(i+1)!=null )) {
//		comboSeq.removeItemAt(i);
//	}
//}

 
//String sec1 = (String)comboSeq.getSelectedItem ( ) ;
//for(int i=0; i<comboSeq.getItemCount(); i++){
//	if((comboSeq.getItemAt(i).equals(comboSeq.getItemAt(i + 1)) && comboSeq.getItemAt(i + 1) != null )) {
//		comboSeq.removeItemAt(i);
//	}
//}
//comboSeq = (JComboBox)e.getSource( ) ;
//comboSeq.removeItem(sec1);
//JComboBox cb = (JComboBox)e . getSource ( ) ;
//String petName = (String)cb . getSelectedItem ( ) ;
//updateLabel(petName) ;



//String entrada = caja2.getEditor().getItem().toString().toUpperCase();
//caja2.addItem(entrada);//añadimos el string del usuario
////comprobamos con este for que no hay duplicados en nuestro historial
//for(int i=0;i<caja2.getItemCount();i++){
//	if((caja2.getItemAt(i).equals(caja2.getItemAt(i+1)) && caja2.getItemAt(i+1)!=null )) {
//		caja2.removeItemAt(i);
//	}
//}
/*
 * 	try{
//	String result = bCnt.blastQuery('p', dataBaseFile, 
//			dataBaseIndexes, (float) 0.9, "GKGKGKGKGK");
//	System.out.println(result);
//} catch(Exception exc){
//	System.out.println("Error en la llamada: " + exc.toString());
//}
 */
//}

//public void clearTxtField(){
//pregunta.setText("");
//}
