package blastGUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import blast.BlastController;


public class PanelTexto2 extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String dataBaseFile = new String("yeast.aa");
	private static final String dataBaseIndexes = new String("yeast.aa.indexs");
	
	private static int NUM_COLUMNA = 25;
	private static int NUM_FILA = 50;
	
	BlastController bCnt = new BlastController();
	
	//Text area para introducir la consulta:
		JTextArea textConsulta;//para introducir la secuencia a comparar
		JLabel lConsulta;
		JTextArea tPorcentaje;//para introducir el porcentaje
		JLabel lPorcentaje;
		JButton bComparar; //para iniciar la comparacion
		JRadioButton bRadioProteinas; 
		JRadioButton bRadioNucleotidos;
		ButtonGroup bRadioGrupo; //para agrupar los 2 botones de radio y definir uno por defecto
		JLabel lResultado;
		JTextArea textAreaRespuesta;
		JLabel lSecuencias;
		private JComboBox <String>comboSeq;
		
		@SuppressWarnings("unused")
		private JScrollPane scrollPaneTextArea;
		private JPanel panelBotonesRadio;
		private JPanel panelPorcentaje;
		private JPanel panelPorcentajeBotones;
		//private JPanel panelRespuestaCombo;
		
		
		public PanelTexto2() {
			
			setLayout(new GridLayout(0, 1));
			
			//Primer textArea para introducir la secuencia a comparar:
			lConsulta = new JLabel("Introduce la secuencia a comparar: ");
			textConsulta = new JTextArea();
			
			//TextArea para introducir el porcentaje:
			tPorcentaje = new JTextArea();
			lPorcentaje = new JLabel("Porcentaje: ");
			
			bComparar = new JButton("Comparar ");
			lResultado = new JLabel("Resultado de la comparacion: ");
			//Botones de radio:
			
			bRadioProteinas = new JRadioButton("Proteínas", true);
			bRadioNucleotidos = new JRadioButton("Nucleótidos", false);
			bRadioGrupo = new ButtonGroup();
			bRadioGrupo.add (bRadioProteinas);
			bRadioGrupo.add (bRadioNucleotidos);
			
			//Definicion del array de String que compondra el combo box:
			lSecuencias = new JLabel("Secuencias ya comparadas: ");
			
			//String secuencia;
			//String secun = null;
//			List secuencias = new List() {
//					String sec = comboSeq.getEditor().getItem().toString();
//			};
			
//				List ListItem = ControllerEmpresa.CargarEmpresa();
//					  
//				 int i;
//				 if (ListItem != null) {
//				 int size = ListItem.size();
//				    for (i=0;i<size;i++){
//				    comboSeq.addItem(ListItem.get(i));
//				    }
//				 }
//				                          
//			};
				
			//comboSeq = new JComboBox <String> (secuencias);
			comboSeq = new JComboBox <String> ();
			comboSeq.setEditable(true);
			//bComparar.addActionListener(comboSeq);
			bComparar.addActionListener(this);
			comboSeq.addActionListener(this);

			
			
			
			panelBotonesRadio = new JPanel(new GridLayout(0, 2));
			panelPorcentaje = new JPanel(new GridLayout(3, 0));
			panelPorcentajeBotones = new JPanel(new GridLayout(0, 2));
			//panelRespuestaCombo = new JPanel(new GridLayout(0, 2));
			
			
			textAreaRespuesta  = new JTextArea(NUM_FILA, NUM_COLUMNA);
			scrollPaneTextArea  = new JScrollPane (textAreaRespuesta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
					JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			add(lConsulta);
			add(textConsulta);
			add(panelBotonesRadio);
			//add(bRadioProteinas);
			//add(bRadioNucleotidos);
			
			panelBotonesRadio.add(add(bRadioProteinas));
			panelBotonesRadio.add(add(bRadioNucleotidos));
			add(panelPorcentaje);
			
			panelPorcentaje.add(lPorcentaje);
			panelPorcentaje.add(tPorcentaje);
			panelPorcentaje.add(bComparar);
			
			panelPorcentajeBotones.add(panelBotonesRadio);
			panelPorcentajeBotones.add(panelPorcentaje);
			add(panelPorcentajeBotones);
			
			add(lSecuencias);
			add(comboSeq);
			add(lResultado);
			add(scrollPaneTextArea);
			
//			panelRespuestaCombo.add(scrollPaneTextArea);
//			panelRespuestaCombo.add(comboSeq);
//			add(panelRespuestaCombo);
		
		}
		
	//@SuppressWarnings("unlikely-arg-type")
	@Override
	public void actionPerformed(ActionEvent e) {
		char p = ' ';
		//char type = 'p';
		float porcentaje =Float.parseFloat(tPorcentaje.getText());//obtenemos el porcentaje de acierto
		//String sec = comboSeq.getSelectedItem().toString();
//		bCnt = new BlastController();
		String sec = getSecuencia().toUpperCase();
		
		//System.out.println(sec);
		if(e.getSource() == bComparar){
			
			//comboSeq = new JComboBox();
			JComboBox<String> comboBox2 = new JComboBox<String>();			
			
			//comboBox2.addItem(sec);
			//comboBox2.getItemCount();
			//comboBox.getItemCount();
			//comboBox2.addItem(sec);
			//sec.getSecuencia();
			for(int i=0; i < comboBox2.getItemCount(); i++){
				if((comboBox2.getItemAt(i).equals(comboBox2.getItemAt(i + 1)) && comboBox2.getItemAt(i + 1) != null )) {
					comboBox2.removeItemAt(i);
					
				}
				
			}
			//String memoria=combox.getEditor().getItem().toString();
			//comboBox2.addItem(comboBox2.getEditor().getItem().toString());
//			for(int i=0;i<comboBox2.getItemCount();i++) {
//				for( int j  =  comboBox2.getItemCount() - 1 ; j  >  i; j --)
//				if(comboBox2.getItemAt(j).equals(comboBox2.getItemAt(i))) {
//					comboBox2.removeItemAt(j);
//				}
//			}
		
		
		}
		try{
			if(bRadioProteinas.isSelected()) {
				//type ='p';
				p ='p';
//				 sec = bCnt.blastQuery(p, dataBaseFile, 
//						dataBaseIndexes, Float.parseFloat(tPorcentaje.getText()),comboSeq.getSelectedItem().toString());
				 
				String resultado = bCnt.blastQuery(p, dataBaseFile, dataBaseIndexes, porcentaje, sec);
				 textAreaRespuesta.setText(resultado + porcentaje);
				
	
			}else {
				//type ='n';
				p ='n';
				textAreaRespuesta.setText("ERROR esta opción no esta implementada. ");
			
			}
		} catch(Exception exc){
			System.out.println("Error en la llamada: " + exc.toString());
		}
	}
	
	public String getSecuencia(){
		String p;
		p = textConsulta.getText();
		return p;
	}

}
