package uniandes.cupi2.carShowIncarpasMuscleCar.interfaz;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JScrollPane;

import uniandes.cupi2.carShowIncarpasMuscleCar.mundo.CapsulaPuntos;
import uniandes.cupi2.carShowIncarpasMuscleCar.mundo.MuscleCar;

import java.awt.GridLayout;
import java.util.Iterator;
import javax.swing.ScrollPaneConstants;

public class PanelPosicionGeneral extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MuscleCar mundo;
	private JPanel panelPosicionesGenerales;
	private JScrollPane scrollPane;
	private InterfazCarShowIncarpasMuscleCar pPal;

	/**
	 * Create the panel.
	 * @param pPal 
	 * @param pPalP 
	 */
	public PanelPosicionGeneral(MuscleCar mundoP, InterfazCarShowIncarpasMuscleCar pPalP) {
		pPal = pPalP;
		mundo = mundoP;
		setBorder(new TitledBorder(null, "Pocisi\u00F3n General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(0, 0));
		panel.setMinimumSize(new Dimension(100, 600));
		add(panel);
		
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel.add(scrollPane);
		
		
		panelPosicionesGenerales = new JPanel();
		panelPosicionesGenerales.setLayout(new GridLayout(1, 0, 0, 0));
		panelPosicionesGenerales.setMinimumSize(new Dimension(102, 70));
		scrollPane.setViewportView(panelPosicionesGenerales);

	}

	public void refresh() 
	{
		panelPosicionesGenerales = new JPanel();
		panelPosicionesGenerales.setLayout(new GridLayout(0, 1, 0, 0));
		panelPosicionesGenerales.setMinimumSize(new Dimension(102, 70));
		Iterator<CapsulaPuntos> iter = mundo.carreraActual.iter();
		int i = 0;
		PanelCompetidor anterior = null;
		PanelCompetidor pPrimerComp = null;
		if (iter.hasNext())
		{
			i++;
			CapsulaPuntos capsula = iter.next();
			pPrimerComp = new PanelCompetidor(null, null, capsula.conductor , mundo, i, pPal);
			pPrimerComp.primero  = pPrimerComp;
			anterior = pPrimerComp;
			panelPosicionesGenerales.add(pPrimerComp);
		}
		
		while (iter.hasNext())
		{
			
			i++;
			CapsulaPuntos capsula = iter.next();
			PanelCompetidor nuevo = new PanelCompetidor(pPrimerComp, null, capsula.conductor , mundo, i, pPal);
			panelPosicionesGenerales.add(nuevo);
			anterior.siguiente = nuevo;
			
			anterior = nuevo;
			
		}
		scrollPane.setViewportView(panelPosicionesGenerales);
		
	}

}
