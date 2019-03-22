package noticias;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import noticias.Operaciones_noticia;
import sesion.inicio_de_sesion;

/**
 * Servlet implementation class esconderMostrarNoticiaServlet
 */
@WebServlet("/esconderMostrarNoticiaServlet")
public class esconderMostrarNoticiaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public esconderMostrarNoticiaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		//Instancia de las noticias
		ArrayList<Operaciones_noticia> noticias = Operaciones_noticia.getArrayNoticias();
		
		//Instancia de inicio de sesio
		inicio_de_sesion is = inicio_de_sesion.getInstanciaInicioSesion();
		
		int esconder = Integer.parseInt(request.getParameter("esconder"));
		
		String [] verificar = is.usuarioConSesionAbierta();
		
		
		if(!verificar[0].equals("ninguno")) {
		noticias.get(esconder).setVisibilidad(false);
		
		out.println("<html>"
				+ "<head>"
				+ "<meta http-equiv=\"refresh\" content=\"0; url=mainMenu.jsp\">"
				+ "</head>"
				+ "</body>"
				+ "</body>"
				+ "</html>");
		}else {
			for (int i = 0; i < noticias.size(); i++) {
				noticias.get(i).setVisibilidad(true);
			}
			
			out.println("<html>"
					+ "<head>"
					+ "<meta http-equiv=\"refresh\" content=\"0; url=mainMenu.jsp\">"
					+ "</head>"
					+ "</body>"
					+ "</body>"
					+ "</html>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

}
