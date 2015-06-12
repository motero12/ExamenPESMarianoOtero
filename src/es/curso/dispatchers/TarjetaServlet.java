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
				long numeroTarjeta=new Long(request.getParameter("numerotarjeta"));
				int cupoMaximo=new Integer(request.getParameter("cupomaximo"));
				int cupoDisponible=new Integer(request.getParameter("cupodisponible"));
				String tipoTarjeta=request.getParameter("tipotarjeta");
				int numeroComproba=new Integer(request.getParameter("numerocomproba"));
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
		}
	}

}
