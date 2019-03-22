package usuario;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import registros.registro;
import sesion.inicio_de_sesion;
import sesion.inicio_de_sesion.*;

/**
 * Servlet implementation class editarPerfilServlet
 */
@WebServlet("/editarPerfilServlet")
public class editarPerfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editarPerfilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();//para establecer etiquetas html
		inicio_de_sesion is = inicio_de_sesion.getInstanciaInicioSesion();//instancia de la clase
        ArrayList<usuario> usuarios = registro.getArrayUsuarios();//Obtenemos los usuarios que estan registados 
		
		//Obtener los valores que se ingresaron en lso campos de texto
		String acerca_de_mi = request.getParameter("about");
        String email = request.getParameter("uemail");
        String showdead = request.getParameter("showd");
        String noprocast = request.getParameter("nopro");
        long visitasMaximas = Long.parseLong(request.getParameter("maxv"));
        int minAway = Integer.parseInt(request.getParameter("mina"));
        int delay = Integer.parseInt(request.getParameter("delay"));
        
        //Variabe para verificar el usuario con la sesion abierta
        String [] retorno = is.usuarioConSesionAbierta();//variable que almacena el usuario que inicio sesion
        
        int id = Integer.parseInt(retorno[1]);//id del usuario con sesion abierta
        usuario usuarioActual = usuarios.get(  id  );//Objeto usuario con sesion abierta
        
        usuarioActual.setAcerca_de_mi(acerca_de_mi);
        usuarioActual.setEmail(email);
        usuarioActual.setShowdead(showdead);
        usuarioActual.setNoprocast(noprocast);
        usuarioActual.setVisitasMaximas(visitasMaximas);
        usuarioActual.setMinAway(minAway);
        usuarioActual.setRetraso(delay);
        out.println("<html>"
				+ "<head>"
				+ "<meta http-equiv=\"refresh\" content=\"0; url=perfilUsuario.jsp\">"
				+ "</head>"
				+ "</body>"
				+ "</body>"
				+ "</html>");
	}

}
