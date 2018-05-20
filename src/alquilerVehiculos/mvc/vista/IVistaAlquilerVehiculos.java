package alquilerVehiculos.mvc.vista;

import alquilerVehiculos.mvc.controlador.IControladorAlquilerVehiculos;

public interface IVistaAlquilerVehiculos {

	/**
	 * @param controlador
	 */
	void setControlador(IControladorAlquilerVehiculos controlador);

	void comenzar();

	void salir();

	void listarAlquileres();

	void cerrarAlquiler();

	void abrirAlquiler();

	void listarVehiculos();

	void obtenerAlquileresAbiertos();
	
	void obtenerAlquileresCliente() ;
	 
	 
	 
}