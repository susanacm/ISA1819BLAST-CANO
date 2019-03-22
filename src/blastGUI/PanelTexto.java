package blastGUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.KeyEvent;

import javax.swing.*;

public class PanelTexto extends JPanel implements ActionListener{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int NUM_COLUMNA = 25;
	private static int NUM_FILA = 50;
	
	//Declaración para los botones radio:
	JRadioButton bRadioProteinas;
	JRadioButton bRadioNucleotidos;
	ButtonGroup bRadioGrupo;
	//private JPanel panelBRadio;
	//private JPanel panel1;
	
	//Text area para introducir la consulta:
	JTextArea textConsulta = new JTextArea();
	JLabel lConsulta = new JLabel("Introduce la secuencia a comparar: ");
	//private JPanel panelIntroSeq;
	
	//Declaracion del comboBox:
	JComboBox <String> comboSeq;
	
	//Declaracion Area de texto para los resultados:
	JTextArea textAreaRespuesta;
	//private JScrollPane scrollPaneTextArea;
	JLabel resultado;
		
	
	public PanelTexto() {
		setLayout(new GridLayout(0, 1));
		
		//Primer textArea para introducir la secuencia a comparar:
		lConsulta = new JLabel("Introduce la secuencia a comparar: ");
		textConsulta = new JTextArea();
		//panelIntroSeq = new JPanel(new BorderLayout());
		
//		panelIntroSeq.add(lConsulta, BorderLayout.NORTH);
//		panelIntroSeq.add(textConsulta, BorderLayout.CENTER);
//		
//		JFrame frame1 = new JFrame();
//		frame1.getContentPane().add(panelIntroSeq,"Center");
		
		// 2 Botones Ratios:
		//JRadioButton(String text, boolean selected)
		//Crea un botón de opción con el texto especificado y el estado de selección.
	
		bRadioProteinas = new JRadioButton("Proteínas", true);
		//Si no lo ponemos a true en el inicio tambien podemos hacerlo con :
		//" proteinas.setSelectd(true);"
	
		//ATAJO POR TECLADO: bRadioProteinas.setMnemonic (KeyEvent.VK_D); 
		//bRadioProteinas.setActionCommand(proteinas);
		bRadioProteinas.addActionListener(comboSeq);
	
		bRadioNucleotidos = new JRadioButton("Nucleótidos", false);
		//ATAJO POR TECLADO: bRadioNucleotidos.setMnemonic (KeyEvent.VK_D);
		//bRadioNucleotidos.setActionCommand(nucleotidos);
		bRadioNucleotidos.addActionListener(comboSeq);
	
		// Agrupar los botones de radio.
		bRadioGrupo = new ButtonGroup();
		bRadioGrupo.add (bRadioProteinas);
		bRadioGrupo.add (bRadioNucleotidos);
//	
//		panel1 = new JPanel(new BorderLayout());
//		panel1.add(bRadioProteinas, BorderLayout.NORTH);
//		panel1.add(bRadioNucleotidos, BorderLayout.CENTER);
//	
		
		add(bRadioProteinas, BorderLayout.BEFORE_LINE_BEGINS);
		add(bRadioNucleotidos, BorderLayout.BEFORE_LINE_BEGINS);
		
	//Definicion del array de String que compondra el combo box:
	String[] secuencias = new String[] {
			
	};
	comboSeq = new JComboBox <String> (secuencias);
	comboSeq.setEditable(true);
	add(comboSeq, BorderLayout.CENTER);
	//panel1.add(comboSeq);
	
	//Area de texto:
	
	//JTextArea textAreaRes;
	//private JScrollPane scrollPaneTextArea;
	  
	
	textAreaRespuesta = new JTextArea(NUM_COLUMNA , NUM_FILA);
	//scrollPaneTextArea = new JScrollPane(textAreaRes, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS, 
			//JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	//getContentPane().add(panel1);
	resultado = new JLabel("Resultado de la comparación: ");
	add(textAreaRespuesta, BorderLayout.PAGE_END);
	add(resultado, BorderLayout.AFTER_LAST_LINE);
	//panel1.add(textAreaRespuesta);
	
	
	// Registrar un oyente para los botones de radio.
	bRadioProteinas.addActionListener (this);
	bRadioNucleotidos.addActionListener (this);
	comboSeq.addActionListener(this);

	add(lConsulta);
	add(textConsulta);
	add(textAreaRespuesta);
	//add(bRadioGrupo); NO SE PUEDE AÑADIR POR QUE NO ES UN COMPONENTE.
	add(bRadioNucleotidos);
	add(bRadioProteinas);
	add(comboSeq);
	//add(panel1);
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		JRadioButton buttonR = (JRadioButton) ev.getSource ();
		 if (buttonR == bRadioProteinas) {
			 // se selecciona la opción de proteinas
			 
		 } else if (buttonR == bRadioNucleotidos) {
			 //esta seleccionada la apción de nuecleotidos.
			 System.out.println("ERROR esta opción no esta implementada. ");
		 }
		 
		
	}

	
	public void rellenarComboBox(String secuencia) {
		
		comboSeq.addItem(secuencia);
	}
	// Para los botones radio:
	/*public void itemStateChange(evento ItemEvent) {
		
		int state = event.getStateChange ();
		if (state == ItemEvent.SELECTED) {
			// hacer algo cuando se selecciona el botón
		}else if (state == ItemEvent.DESELECTED) {
			// hacer otra cosa cuando se deselecciona el botón
			
		}
	});*/
			
	//String sec = (String)comboSeq.getSelectedItem ( ) ;
//	for(int i=0; i<comboSeq.getItemCount(); i++){
//		if((comboSeq.getItemAt(i).equals(comboSeq.getItemAt(i + 1)) && comboSeq.getItemAt(i + 1) != null )) {
//			comboSeq.removeItemAt(i);
//		}
//	}
//	String sec=comboSeq.getEditor().getItem().toString();
//	comboSeq.addItem(sec);
//	for(int i=0;i<comboSeq.getItemCount();i++) {
//		for( int j  =  comboSeq.getItemCount() - 1 ; j  >  i; j --)
//		if(comboSeq.getItemAt(j).equals(comboSeq.getItemAt(i))) {
//			comboSeq.removeItemAt(j);
//		}
//	}
	
	
	
//	comboSeq.addActionListener(new ActionListener() {
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			//String sec = (String)comboSeq.getSelectedItem ( ) ;
//			//PROBAR ESTO EN ACTIONpERFOREMED ABAJO/////////////////
//			secuencia.getSecuencia();
//			for(int i=0; i<comboSeq.getItemCount(); i++){
//				if((comboSeq.getItemAt(i).equals(comboSeq.getItemAt(i + 1)) && comboSeq.getItemAt(i + 1) != null )) {
//					comboSeq.removeItemAt(i);
//				}
//			}
//			
//		}
//		
//	});
//	bComparar.addActionListener(new ActionListener() {
//
//		@Override
//		public void actionPerformed(ActionEvent ae1) {
//			comboSeq.addItem(secun);
//			for(int i = 0; i < comboSeq.getComponentCount(); i++) {
//				if(comboSeq.getItemAt(i).equalsIgnoreCase(secun));
//				comboSeq.remove(i);
//			}
//		}
//		
//	});
//bComparar.addActionListener(comboSeq);

					
//	for(Objeto objeto : ArrayObjetos) {
//	    combito.addItem(objeto.toString());
//	}
			
}
