/*
 * Susana Cano Marín
 * Ingenieria de Softwere Avanzado
 */

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
	
	//Declaracion de los elementos que se van a usar:
		JTextArea textConsulta;//para introducir la secuencia a comparar
		JLabel lConsulta;
		JTextArea tPorcentaje;//para introducir el porcentaje
		JLabel lPorcentaje;
		JButton bComparar; //para iniciar la comparacion
		JRadioButton bRadioProteinas; 
		JRadioButton bRadioNucleotidos;
		ButtonGroup bRadioGrupo; //para agrupar los 2 botones de radio y definir uno por defecto
		JLabel lResultado;
		JTextArea textAreaRespuesta; //para devolver el resultado de la comparacion
		JLabel lSecuencias;
		JComboBox <String>comboSeq; //donde se van guardando las secuencias comparadas
		
		private JScrollPane scrollPaneTextArea; //contiene textAreaRespuesta y la etiqueta lSecuencias
		private JPanel panelBotonesRadio; // contiene bRadioGrupo, que a su vez contiene: bRadioProteinas y bRadioNucleotidos
		private JPanel panelPorcentaje; // contiene lPorcentaje, comboSeq y bComparar.
		private JPanel panelPorcentajeBotones; // contiene los paneles: panelBotonesRadio y panelPorcentaje.
		
		
		
		public PanelTexto2() {
			
			setLayout(new GridLayout(0, 1));
			
			//Primer textArea para introducir la secuencia a comparar:
			lConsulta = new JLabel("Introduce la secuencia a comparar: ");
			textConsulta = new JTextArea();
			
			//TextArea para introducir el porcentaje:
			tPorcentaje = new JTextArea();
			lPorcentaje = new JLabel("Porcentaje: ");
			
			// Boton = comparar
			bComparar = new JButton("Comparar ");
			lResultado = new JLabel("Resultado de la comparacion: ");
			
			//Botones de radio:
			bRadioProteinas = new JRadioButton("Proteínas", true);
			bRadioNucleotidos = new JRadioButton("Nucleótidos", false);
			bRadioGrupo = new ButtonGroup();
			bRadioGrupo.add (bRadioProteinas);
			bRadioGrupo.add (bRadioNucleotidos);
			
			lSecuencias = new JLabel("Secuencias ya comparadas: ");
							
			// Definicion del comboBox:
			comboSeq = new JComboBox <String> ();
			
			//Activacion de los eventos de la clase PanelTexto2:
			bComparar.addActionListener(this);
			comboSeq.addActionListener(this);
			
			// Definicion de los paneles:
			panelBotonesRadio = new JPanel(new GridLayout(0, 2));
			panelPorcentaje = new JPanel(new GridLayout(3, 0));
			panelPorcentajeBotones = new JPanel(new GridLayout(0, 2));

			
			textAreaRespuesta  = new JTextArea(NUM_FILA, NUM_COLUMNA);
			scrollPaneTextArea  = new JScrollPane (textAreaRespuesta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
					JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			
			// Añadimos los elementos inicializados:
			add(lConsulta);
			add(textConsulta);
			add(panelBotonesRadio);
			
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
			
		}
		
	
	@Override
	public void actionPerformed(ActionEvent e) {
		char p = ' ';
		float porcentaje =Float.parseFloat(tPorcentaje.getText());//obtenemos el porcentaje de acierto
		String sec = textConsulta.getText().toUpperCase();
		comboSeq.addItem(sec); //añadimos el string generado por el usuario en textConsulta al la lista de secuencias ya comparadas
		
		
		if(e.getSource() == bComparar){	 
			sec = (String) comboSeq.getEditor().getItem().toString().toUpperCase();
			
				// Para evitar duplicacion de secuencias en el comboBox
				for(int i = 0; i < comboSeq.getItemCount(); i++){
					if((comboSeq.getItemAt(i).equals(comboSeq.getItemAt(i+1)) && comboSeq.getItemAt(i+1)!=null )) {
						comboSeq.removeItemAt(i);
					}
				}
		//System.out.println(comboSeq);
		
		}
		try{
			// Para reconocer si la secuencia a analizar es de proteinas o nucleotidos:
			if(bRadioProteinas.isSelected()) {
				
				p ='p';
				String resultado = bCnt.blastQuery(p, dataBaseFile, dataBaseIndexes, porcentaje, sec);
				 textAreaRespuesta.setText(resultado + porcentaje);
			}else {
				p ='n';
				textAreaRespuesta.setText("ERROR esta opción no esta implementada. ");
			}
		} catch(Exception exc){
			System.out.println("Error en la llamada: " + exc.toString());
		}
	}

}
