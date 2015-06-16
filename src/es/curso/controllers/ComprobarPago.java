package es.curso.controllers;

import es.curso.model.entity.Tarjeta;

public interface ComprobarPago {
	public Tarjeta comprobarPago(String numeroTarjeta, short contrasenha, 
			String numeroComprobacion, int importePago);
}
