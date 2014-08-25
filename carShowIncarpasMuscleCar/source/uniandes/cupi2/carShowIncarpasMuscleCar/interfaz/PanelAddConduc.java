package uniandes.cupi2.carShowIncarpasMuscleCar.interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;

import uniandes.cupi2.carShowIncarpasMuscleCar.mundo.MuscleCar;

import javax.swing.JButton;
import javax.swing.JTextField;

public class PanelAddConduc extends JPanel implements ActionListener, FocusListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public PanelAddConduc primero;
	public PanelAddConduc siguiente;
	private JTextField textNombre;
	private JTextField txtVehiculo;
	private JButton btnEditar;
	private MuscleCar mundo;
	private int numero;
	private boolean listo;

	/**
	 * Create the panel.
	 * @param mundo 
	 * @param puntos 
	 */
	public PanelAddConduc(int numeroP, MuscleCar mundoP) 
	{
		mundo = mundoP;
		numero = numeroP;
		
		setMaximumSize(new Dimension(500, 65));
		setBorder(new CompoundBorder(new MatteBorder(2, 1, 2, 1, (Color) new Color(0, 0, 153)), null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel Numero = new JLabel("Numero" );
		GridBagConstraints gbc_Numero = new GridBagConstraints();
		gbc_Numero.insets = new Insets(0, 4, 5, 8);
		gbc_Numero.gridx = 0;
		gbc_Numero.gridy = 0;
		add(Numero, gbc_Numero);
		
		JLabel lblFoto = new JLabel("Foto");
		GridBagConstraints gbc_lblFoto = new GridBagConstraints();
		gbc_lblFoto.gridheight = 2;
		gbc_lblFoto.insets = new Insets(0, 4, 0, 12);
		gbc_lblFoto.gridx = 1;
		gbc_lblFoto.gridy = 0;
		add(lblFoto, gbc_lblFoto);
		
		JLabel lblNombreCompetidor = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombreCompetidor = new GridBagConstraints();
		gbc_lblNombreCompetidor.anchor = GridBagConstraints.EAST;
		gbc_lblNombreCompetidor.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreCompetidor.gridx = 2;
		gbc_lblNombreCompetidor.gridy = 0;
		add(lblNombreCompetidor, gbc_lblNombreCompetidor);
		
		textNombre = new JTextField();
		textNombre.addFocusListener(this);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 0;
		add(textNombre, gbc_textField);
		textNombre.setColumns(10);
		
		JLabel lblNum = new JLabel("" + numero);
		GridBagConstraints gbc_lblNum = new GridBagConstraints();
		gbc_lblNum.insets = new Insets(0, 0, 0, 5);
		gbc_lblNum.gridx = 0;
		gbc_lblNum.gridy = 1;
		add(lblNum, gbc_lblNum);
		
		JLabel lblVehculo = new JLabel("Veh’culo");
		GridBagConstraints gbc_lblVehculo = new GridBagConstraints();
		gbc_lblVehculo.anchor = GridBagConstraints.EAST;
		gbc_lblVehculo.insets = new Insets(0, 0, 0, 5);
		gbc_lblVehculo.gridx = 2;
		gbc_lblVehculo.gridy = 1;
		add(lblVehculo, gbc_lblVehculo);
		
		setOpaque(false);
		setBackground(new Color(129, 139, 184, 10));
		
		txtVehiculo = new JTextField();
		txtVehiculo.addFocusListener(this);
		GridBagConstraints gbc_txtVehiculo = new GridBagConstraints();
		gbc_txtVehiculo.insets = new Insets(0, 0, 0, 5);
		gbc_txtVehiculo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtVehiculo.gridx = 3;
		gbc_txtVehiculo.gridy = 1;
		add(txtVehiculo, gbc_txtVehiculo);
		txtVehiculo.setColumns(10);
		
		btnEditar = new JButton("editar");
		btnEditar.setVisible(false);
		btnEditar.addActionListener(this);
		GridBagConstraints gbc_btnEditar = new GridBagConstraints();
		gbc_btnEditar.gridx = 4;
		gbc_btnEditar.gridy = 1;
		add(btnEditar, gbc_btnEditar);
		
		listo = false;

	}
	
	protected void paintComponent(Graphics g)
    {
        g.setColor( getBackground() );
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		setBackground(new Color(60, 181, 83, 0));
		btnEditar.setVisible(false);
		txtVehiculo.setEditable(true);
		textNombre.setEditable(true);
		listo = false;
		mundo.eliminarConductor (textNombre.getText(),txtVehiculo.getText(), numero);
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		
		
		if ( !textNombre.getText().isEmpty() && !txtVehiculo.getText().isEmpty() && !listo)
		{
			//TODO
			//listo = mundo.addCompetidor(textNombre.getText(),txtVehiculo.getText(), numero);
		}
		
		if (listo)
		{
			setBackground(new Color(60, 181, 83, 80));
			btnEditar.setVisible(true);
			txtVehiculo.setEditable(false);
			textNombre.setEditable(false);
		}
		
	}


}
