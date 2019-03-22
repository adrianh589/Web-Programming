package noticias;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import registros.registro;
import sesion.inicio_de_sesion;
import usuario.usuario;

/**
 * Servlet implementation class submitServlet
 */
@WebServlet("/submitServlet")
public class submitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public submitServlet() {
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
        
        Date date = new Date();
    	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		//Obtenemos el nombre del usuario actual
		String[] usuarioConectado = is.usuarioConSesionAbierta();
		
		int id = Integer.parseInt(usuarioConectado[1]);//id del usuario con sesion abierta
        usuario usuarioActual = usuarios.get(  id  );//Objeto usuario con sesion abierta
		
		Operaciones_noticia noticias = new Operaciones_noticia();//Creamos una noticia nueva
		ArrayList<Operaciones_noticia> noticiasPublicadas = Operaciones_noticia.getArrayNoticias();//Traemos el array de noticias
		
		
		String title = request.getParameter("title");//Obtenemos el titulo de la noticia
        String url = request.getParameter("url");//Obtenemos la url si se proporciona
        String text = request.getParameter("text");//Obtenemos el cotenido de la noticia si se proporciona
        
        if(url.equals("")&&text.equals("")) {
			out.println(
					"<html op=\"x\">"
					+ "<head>"
					+ "		<meta name=\"referrer\" content=\"origin\">"
					+ "		<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"
					+ "<meta http-equiv=\"refresh\" content=\"1; url=submit.jsp\">"
					+ "		<link rel=\"stylesheet\" type=\"text/css\" href=\"css/styles.css\">"
					+ "		<link rel=\"shortcut icon\" href=\"favicon.ico\">"
					+ "		<title>Message | Hacker News</title>"
					+ "	</head>"
					+ "<body>"
					+ "<center>"
					+ "<table id=\"hnmain\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"85%\" bgcolor=\"#f6f6ef\">"
					+ "<tr>"
					+ "<td bgcolor=\"#ff6600\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"padding:2px\">"
					+ "<tr>"
					+ "<td style=\"width:18px;padding-right:4px\">"
					+ "<a href=\"https://news.ycombinator.com\"><img src=\"img/y18.gif\" width=\"18\" height=\"18\" style=\"border:1px #ffffff solid;\">"
					+ "</a>"
					+ "</td>"
					+ "<td style=\"line-height:12pt; height:10px;\">"
					+ "<span class=\"pagetop\">"
					+ "<b>Message</b>"
					+ "</span>"
					+ "</td>"
					+ "</tr>"
					+ "</table>"
					+ "</td>"
					+ "</tr>"
					+ "<tr style=\"height:10px\">"
					+ "</tr>"
					+ "<tr>"
					+ "<td>"
					+ "<span class=\"admin\"><center>Sorry, you did not provide a url or a text..</center></span>"
					+ "<br>"
					+ "<br>\r\n"
					+ "</td></tr></table></center></body></html>");
        	
        }else {
        	noticias.setTitulo(title);//Se le modifica el titulo a la noticia actual
        	noticias.setAutorNoticia(usuarioActual.getNombreUsuario());//Se le modifica el autor a la noticia actual
        	noticias.setContenido(text);//Se le modifica el contenido a la noticia actual
        	noticias.setUrl(url);//Se le modifica la url a la noticia actual
        	noticias.setFechaPublicacion(dateFormat.format(date));//Se le modifica la fecha de publicacion a la noticia actual
        	
        	usuarioActual.setNoticiasPublicadas(noticias);//Añadimos la noticia a su correspondiente autor, que es el que tiene la sesion iniciada
        	noticiasPublicadas.add(noticias);//Añadimos la noticia al array de noticias
        	
        	for (int i = 0; i < usuarioActual.getNoticiasPublicadas().size(); i++) {
        		System.out.println("---------------------------------------------------------------------");
        		
        		System.out.println("ranking: "+i);
        		System.out.println("titulo usu:"+usuarioActual.getNoticiasPublicadas().get(i).getTitulo());
            	System.out.println("autor: "+usuarioActual.getNoticiasPublicadas().get(i).getAutorNoticia());
            	System.out.println("contenido: "+usuarioActual.getNoticiasPublicadas().get(i).getContenido());
            	System.out.println("url: "+usuarioActual.getNoticiasPublicadas().get(i).getUrl());
            	System.out.println("fecha publicada: "+usuarioActual.getNoticiasPublicadas().get(i).getFechaPublicacion());
            	
            	System.out.println("---------------------------------------------------------------------");
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
	}

}
