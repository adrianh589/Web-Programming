package registros;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class mainServletAH
 */
@WebServlet("/mainServletAH")
public class mainServletAH extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mainServletAH() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		String nombreUsuario = request.getParameter("username");
        String contraseña = request.getParameter("password");
        
        registro rg = new registro();
        
        //verificar si existe
        boolean existe = rg.existe(nombreUsuario);
        
        //Crear cuenta
        rg.crearCuenta(nombreUsuario,contraseña);
        
        
        
        if (existe) {
        	out.println("<html>"
					+ "<head>"
					+ "</head>"
					+ "</body>"
					+ "That username is taken. Please choose another.<br><br>"
					+ "<a href='http://localhost:8080/ProjectHackerNewsY/registro.jsp'>Try to register again</a>"
					+ "</body>"
					+ "</html>");
			
		} else {
			out.println("<html>"
					+ "<head>"
					+ "<meta http-equiv=\"refresh\" content=\"0; url=http://localhost:8080/ProjectHackerNewsY/mainMenu.jsp\">"
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
