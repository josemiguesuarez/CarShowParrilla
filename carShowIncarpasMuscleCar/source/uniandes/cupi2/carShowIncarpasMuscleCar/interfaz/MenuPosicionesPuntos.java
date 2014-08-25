package uniandes.cupi2.carShowIncarpasMuscleCar.interfaz;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import uniandes.cupi2.carShowIncarpasMuscleCar.mundo.Puntos;

public class MenuPosicionesPuntos extends JPanel implements KeyListener, FocusListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private Puntos puntos;

	/**
	 * Create the panel.
	 * @param i 
	 * @param puntos 
	 */
	public MenuPosicionesPuntos(int i, Puntos puntosP) {
		puntos  = puntosP;
		setMaximumSize(new Dimension(200, 30));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblPosicion = new JLabel("Nœmero de puntos para la posici—n");
		GridBagConstraints gbc_lblPosicion = new GridBagConstraints();
		gbc_lblPosicion.insets = new Insets(0, 0, 0, 5);
		gbc_lblPosicion.gridx = 0;
		gbc_lblPosicion.gridy = 0;
		add(lblPosicion, gbc_lblPosicion);
		
		JLabel lblPuntos = new JLabel( i + ": ");
		GridBagConstraints gbc_lblPuntos = new GridBagConstraints();
		gbc_lblPuntos.insets = new Insets(0, 10, 0, 5);
		gbc_lblPuntos.anchor = GridBagConstraints.EAST;
		gbc_lblPuntos.gridx = 1;
		gbc_lblPuntos.gridy = 0;
		add(lblPuntos, gbc_lblPuntos);
		
		textField = new JTextField();
		textField.addKeyListener(this);
		textField.addFocusListener(this);
		textField.setMaximumSize(new Dimension(80,30));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 0;
		add(textField, gbc_textField);
		textField.setColumns(10);
		setOpaque(false);

	}

	protected void paintComponent(Graphics g)
    {
        g.setColor( getBackground() );
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent ke) {
		if (!Character.isDigit(ke.getKeyChar()) )
		{
			ke.consume();
		}
		else if ( !textField.getText().isEmpty())
		{
			puntos.puntos = Integer.parseInt(textField.getText());
		}
		
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		if (!textField.getText().isEmpty())
		{
			setBackground(new Color(60, 181, 83, 80));
			puntos.puntos = Integer.parseInt(textField.getText());
		}
		else
		{
			System.out.println("perdio el foco y est‡ vacia la cadena");
			setBackground(new Color(0, 0, 253, 0));
		}
		
	}

}
