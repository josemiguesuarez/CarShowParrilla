package uniandes.cupi2.carShowIncarpasMuscleCar.mundo;

import java.io.Serializable;

public class CapsulaPuntos implements Comparable<CapsulaPuntos>,Serializable{
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
	public Conductor conductor;
	private Carrera carrera;
    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------
	
	public CapsulaPuntos(Conductor conductorP, Carrera carreraP) 
	{
		carrera = carreraP;
		conductor = conductorP;
	}
	@Override
	public int compareTo(CapsulaPuntos o) 
	{
		int comp = o.conductor.calcularPuntosCarrera(carrera) - conductor.calcularPuntosCarrera(carrera);
		if (comp == 0)
		{
			return conductor.id.numero - o.conductor.id.numero;
		}
		else
		{
			return o.conductor.calcularPuntosCarrera(carrera) - conductor.calcularPuntosCarrera(carrera);
		}
		
	}
	
	//-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------
}
