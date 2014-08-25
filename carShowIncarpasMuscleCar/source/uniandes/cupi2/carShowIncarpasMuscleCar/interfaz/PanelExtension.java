/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: carShowIncarpasMuscleCar
 * Autor: Jose Miguel Suarez - 20-ene-2014
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.carShowIncarpasMuscleCar.interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Panel de manejo de extensiones
 */
public class PanelExtension extends JPanel implements ActionListener
{

    //-----------------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------------

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Comando Opción 1
     */
    private static final String EMPESAR = "OPCION_1";

    /**
     * Comando Opción 2
     */
    private static final String INSCRITOS = "Mostrar Inscritos";

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación
     */
    private InterfazCarShowIncarpasMuscleCar principal;

    //-----------------------------------------------------------------
    // Atributos de interfaz
    //-----------------------------------------------------------------

    /**
     * Botón Opción 1
     */
    private JButton btnOpcion1;

    /**
     * Botón Opción 2
     */
    private JButton btnOpcion2;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Constructor del panel
     * @param ventana Ventana principal
     */
    public PanelExtension( InterfazCarShowIncarpasMuscleCar ventana )
    {
        principal = ventana;

        setBorder( new TitledBorder( "Opciones" ) );
        setLayout( new GridLayout( 1, 2 ) );

        //Botón opción 1
        btnOpcion1 = new JButton("Empezar Carrera");
        btnOpcion1.setActionCommand( EMPESAR );
        btnOpcion1.addActionListener( this );
        add(btnOpcion1);
        
        //Botón opción 2
        btnOpcion2 = new JButton(INSCRITOS);
        btnOpcion2.setActionCommand( INSCRITOS );
        btnOpcion2.addActionListener( this );
        add(btnOpcion2);
    }

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones
     * @param e Acción que generó el evento.
     */
    public void actionPerformed( ActionEvent e )
    {
        if(EMPESAR.equals( e.getActionCommand() ))
        {
            principal.empezarCarrera();
        }
        else if(INSCRITOS.equals( e.getActionCommand() ))
        {
            principal.mostrarInscritos();
        }
    }
    public void cambiarBTN1(Date fecha)
    {
    	btnOpcion1.setText(fecha.toString());
    }

}
