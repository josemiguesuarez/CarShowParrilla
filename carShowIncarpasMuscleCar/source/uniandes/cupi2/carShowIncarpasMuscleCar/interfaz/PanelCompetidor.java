package uniandes.cupi2.carShowIncarpasMuscleCar.interfaz;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;

import uniandes.cupi2.carShowIncarpasMuscleCar.mundo.Conductor;
import uniandes.cupi2.carShowIncarpasMuscleCar.mundo.EstadoCarrera;
import uniandes.cupi2.carShowIncarpasMuscleCar.mundo.MuscleCar;
import uniandes.cupi2.carShowIncarpasMuscleCar.mundo.Valida;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelCompetidor extends JPanel implements MouseListener  {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String nombre;
	public boolean selected;
	public PanelCompetidor primero;
	public PanelCompetidor siguiente;
	private MuscleCar mundo;
	public Conductor conductor;
	private long tiempoI;
	private long tiempoF;
	private InterfazCarShowIncarpasMuscleCar pPal;

	/**
	 * Create the panel.
	 * @param puntos 
	 */
	public PanelCompetidor(PanelCompetidor primeroP, PanelCompetidor siguienteP , Conductor cond, MuscleCar mundoP, int puesto, InterfazCarShowIncarpasMuscleCar pPalP) 
	{
		incializar(primeroP, siguienteP, cond, mundoP, puesto, pPalP);
		JLabel lblPuntos = new JLabel("Pnts. " + cond.calcularPuntosCarrera(mundo.carreraActual));
		GridBagConstraints gbc_lblPuntos = new GridBagConstraints();
		gbc_lblPuntos.anchor = GridBagConstraints.EAST;
		gbc_lblPuntos.insets = new Insets(0, 0, 0, 8);
		gbc_lblPuntos.gridx = 3;
		gbc_lblPuntos.gridy = 1;
		add(lblPuntos, gbc_lblPuntos);
	}

	private void incializar(PanelCompetidor primeroP,
			PanelCompetidor siguienteP, Conductor cond, MuscleCar mundoP,
			int puesto, InterfazCarShowIncarpasMuscleCar pPalP) {
		pPal = pPalP;
		tiempoI = -1;
		tiempoF = -1;
		conductor = cond;
		primero = primeroP;
		siguiente = siguienteP;
		nombre = cond.nombre;
		mundo = mundoP;
		addMouseListener(this);
		setMinimumSize(new Dimension(100, 60));
		setBorder(new CompoundBorder(new MatteBorder(2, 1, 2, 1, (Color) new Color(0, 0, 153)), null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblPuesto = new JLabel("" + puesto);
		GridBagConstraints gbc_lblPuesto = new GridBagConstraints();
		gbc_lblPuesto.gridheight = 2;
		gbc_lblPuesto.insets = new Insets(0, 4, 0, 8);
		gbc_lblPuesto.gridx = 0;
		gbc_lblPuesto.gridy = 0;
		add(lblPuesto, gbc_lblPuesto);
		
		JLabel lblFoto = new JLabel("Foto");
		GridBagConstraints gbc_lblFoto = new GridBagConstraints();
		gbc_lblFoto.gridheight = 2;
		gbc_lblFoto.insets = new Insets(0, 4, 0, 12);
		gbc_lblFoto.gridx = 1;
		gbc_lblFoto.gridy = 0;
		add(lblFoto, gbc_lblFoto);
		
		JLabel lblNombredeelconductor = new JLabel(cond.id.numero+". " + cond.nombre);
		GridBagConstraints gbc_lblNombredeelconductor = new GridBagConstraints();
		gbc_lblNombredeelconductor.anchor = GridBagConstraints.WEST;
		gbc_lblNombredeelconductor.gridwidth = 2;
		gbc_lblNombredeelconductor.insets = new Insets(0, 4, 5, 8);
		gbc_lblNombredeelconductor.gridx = 2;
		gbc_lblNombredeelconductor.gridy = 0;
		add(lblNombredeelconductor, gbc_lblNombredeelconductor);
		
		JLabel lblVehiculo = new JLabel(cond.vehiculo.nombre);
		GridBagConstraints gbc_lblVehiculo = new GridBagConstraints();
		gbc_lblVehiculo.anchor = GridBagConstraints.WEST;
		gbc_lblVehiculo.insets = new Insets(0, 8, 0, 8);
		gbc_lblVehiculo.gridx = 2;
		gbc_lblVehiculo.gridy = 1;
		add(lblVehiculo, gbc_lblVehiculo);
		
		
		
		setOpaque(false);
		setBackground(new Color(129, 139, 184, 10));
	}

	public PanelCompetidor(PanelCompetidor primeroP, PanelCompetidor siguienteP , Conductor cond, MuscleCar mundoP, int puesto, InterfazCarShowIncarpasMuscleCar pPalP, Valida v) 
	{
		
		incializar(primeroP, siguienteP, cond, mundoP, puesto, pPalP);
		
		JLabel lblPuntos = new JLabel("Pnts. " + cond.darPosicionValidad(mundo.carreraActual, mundo.validaActual));
		GridBagConstraints gbc_lblPuntos = new GridBagConstraints();
		gbc_lblPuntos.anchor = GridBagConstraints.EAST;
		gbc_lblPuntos.insets = new Insets(0, 0, 0, 8);
		gbc_lblPuntos.gridx = 3;
		gbc_lblPuntos.gridy = 1;
		add(lblPuntos, gbc_lblPuntos);
	}

	protected void paintComponent(Graphics g)
    {
        g.setColor( getBackground() );
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		if ( !selected)
			setBackground(new Color(0, 0, 255, 20));
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		if (!selected)
			setBackground(new Color(129, 139, 184, 10));
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		setBackground(new Color(0, 0, 255, 100));
		
	}

	public void desseleccionarTodos() {
		selected = false;
		setBackground(new Color(129, 139, 184, 10));
		if (siguiente != null)
		siguiente.desseleccionarTodos();
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		primero.desseleccionarTodos();
		
		setBackground(new Color(0, 0, 255, 90));
		selected = true;
		
		if ( tiempoI == -1)
		{
			tiempoI = System.currentTimeMillis();
		}
		else if ( tiempoF == -1)
		{
			tiempoF = System.currentTimeMillis();
			System.out.println((tiempoF-tiempoI));
			if (tiempoF-tiempoI < 500)
			{
				pPal.mostrarInscrito(conductor);
				tiempoI = -1;
				tiempoF = -1;
			}
			else
			{
				tiempoI = tiempoF;
				tiempoF = -1;
			}
			
		}
		
		
		
	}

	public PanelCompetidor getSeleccionado() {
		return primero.buscarSeleccionado();
	}
	public void deliteSeleccionado()
	{
		if ( siguiente != null)
		{
			if (siguiente.selected)
			{
				siguiente = siguiente.siguiente;
			}
			else
			{
				siguiente.deliteSeleccionado();
			}
		}
	}
	

	private PanelCompetidor buscarSeleccionado() {
		if ( selected)
		{
			return this;
		}
		else if ( siguiente != null)
		{
			return siguiente.buscarSeleccionado();
		}
		return null;
	}

}
