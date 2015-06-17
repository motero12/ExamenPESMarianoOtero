package es.curso.dispatchers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.curso.controllers.ejb.AltaTarjetaControllersEjb;
import es.curso.controllers.ejb.BloquearTarjetaEjb;
import es.curso.controllers.ejb.ComprobarPagoEjb;
import es.curso.controllers.ejb.ampliarCupoEjb;
import es.curso.model.entity.Tarjeta;

/**
 * Servlet implementation class TarjetaServlet
 */
@WebServlet("/Tarjeta/*")
public class TarjetaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TarjetaServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getPathInfo().substring(1);
		request.setCharacterEncoding("UTF-8");
		String titulo="Sin titulo";
		RequestDispatcher rd;
		switch(action){
		//se ejecuta cuando se pulsa Alta de tarjeta de credito desde index.jsp
			case "altaTarjeta":
				rd=request.getRequestDispatcher("/jsp/altaTarjetaCredito.jsp");
				rd.forward(request, response);
				break;
			case "ampliarCupo":
				rd = request.getRequestDispatcher("/jsp/buscarPorNumeroTarjeta.jsp");
//				System.out.println("antes de rdforward en ampliarCupo de doGet");
				rd.forward(request, response);
//				System.out.println("antes de break en ampliarCupo de doGet");
				break;
			case "bloquearTarjeta":
				rd = request.getRequestDispatcher("/jsp/BloquearTarjeta.jsp");
				rd.forward(request, response);
				break;
			case"efectuarPago":
				rd = request.getRequestDispatcher("/jsp/PagarConTarjeta.jsp");
				rd.forward(request, response);
				break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getPathInfo().substring(1);
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher rd;
		switch(action){
		//se ejecuta cuando se pulsa el boton de enviar desde la pantalla de alta de tarjeta
			case "altaTarjeta":
				String numeroTarjeta=new String(request.getParameter("numerotarjeta"));
				int cupoMaximo=new Integer(request.getParameter("cupomaximo"));
				int cupoDisponible=new Integer(request.getParameter("cupodisponible"));
				String tipoTarjeta=request.getParameter("tipotarjeta");
				String numeroComproba=new String(request.getParameter("numerocomproba"));
				short contrasenha=new Short(request.getParameter("contrasenha"));
				byte bloqueada=new Byte(request.getParameter("bloqueada"));
				Tarjeta tarjeta=new Tarjeta(0,numeroTarjeta, cupoMaximo, cupoDisponible, 
						tipoTarjeta, numeroComproba, contrasenha, bloqueada);
				AltaTarjetaControllersEjb controlador=new
						AltaTarjetaControllersEjb();
				controlador.agregar(tarjeta);
				rd=request.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);
				break;
			case "buscarPorNumeroTarjeta":
				String numTarjeta=new String(request.getParameter("numeroTarjeta"));
				short contrasenhaCupo= Short.parseShort(request.getParameter("contrasenha"));
				int cupoDispon=Integer.parseInt(request.getParameter("ampliarCupo"));
				ampliarCupoEjb ampliarCupo=new ampliarCupoEjb();
//				System.out.println("en case el valor de numtarjeta es "+numTarjeta);
//				System.out.println("en case el valor de contrasenha es "+contrasenhaCupo);
//				System.out.println("en case el valor de cupodispon es "+cupoDispon);
				ampliarCupo.buscarNumeroTarjeta(numTarjeta, contrasenhaCupo, cupoDispon);
				rd=request.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);
				break;
			case "bloquearTarjeta":
				String numTarjetaBloque=new String(request.getParameter("numeroTarjeta"));
				short contrasenhaBloque= Short.parseShort(request.getParameter("contrasenha"));
				BloquearTarjetaEjb bloquearTarjeta=new BloquearTarjetaEjb();
				bloquearTarjeta.buscarTarjetaBloquear(numTarjetaBloque, contrasenhaBloque);
				rd=request.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);
				break;
			case "pagarConTarjeta":
				String numTarjetaPago=new String(request.getParameter("numeroTarjeta"));
				short contrasenhaPago= Short.parseShort(request.getParameter("contrasenha"));
				String numComprobaPago=new String(request.getParameter("numeroComproba"));
				int importePago=Integer.parseInt(request.getParameter("importePago"));
				Tarjeta tarjetaPagar=new Tarjeta();
				ComprobarPagoEjb comprobarPago=new ComprobarPagoEjb();
				tarjetaPagar=comprobarPago.comprobarPago(numTarjetaPago, contrasenhaPago, 
						numComprobaPago, importePago);
				rd=request.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);
				break;
		}
	}

}
