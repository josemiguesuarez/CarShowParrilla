package uniandes.cupi2.carShowIncarpasMuscleCar.mundo;

import java.io.Serializable;

public class CapsulaPos implements Comparable<CapsulaPos>, Serializable
{
	//-----------------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------------



    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int posicion;
	public Conductor conductor;
    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------
	
	public CapsulaPos(int posicionP, Conductor conductorP) 
	{
		posicion = posicionP;
		conductor = conductorP;
	}
	@Override
	public int compareTo(CapsulaPos o) {
		return posicion-o.posicion;
	}
	
	//-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

}
