package es.hiberus.hotel.utils;

import java.util.ArrayList;
import java.util.List;

import es.hiberus.hotel.domain.Cliente;

public abstract class ClienteUtil {
	public static Cliente crear() {
		Cliente cliente = new Cliente();
		cliente.setBorrado(false);
		cliente.setDni("00000000A");
		cliente.setNombre("Nombre");
		cliente.setSesion(false);
		cliente.setContrasenia("Contrasenia");
		return cliente;
	}
	
	public static List<Cliente> crearLista(int size) {
		List<Cliente> clientes = new ArrayList<Cliente>();
		Cliente cliente = null;
		for (int i = 0; i < size; i++) {
			cliente = crear();
			clientes.add(cliente);
		}
		return clientes;
	}
	
	public static List<Cliente> crearLista() {
		return crearLista(4);
	}

	public static Cliente clonar(Cliente cliente) {
		Cliente clienteClonado = new Cliente();
		clienteClonado.setId(cliente.getId());
		clienteClonado.setBorrado(cliente.getBorrado());
		clienteClonado.setDni(cliente.getDni());
		clienteClonado.setNombre(cliente.getNombre());
		clienteClonado.setSesion(cliente.getSesion());
		return clienteClonado;
	}
	
	public static List<Cliente> clonarClientes(List<Cliente> clientes) {
		List<Cliente> clientesClonados = new ArrayList<Cliente>(); 
		Cliente clienteClonado = null;
		for (Cliente cliente : clientes) {
			clienteClonado = clonar(cliente);
			clientesClonados.add(clienteClonado);
		}
		return clientesClonados;
	}
}
