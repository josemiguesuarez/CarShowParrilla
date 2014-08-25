package uniandes.cupi2.carShowIncarpasMuscleCar.mundo;

import java.io.Serializable;
import java.util.Iterator;

import ListaOrdenada.Lista;

public class EstadoCarrera implements Comparable<EstadoCarrera> ,Serializable
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
	public Carrera carrera;
	private Lista<EstadoValida> estadosValidas;
	
    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------
	
	public EstadoCarrera(Carrera carreraNueva) {
		carrera = carreraNueva;
		estadosValidas = new Lista<EstadoValida>();
	}

	
	
	//-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------
	
	public int calcularPuntajeCarrera()
	{
		Iterator<EstadoValida> iter = estadosValidas.iterator();
		int count = 0;
		while (iter.hasNext())
		{
			count += iter.next().darPuntaje();
		}
		return count;
	}
	@Override
	public int compareTo(EstadoCarrera o) 
	{
		return carrera.compareTo(o.carrera);
	}



	public void addValida(Valida validaNueva) {
		estadosValidas.agregarElemento(new EstadoValida(validaNueva));
		
	}



	public void actualizarPosValidad(Valida validaActual, int i) 
	{
		estadosValidas.bucarElemento(new EstadoValida(validaActual)).posicion = i;	
	}

	public EstadoValida buscarValida( Valida val)
	{
		return estadosValidas.bucarElemento(new EstadoValida(val));
	}

	public int desposicionar(Valida validaActual) {
		int resp = estadosValidas.bucarElemento(new EstadoValida(validaActual)).posicion;
		estadosValidas.bucarElemento(new EstadoValida(validaActual)).posicion = null;
		return resp;
		
	}
}
