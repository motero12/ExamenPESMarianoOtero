package es.curso.controllers;

import es.curso.persistence.model.dao.TarjetaDao;
	
	public interface ampliarCupo {
		public  void buscarNumeroTarjeta(String numeroTarjeta, short contrasenha, int cupoDisponible);
}
