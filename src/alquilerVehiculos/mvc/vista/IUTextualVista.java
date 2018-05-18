package alquilerVehiculos.mvc.vista;

import alquilerVehiculos.mvc.controlador.IControladorAlquilerVehiculo;

public interface IUTextualVista {

	/**
	 * @param controlador
	 */
	void setControlador(IControladorAlquilerVehiculo controlador);

	void comenzar();

	void salir();

	void listarAlquileres();

	void cerrarAlquiler();

	void abrirAlquiler();

	void listarVehiculos();

	void obtenerAlquileresAbiertos();
	
	void obtenerAlquileresCliente() ;
	 
	 
	 
}