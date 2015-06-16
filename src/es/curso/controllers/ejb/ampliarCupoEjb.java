package es.curso.controllers.ejb;

import es.curso.controllers.ampliarCupo;
import es.curso.persistence.model.dao.TarjetaDao;
import es.curso.persistence.model.dao.jdbc.TarjetaDaoJdbc;

public class ampliarCupoEjb implements ampliarCupo{

	@Override
	public void buscarNumeroTarjeta(String numeroTarjeta, short contrasenha,
			int cupoDisponible) {
		// TODO Auto-generated method stub
		TarjetaDao tarjetaDao=new TarjetaDaoJdbc();
//		System.out.println("en controller numerotarjeta es "+numeroTarjeta);
//		System.out.println("en controller contrasenha es "+contrasenha);
//		System.out.println("en controller cupodisponible es "+cupoDisponible);
		tarjetaDao.ampliarCupoTarjeta(numeroTarjeta, contrasenha, cupoDisponible);
	}
	
}
