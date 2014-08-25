package uniandes.cupi2.carShowIncarpasMuscleCar.mundo;

import java.io.Serializable;

public class EstadoValida implements Comparable<EstadoValida>, Serializable
{
	//-----------------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------------



    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------
	public Integer posicion;
	public Valida valida;
	
    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------
	
	public EstadoValida(Valida validaP) 
	{
		valida = validaP;
		posicion = null;
	}

	
	
	//-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------
	
	public int darPuntaje() 
	{
		return (posicion != null) ? valida.sistemaPosiciones.darElemento(posicion).puntos: 0;
		
	}
	
	@Override
	public int compareTo(EstadoValida o) {
		// TODO Auto-generated method stub
		return valida.compareTo(o.valida);
	}



	
}
