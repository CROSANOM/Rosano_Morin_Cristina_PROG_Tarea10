package alquilerVehiculos.mvc.vista;

import alquilerVehiculos.mvc.controlador.IControladorAlquilerVehiculos;
import alquilerVehiculos.mvc.modelo.dominio.Alquiler;
import alquilerVehiculos.mvc.modelo.dominio.Cliente;
import alquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.TipoVehiculo;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo;
import alquilerVehiculos.mvc.vista.utilidades.Consola;

public class IUTextual implements IVistaAlquilerVehiculos {

	// atributo
	IControladorAlquilerVehiculos controlador;

	// constructor

	public IUTextual() {
		Opcion.setVista(this);
	}

	// SetControlado(Controlador )

	@Override
	public void setControlador(IControladorAlquilerVehiculos controlador) {
		this.controlador = controlador;

	}

	// Metodo de comenzar ( getOpcionSegunOrdinal ) metodo de Option

	@Override
	public void comenzar() {
		int ordinalOpcion;
		do {
			Consola.mostrarMenu();
			ordinalOpcion = Consola.elegirOpcion();
			Opcion opcion = Opcion.getOpcionSegunOrdinal(ordinalOpcion);
			opcion.ejecutar();
		} while (ordinalOpcion != Opcion.SALIR.ordinal());
	}

	// metodo Salir

	public void salir() {
		System.out.println("Hasta Pronto, gracias :-D");
		controlador.salir();
	}

	// metodos alquileres

	// metodo de alquileres

	// AbriAlquiler

	public void abrirAlquiler() {

		Consola.mostrarCabecera("Abrir Alquiler");
		String matricula = Consola.leerMatricula();
		String dni = Consola.leerDni();
		Vehiculo vehiculo = controlador.buscarVehiculo(matricula);
		Cliente cliente = controlador.buscarCliente(dni);
		if (vehiculo == null)
			System.out.println("No existe un turismo con esa matr�cula" + "\n");
		else {
			try {
				controlador.abrirAlquiler(cliente, vehiculo);
				System.out.println("Alquier Abierto Satisfactoriamente");
			} catch (ExcepcionAlquilerVehiculos e) {
				System.out.printf("ERROR: %s%n%n", e.getMessage());
			}
		}

	}

	// cerrarAlquiler

	public void cerrarAlquiler() {
		Consola.mostrarCabecera("Cerrar Alquiler");
		String dni = Consola.leerDni();
		Cliente cliente =controlador.buscarCliente(dni);
		String matricula = Consola.leerMatricula();
		Vehiculo vehiculo = controlador.buscarVehiculo(matricula);
		if (vehiculo == null)
			System.out.println("ERROR: No existe un vehiculo con dicha matri­cula\n");
		else {
			try {
				controlador.cerrarAlquiler(cliente,vehiculo);
				System.out.println("Alquiler cerrado satisfactoriamente");
			} catch (ExcepcionAlquilerVehiculos e) {
				System.out.printf("ERROR: %s%n%n", e.getMessage());
			}
		}
	}

	public void listarAlquileres() {
		Consola.mostrarCabecera("Listar Alquiler");
		for (Alquiler alquiler : controlador.obtenerAlquileresAbiertos()) {
			if (alquiler != null)
				System.out.println(alquiler);
		}
		System.out.println("");
	}

	// obtenerAlquileresAbiertos

	public void obtenerAlquileresAbiertos() {

		Consola.mostrarCabecera("Obtener Alquiler Abierto");

		for (Alquiler alquileresAbiertos : controlador.obtenerAlquileresAbiertos()) {
			System.out.println(alquileresAbiertos);

		}

	}

	public void obtenerAlquileresCliente() {
		String dni = Consola.leerDni();

		try {// abre try
			controlador.buscarCliente(dni);
			Consola.mostrarCabecera("Listado de Alquileres por Cliente");
			if (controlador.obtenerAlquileresCliente(dni).size() == 0) {
				System.out.println("El cliente solicitado no tiene alquileres en curso");
			} else {
				for (Alquiler alquileresCliente : controlador.obtenerAlquileresCliente(dni)) {
					System.out.println(alquileresCliente);
				}
			}
		} // fin try //
		catch (ExcepcionAlquilerVehiculos e) { // abre catch
			System.out.printf("\nERROR: %s%n%n", e.getMessage());
		}
	}

	public void obtenerAlquileresVehiculo() {
		String matricula = Consola.leerMatricula();

		try {
			controlador.buscarVehiculo(matricula);
			Consola.mostrarCabecera("Listado de Alquileres por veh�culo");
			if (controlador.obtenerAlquileresVehiculos(matricula).size() == 0) {
				System.out.println("El veh�culo solicitado no tiene alquileres en curso.");
			} else {
				for (Alquiler alquileresVehiculo : controlador.obtenerAlquileresVehiculos(matricula)) {
					System.out.println(alquileresVehiculo);
				}
			}
		} catch (ExcepcionAlquilerVehiculos e) {
			System.out.printf("\nERROR: %s%n%n", e.getMessage());
		}
	}

	// Metodos de Vehiculos

	// ListarVehiculos

	public void listarVehiculos() {
		Consola.mostrarCabecera("Listar Vehiculos");
		for (Vehiculo vehiculo : controlador.obtenerVehiculos()) {
			if (vehiculo != null)
				System.out.println(vehiculo);
		}
		System.out.println("");
	}

	// buscarTurismo

	public void buscarVehiculo() {
		Consola.mostrarCabecera("Buscar Vehiculo");
		String matricula = Consola.leerMatricula();
		Vehiculo vehiculoBuscado = controlador.buscarVehiculo(matricula);
		String mensaje = (vehiculoBuscado != null) ? vehiculoBuscado.toString() : "El veh�culo no existe";
		System.out.printf("%s%n%n", mensaje);
	}

	// borrarTurismo

	public void borrarVehiculo() {
		Consola.mostrarCabecera("Borrar Vehiculo");
		String matricula = Consola.leerMatricula();
		try {
			controlador.borrarVehiculo(matricula);
			System.out.println("Vehiculo borrado satisfactoriamente\n");
		} catch (ExcepcionAlquilerVehiculos e) {
			System.out.printf("ERROR: %s%n%n", e.getMessage());
		}
	}

	// anadirVehiculo

	public void anadirVehiculo() {
		Consola.mostrarCabecera("A�adir vehiculo");
		int ordinalTipo = Consola.elegirTipoVehiculo();

		try {
			Vehiculo vehiculo = Consola.leerVehiculo();
			controlador.anadirVehiculo(vehiculo, TipoVehiculo.getTipoVehiculosSegunOrdinal(ordinalTipo));
			System.out.println("Vehiculo a�adido satisfactoriamente\n");
		} catch (ExcepcionAlquilerVehiculos e) {
			System.out.printf("ERROR: %s%n%n", e.getMessage());
		}
	}

	// metodos de Clientes

	// listar

	public void listarClientes() {
		Consola.mostrarCabecera("Listar clientes");
		for (Cliente cliente : controlador.obtenerClientes()) {
			if (cliente != null)
				System.out.println(cliente);
		}
		System.out.println("");
	}

	public void buscarCliente() {
		Consola.mostrarCabecera("Buscar cliente");
		String dni = Consola.leerDni();
		Cliente cliente = controlador.buscarCliente(dni);
		String mensaje = (cliente != null) ? cliente.toString() : "El cliente no existe";
		System.out.printf("%s%n%n", mensaje);
	}

	public void borrarCliente() {
		Consola.mostrarCabecera("Borrar cliente");
		String dni = Consola.leerDni();
		try {
			controlador.borrarCliente(dni);
			System.out.println("Cliente borrado satisfactoriamente\n");
		} catch (Exception e) {
			System.out.printf("ERROR: %s%n%n", e.getMessage());
		}
	}

	public void anadirCliente() {
		Consola.mostrarCabecera("Anadir cliente");
		try {
			Cliente cliente = Consola.leerCliente();
			controlador.anadirCliente(cliente);
			System.out.println("Cliente anadido satisfactoriamente\n");
		} catch (ExcepcionAlquilerVehiculos e) {
			System.out.printf("ERROR: %s%n%n", e.getMessage());
		}
	}

}
