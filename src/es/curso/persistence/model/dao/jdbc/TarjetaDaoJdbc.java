package es.curso.persistence.model.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import es.curso.model.entity.Tarjeta;
import es.curso.persistence.model.dao.TarjetaDao;

public class TarjetaDaoJdbc implements TarjetaDao {
	private Connection cx;
	@Override
	public void insertTarjeta(Tarjeta tarjeta) {
		// TODO Auto-generated method stub
		try {
			abrirConexion();
			PreparedStatement ps=cx.prepareStatement("insert into tarjetacredito values(?,?,?,?,?,?,?,?)");
			// insertar los datos del cliente en las ?
				ps.setInt(1, 0);
				ps.setLong(2, tarjeta.getNumeroTarjeta());
				ps.setInt(3, tarjeta.getCupoMaximo());
				ps.setInt(4, tarjeta.getCupoDisponible());
				ps.setString(5, tarjeta.getTipoTarjeta());
				ps.setInt(6, tarjeta.getNumeroComprobacion());
				ps.setShort(7, tarjeta.getContrasenha());
				ps.setByte(8, tarjeta.getBloqueada());
			// 3. ejecutar la sentencia sql	
			// executeUpdate se usa para insert, delete y update
			// esta instruccion devuelve como resultado el
			// numero de filas afectadas
				ps.executeUpdate();
			// hacer commit
				cx.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				cx.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally{
			// 4. cerrar la conexion al ponerlo en finally
			// siempre se ejecuta
				cerrarConexion();
		}
	}
	private void abrirConexion(){
		//determinar si tengo el driver a conectar(de mysql)
		try {
			Class.forName("com.mysql.jdbc.Driver");
		//establecer la conexion
			cx= DriverManager.getConnection("jdbc:mysql://localhost:3306/Banco","rootBanco","rootBanco");
		//iniciar el autoCommit en false
			cx.setAutoCommit(false);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void cerrarConexion(){
		try {
			if(cx!=null)
			cx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
