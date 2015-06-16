package es.curso.persistence.model.dao;

import es.curso.model.entity.Tarjeta;

public interface TarjetaDao {
	public void insertTarjeta(Tarjeta tarjeta);
	public void ampliarCupoTarjeta(String numeroTarjeta, short contrasenha, int cupoTarjeta);
	public void bloquearTarjeta(String numeroTarjeta, short contrasenha);
	public Tarjeta consultarTarjeta(String numeroTarjeta, short contrasenha, String numeroComprobacion);
	public  void updateCupoDisponible(String numeroTarjeta, short contrasenha, int importePago);
}
