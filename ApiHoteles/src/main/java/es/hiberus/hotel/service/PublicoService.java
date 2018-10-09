package es.hiberus.hotel.service;

import org.springframework.stereotype.Service;

import es.hiberus.hotel.domain.Cliente;

@Service
public interface PublicoService extends BaseService{
	
	Cliente iniciarSesion(String nombreCliente, String contraseña);
	
	Cliente registrarse(Cliente cliente);
	
}
