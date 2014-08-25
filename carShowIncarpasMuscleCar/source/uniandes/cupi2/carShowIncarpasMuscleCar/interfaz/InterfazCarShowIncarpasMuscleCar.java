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

import java.awt.BorderLayout;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import TablaHashing.TablaHashing;

import uniandes.cupi2.carShowIncarpasMuscleCar.mundo.Conductor;
import uniandes.cupi2.carShowIncarpasMuscleCar.mundo.MuscleCar;
import uniandes.cupi2.carShowIncarpasMuscleCar.mundo.Puntos;


/**
 * Esta es la ventana principal de la aplicación.
 */
public class InterfazCarShowIncarpasMuscleCar extends JFrame
{
	private final static String nombreArchivo = "/datosMuscleCar2.cshc"; 
    private static final String ARCHIVO_DATOS_PROGRAMA_CSHC = "/datosPrograma2.cshc";

	//-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Clase principal del mundo
     */
    private MuscleCar mundo;

    //-----------------------------------------------------------------
    // Atributos de la interfaz
    //-----------------------------------------------------------------

    /**
     * Panel con las extensiones
     */
    private PanelExtension panelExtension;
    
    /**
     * Panel con la imagen del encabezado
     */
    private PanelImagen panelImagen;

	private PanelCentral panelCentro;

	private String ruta1;

	private String ruta2;

	private String text;
	

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Descripción <br>
     * <b>post: </b> Descripción
     */
    public InterfazCarShowIncarpasMuscleCar()
    {
    	
    	Contrasena contra = new Contrasena( this);
    	contra.setVisible(true);
    	this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    	
    
        
    }
    public void menuPos(String ruta1P, String ruta2P, String string) {
    	ruta1 = ruta1P;
    	ruta2 = ruta2P;
    	text = string;
    	try 
    	{
    		System.out.println("Tratando de abrir archivo en las rutas: \n"+ ruta1P+ " \n" + ruta2P);
    		ObjectInputStream ois = new ObjectInputStream( new FileInputStream( ruta1 + nombreArchivo) );
            mundo = ( MuscleCar )ois.readObject( );
            ois.close( );
            
            if (mundo.text.equals(text))
            {
            	iniciar();
            }
            else
            {
            	Contrasena contra = new Contrasena( this);
            	contra.setVisible(true);
            }
    	}
    	catch (Exception e) {
    		try 
        	{
        		ObjectInputStream ois = new ObjectInputStream( new FileInputStream( ruta2 + ARCHIVO_DATOS_PROGRAMA_CSHC ) );
                mundo = ( MuscleCar )ois.readObject( );
                ois.close( );
                if (mundo.text.equals(text))
                {
                	iniciar();
                }
                else
                {
                	Contrasena contra = new Contrasena( this);
                	contra.setVisible(true);
                	
                }
        	}
        	catch (Exception e1) {
        		JFrame menupos = new MenuPosiciones(this);
            	menupos.setVisible(true);
    		}
		}
    	
    	
		
	}

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------
    
    
    //-----------------------------------------------------------------
    // Puntos de Extensión
    //-----------------------------------------------------------------

    /**
     * Método para la extensión 1
     */
    public void empezarCarrera( )
    {
    	mundo.empezarCarreraActual();
    	panelCentro.refresh();
    	validate();
    }

    /**
     * Método para la extensión 2
     */
    public void mostrarInscritos( )
    {
        MenuCompetidores comp = new MenuCompetidores(mundo, this, false, null);
        comp.setVisible(true);
    }


	public void mostrarInscrito(Conductor conductor) {
		MenuCompetidores comp = new MenuCompetidores(mundo, this, false, conductor);
        comp.setVisible(true);
		
	}

    //-----------------------------------------------------------------
    // Main
    //-----------------------------------------------------------------

    /**
     * Este método ejecuta la aplicación, creando una nueva interfaz
     * @param args
     */
    public static void main( String[] args )
    {
    	new InterfazCarShowIncarpasMuscleCar();
    }

	public void listoPuntos (TablaHashing<Integer, Puntos> sistemaPosiciones, int numMaxConduc) {
		
		// Crea la clase principal
        mundo = new MuscleCar(sistemaPosiciones, numMaxConduc);
        MenuCompetidores addComp = new MenuCompetidores( mundo, this, true, null);
        addComp.setVisible(true);
        mundo.rutasYContras(ruta1, ruta2, text);
        
        
	}

	public void listoConductores() {
		
		MenuAgregarCarrera addCarera = new MenuAgregarCarrera(this);
		addCarera.setVisible(true);	
	}

	public void listoPrimeraCarrera(String text, Date time, String text2) {
		
		mundo.addCarrera(text, time, text2);
		iniciar();
		mundo.empezarCarreraActual();
		
	}
	private void iniciar() {
		// Construye la forma
        setLayout( new BorderLayout( ) );
        setSize( 900, 630 );
        setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        
        //Creación de los paneles aquí
        panelImagen = new PanelImagen();
        add( panelImagen, BorderLayout.NORTH );
 
        
        panelCentro = new PanelCentral(this, mundo);
        
        add(panelCentro, BorderLayout.CENTER);
        
        panelExtension = new PanelExtension( this );
        add( panelExtension, BorderLayout.SOUTH );
        
        //Centrar la ventana
        setLocationRelativeTo(null);
		setVisible(true);
		
		panelCentro.refresh();
	}

	public void refresh() {
		panelCentro.refresh();
		
	}
	public void dispose( )
    {
		System.out.println("Tratando de crear el archivo en las rutas: \n"+ ruta1+ " \n" + ruta2);
        try
        {
        	ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream( ruta1 + "/datosMuscleCar.cshc" ) );
            oos.writeObject( mundo );
            oos.close( );
        }
        catch( Exception e )
        {
        	e.printStackTrace();
        }
        
        try
        {
        	ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream( ruta2 + ARCHIVO_DATOS_PROGRAMA_CSHC) );
            oos.writeObject( mundo );
            oos.close( );   
        }
        catch( Exception e2 )
        {
        	 e2.printStackTrace();
            setVisible( true );
            int respuesta = JOptionPane.showConfirmDialog( this, "Problemas salvando la información:\n" + e2.getMessage( ) + "\n¿Quiere cerrar el programa sin salvar?", "Error", JOptionPane.YES_NO_OPTION );
            if( respuesta == JOptionPane.YES_OPTION )
            {
                super.dispose( );
            }
           
        }
        
        super.dispose( );
    }

	



}