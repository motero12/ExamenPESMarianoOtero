package es.curso.controllers.ejb;

import es.curso.controllers.AltaTarjetaControllers;
import es.curso.model.entity.Tarjeta;
import es.curso.persistence.model.dao.TarjetaDao;
import es.curso.persistence.model.dao.jdbc.TarjetaDaoJdbc;

public class AltaTarjetaControllersEjb implements AltaTarjetaControllers{
	private TarjetaDao tarjetaDao;
	@Override
	public void agregar(Tarjeta tarjeta) {
		// TODO Auto-generated method stub
		tarjetaDao=new TarjetaDaoJdbc();
		 tarjetaDao.insertTarjeta(tarjeta);
	}

}
