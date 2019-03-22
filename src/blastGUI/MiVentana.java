package blastGUI;

import javax.swing.*;
import java.awt.*;

public class MiVentana extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MiVentana() {
		super("Comparador de secuencias: ");
		setSize(600, 800);
		
		
		setLocation(600, 150);
		
		setExtendedState(Frame.NORMAL);
		
		PanelTexto2 miTexto = new PanelTexto2();
		//PanelTexto miTexto = new PanelTexto();
		add(miTexto);
		//this.setVisible(true);
	}
}


