package uniandes.cupi2.carShowIncarpasMuscleCar.interfaz;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import uniandes.cupi2.carShowIncarpasMuscleCar.mundo.Puntos;

import TablaHashing.TablaHashing;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MenuPosiciones extends JFrame implements ActionListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNumConduc;
	private JPanel panelPuntos;
	private int numMaxConduc;
	private JScrollPane scrollPanePuntos;
	private TablaHashing<Integer, Puntos> sistemaPosiciones;
	private JPanel panelPuntosGeneral;
	private InterfazCarShowIncarpasMuscleCar iPal;


	/**
	 * Create the frame.
	 * @param interPrincipal 
	 */
	public MenuPosiciones(InterfazCarShowIncarpasMuscleCar interPrincipal) {
		
		iPal = interPrincipal;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 381, 100);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{452, 0};
		gbl_contentPane.rowHeights = new int[]{16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JTextArea txtrHolaParaEmpezar = new JTextArea();
		txtrHolaParaEmpezar.setEditable(false);
		txtrHolaParaEmpezar.setText("Hola, para empezar el campeonato se deben \nregistrar algunos datos:");
		GridBagConstraints gbc_txtrHolaParaEmpezar = new GridBagConstraints();
		gbc_txtrHolaParaEmpezar.insets = new Insets(5, 5, 5, 0);
		gbc_txtrHolaParaEmpezar.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtrHolaParaEmpezar.gridx = 0;
		gbc_txtrHolaParaEmpezar.gridy = 0;
		contentPane.add(txtrHolaParaEmpezar, gbc_txtrHolaParaEmpezar);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.anchor = GridBagConstraints.NORTH;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblCantidadMaximaDe = new JLabel("Cantidad Maxima de Competidores:");
		GridBagConstraints gbc_lblCantidadMaximaDe = new GridBagConstraints();
		gbc_lblCantidadMaximaDe.insets = new Insets(0, 0, 5, 5);
		gbc_lblCantidadMaximaDe.gridx = 0;
		gbc_lblCantidadMaximaDe.gridy = 0;
		panel.add(lblCantidadMaximaDe, gbc_lblCantidadMaximaDe);
		
		txtNumConduc = new JTextField();
		txtNumConduc.addKeyListener(this);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panel.add(txtNumConduc, gbc_textField);
		txtNumConduc.setColumns(10);
		
		JButton btnNewButton = new JButton("Ok");
		btnNewButton.addActionListener(this);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 0;
		panel.add(btnNewButton, gbc_btnNewButton);
		
		panelPuntosGeneral = new JPanel();
		panelPuntosGeneral.setVisible(false);
		panelPuntosGeneral.setBorder(new TitledBorder(null, "Posiciones y Puntos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridheight = 14;
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 2;
		contentPane.add(panelPuntosGeneral, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		panelPuntosGeneral.setLayout(gbl_panel_1);
		
		JTextArea txtrAsignaLosPuntos = new JTextArea();
		txtrAsignaLosPuntos.setEditable(false);
		txtrAsignaLosPuntos.setText("Asigna los puntos que recibir\u00E1n los competidores con \nrespecto a su puesto en cada v\u00E1lida.");
		GridBagConstraints gbc_txtrAsignaLosPuntos = new GridBagConstraints();
		gbc_txtrAsignaLosPuntos.insets = new Insets(5, 5, 5, 0);
		gbc_txtrAsignaLosPuntos.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtrAsignaLosPuntos.gridx = 0;
		gbc_txtrAsignaLosPuntos.gridy = 0;
		panelPuntosGeneral.add(txtrAsignaLosPuntos, gbc_txtrAsignaLosPuntos);
		
		scrollPanePuntos = new JScrollPane();
		
		scrollPanePuntos.setSize(280, 300);
		scrollPanePuntos.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridheight = 11;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 1;
		panelPuntosGeneral.add(scrollPanePuntos, gbc_scrollPane_1);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.anchor = GridBagConstraints.SOUTH;
		gbc_btnAceptar.gridx = 0;
		gbc_btnAceptar.gridy = 12;
		panelPuntosGeneral.add(btnAceptar, gbc_btnAceptar);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String com = e.getActionCommand();
		System.out.println(com);
		if (com.equals("Ok") && !txtNumConduc.getText().isEmpty())
		{
			numMaxConduc = Integer.parseInt(txtNumConduc.getText());
			
			
			if (numMaxConduc*30 + 250< 800)
			{
				setBounds(400, 10, 381, numMaxConduc*30 + 250);
			}
			else
			{
				setBounds(400, 10, 381, 800);
			}
			
			if ( numMaxConduc*30 < 550)
			{	scrollPanePuntos.setMinimumSize(new Dimension(300, numMaxConduc*30));}
			else 
			{	scrollPanePuntos.setMinimumSize(new Dimension(300, 550));}
			
			panelPuntos = new JPanel();
			scrollPanePuntos.setViewportView(panelPuntos);
			panelPuntos.setLayout(new GridLayout(0, 1, 0, 0));
			
			sistemaPosiciones = new TablaHashing<Integer, Puntos>(numMaxConduc, 0.8, 2);
			for (int i = 1; i <= numMaxConduc; i++) 
			{
				Integer posicion = new Integer(i);
				Puntos puntos = new Puntos(0);
				sistemaPosiciones.agregar(posicion, puntos);
				panelPuntos.add(new MenuPosicionesPuntos(i, puntos));
			}
			panelPuntosGeneral.setVisible(true);
			
			
			//validate();
		}
		else if ( com.equals("Aceptar"))
		{
			setVisible(false);
			iPal.listoPuntos( sistemaPosiciones, numMaxConduc);
			
		}
		
	}

	@Override
	public void keyPressed(KeyEvent ke) {
		
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent ke) {
		if (!Character.isDigit(ke.getKeyChar()))
		{
			ke.consume();
		}
		
	}

}
