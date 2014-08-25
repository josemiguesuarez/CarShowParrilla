package uniandes.cupi2.carShowIncarpasMuscleCar.interfaz;


import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;


public class Contrasena extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblConfirmacinContrasea;
	private JTextField textField_1;
	private JLabel lblDirectorio;
	private JButton btnSeleccionarDirectorio;
	private JLabel lblDirectorio_1;
	private JButton btnSeleccionarDirectorio_1;
	private JButton btnContinuar;


	private String ruta1;
	private String ruta2;
	private InterfazCarShowIncarpasMuscleCar pPal;

	/**
	 * Create the frame.
	 * @param pPalP 
	 */
	public Contrasena(InterfazCarShowIncarpasMuscleCar pPalP) {
		pPal = pPalP;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{181, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblPorFavorElija = new JLabel("Por favor elija una contrase\u00F1a y una directorio para el progrma");
		GridBagConstraints gbc_lblPorFavorElija = new GridBagConstraints();
		gbc_lblPorFavorElija.gridwidth = 2;
		gbc_lblPorFavorElija.insets = new Insets(0, 0, 5, 0);
		gbc_lblPorFavorElija.gridx = 0;
		gbc_lblPorFavorElija.gridy = 1;
		contentPane.add(lblPorFavorElija, gbc_lblPorFavorElija);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
		gbc_lblContrasea.anchor = GridBagConstraints.EAST;
		gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasea.gridx = 0;
		gbc_lblContrasea.gridy = 3;
		contentPane.add(lblContrasea, gbc_lblContrasea);
		
		textField = new JTextField();
		textField.setMinimumSize(new Dimension(100, 30));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.WEST;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 3;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		lblConfirmacinContrasea = new JLabel("Confirmaci\u00F3n contrase\u00F1a:");
		GridBagConstraints gbc_lblConfirmacinContrasea = new GridBagConstraints();
		gbc_lblConfirmacinContrasea.anchor = GridBagConstraints.EAST;
		gbc_lblConfirmacinContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblConfirmacinContrasea.gridx = 0;
		gbc_lblConfirmacinContrasea.gridy = 4;
		contentPane.add(lblConfirmacinContrasea, gbc_lblConfirmacinContrasea);
		
		textField_1 = new JTextField();
		textField_1.setMinimumSize(new Dimension(100, 30));
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.anchor = GridBagConstraints.WEST;
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 4;
		contentPane.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		lblDirectorio = new JLabel("Directorio:");
		GridBagConstraints gbc_lblDirectorio = new GridBagConstraints();
		gbc_lblDirectorio.insets = new Insets(0, 0, 5, 5);
		gbc_lblDirectorio.gridx = 0;
		gbc_lblDirectorio.gridy = 6;
		contentPane.add(lblDirectorio, gbc_lblDirectorio);
		
		btnSeleccionarDirectorio = new JButton("Seleccionar Directorio");
		btnSeleccionarDirectorio.addActionListener(this);
		GridBagConstraints gbc_btnSeleccionarDirectorio = new GridBagConstraints();
		gbc_btnSeleccionarDirectorio.anchor = GridBagConstraints.WEST;
		gbc_btnSeleccionarDirectorio.insets = new Insets(0, 0, 5, 0);
		gbc_btnSeleccionarDirectorio.gridx = 1;
		gbc_btnSeleccionarDirectorio.gridy = 6;
		contentPane.add(btnSeleccionarDirectorio, gbc_btnSeleccionarDirectorio);
		
		lblDirectorio_1 = new JLabel("Directorio 2:");
		GridBagConstraints gbc_lblDirectorio_1 = new GridBagConstraints();
		gbc_lblDirectorio_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblDirectorio_1.gridx = 0;
		gbc_lblDirectorio_1.gridy = 7;
		contentPane.add(lblDirectorio_1, gbc_lblDirectorio_1);
		
		btnSeleccionarDirectorio_1 = new JButton("Seleccionar Directorio 2");
		btnSeleccionarDirectorio_1.addActionListener(this);
		GridBagConstraints gbc_btnSeleccionarDirectorio_1 = new GridBagConstraints();
		gbc_btnSeleccionarDirectorio_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnSeleccionarDirectorio_1.anchor = GridBagConstraints.WEST;
		gbc_btnSeleccionarDirectorio_1.gridx = 1;
		gbc_btnSeleccionarDirectorio_1.gridy = 7;
		contentPane.add(btnSeleccionarDirectorio_1, gbc_btnSeleccionarDirectorio_1);
		
		btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(this);
		GridBagConstraints gbc_btnContinuar = new GridBagConstraints();
		gbc_btnContinuar.gridwidth = 2;
		gbc_btnContinuar.insets = new Insets(0, 0, 0, 5);
		gbc_btnContinuar.gridx = 0;
		gbc_btnContinuar.gridy = 9;
		contentPane.add(btnContinuar, gbc_btnContinuar);
		ruta1 ="";
		ruta2 = "";
	}



	@Override
	public void actionPerformed(ActionEvent a) {
		if (a.getActionCommand().equals("Continuar"))
		{
			if (!textField.getText().isEmpty() && !textField_1.getText().isEmpty() && textField.getText().equals(textField_1.getText()))
			{
				if ( !ruta1.isEmpty() && !ruta2.isEmpty() && !ruta1.equals(ruta2))
				{
					pPal.menuPos(ruta1, ruta2, textField.getText());
					setVisible(false);
				}
			}
		}
		else if (a.getActionCommand().equals("Seleccionar Directorio"))
		{
			JFileChooser fc = new JFileChooser( "./data" );
	        fc.setDialogTitle( "Seleccionar Directorio 1" );
	        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	        
	        int resultado = fc.showOpenDialog( this );
	        if( resultado == JFileChooser.APPROVE_OPTION )
	        {
	            File archivoCampeonato = fc.getSelectedFile( );
	            ruta1 = archivoCampeonato.getAbsolutePath();
	            btnSeleccionarDirectorio.setText(ruta1);
	            btnSeleccionarDirectorio.setActionCommand("Seleccionar Directorio");
	        }
		}
		else if (a.getActionCommand().equals("Seleccionar Directorio 2"))
		{
			JFileChooser fc = new JFileChooser( "./data" );
	        fc.setDialogTitle( "Seleccionar Directorio 2" );
	        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	        
	        int resultado = fc.showOpenDialog( this );
	        if( resultado == JFileChooser.APPROVE_OPTION )
	        {
	            File archivoCampeonato = fc.getSelectedFile( );
	            ruta2 = archivoCampeonato.getAbsolutePath();
	            btnSeleccionarDirectorio_1.setText(ruta2);
	            btnSeleccionarDirectorio_1.setActionCommand("Seleccionar Directorio 2");
	        }
		}
		
	}

}
