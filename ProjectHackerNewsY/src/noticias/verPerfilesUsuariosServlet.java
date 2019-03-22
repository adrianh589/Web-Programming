package noticias;

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
import usuario.usuario;

/**
 * Servlet implementation class verPerfilesUsuariosServlet
 */
@WebServlet("/verPerfilesUsuariosServlet")
public class verPerfilesUsuariosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public verPerfilesUsuariosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		inicio_de_sesion is = inicio_de_sesion.getInstanciaInicioSesion();//instancia de la clase
		String[] retorno = is.usuarioConSesionAbierta();//variable que almacena el usuario que inicio sesion
		
		String autorObtenido = request.getParameter("autorNoticia");
		
		System.out.println(autorObtenido);
		
		//Traemos los usuarios
		ArrayList<usuario> usuarios = registro.getArrayUsuarios();
		
		int idUsuario = 0;
		
		//Ubicamos el usuario en el array
		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).getNombreUsuario().equals(autorObtenido)) {
				idUsuario = i;
			}
		}
		
		usuarios.get(idUsuario).getNombreUsuario();
		
		//Procedemos a imprimir sus datos
		
		
		out.println(""
				+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"css/styles.css\">"
				+ "<html op=\"user\">\r\n" + 
				"<head>\r\n" + 
				"<meta name=\"referrer\" content=\"origin\">\r\n" + 
				"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + 
				"<link rel=\"stylesheet\" type=\"text/css\"\r\n" + 
				"	href=\"news.css?fYFyol5qLeG8Il6sQ0cs\">\r\n" + 
				"<link rel=\"shortcut icon\" href=\"favicon.ico\">\r\n" + 
				"<title>Profile: "+usuarios.get(idUsuario).getNombreUsuario()+" | Hacker News</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"	<center>\r\n" + 
				"		<table id=\"hnmain\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\r\n" + 
				"			width=\"85%\" bgcolor=\"#f6f6ef\">\r\n" + 
				"			<tr>\r\n" + 
				"				<td bgcolor=\"#ff6600\"><table border=\"0\" cellpadding=\"0\"\r\n" + 
				"						cellspacing=\"0\" width=\"100%\" style=\"padding: 2px\">\r\n" + 
				"						<tr>\r\n" + 
				"							<td style=\"width: 18px; padding-right: 4px\"><a\r\n" + 
				"								href=\"mainMenu.jsp\"><img src=\"img/y18.gif\"\r\n" + 
				"									width=\"18\" height=\"18\" style=\"border: 1px white solid;\"></a></td>\r\n" + 
				"							<td style=\"line-height: 12pt; height: 10px;\"><span\r\n" + 
				"								class=\"pagetop\"><b class=\"hnname\"><a href=\"mainMenu.jsp\">Hacker\r\n" + 
				"											News</a></b> <a href=\"newest\">new</a> | <a\r\n" + 
				"									href=\"threads?id=adrianh_589\">threads</a> | <a href=\"front\">past</a>\r\n" + 
				"									| <a href=\"newcomments\">comments</a> | <a href=\"ask\">ask</a> |\r\n" + 
				"									<a href=\"show\">show</a> | <a href=\"jobs\">jobs</a> | <a\r\n" + 
				"									href=\"submit\">submit</a> </span></td>\r\n" + 
				"							<td style=\"text-align: right; padding-right: 4px;\"><span\r\n" + 
				"								class=\"pagetop\"> <a id='me' href=\"perfilUsuario.jsp?id=adrian\">"+retorno[0]+"</a>\r\n" + 
				"									(0) | <a id='logout'\r\n" + 
				"									href=\"logout?auth=90392a2301a1d50f032fdd7154849f89e8fc2162&amp;goto=user%3Fid%3Dcollinmanderson\">logout</a>\r\n" + 
				"							</span></td>\r\n" + 
				"						</tr>\r\n" + 
				"					</table></td>\r\n" + 
				"			</tr>\r\n" + 
				"			<tr id=\"pagespace\" title=\"Profile: "+usuarios.get(idUsuario).getNombreUsuario()+" \"\r\n" + 
				"				style=\"height: 10px\"></tr>\r\n" + 
				"			<tr>\r\n" + 
				"				<td><table border=\"0\">\r\n" + 
				"						<tr class='athing'>\r\n" + 
				"							<td valign=\"top\">user:</td>\r\n" + 
				"							<td timestamp=\"1411746178\"><a href=\"user?id=collinmanderson\"\r\n" + 
				"								class=\"hnuser\">"+usuarios.get(idUsuario).getNombreUsuario()+"</a></td>\r\n" + 
				"						</tr>\r\n" + 
				"						<tr>\r\n" + 
				"							<td valign=\"top\">created:</td>\r\n" + 
				"							<td><a href=\"front?day=2014-09-26&birth=collinmanderson\">"+usuarios.get(idUsuario).getFecha_creacion()+"</a></td>\r\n" + 
				"						</tr>\r\n" + 
				"						<tr>\r\n" + 
				"							<td valign=\"top\">karma:</td>\r\n" + 
				"							<td>"+usuarios.get(idUsuario).getKarma()+"</td>\r\n" + 
				"						</tr>\r\n" + 
				"						<tr>\r\n" + 
				"							<td valign=\"top\">about:</td>\r\n" + 
				"							<td>"+usuarios.get(idUsuario).getAcerca_de_mi()+"</td>\r\n" + 
				"						</tr>\r\n" + 
				"						<tr>\r\n" + 
				"							<td></td>\r\n" + 
				"							<td><a href=\"submitted?id=collinmanderson\"><u>submissions</u></a></td>\r\n" + 
				"						</tr>\r\n" + 
				"						<tr>\r\n" + 
				"							<td></td>\r\n" + 
				"							<td><a href=\"threads?id=collinmanderson\"><u>comments</u></a></td>\r\n" + 
				"						</tr>\r\n" + 
				"						<tr>\r\n" + 
				"							<td></td>\r\n" + 
				"							<td><a href=\"favorites?id=collinmanderson\"><u>favorites</u></a>\r\n" + 
				"							</td>\r\n" + 
				"						</tr>\r\n" + 
				"					</table> <br>\r\n" + 
				"				<br></td>\r\n" + 
				"			</tr>\r\n" + 
				"		</table>\r\n" + 
				"	</center>\r\n" + 
				"</body>\r\n" + 
				"<script type='text/javascript' src='hn.js?fYFyol5qLeG8Il6sQ0cs'></script>\r\n" + 
				"</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
