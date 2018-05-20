package alquilerVehiculos.aplicacion;

//IMPORTAMOS PAQUETES NECESARIOS

import alquilerVehiculos.mvc.controlador.ControladorAlquilerVehiculos;
import alquilerVehiculos.mvc.controlador.IControladorAlquilerVehiculos;
import alquilerVehiculos.mvc.modelo.IModeloAlquilerVehiculos;
import alquilerVehiculos.mvc.modelo.ficheros.ModeloAlquilerVehiculos; // 
import alquilerVehiculos.mvc.vista.IUTextual;
import alquilerVehiculos.mvc.vista.IVistaAlquilerVehiculos;

// Accedo a las clases que controlan la aplicaci�n incluida la consola no se instancian sus metodos Staticos
public class PrincipalAlquilerVehiculos {

	// metodo main

	/**
	 * @param args
	 *            llama a Interfaz y al metodo comenzar
	 */
	public static void main(String[] args) {
		IModeloAlquilerVehiculos modelo = new ModeloAlquilerVehiculos();
		IVistaAlquilerVehiculos vista = new IUTextual();
		IControladorAlquilerVehiculos controlador = new ControladorAlquilerVehiculos(modelo, vista);

		controlador.comenzar();

	}

}
