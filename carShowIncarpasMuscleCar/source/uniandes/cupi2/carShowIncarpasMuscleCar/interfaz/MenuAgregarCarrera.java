package uniandes.cupi2.carShowIncarpasMuscleCar.interfaz;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;

import datechooser.beans.DateChooserPanel;

public class MenuAgregarCarrera extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private InterfazCarShowIncarpasMuscleCar pPal;
	private DateChooserPanel dateChooserPanel;
	private JTextArea textArea;


	/**
	 * Create the frame.
	 * @param interfazCarShowIncarpasMuscleCar 
	 */
	public MenuAgregarCarrera(InterfazCarShowIncarpasMuscleCar pPalP) {
		pPal = pPalP;
		setTitle("Agregar Nueva Carrera");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 0;
		contentPane.add(lblNombre, gbc_lblNombre);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 3, 5, 0);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha:");
		GridBagConstraints gbc_lblFecha = new GridBagConstraints();
		gbc_lblFecha.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblFecha.insets = new Insets(0, 0, 5, 5);
		gbc_lblFecha.gridx = 0;
		gbc_lblFecha.gridy = 1;
		contentPane.add(lblFecha, gbc_lblFecha);
		
		dateChooserPanel = new DateChooserPanel();
		GridBagConstraints gbc_dateChooserPanel = new GridBagConstraints();
		gbc_dateChooserPanel.insets = new Insets(0, 6, 5, 0);
		gbc_dateChooserPanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_dateChooserPanel.gridx = 1;
		gbc_dateChooserPanel.gridy = 1;
		contentPane.add(dateChooserPanel, gbc_dateChooserPanel);
		
		JLabel lblObservaciones = new JLabel("Observaciones:");
		GridBagConstraints gbc_lblObservaciones = new GridBagConstraints();
		gbc_lblObservaciones.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblObservaciones.insets = new Insets(0, 0, 5, 5);
		gbc_lblObservaciones.gridx = 0;
		gbc_lblObservaciones.gridy = 2;
		contentPane.add(lblObservaciones, gbc_lblObservaciones);
		
		textArea = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.insets = new Insets(0, 6, 5, 0);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 1;
		gbc_textArea.gridy = 2;
		contentPane.add(textArea, gbc_textArea);
		
		JButton Aceptar = new JButton("Aceptar");
		Aceptar.addActionListener(this);
		GridBagConstraints gbc_Aceptar = new GridBagConstraints();
		gbc_Aceptar.anchor = GridBagConstraints.EAST;
		gbc_Aceptar.gridwidth = 2;
		gbc_Aceptar.gridx = 0;
		gbc_Aceptar.gridy = 3;
		contentPane.add(Aceptar, gbc_Aceptar);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		setVisible(false);
		pPal.listoPrimeraCarrera(textField.getText(), dateChooserPanel.getSelectedDate().getTime(), textArea.getText());
		
	}

}
