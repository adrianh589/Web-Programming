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

/**
 * Servlet implementation class cambioDeContrasena
 */
@WebServlet("/cambioDeContrasena")
public class cambioDeContrasena extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cambioDeContrasena() {
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
		String antiguaContrase�a = request.getParameter("oldpw");
        String nuevaContrase�a = request.getParameter("pw");
        
        System.out.println(antiguaContrase�a);
        System.out.println(nuevaContrase�a);
        
        //Variabe para verificar el usuario con la sesion abierta
        String [] retorno = is.usuarioConSesionAbierta();//variable que almacena el usuario que inicio sesion
        
        int id = Integer.parseInt(retorno[1]);//id del usuario con sesion abierta
        usuario usuarioActual = usuarios.get(  id  );//Objeto usuario con sesion abierta
        
        if(antiguaContrase�a.equals(usuarioActual.getContrase�a())) {
        	
        usuarioActual.setContrase�a(nuevaContrase�a);
        
        out.println("<html>"
				+ "<head>"
				+ "<meta http-equiv=\"refresh\" content=\"0; url=CierreDeSesionServlet\">"
				+ "</head>"
				+ "</body>"
				+ "</body>"
				+ "</html>");
        }else {
        	out.println("<html>"
    				+ "<head>"
    				+ "<meta http-equiv=\"refresh\" content=\"3; url=cambioDeContrasena.jsp\">"
    				+ "</head>"
    				+ "</body>"
    				+ "<label>Error the passwords do not match</label>"
    				+ "</body>"
    				+ "</html>");
        }
		
	}

}
