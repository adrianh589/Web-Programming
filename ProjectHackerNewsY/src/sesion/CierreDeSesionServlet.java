package sesion;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import noticias.Operaciones_noticia;

/**
 * Servlet implementation class CieerreDeSesionServlet
 */
@WebServlet("/CierreDeSesionServlet")
public class CierreDeSesionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CierreDeSesionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		//Instancia de la clase de cierra de sesion
		cierre_de_sesion cs = new cierre_de_sesion();
		
		//Instancia de la clase de inicio de sesion
		inicio_de_sesion is = inicio_de_sesion.getInstanciaInicioSesion();
		
		//Obtenemos el nombre del usuario actual
		String[] nombreUsuario = is.usuarioConSesionAbierta();
		
		
		
		//Cerramos la sesion del usuario
		cs.cerrarSesion(nombreUsuario[0]);
		
		//Instancia de las noticias
	    ArrayList<Operaciones_noticia> noticias = Operaciones_noticia.getArrayNoticias();
		
		//mostramos todas las noticias
		for (int i = 0; i < noticias.size(); i++) {
			noticias.get(i).setVisibilidad(true);
		}
		
		//Redirigimos a la página principal
		out.println("<html>"
				+ "<head>"
				+ "<meta http-equiv=\"refresh\" content=\"0; url=mainMenu.jsp\">"
				+ "</head>"
				+ "</body>"
				+ "</body>"
				+ "</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
