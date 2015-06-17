package es.curso.persistence.model.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
				ps.setString(2, tarjeta.getNumeroTarjeta());
				ps.setInt(3, tarjeta.getCupoMaximo());
				ps.setInt(4, tarjeta.getCupoDisponible());
				ps.setString(5, tarjeta.getTipoTarjeta());
				ps.setString(6, tarjeta.getNumeroComprobacion());
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
	@Override
	public void ampliarCupoTarjeta(String numeroTarjeta, short contrasenha,
			int cupoTarjeta) {
		// TODO Auto-generated method stub
		try {
			abrirConexion();
			PreparedStatement ps=cx.prepareStatement("update tarjetacredito set cupoDisponible = cupoDisponible + ?"
					+ " where numeroTarjeta= ?"
					+ " and contrasenha= ?");
			ps.setInt(1, cupoTarjeta);
			ps.setString(2, numeroTarjeta);
			ps.setShort(3, contrasenha);
			ps.executeUpdate();
			// hacer commit
			cx.commit();
		} catch (SQLException e) {
			try {
				cx.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			// 4. cerrar la conexion al ponerlo en finally
			// siempre se ejecuta
				cerrarConexion();
		}
	}
	@Override
	public void bloquearTarjeta(String numeroTarjeta, short contrasenha) {
		// TODO Auto-generated method stub
		try {
			abrirConexion();
			PreparedStatement ps=cx.prepareStatement("update tarjetacredito set Bloqueada = 1"
					+ " where numeroTarjeta= ?"
					+ " and contrasenha= ?");
			ps.setString(1, numeroTarjeta);
			ps.setShort(2, contrasenha);
			ps.executeUpdate();
			cx.commit();
		} catch (SQLException e) {
			try {
				cx.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			// 4. cerrar la conexion al ponerlo en finally
			// siempre se ejecuta
				cerrarConexion();
		}
	}
	@Override
	public Tarjeta consultarTarjeta(String numeroTarjeta, short contrasenha,
			String numeroComprobacion) {
		Tarjeta tarjeta=new Tarjeta();
		try {
			abrirConexion();
			PreparedStatement ps=cx.prepareStatement("select * from tarjetacredito "
					+ " where numeroTarjeta= ?"
					+ " and contrasenha= ?"
					+ " and numeroComprobacion= ?");
			ps.setString(1, numeroTarjeta);
			ps.setShort(2, contrasenha);
			ps.setString(3, numeroComprobacion);
			ResultSet consulta=ps.executeQuery();
			while(consulta.next()){
				tarjeta.setId(consulta.getInt("id"));
				tarjeta.setNumeroTarjeta(consulta.getString("numeroTarjeta"));
				tarjeta.setCupoMaximo(consulta.getInt("cupoMaximo"));
				tarjeta.setCupoDisponible(consulta.getInt("cupoDisponible"));
				tarjeta.setTipoTarjeta(consulta.getString("tipoTarjeta"));
				tarjeta.setNumeroComprobacion(consulta.getString("numeroComprobacion"));
				tarjeta.setContrasenha(consulta.getShort("contrasenha"));
				tarjeta.setBloqueada(consulta.getByte("Bloqueada"));
			}
			
		} catch (SQLException e) {
			try {
				cx.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			// 4. cerrar la conexion al ponerlo en finally
			// siempre se ejecuta
				cerrarConexion();
		}
		// TODO Auto-generated method stub
		return tarjeta;
	}
	@Override
	public void updateCupoDisponible(String numeroTarjeta, short contrasenha,
			int importePago) {
		// TODO Auto-generated method stub
		try {
			abrirConexion();
			PreparedStatement ps=cx.prepareStatement("update tarjetacredito set cupoDisponible =  ?"
					+ " where numeroTarjeta= ?"
					+ " and contrasenha= ?");
			ps.setInt(1, importePago);
			ps.setString(2, numeroTarjeta);
			ps.setShort(3, contrasenha);
			ps.executeUpdate();
			cx.commit();
		} catch (SQLException e) {
			try {
				cx.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			// 4. cerrar la conexion al ponerlo en finally
			// siempre se ejecuta
				cerrarConexion();
		}
	}
	
}
