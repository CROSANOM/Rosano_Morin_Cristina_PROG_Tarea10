package alquilerVehiculos.mvc.modelo.bd;

import java.util.Collection;
import java.util.List;

import alquilerVehiculos.mvc.modelo.IModeloAlquilerVehiculos;
import alquilerVehiculos.mvc.modelo.dominio.Alquiler;
import alquilerVehiculos.mvc.modelo.dominio.Cliente;
import alquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.TipoVehiculo;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo;
import alquilerVehiculos.mvc.modelo.bd.dao.Alquileres;
import alquilerVehiculos.mvc.modelo.bd.dao.Clientes;
import alquilerVehiculos.mvc.modelo.bd.dao.Vehiculos;

/**
 * @author crosanom
 *
 *
 */

public  class AlquilerVehiculos implements IModeloAlquilerVehiculos {
	// atributos
	private Clientes clientes;
	private Vehiculos vehiculos;
	private Alquileres alquileres;

	// constructor

	public AlquilerVehiculos() {
		clientes = new Clientes();
		vehiculos = new Vehiculos();
		alquileres = new Alquileres();
	}

	// Metodos clientes

	@Override
	public void anadirCliente(Cliente cliente) {
		clientes.anadirCliente(cliente);
	}

	@Override
	public void borrarCliente(String dni) {
		clientes.borrarCliente(dni);
	}

	public Cliente buscarCliente(String dni) {
		return clientes.buscar(dni);
	}
	
	@Override
	public List<Cliente> obtenerCliente() {
		return clientes.getClientes();
	}

	// metodos para Vehiculos

	@Override
	public void anadirVehiculo(Vehiculo vehiculo, TipoVehiculo tipoVehiculo) {
		vehiculos.anadir(vehiculo);
	}

	@Override
	public void borrarVehiculo(String matricula) {
		vehiculos.borrar(matricula);
	}

	@Override
	public Vehiculo buscarVehiculo(String matricula) {
		return vehiculos.buscar(matricula);
	}

	@Override
	public List<Vehiculo> obtenerVehiculos() {
		return vehiculos.getVehiculos();
	}

	// metodos para los alquileres

	@Override
	public void abrirAlquiler(Cliente cliente, Vehiculo vehiculo) {
		comprobarExistenciaVehiculo(vehiculo);
		alquileres.abrir(cliente, vehiculo);
	}

	private void comprobarExistenciaVehiculo(Vehiculo vehiculo) {
		if(vehiculos.buscar(vehiculo.getMatricula())==null)
			throw new ExcepcionAlquilerVehiculos("El vehiculo no existe");
			
	}

	@Override
	public void cerrarAlquiler( Cliente cliente, Vehiculo vehiculo) {
		comprobarExistenciaVehiculo(vehiculo);
		alquileres.cerrar(cliente, vehiculo);
	}

//	public <Alquileres> obtenerAlquileres() {
//		return alquileres.getAlquileres();
//
//	}
	

	
	public List<Alquiler>obtenerAlquileres(){
		return null;
		
	}

	//  obtener Alquileres Abiertos
	public List<Alquiler> obtenerAlquileresAbiertos() {
		return null;

	}

 // obtenerAlquileresCliente ( String dni ) 
	
	public List<Alquiler> obtenerAlquileresCliente(String dni) {
		return null;

	}

	public List<Alquiler> obtenerAlquileresVehiculos(String matricula) {

		return null;
	}
	// acceso para leer - escribir clientes, vehiculos, alquileres

	public void leerClientes() {
		
	}

	public void escribirClientes() {
	
	}

	public void leerVehiculos() {
	
	}

	public void escribirVehiculos() {
		
	}

	public void leerAlquileres() {
		
	}

	public void escribirAlquileres() {
		
	}

	@Override
	public String toString() {
		return "AlquilerVehiculos [clientes=" + clientes + ", vehiculos=" + vehiculos + ", alquileres=" + alquileres
				+ "]";
	}
	
}

