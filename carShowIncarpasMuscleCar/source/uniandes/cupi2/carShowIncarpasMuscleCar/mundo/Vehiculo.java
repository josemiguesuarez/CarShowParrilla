package uniandes.cupi2.carShowIncarpasMuscleCar.mundo;

import java.io.Serializable;

public class Vehiculo  extends Competidor implements Serializable
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
	public String nombre;
	public String marca;
	public String modelo;
	public String placa;
	public String color;
    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------
	
	public Vehiculo( String alias, String marcaP, String modeloP, String placaP, String colorP ) 
	{
		nombre = alias;
		marca = marcaP;
		modelo = modeloP;
		placa = placaP;
		color = colorP;
	} 
	
	public String toString()
	{
		return nombre;
	}

	@Override
	public int compareTo(Competidor o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

}
