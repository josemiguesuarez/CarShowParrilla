package uniandes.cupi2.carShowIncarpasMuscleCar.mundo;

import java.io.Serializable;
import java.util.Iterator;

import trie.Trie;
import ListaOrdenada.Lista;
import ListaOrdenada.NodoList;
import TablaHashing.TablaHashing;



public class Valida implements Comparable<Valida>, Serializable
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
	public int numero;
	public TablaHashing<Integer, Puntos> sistemaPosiciones;
	public Trie<Competidor> trConductores;
	public Trie <Competidor> trVehiculos;
	public Lista<Competidor> listNumeros;
	public Lista<CapsulaPos> listPosiciones;
	public Lista<Competidor> todos;


	//-----------------------------------------------------------------
	// Constructores
	//-----------------------------------------------------------------

	public Valida(int numeroP, TablaHashing<Integer, Puntos> sistemaPosiciones2, Carrera carrera) 
	{
		numero = numeroP;
		sistemaPosiciones = sistemaPosiciones2;

		trConductores = new Trie<Competidor>();
		trVehiculos = new Trie<Competidor>();
		listNumeros = new Lista<Competidor>();
		listPosiciones = new Lista<CapsulaPos>();
		todos = new Lista<Competidor>();
		Iterator<CapsulaPuntos> iter = carrera.competidoresOrdenados.iterator();
		while (iter.hasNext())
		{
			Conductor conduc = iter.next().conductor;
			trConductores.insertar(conduc);
			trVehiculos.insertar(conduc.vehiculo);
			listNumeros.agregarElemento(conduc.id);
			todos.agregarElemento(conduc.id);
		}
	}

	@Override
	public int compareTo(Valida o) {
		return numero - o.numero;
	}

	//-----------------------------------------------------------------
	// Métodos
	//-----------------------------------------------------------------

	public String toString ()
	{
		return "Valida " + numero;
	}

	public int posicionar(Conductor conductor, int i) 
	{
		trConductores.eliminar(conductor.nombre);
		trVehiculos.eliminar(conductor.vehiculo.nombre);
		listNumeros.eliminarElemento(conductor.id);
		if (i == 0)
		{
			NodoList<CapsulaPos> nodo = listPosiciones.darPrimero();
			if (nodo == null)
			{
				i = 1;
			}
			else 
			{
				while(nodo.darSiguiente() != null)
				{
					nodo = nodo.darSiguiente();
				}
				i = nodo.darNodo().posicion+1;
			}
		}

		listPosiciones.agregarElemento(new CapsulaPos(i, conductor));

		return i;
	}

	public void desposicionar(Conductor conductor, int anteriorPosicion) {
		trConductores.insertar(conductor);
		trVehiculos.insertar(conductor.vehiculo);
		listNumeros.agregarElemento(conductor.id);
		listPosiciones.eliminarElemento(new CapsulaPos(anteriorPosicion, conductor));

	}

	public void addCompetidor(Conductor conduc) {
		if(todos.bucarElemento(conduc.id) == null)
		{
			trConductores.insertar(conduc);
			trVehiculos.insertar(conduc.vehiculo);
			listNumeros.agregarElemento(conduc.id);
			todos.agregarElemento(conduc.id);
		}

	}

}
