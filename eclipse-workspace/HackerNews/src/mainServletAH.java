

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
        
        //Crear cuenta
        String cuenta[] = crearCuenta(nombreUsuario,contraseña);
        
        //Probar que se guardo correctamente el usuario
        for(int i = 0; i < cuenta.length; i++) {
        	System.out.println(cuenta[i]);
        }
		
        
        
		out.println("<html>");
        out.println("<head></head>");         
        out.println("<body>");
        out.println("<h1>Usuario registrado con exito</h1>");
        out.print("<p>"+cuenta[0]+"</p>");
        out.print("<p>"+cuenta[1]+"</p>");
        out.println("</body>");
        out.println("</html>");    
	}
	
	static String[] crearCuenta(String nombreUsuario, String contraseña) {
		String registroUsuario[] = {nombreUsuario,contraseña};
		return registroUsuario;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
