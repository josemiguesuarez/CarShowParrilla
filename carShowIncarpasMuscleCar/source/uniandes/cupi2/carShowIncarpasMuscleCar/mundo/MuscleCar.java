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

package uniandes.cupi2.carShowIncarpasMuscleCar.mundo;

import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;

import trie.Trie;
import ListaDE.ListaDE;
import ListaOrdenada.Lista;
import TablaHashing.TablaHashing;

/**
 *  
 */
public class MuscleCar implements Serializable
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
	private ListaDE <Carrera> carreras;

	private Trie<Conductor> trConductores;
	private Trie <Vehiculo> trVehiculos;
	public Lista<Competidor> listNumeros;

	private TablaHashing<Integer, Puntos> sistemaPosiciones;

	public int numMaxConduc;
	public Carrera carreraActual;
	public Valida validaActual;

	public String ruta1;

	public String ruta2;

	public String text;

	//-----------------------------------------------------------------
	// Constructores
	//-----------------------------------------------------------------

	/**
	 * @param numMaxConduc 
	 * @param sistemaPosiciones2 
	 *  
	 */
	public MuscleCar(TablaHashing<Integer, Puntos> sistemaPosiciones2, int numMaxConducP )
	{
		carreras = new ListaDE<Carrera>();
		trConductores = new Trie<Conductor>();
		trVehiculos = new Trie<Vehiculo>();
		listNumeros = new Lista<Competidor>();
		sistemaPosiciones = sistemaPosiciones2;
		numMaxConduc = numMaxConducP;
		for (int j = 1; j <= numMaxConduc; j++) 
		{
			listNumeros.agregarElemento(new Numero(j));
		}
		


	}

	//-----------------------------------------------------------------
	// Métodos
	//-----------------------------------------------------------------
	public void addCarrera( String nombre, Date fecha, String observaciones)
	{
		System.out.println("Se agrego carrera y valida");
		carreraActual =  new Carrera(nombre, fecha, observaciones, listNumeros);
		validaActual = carreraActual.addValida(sistemaPosiciones);
		carreras.agregarAlFinal(carreraActual);


	}

	public void addValida (Carrera carrera)
	{
		if (carrera == null)
			validaActual = carreraActual.addValida(sistemaPosiciones);
		else 
			validaActual = carrera.addValida(sistemaPosiciones);
		
		Iterator<Conductor> iter = trConductores.iterator();
		while (iter.hasNext())
		{
			iter.next().addEstadoValidaACarrera(carreraActual, validaActual);
		}
	}

	public void cambiarPuntosAPosicion ( Integer i, int puntosP)
	{
		Puntos puntosAnt = sistemaPosiciones.eliminarElemento(i);
		puntosAnt.puntos = puntosP;
		sistemaPosiciones.agregar(i, puntosAnt);
	}

	public void agregarPosicion ( Integer i, Puntos puntos)
	{
		sistemaPosiciones.agregar(i, puntos);
	}

	//-----------------------------------------------------------------
	// Puntos de Extensión
	//-----------------------------------------------------------------

	/**
	 * Método para la extensión 1
	 * @return respuesta1
	 */
	public String metodo1( )
	{
		return "Respuesta 1";
	}

	/**
	 * Método para la extensión2
	 * @return respuesta2
	 */
	public String metodo2( )
	{
		return "Respuesta 2";
	}

	public boolean addCompetidor( Numero num, Conductor conducP, Vehiculo vehip) {
		Conductor conductor = conducP;
		Vehiculo vehiculo = vehip;
		vehiculo.conductor = conductor;
		
		num.conductor = conductor;
		conductor.cambiarDatos(num, vehiculo);


		if (trConductores.insertar(conductor) )
		{
			trVehiculos.insertar(vehiculo);
			return true;
		}
		else
		{
			return false;
		}

	}

	public void eliminarConductor(String text, String text2, int numero) {
		trConductores.eliminar(text);
		trVehiculos.eliminar(text2);
		listNumeros.bucarElemento(new Numero(numero)).conductor = null;


	}

	public void empezarCarreraActual() 
	{
		Iterator<Conductor> iter = trConductores.iterator();
		Conductor conduc;
		while (iter.hasNext())
		{
			conduc = iter.next();
			conduc.addEstadoCarrera(carreraActual);
			carreraActual.addCompetidor(conduc);
			validaActual.addCompetidor(conduc);
			conduc.addEstadoValidaACarrera ( carreraActual, validaActual);	
		}

	}

	public void posicionar(Conductor conductor, int i) {
		conductor.posicionar(carreraActual, validaActual, validaActual.posicionar(conductor, i));


	}

	public void deseposicionar(Conductor conductor) {
		int anteriorPosicion = conductor.desposicionar(carreraActual, validaActual);
		validaActual.desposicionar(conductor, anteriorPosicion);
		
	}

	public void rutasYContras(String ruta1P, String ruta2P, String textP) {
		ruta1 = ruta1P;
		ruta2 = ruta2P;
		text = textP;
		
	}


}