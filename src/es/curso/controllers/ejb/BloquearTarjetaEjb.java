package es.curso.controllers.ejb;

import es.curso.controllers.BloquearTarjeta;
import es.curso.persistence.model.dao.TarjetaDao;
import es.curso.persistence.model.dao.jdbc.TarjetaDaoJdbc;

public class BloquearTarjetaEjb implements BloquearTarjeta{

	@Override
	public void buscarTarjetaBloquear(String numeroTarjeta, short contrasenha) {
		// TODO Auto-generated method stub
		TarjetaDao tarjetaDao=new TarjetaDaoJdbc();
		tarjetaDao.bloquearTarjeta(numeroTarjeta, contrasenha);
	}

}
