package uniandes.cupi2.carShowIncarpasMuscleCar.mundo;

import java.io.Serializable;

import ListaOrdenada.Lista;

public class Conductor extends Competidor implements Serializable{

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
	public Lista<EstadoCarrera> estadosCarreras;
	public Vehiculo vehiculo;
	public Numero id;
	public String nombre;
	public String documento;
	public String gsrh;
	public String correo;
	public String celular;
	
	
    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------
	
	public Conductor(String nombreP, String foto, String documentoP, String gsrhP, String correoP, String celularP) 
	{
		conductor = this;
		nombre = nombreP;
		documento = documentoP;
		gsrh = gsrhP;
		correo = correoP;
		celular = celularP;
		estadosCarreras = new Lista<EstadoCarrera>();
	}

	public void addEstadoCarrera(Carrera carreraNueva) 
	{
		estadosCarreras.agregarElemento(new EstadoCarrera(carreraNueva));
		
	}

	public void addEstadoValidaACarrera(Carrera carreraNueva, Valida validaNueva) {
		estadosCarreras.bucarElemento(new EstadoCarrera(carreraNueva)).addValida(validaNueva);
		
	} 

	public void cambiarDatos( Numero idP, Vehiculo vehiculoP )
	{
		id = idP;
		vehiculo = vehiculoP;
	}

	public int calcularPuntosCarrera(Carrera carrera) {
		EstadoCarrera estacarr = estadosCarreras.bucarElemento(new EstadoCarrera(carrera));
		return (estacarr == null)? 0:estacarr.calcularPuntajeCarrera();
	}
	
	public int darPosicionValidad (Carrera carrera, Valida val)
	{
		EstadoCarrera estacarr = estadosCarreras.bucarElemento(new EstadoCarrera(carrera));
		if (estacarr != null)
		{
			EstadoValida estValida = estacarr.buscarValida(val);
			if ( estValida != null)
			{
				return estValida.darPuntaje();
			}
			
		}
		return -1;
	}
	
	public String toString()
	{
		return nombre;
	}
	//-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

	@Override
	public int compareTo(Competidor o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void posicionar(Carrera carreraActual, Valida validaActual, int i) 
	{
		estadosCarreras.bucarElemento(new EstadoCarrera(carreraActual)).actualizarPosValidad(validaActual, i);
		
	}

	public int desposicionar(Carrera carreraActual, Valida validaActual) {
		return estadosCarreras.bucarElemento(new EstadoCarrera(carreraActual)).desposicionar(validaActual);
		
	}
}
