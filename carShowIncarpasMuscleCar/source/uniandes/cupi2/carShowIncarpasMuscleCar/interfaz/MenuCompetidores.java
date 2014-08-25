package uniandes.cupi2.carShowIncarpasMuscleCar.interfaz;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JScrollPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Iterator;

import uniandes.cupi2.carShowIncarpasMuscleCar.mundo.Competidor;
import uniandes.cupi2.carShowIncarpasMuscleCar.mundo.Conductor;
import uniandes.cupi2.carShowIncarpasMuscleCar.mundo.MuscleCar;
import uniandes.cupi2.carShowIncarpasMuscleCar.mundo.Numero;
import uniandes.cupi2.carShowIncarpasMuscleCar.mundo.Vehiculo;

import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.ListSelectionModel;


public class MenuCompetidores extends JFrame implements ActionListener, ListSelectionListener, FocusListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String TODOS = "Todos";
	private static final String NO_USADOS = "No registrados";
	private static final String USADOS = "Registrados";
	private static final String MOSTRAR = "Mostrar";
	private static final String CONTINUAR = "Continuar";
	private static final String GUARDAR = "Guardar";
	private static final String EDITAR = "editar";
	private static final String ALEATORIO = "Aleatorio";
	private static final String RELLENAR = "Rellene Todos Los Campos";
	private JPanel contentPane;
	private InterfazCarShowIncarpasMuscleCar pPal;
	private JTextField textNombre;
	private JTextField textDocumento;
	private JTextField textRH;
	private JTextField textCorreo;
	private JTextField textCelular;
	private JTextField textMarca;
	private JTextField textModelo;
	private JTextField textPlaca;
	private JTextField textColor;
	private JTextField textAlias;
	private JList list;
	private JComboBox comboBox;
	private String mostrar;
	private MuscleCar mundo;
	private Numero numeroActual;
	private JButton btnEditar;
	private Numero conductorAEditar;
	private boolean inicializacion;



	/**
	 * Create the frame.
	 * @param conductor 
	 * @param inicializacion 
	 * @param numMaxConduc 
	 */
	public MenuCompetidores(MuscleCar mundoP, InterfazCarShowIncarpasMuscleCar pPalP, boolean inicializacionP, Conductor conductor) {
		
		pPal = pPalP;
		mundo = mundoP;
		mostrar = TODOS;
		conductorAEditar = null;
		inicializacion = inicializacionP;
		numeroActual = (Numero) mundo.listNumeros.darPrimero().darNodo();

		setTitle("Agregar Competidores");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{346, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);



		JButton btnContinuar = new JButton(CONTINUAR);
		btnContinuar.addActionListener(this);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Registro Seleccionado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 0;
		contentPane.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Informaci\u00F3n Conductor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 0;
		panel_2.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);

		JLabel lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 0;
		panel_3.add(lblNombre, gbc_lblNombre);

		textNombre = new JTextField();
		GridBagConstraints gbc_textNombre = new GridBagConstraints();
		gbc_textNombre.insets = new Insets(0, 0, 5, 0);
		gbc_textNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNombre.gridx = 1;
		gbc_textNombre.gridy = 0;
		panel_3.add(textNombre, gbc_textNombre);
		textNombre.setColumns(10);

		JLabel lblDocumento = new JLabel("Documento:");
		GridBagConstraints gbc_lblDocumento = new GridBagConstraints();
		gbc_lblDocumento.anchor = GridBagConstraints.EAST;
		gbc_lblDocumento.insets = new Insets(0, 0, 5, 5);
		gbc_lblDocumento.gridx = 0;
		gbc_lblDocumento.gridy = 1;
		panel_3.add(lblDocumento, gbc_lblDocumento);

		textDocumento = new JTextField();
		GridBagConstraints gbc_textDocumento = new GridBagConstraints();
		gbc_textDocumento.insets = new Insets(0, 0, 5, 0);
		gbc_textDocumento.fill = GridBagConstraints.HORIZONTAL;
		gbc_textDocumento.gridx = 1;
		gbc_textDocumento.gridy = 1;
		panel_3.add(textDocumento, gbc_textDocumento);
		textDocumento.setColumns(10);

		JLabel lblGsRh = new JLabel("G.S. RH:");
		GridBagConstraints gbc_lblGsRh = new GridBagConstraints();
		gbc_lblGsRh.anchor = GridBagConstraints.EAST;
		gbc_lblGsRh.insets = new Insets(0, 0, 5, 5);
		gbc_lblGsRh.gridx = 0;
		gbc_lblGsRh.gridy = 2;
		panel_3.add(lblGsRh, gbc_lblGsRh);

		textRH = new JTextField();
		GridBagConstraints gbc_textRH = new GridBagConstraints();
		gbc_textRH.insets = new Insets(0, 0, 5, 0);
		gbc_textRH.fill = GridBagConstraints.HORIZONTAL;
		gbc_textRH.gridx = 1;
		gbc_textRH.gridy = 2;
		panel_3.add(textRH, gbc_textRH);
		textRH.setColumns(10);

		JLabel lblCorreo = new JLabel("Correo:");
		GridBagConstraints gbc_lblCorreo = new GridBagConstraints();
		gbc_lblCorreo.anchor = GridBagConstraints.EAST;
		gbc_lblCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorreo.gridx = 0;
		gbc_lblCorreo.gridy = 3;
		panel_3.add(lblCorreo, gbc_lblCorreo);

		textCorreo = new JTextField();
		GridBagConstraints gbc_textCorreo = new GridBagConstraints();
		gbc_textCorreo.insets = new Insets(0, 0, 5, 0);
		gbc_textCorreo.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCorreo.gridx = 1;
		gbc_textCorreo.gridy = 3;
		panel_3.add(textCorreo, gbc_textCorreo);
		textCorreo.setColumns(10);

		JLabel lblCelular = new JLabel("Celular:");
		GridBagConstraints gbc_lblCelular = new GridBagConstraints();
		gbc_lblCelular.anchor = GridBagConstraints.EAST;
		gbc_lblCelular.insets = new Insets(0, 0, 0, 5);
		gbc_lblCelular.gridx = 0;
		gbc_lblCelular.gridy = 4;
		panel_3.add(lblCelular, gbc_lblCelular);

		textCelular = new JTextField();
		GridBagConstraints gbc_textCelular = new GridBagConstraints();
		gbc_textCelular.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCelular.gridx = 1;
		gbc_textCelular.gridy = 4;
		panel_3.add(textCelular, gbc_textCelular);
		textCelular.setColumns(10);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Informaci\u00F3n Veh\u00EDculo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 1;
		panel_2.add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{0, 0, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_4.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);

		JLabel lblMarca = new JLabel("Marca:");
		GridBagConstraints gbc_lblMarca = new GridBagConstraints();
		gbc_lblMarca.anchor = GridBagConstraints.EAST;
		gbc_lblMarca.insets = new Insets(0, 0, 5, 5);
		gbc_lblMarca.gridx = 0;
		gbc_lblMarca.gridy = 0;
		panel_4.add(lblMarca, gbc_lblMarca);

		textMarca = new JTextField();
		GridBagConstraints gbc_textMarca = new GridBagConstraints();
		gbc_textMarca.insets = new Insets(0, 0, 5, 0);
		gbc_textMarca.fill = GridBagConstraints.HORIZONTAL;
		gbc_textMarca.gridx = 1;
		gbc_textMarca.gridy = 0;
		panel_4.add(textMarca, gbc_textMarca);
		textMarca.setColumns(10);

		JLabel lblModelo = new JLabel("Modelo:");
		GridBagConstraints gbc_lblModelo = new GridBagConstraints();
		gbc_lblModelo.anchor = GridBagConstraints.EAST;
		gbc_lblModelo.insets = new Insets(0, 0, 5, 5);
		gbc_lblModelo.gridx = 0;
		gbc_lblModelo.gridy = 1;
		panel_4.add(lblModelo, gbc_lblModelo);

		textModelo = new JTextField();
		GridBagConstraints gbc_textModelo = new GridBagConstraints();
		gbc_textModelo.insets = new Insets(0, 0, 5, 0);
		gbc_textModelo.fill = GridBagConstraints.HORIZONTAL;
		gbc_textModelo.gridx = 1;
		gbc_textModelo.gridy = 1;
		panel_4.add(textModelo, gbc_textModelo);
		textModelo.setColumns(10);

		JLabel lblPlaca = new JLabel("Placa:");
		GridBagConstraints gbc_lblPlaca = new GridBagConstraints();
		gbc_lblPlaca.anchor = GridBagConstraints.EAST;
		gbc_lblPlaca.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlaca.gridx = 0;
		gbc_lblPlaca.gridy = 2;
		panel_4.add(lblPlaca, gbc_lblPlaca);

		textPlaca = new JTextField();
		GridBagConstraints gbc_textPlaca = new GridBagConstraints();
		gbc_textPlaca.insets = new Insets(0, 0, 5, 0);
		gbc_textPlaca.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPlaca.gridx = 1;
		gbc_textPlaca.gridy = 2;
		panel_4.add(textPlaca, gbc_textPlaca);
		textPlaca.setColumns(10);

		JLabel lblColor = new JLabel("Color:");
		GridBagConstraints gbc_lblColor = new GridBagConstraints();
		gbc_lblColor.anchor = GridBagConstraints.EAST;
		gbc_lblColor.insets = new Insets(0, 0, 5, 5);
		gbc_lblColor.gridx = 0;
		gbc_lblColor.gridy = 3;
		panel_4.add(lblColor, gbc_lblColor);

		textColor = new JTextField();
		GridBagConstraints gbc_textColor = new GridBagConstraints();
		gbc_textColor.insets = new Insets(0, 0, 5, 0);
		gbc_textColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_textColor.gridx = 1;
		gbc_textColor.gridy = 3;
		panel_4.add(textColor, gbc_textColor);
		textColor.setColumns(10);

		JLabel lblAlias = new JLabel("Alias:");
		GridBagConstraints gbc_lblAlias = new GridBagConstraints();
		gbc_lblAlias.anchor = GridBagConstraints.EAST;
		gbc_lblAlias.insets = new Insets(0, 0, 0, 5);
		gbc_lblAlias.gridx = 0;
		gbc_lblAlias.gridy = 4;
		panel_4.add(lblAlias, gbc_lblAlias);

		textAlias = new JTextField();
		GridBagConstraints gbc_textAlias = new GridBagConstraints();
		gbc_textAlias.fill = GridBagConstraints.HORIZONTAL;
		gbc_textAlias.gridx = 1;
		gbc_textAlias.gridy = 4;
		panel_4.add(textAlias, gbc_textAlias);
		textAlias.setColumns(10);

		JPanel panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 2;
		panel_2.add(panel_5, gbc_panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{0, 0};
		gbl_panel_5.rowHeights = new int[]{0, 0};
		gbl_panel_5.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);

		btnEditar = new JButton(RELLENAR);
		btnEditar.addActionListener(this);
		GridBagConstraints gbc_btnEditar = new GridBagConstraints();
		gbc_btnEditar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEditar.gridx = 0;
		gbc_btnEditar.gridy = 0;
		panel_5.add(btnEditar, gbc_btnEditar);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(null, "Seleccionar Registro", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.insets = new Insets(0, 0, 5, 5);
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 0;
		gbc_panel_6.gridy = 0;
		contentPane.add(panel_6, gbc_panel_6);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[]{340, 0};
		gbl_panel_6.rowHeights = new int[]{29, 0, 0};
		gbl_panel_6.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_6.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_6.setLayout(gbl_panel_6);

		comboBox = new JComboBox();
		comboBox.setActionCommand(MOSTRAR);
		comboBox.addItem(TODOS);
		comboBox.addItem(NO_USADOS);
		comboBox.addItem(USADOS);
		comboBox.addItem(ALEATORIO);
		comboBox.addActionListener(this);

		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 0;
		panel_6.add(comboBox, gbc_comboBox);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panel_6.add(scrollPane, gbc_scrollPane);

		list = new JList();
		scrollPane.setViewportView(list);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		GridBagConstraints gbc_btnAgregarAprovados = new GridBagConstraints();
		gbc_btnAgregarAprovados.gridwidth = 2;
		gbc_btnAgregarAprovados.anchor = GridBagConstraints.SOUTH;
		gbc_btnAgregarAprovados.gridx = 0;
		gbc_btnAgregarAprovados.gridy = 1;
		contentPane.add(btnContinuar, gbc_btnAgregarAprovados);

		
		//textAlias;
		textCelular.addKeyListener(Constantes.SOLO_NUMERO);
		textColor.addKeyListener(Constantes.CONVERT_TO_MAYUSCULAS);
		textDocumento.addKeyListener(Constantes.SOLO_NUMERO);
		textMarca.addKeyListener(Constantes.CONVERT_TO_MAYUSCULAS);
		textModelo.addKeyListener(Constantes.SOLO_NUMERO);
		textNombre.addKeyListener(Constantes.CONVERT_TO_CAPITAL);
		textPlaca.addKeyListener(Constantes.CONVERT_TO_MAYUSCULAS);
		textRH.addKeyListener(Constantes.CONVERT_TO_MAYUSCULAS);
		textAlias.addKeyListener(Constantes.CONVERT_TO_MAYUSCULAS);
		
		textCelular.addFocusListener(Constantes.GREEN_WHEN_NOT_NULL);
		textColor.addFocusListener(Constantes.GREEN_WHEN_NOT_NULL);
		textCorreo.addFocusListener(Constantes.GREEN_WHEN_NOT_NULL);
		textDocumento.addFocusListener(Constantes.GREEN_WHEN_NOT_NULL);
		textMarca.addFocusListener(Constantes.GREEN_WHEN_NOT_NULL);
		textModelo.addFocusListener(Constantes.GREEN_WHEN_NOT_NULL);
		textNombre.addFocusListener(Constantes.GREEN_WHEN_NOT_NULL);
		textPlaca.addFocusListener(Constantes.GREEN_WHEN_NOT_NULL);
		textRH.addFocusListener(Constantes.GREEN_WHEN_NOT_NULL);
		textAlias.addFocusListener(Constantes.GREEN_WHEN_NOT_NULL);
		
		textCelular.addFocusListener(this);
		textColor.addFocusListener(this);
		textCorreo.addFocusListener(this);
		textDocumento.addFocusListener(this);
		textMarca.addFocusListener(this);
		textModelo.addFocusListener(this);
		textNombre.addFocusListener(this);
		textPlaca.addFocusListener(this);
		textRH.addFocusListener(this);
		textAlias.addFocusListener(this);

		refreshListaRegistros();
		setSize(730, 500);
		setResizable(false);


		if (conductor != null)
		{
			list.setSelectedValue(conductor.id, true);
		}
	}
	
	protected void paintComponent(Graphics g)
    {
        g.setColor( getBackground() );
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponents(g);
    }



	private void refreshListaRegistros() {
		Iterator<Competidor> iter = mundo.listNumeros.iterator();
		Numero [] numeros = new Numero[mundo.numMaxConduc];
		int numSelec=0;
		int cont = 0;
		for (int i = 0; i < mundo.numMaxConduc; i++) 
		{
			Numero num = (Numero) iter.next();
			if (mostrar.equals(TODOS))
				numeros[i] = num;
			else if ( (mostrar.equals(NO_USADOS)|| mostrar.equals(ALEATORIO)) && num.conductor == null)
			{
				numeros[i] = num;
				cont ++;
			}
			else if (mostrar.equals(USADOS) && num.conductor != null)
			{
				numeros[i] = num;
				cont++;
			}


		}
		if (mostrar.equals(ALEATORIO))
		{
			Numero numeroP = null;
			int cota = mundo.numMaxConduc;
			while (numeroP == null && cota != 0)
			{
				double alea = Math.random();
				numSelec = (int) Math.floor(alea*(mundo.numMaxConduc));
				if ( alea != 1)					
					numeroP = numeros[numSelec];

				cota--;
			}
			for (int i = 0; i < numeros.length; i++) {
				if ( numeros[i] != numeroP)
					numeros[i] = null;
			}
			numeroActual = numeroP;

		}
		else if (mostrar.equals(NO_USADOS) || mostrar.equals(USADOS))
		{
			Numero[] numerosSupl = new Numero[cont];
			int j = 0;
			for (int i = 0; i < cont; i++) 
			{
				while (numerosSupl[i] == null)
				{
					numerosSupl[i] = numeros[j];
					j++;
				}

			}
			numeros = numerosSupl;
		}
		list.setListData(numeros);
		list.setSelectedValue(numeroActual, true);
		list.addListSelectionListener(this);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		String com = e.getActionCommand();
		if (com.equals(CONTINUAR))
		{
			setVisible(false);
			if (inicializacion)
			{
				pPal.listoConductores();
			}
			
		}
		else if (com.equals(MOSTRAR)) 
		{
			mostrar = (String) comboBox.getSelectedItem();
			refreshListaRegistros();
			list.setSelectedIndex(0);
		}
		else if ( com.equals(GUARDAR))
		{
			if ( conductorAEditar != null)
			{
				mundo.eliminarConductor(conductorAEditar.conductor.nombre, conductorAEditar.conductor.nombre, conductorAEditar.numero);
			}
			Conductor conductor = new Conductor(textNombre.getText(), "", textDocumento.getText(), textRH.getText(), textCorreo.getText(), textCelular.getText());
			Vehiculo vehip = new Vehiculo(textAlias.getText(), textMarca.getText(), textModelo.getText(), textPlaca.getText(), textColor.getText());
			mundo.addCompetidor(numeroActual, conductor, vehip);

			noEditable();
			refreshListaRegistros();
			if ( mostrar.equals(NO_USADOS))
				list.setSelectedIndex(0);
		}
		else if (com.equals(EDITAR))
		{
			conductorAEditar = (Numero) list.getSelectedValue();
			editable();
		}



	}



	private void noEditable() {
		textAlias.setEditable(false);
		textCelular.setEditable(false);
		textColor.setEditable(false);
		textCorreo.setEditable(false);
		textDocumento.setEditable(false);
		textMarca.setEditable(false);
		textModelo.setEditable(false);
		textNombre.setEditable(false);
		textPlaca.setEditable(false);
		textRH.setEditable(false);

		btnEditar.setText(EDITAR);
		btnEditar.setActionCommand(EDITAR);
	}

	private void editable() {
		textAlias.setEditable(true);
		textCelular.setEditable(true);
		textColor.setEditable(true);
		textCorreo.setEditable(true);
		textDocumento.setEditable(true);
		textMarca.setEditable(true);
		textModelo.setEditable(true);
		textNombre.setEditable(true);
		textPlaca.setEditable(true);
		textRH.setEditable(true);

		btnEditar.setText(GUARDAR);
		btnEditar.setActionCommand(GUARDAR);

	}

	@Override
	public void valueChanged(ListSelectionEvent le) {

		if (list.getSelectedValue()!= null)
		{
			conductorAEditar = null;
			numeroActual = (Numero) list.getSelectedValue();
			
			if ( numeroActual.conductor != null)
			{
				
				btnEditar.setText(EDITAR);
				btnEditar.setActionCommand(GUARDAR);
				mostrarDatosConductor();
				noEditable();
			}
			else
			{
				if ( comprobarRelleno())
				{
					borrarCampos();
					btnEditar.setText(GUARDAR);
					btnEditar.setActionCommand(GUARDAR);
					btnEditar.setEnabled(true);
					editable();
				}
				else
				{
					borrarCampos();
					btnEditar.setText(RELLENAR);
					btnEditar.setActionCommand(RELLENAR);
					btnEditar.setEnabled(false);
				}
				
			}
		}
	}



	private boolean comprobarRelleno() {
		boolean comprobacion = true;
		comprobacion = comprobacion && textAlias.getText() != null && !textAlias.getText().equals("");
		comprobacion = comprobacion && textCelular.getText() != null && !textCelular.getText().equals("");
		comprobacion = comprobacion && textColor.getText() != null && !textColor.getText().equals("");
		comprobacion = comprobacion && textCorreo.getText() != null && !textCorreo.getText().equals("");
		comprobacion = comprobacion && textDocumento.getText() != null && !textDocumento.getText().equals("");
		comprobacion = comprobacion && textMarca.getText() != null && !textMarca.getText().equals("");
		comprobacion = comprobacion && textModelo.getText() != null && !textModelo.getText().equals("");
		comprobacion = comprobacion && textNombre.getText() != null && !textNombre.getText().equals("");
		comprobacion = comprobacion && textPlaca.getText() != null && !textPlaca.getText().equals("");
		comprobacion = comprobacion && textRH.getText() != null && !textRH.getText().equals("");
		return comprobacion;
		
	}

	private void mostrarDatosConductor() {
		textAlias.setText(numeroActual.conductor.vehiculo.nombre);
		textCelular.setText(numeroActual.conductor.celular);
		textColor.setText(numeroActual.conductor.vehiculo.color);
		textCorreo.setText(numeroActual.conductor.correo);
		textDocumento.setText(numeroActual.conductor.documento);
		textMarca.setText(numeroActual.conductor.vehiculo.marca);
		textModelo.setText(numeroActual.conductor.vehiculo.modelo);
		textNombre.setText(numeroActual.conductor.nombre);
		textPlaca.setText(numeroActual.conductor.vehiculo.placa);
		textRH.setText(numeroActual.conductor.gsrh);

	}



	private void borrarCampos() {
		textAlias.setText("");
		textCelular.setText("");
		textColor.setText("");
		textCorreo.setText("");
		textDocumento.setText("");
		textMarca.setText("");
		textModelo.setText("");
		textNombre.setText("");
		textPlaca.setText("");
		textRH.setText("");

	}

	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		if ( comprobarRelleno())
		{
			btnEditar.setText(GUARDAR);
			btnEditar.setActionCommand(GUARDAR);
			editable();
			btnEditar.setEnabled(true);
		}
		
	}





}
