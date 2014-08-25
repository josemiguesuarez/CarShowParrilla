package uniandes.cupi2.carShowIncarpasMuscleCar.mundo;

import java.io.Serializable;

public class Numero extends Competidor implements Serializable
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
	public int numero;
	//-----------------------------------------------------------------
	// Constructores
	//-----------------------------------------------------------------

	public Numero( int numeroP) 
	{	
		numero = numeroP;
		conductor = null;
	}

	public void cambiarConductor ( Conductor cond)
	{
		conductor = cond;
	}

	@Override
	public int compareTo(Competidor o) {
		// TODO Auto-generated method stub
		if ( o.conductor != null)
			return numero - o.conductor.id.numero;
		else
			return numero - ((Numero)o).numero;
	}
	public String toString()
	{
		if ( conductor != null)
		{
			return numero + ". " + conductor.nombre;
		}
		else 
		{
			return numero + ". No registrado";
		}
	}



	//-----------------------------------------------------------------
	// Métodos
	//-----------------------------------------------------------------

}
