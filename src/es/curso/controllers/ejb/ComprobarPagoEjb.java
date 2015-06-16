package es.curso.controllers.ejb;

import es.curso.controllers.ComprobarPago;
import es.curso.model.entity.Tarjeta;
import es.curso.persistence.model.dao.jdbc.TarjetaDaoJdbc;

public class ComprobarPagoEjb implements ComprobarPago{
	@Override
	public Tarjeta comprobarPago(String numeroTarjeta, short contrasenha,
			String numeroComprobacion, int importePago) {
		// TODO Auto-generated method stub
		Tarjeta tarjeta=new Tarjeta();
		TarjetaDaoJdbc tarjetaDao=new TarjetaDaoJdbc();
		tarjetaDao.consultarTarjeta(numeroTarjeta, contrasenha, numeroComprobacion);
		int cupoDispon=tarjeta.getCupoDisponible();
		if((importePago+20)<=cupoDispon){
			importePago=tarjeta.getCupoDisponible() - importePago;
			tarjetaDao.updateCupoDisponible(numeroTarjeta, contrasenha, importePago);
		}
		else{
			System.out.println("no se puede efectuar el pago");
		}
		return tarjeta;
	}

}
