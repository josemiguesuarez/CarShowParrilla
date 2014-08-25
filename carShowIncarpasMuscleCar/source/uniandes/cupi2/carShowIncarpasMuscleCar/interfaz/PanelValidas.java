package uniandes.cupi2.carShowIncarpasMuscleCar.interfaz;

import iteradorSimple.IteradorSimple;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.border.EtchedBorder;
import java.awt.Insets;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import ListaOrdenada.NodoList;


import uniandes.cupi2.carShowIncarpasMuscleCar.mundo.CapsulaPos;
import uniandes.cupi2.carShowIncarpasMuscleCar.mundo.Competidor;
import uniandes.cupi2.carShowIncarpasMuscleCar.mundo.Conductor;
import uniandes.cupi2.carShowIncarpasMuscleCar.mundo.MuscleCar;
import uniandes.cupi2.carShowIncarpasMuscleCar.mundo.Numero;
import uniandes.cupi2.carShowIncarpasMuscleCar.mundo.Valida;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;

public class PanelValidas extends JPanel implements ActionListener, KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String CAMBIAR_VALIDA = "CambiarValida";
	private static final String CAMBIAR_ORDEN = "CambiarO";
	private static final String POSICION = "Posicion";
	private static final String DESPOSICIONAR = "Desposicionar";
	private JTextField textBuscar;
	private JTextField textField_1;
	private MuscleCar mundo;
	private JComboBox cmbValidas;
	private JComboBox cmbOrganizarPor;
	private JPanel panelNoPosicionados;
	private JScrollPane scrollPaneNoPos;
	private JComboBox cmbPosicionarEn;
	private PanelCompetidor panelCompPrimeroNoPos;
	private JScrollPane scrollPanePos;
	private JPanel panelYaPosicionados;
	private PanelCompetidor panelCompPrimeroYaPos;
	private InterfazCarShowIncarpasMuscleCar pPal;
	private boolean habilitarComboBoxValida;

	/**
	 * Create the panel.
	 * @param pPal 
	 * @param mundo 
	 */
	public PanelValidas(MuscleCar mundoP, InterfazCarShowIncarpasMuscleCar pPalP) {
		pPal = pPalP;
		mundo = mundoP;
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "V\u00E1lidas", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		JPanel panelSeleccion = new JPanel();
		panelSeleccion.setBorder(new TitledBorder(null, "Selecci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panelSeleccion = new GridBagConstraints();
		gbc_panelSeleccion.insets = new Insets(0, 6, 4, 6);
		gbc_panelSeleccion.fill = GridBagConstraints.BOTH;
		gbc_panelSeleccion.gridx = 0;
		gbc_panelSeleccion.gridy = 0;
		add(panelSeleccion, gbc_panelSeleccion);
		GridBagLayout gbl_panelSeleccion = new GridBagLayout();
		gbl_panelSeleccion.columnWidths = new int[]{0, 293, 0, 0};
		gbl_panelSeleccion.rowHeights = new int[]{0, 0};
		gbl_panelSeleccion.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelSeleccion.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelSeleccion.setLayout(gbl_panelSeleccion);

		JLabel lblSeleccionarLaVlida = new JLabel("Seleccionar la V\u00E1lida:");
		GridBagConstraints gbc_lblSeleccionarLaVlida = new GridBagConstraints();
		gbc_lblSeleccionarLaVlida.anchor = GridBagConstraints.EAST;
		gbc_lblSeleccionarLaVlida.insets = new Insets(0, 16, 0, 5);
		gbc_lblSeleccionarLaVlida.gridx = 0;
		gbc_lblSeleccionarLaVlida.gridy = 0;
		panelSeleccion.add(lblSeleccionarLaVlida, gbc_lblSeleccionarLaVlida);

		cmbValidas = new JComboBox();
		cmbValidas.addActionListener(this);
		cmbValidas.setActionCommand(CAMBIAR_VALIDA);
		GridBagConstraints gbc_cmbValidas = new GridBagConstraints();
		gbc_cmbValidas.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbValidas.insets = new Insets(0, 0, 0, 5);
		gbc_cmbValidas.gridx = 1;
		gbc_cmbValidas.gridy = 0;
		panelSeleccion.add(cmbValidas, gbc_cmbValidas);

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this);
		GridBagConstraints gbc_btnAgregar = new GridBagConstraints();
		gbc_btnAgregar.gridx = 2;
		gbc_btnAgregar.gridy = 0;
		panelSeleccion.add(btnAgregar, gbc_btnAgregar);

		JPanel panelValidaSelec = new JPanel();
		panelValidaSelec.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "V\u00E1lida Seleccionada", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_panelValidaSelec = new GridBagConstraints();
		gbc_panelValidaSelec.insets = new Insets(0, 6, 0, 6);
		gbc_panelValidaSelec.fill = GridBagConstraints.BOTH;
		gbc_panelValidaSelec.gridx = 0;
		gbc_panelValidaSelec.gridy = 1;
		add(panelValidaSelec, gbc_panelValidaSelec);
		GridBagLayout gbl_panelValidaSelec = new GridBagLayout();
		gbl_panelValidaSelec.columnWidths = new int[]{275, 156, 0};
		gbl_panelValidaSelec.rowHeights = new int[]{10, 0};
		gbl_panelValidaSelec.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelValidaSelec.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelValidaSelec.setLayout(gbl_panelValidaSelec);

		JPanel panelPosicionar = new JPanel();
		panelPosicionar.setBorder(new TitledBorder(null, "Por Posicionar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panelPosicionar = new GridBagConstraints();
		gbc_panelPosicionar.insets = new Insets(0, 0, 0, 5);
		gbc_panelPosicionar.fill = GridBagConstraints.BOTH;
		gbc_panelPosicionar.gridx = 0;
		gbc_panelPosicionar.gridy = 0;
		panelValidaSelec.add(panelPosicionar, gbc_panelPosicionar);
		GridBagLayout gbl_panelPosicionar = new GridBagLayout();
		gbl_panelPosicionar.columnWidths = new int[]{100, 189, 0};
		gbl_panelPosicionar.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panelPosicionar.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelPosicionar.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panelPosicionar.setLayout(gbl_panelPosicionar);

		JLabel lblOrganizarPor = new JLabel("Organizar por:");
		lblOrganizarPor.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblOrganizarPor = new GridBagConstraints();
		gbc_lblOrganizarPor.anchor = GridBagConstraints.EAST;
		gbc_lblOrganizarPor.insets = new Insets(0, 6, 6, 5);
		gbc_lblOrganizarPor.gridx = 0;
		gbc_lblOrganizarPor.gridy = 0;
		panelPosicionar.add(lblOrganizarPor, gbc_lblOrganizarPor);

		cmbOrganizarPor = new JComboBox();
		cmbOrganizarPor.addActionListener(this);
		cmbOrganizarPor.setActionCommand(CAMBIAR_ORDEN);
		cmbOrganizarPor.addItem("Numero");
		cmbOrganizarPor.addItem("Nombre");
		cmbOrganizarPor.addItem("Vehiculo");
		GridBagConstraints gbc_cmbOrganizarPor = new GridBagConstraints();
		gbc_cmbOrganizarPor.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbOrganizarPor.insets = new Insets(0, 0, 5, 0);
		gbc_cmbOrganizarPor.gridx = 1;
		gbc_cmbOrganizarPor.gridy = 0;
		panelPosicionar.add(cmbOrganizarPor, gbc_cmbOrganizarPor);

		JLabel lblBuscar = new JLabel("Buscar:");
		lblBuscar.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblBuscar = new GridBagConstraints();
		gbc_lblBuscar.anchor = GridBagConstraints.EAST;
		gbc_lblBuscar.insets = new Insets(0, 6, 6, 5);
		gbc_lblBuscar.gridx = 0;
		gbc_lblBuscar.gridy = 1;
		panelPosicionar.add(lblBuscar, gbc_lblBuscar);

		textBuscar = new JTextField();
		textBuscar.addKeyListener(this);
		GridBagConstraints gbc_textBuscar = new GridBagConstraints();
		gbc_textBuscar.insets = new Insets(0, 0, 5, 0);
		gbc_textBuscar.fill = GridBagConstraints.HORIZONTAL;
		gbc_textBuscar.gridx = 1;
		gbc_textBuscar.gridy = 1;
		panelPosicionar.add(textBuscar, gbc_textBuscar);
		textBuscar.setColumns(10);

		JLabel lblPosicionarEn = new JLabel("Posicionar en: ");
		GridBagConstraints gbc_lblPosicionarEn = new GridBagConstraints();
		gbc_lblPosicionarEn.anchor = GridBagConstraints.EAST;
		gbc_lblPosicionarEn.insets = new Insets(0, 6, 6, 5);
		gbc_lblPosicionarEn.gridx = 0;
		gbc_lblPosicionarEn.gridy = 2;
		panelPosicionar.add(lblPosicionarEn, gbc_lblPosicionarEn);

		JPanel panel = new JPanel();
		panel.setBorder(null);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 2;
		panelPosicionar.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{116, 44, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);

		cmbPosicionarEn = new JComboBox();
		cmbPosicionarEn.addActionListener(this);
		cmbPosicionarEn.setActionCommand(POSICION);
		cmbPosicionarEn.addItem("Siguiente"); 

		refrescarPoscionesPosibles();
		
		cmbPosicionarEn.setMinimumSize(new Dimension(250, 30));
		GridBagConstraints gbc_cmbPosicionarEn = new GridBagConstraints();
		gbc_cmbPosicionarEn.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbPosicionarEn.insets = new Insets(0, 0, 0, 5);
		gbc_cmbPosicionarEn.gridx = 0;
		gbc_cmbPosicionarEn.gridy = 0;
		panel.add(cmbPosicionarEn, gbc_cmbPosicionarEn);

		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(this);
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.anchor = GridBagConstraints.EAST;
		gbc_btnOk.gridx = 1;
		gbc_btnOk.gridy = 0;
		panel.add(btnOk, gbc_btnOk);

		scrollPaneNoPos = new JScrollPane();
		scrollPaneNoPos.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 3;
		panelPosicionar.add(scrollPaneNoPos, gbc_scrollPane);

		panelNoPosicionados = new JPanel();
		scrollPaneNoPos.setViewportView(panelNoPosicionados);
		panelNoPosicionados.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panelPosicionados = new JPanel();
		panelPosicionados.setBorder(new TitledBorder(null, "Posicionados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panelPosicionados = new GridBagConstraints();
		gbc_panelPosicionados.fill = GridBagConstraints.BOTH;
		gbc_panelPosicionados.gridx = 1;
		gbc_panelPosicionados.gridy = 0;
		panelValidaSelec.add(panelPosicionados, gbc_panelPosicionados);
		GridBagLayout gbl_panelPosicionados = new GridBagLayout();
		gbl_panelPosicionados.columnWidths = new int[]{0, 130, 0};
		gbl_panelPosicionados.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panelPosicionados.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelPosicionados.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panelPosicionados.setLayout(gbl_panelPosicionados);

		JButton Consolidar = new JButton("Consolidar Valida");

		GridBagConstraints gbc_Consolidar = new GridBagConstraints();
		gbc_Consolidar.gridwidth = 2;
		gbc_Consolidar.insets = new Insets(0, 0, 5, 0);
		gbc_Consolidar.fill = GridBagConstraints.HORIZONTAL;
		gbc_Consolidar.gridx = 0;
		gbc_Consolidar.gridy = 0;
		panelPosicionados.add(Consolidar, gbc_Consolidar);

		JButton btnDesposicionar = new JButton(DESPOSICIONAR);
		btnDesposicionar.addActionListener(this);
		GridBagConstraints gbc_btnDesposicionar = new GridBagConstraints();
		gbc_btnDesposicionar.gridwidth = 2;
		gbc_btnDesposicionar.insets = new Insets(0, 0, 5, 0);
		gbc_btnDesposicionar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDesposicionar.gridx = 0;
		gbc_btnDesposicionar.gridy = 1;
		panelPosicionados.add(btnDesposicionar, gbc_btnDesposicionar);

		JLabel lblEditarPosicin = new JLabel("Editar Posici\u00F3n");
		GridBagConstraints gbc_lblEditarPosicin = new GridBagConstraints();
		gbc_lblEditarPosicin.insets = new Insets(0, 0, 5, 5);
		gbc_lblEditarPosicin.gridx = 0;
		gbc_lblEditarPosicin.gridy = 2;
		panelPosicionados.add(lblEditarPosicin, gbc_lblEditarPosicin);

		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 2;
		panelPosicionados.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);

		scrollPanePos = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridwidth = 2;
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 3;
		panelPosicionados.add(scrollPanePos, gbc_scrollPane_1);

		panelYaPosicionados = new JPanel();
		scrollPanePos.setViewportView(panelYaPosicionados);
		panelYaPosicionados.setLayout(new GridLayout(1, 0, 0, 0));

	}

	private void refrescarPoscionesPosibles() {
		
		cmbPosicionarEn.removeAllItems();
		cmbPosicionarEn.addItem("Siguiente");
		if (mundo.validaActual != null)
		{
			NodoList<CapsulaPos> nodo = mundo.validaActual.listPosiciones.darPrimero();
			int tam = mundo.validaActual.todos.darLongitud();
			for (int i = 1; i <= tam; i++) {
				if (nodo != null && i == nodo.darNodo().posicion)
				{
					nodo = nodo.darSiguiente();
				}
				else
				{
					cmbPosicionarEn.addItem(i);
				}
			}
		}
	}

	private void refrescarCmbValidas() {
		System.out.println("\n" + mundo.validaActual.toString() + "----\t");
		Iterator<Valida> iter = mundo.carreraActual.validas.iterator();
		cmbValidas.removeAllItems();
		while (iter.hasNext())
		{
			Valida elem = iter.next();
			System.out.println("Se a–ade a el combo validas: " + elem.toString());
			cmbValidas.addItem(elem);
		}
		cmbValidas.setSelectedItem(mundo.validaActual);
		System.out.print(mundo.validaActual.toString());




	}

	private void refreshListaNoPos() {
		if ( cmbOrganizarPor.getSelectedIndex() == 0)
		{
			Iterator<Competidor> iterNumer = mundo.validaActual.listNumeros.iterator();
			refreshNoPosicionados(iterNumer);
		}
		else if (cmbOrganizarPor.getSelectedIndex() == 1)
		{
			Iterator<Competidor> iterNumer = mundo.validaActual.trConductores.iterator();
			refreshNoPosicionados(iterNumer);
		}
		else
		{
			Iterator<Competidor> iterNumer = mundo.validaActual.trVehiculos.iterator();
			refreshNoPosicionados(iterNumer);
		}
	}

	private void refreshNoPosicionados(Iterator<Competidor> iterNumer) {


		panelNoPosicionados = new JPanel(new GridLayout(0, 1, 0, 0));
		panelCompPrimeroNoPos = null;
		PanelCompetidor anterior = null;
		if (iterNumer.hasNext())
		{
			panelCompPrimeroNoPos = new PanelCompetidor(null, null, iterNumer.next().conductor, mundo, 0, pPal);
			panelCompPrimeroNoPos.primero = panelCompPrimeroNoPos;
			anterior = panelCompPrimeroNoPos;
			panelNoPosicionados.add(panelCompPrimeroNoPos);

		}
		while (iterNumer.hasNext())
		{
			PanelCompetidor actual = new PanelCompetidor(panelCompPrimeroNoPos, null, iterNumer.next().conductor, mundo, 0, pPal);
			panelNoPosicionados.add(actual);
			anterior.siguiente = actual;

			anterior = actual;
		}
		if (scrollPaneNoPos != null)
			scrollPaneNoPos.setViewportView(panelNoPosicionados);
	}

	public void refresh() {

		habilitarComboBoxValida = false;
		refrescarCmbValidas();
		refreshListaNoPos();
		refreshPosicionados();
		refrescarPoscionesPosibles();
		habilitarComboBoxValida = true;
	}

	private void refreshPosicionados() {
		if (mundo.validaActual != null) {
			Iterator<CapsulaPos> iterNumer = mundo.validaActual.listPosiciones
					.iterator();
			panelYaPosicionados = new JPanel(new GridLayout(0, 1, 0, 0));
			panelCompPrimeroYaPos = null;
			PanelCompetidor anterior = null;
			CapsulaPos capsulaPos;
			if (iterNumer.hasNext()) {
				capsulaPos = iterNumer.next();
				panelCompPrimeroYaPos = new PanelCompetidor(null, null,
						capsulaPos.conductor, mundo, capsulaPos.posicion, pPal, mundo.validaActual);
				panelCompPrimeroYaPos.primero = panelCompPrimeroYaPos;
				anterior = panelCompPrimeroYaPos;
				panelYaPosicionados.add(panelCompPrimeroYaPos);
			}
			while (iterNumer.hasNext()) {
				capsulaPos = iterNumer.next();
				PanelCompetidor actual = new PanelCompetidor(
						panelCompPrimeroNoPos,
						null, 
						capsulaPos.conductor, 
						mundo, capsulaPos.posicion, pPal, 
						mundo.validaActual);
				panelYaPosicionados.add(actual);
				anterior.siguiente = actual;

				anterior = actual;
			}
			if (scrollPanePos != null)
				scrollPanePos.setViewportView(panelYaPosicionados);
		}
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		String com = a.getActionCommand();
		if (com.equals(CAMBIAR_VALIDA))
		{
			if (((Valida) cmbValidas.getSelectedItem()) != null && habilitarComboBoxValida)
			{
				mundo.validaActual = (Valida) cmbValidas.getSelectedItem();
				refreshListaNoPos();
				refreshPosicionados();
			}

		}
		else if (com.equals(CAMBIAR_ORDEN))
		{
			if ( textBuscar != null)
				textBuscar.setText("");
			refreshListaNoPos();
		}
		else if (com.equals("Ok"))
		{
			if ( panelCompPrimeroNoPos != null)
			{
				if ( cmbPosicionarEn.getSelectedIndex() == 0)
				{
					mundo.posicionar ( panelCompPrimeroNoPos.getSeleccionado().conductor, 0);
				}
				else
				{
					int i = (Integer) cmbPosicionarEn.getSelectedItem();
					mundo.posicionar ( panelCompPrimeroNoPos.getSeleccionado().conductor, i);
				}
				
				pPal.refresh();
			}			
		}
		else if (com.equals("Agregar"))
		{
			mundo.addValida(null);
			pPal.refresh();
		}
		else if ( com.equals(DESPOSICIONAR))
		{
			mundo.deseposicionar (panelCompPrimeroYaPos.getSeleccionado().conductor );
			pPal.refresh();
		}

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if ( e.getComponent() == textBuscar)
		{

			if ( textBuscar.getText().isEmpty())
			{
				Iterator<Competidor> iterTodos = mundo.validaActual.listNumeros.iterator();
				refreshNoPosicionados(iterTodos);
			}
			else if (cmbOrganizarPor.getSelectedIndex() == 0)
			{
				IteradorSimple<Competidor> iterNumer = new IteradorSimple<Competidor>();
				Numero num = new Numero(Integer.parseInt(textBuscar.getText()));
				num.conductor = new Conductor("", "", "", "", "", "");
				num.conductor.id = num;
				Competidor comp = mundo.validaActual.listNumeros.bucarElemento(num);
				if ( comp != null)
				{
					System.out.println("Solo se da un competidor");
					iterNumer.add(comp);
					refreshNoPosicionados(iterNumer);
				}

				else 
				{
					refreshNoPosicionados(mundo.validaActual.listNumeros.iterator());

				}
			}
			else 
			{
				IteradorSimple<Competidor> iter;
				if (cmbOrganizarPor.getSelectedIndex() == 1)
				{
					iter = mundo.validaActual.trConductores.buscarPorPrefijo(textBuscar.getText());
					if (!iter.hasNext())
					{
						iter = mundo.validaActual.trConductores.iterator();
					}
				}
				else
				{
					iter = mundo.validaActual.trVehiculos.buscarPorPrefijo(textBuscar.getText());
					if (!iter.hasNext())
					{
						iter = mundo.validaActual.trVehiculos.iterator();
					}
				}
				refreshNoPosicionados(iter);


			}
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		if ( e.getComponent() == textBuscar)
		{
			if (cmbOrganizarPor.getSelectedIndex() == 0)
			{
				if ( !Character.isDigit(e.getKeyChar()))
				{
					e.consume();
				}
			}
		}


	}

}
