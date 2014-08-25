package uniandes.cupi2.carShowIncarpasMuscleCar.interfaz;

import javax.swing.JPanel;

import uniandes.cupi2.carShowIncarpasMuscleCar.mundo.MuscleCar;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PanelCentral extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private InterfazCarShowIncarpasMuscleCar pPal;
	private PanelPosicionGeneral panelPosGen;
	private PanelValidas panelValidas;

	/**
	 * Create the panel.
	 * @param pPalP 
	 */
	public PanelCentral(InterfazCarShowIncarpasMuscleCar pPalP, MuscleCar mundo) {
		pPal = pPalP;
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{127, 195, 0};
		gridBagLayout.rowHeights = new int[]{73, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		panelPosGen = new PanelPosicionGeneral(mundo, pPal);
		GridBagConstraints gbc_panelPosicionGeneral = new GridBagConstraints();
		gbc_panelPosicionGeneral.fill = GridBagConstraints.BOTH;
		gbc_panelPosicionGeneral.insets = new Insets(0, 8, 0, 8);
		gbc_panelPosicionGeneral.gridx = 0;
		gbc_panelPosicionGeneral.gridy = 0;
		add(panelPosGen, gbc_panelPosicionGeneral);
		
		panelValidas = new PanelValidas(mundo, pPal);
		GridBagConstraints gbc_panelValidas = new GridBagConstraints();
		gbc_panelValidas.fill = GridBagConstraints.BOTH;
		gbc_panelValidas.gridx = 1;
		gbc_panelValidas.gridy = 0;
		add(panelValidas, gbc_panelValidas);

	}

	public void refresh() 
	{
		panelPosGen.refresh();
		panelValidas.refresh();
		
		
	}

}
