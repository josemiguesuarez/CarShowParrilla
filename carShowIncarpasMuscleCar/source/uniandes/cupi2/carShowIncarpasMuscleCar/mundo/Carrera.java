package uniandes.cupi2.carShowIncarpasMuscleCar.mundo;

import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;

import ListaDE.ListaDE;
import ListaOrdenada.Lista;
import TablaHashing.TablaHashing;

public class Carrera implements Comparable<Carrera>,Serializable
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
		public String nombre;
		public String observaciones;
		public int numeroDeValidas;
		public Date fecha;
		public ListaDE <Valida> validas;
		public Lista<CapsulaPuntos> competidoresOrdenados;
		private Lista<Competidor> listNumeros;
	
    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------
	
	public Carrera (String nombreP, Date fechaP, String observacionesP, Lista<Competidor> listNumerosP)
	{
		nombre = nombreP;
		observaciones = observacionesP;
		numeroDeValidas = 0;
		fecha = fechaP;
		validas = new ListaDE<Valida>();
		listNumeros = listNumerosP;
		competidoresOrdenados = new Lista<CapsulaPuntos>();
		
		Iterator<Competidor> iter = listNumeros.iterator();
		for (;iter.hasNext();)
		{
			Conductor conduc = iter.next().conductor;
			if (conduc != null)
			competidoresOrdenados.agregarElemento(new CapsulaPuntos(conduc, this));
		}
	}
	
	//-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------
    
	@SuppressWarnings("deprecation")
	public String toString ()
	{
		return fecha.getDate() +"/" + fecha.getMonth() +"/" + fecha.getYear() +"  " + nombre;
	}

	@Override
	public int compareTo(Carrera o) {
		int cFecha = fecha.compareTo(o.fecha);
		if (cFecha == 0) 
		{
			return nombre.compareTo(o.nombre);
		}
		else 
		{
			return cFecha;
		}
	}

	public Valida addValida(TablaHashing<Integer, Puntos> sistemaPosiciones) {
		numeroDeValidas ++;
		Valida validaNueva = new Valida(numeroDeValidas, sistemaPosiciones, this);
		validas.agregarAlFinal(validaNueva);
		return validaNueva;
		
	}

	public void addCompetidor(Conductor conduc) 
	{
		competidoresOrdenados.agregarElemento(new CapsulaPuntos(conduc, this));
		
	}

	public Iterator<CapsulaPuntos> iter() {
		competidoresOrdenados = new Lista<CapsulaPuntos>();
		
		Iterator<Competidor> iter = listNumeros.iterator();
		for (;iter.hasNext();)
		{
			Conductor conduc = iter.next().conductor;
			if (conduc != null)
			competidoresOrdenados.agregarElemento(new CapsulaPuntos(conduc, this));
		}
		
		return competidoresOrdenados.iterator();
	}
	
}
