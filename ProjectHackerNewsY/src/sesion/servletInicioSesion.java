package sesion;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servletInicioSesion
 */
@WebServlet("/servletInicioSesion")
public class servletInicioSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletInicioSesion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		String nombreUsuario = request.getParameter("acct");
        String contraseña = request.getParameter("pw");
        
        //instanciamos la clase de inicio de sesion
        inicio_de_sesion iniciosesion = new inicio_de_sesion();
        
        boolean sesionIniciada = iniciosesion.iniciarSesion(nombreUsuario, contraseña);
        
        if (sesionIniciada==true) {
        	//Redirigimos a la página principal
    		out.println("<html>"
    				+ "<head>"
    				+ "<meta http-equiv=\"refresh\" content=\"0; url=mainMenu.jsp\">"
    				+ "</head>"
    				+ "</body>"
    				+ "</body>"
    				+ "</html>");
			
		} else {
			//Redirigimos a la página principal
			out.println("<html>"
					+ "<head>"
					+ "<meta http-equiv=\"refresh\" content=\"0; url=badLogin.jsp\">"
					+ "</head>"
					+ "</body>"
					+ "</body>"
					+ "</html>");

		}
	
	}

}
