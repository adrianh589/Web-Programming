package noticias;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.sun.org.apache.xerces.internal.util.URI;
import com.sun.org.apache.xerces.internal.util.URI.MalformedURIException;

import registros.registro;
import sesion.inicio_de_sesion;
import usuario.usuario;

// Clase de operaciones que guardara las noticias publicadas por los usuarios
public class Operaciones_noticia {
	
	Date date = new Date();
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	//Array donde se guardaran las noticias
	private static ArrayList<Operaciones_noticia> noticias = new ArrayList<Operaciones_noticia>();
	
	//Obtenemos los usuarios que estan registados 
	ArrayList<usuario> usuarios = registro.getArrayUsuarios();
	
	//Instancia de la clase inicio de sesions
	inicio_de_sesion is = inicio_de_sesion.getInstanciaInicioSesion();
	
	private String titulo;
	private String contenido="";
	private String autorNoticia;
	private String fechaPublicacion=dateFormat.format(date);
	private long puntos=0;
	private String fecha_antiguedad=dateFormat.format(date);
	private String url="";
	private String discusion;
	private String pregunta;
	private Operaciones_noticia guardarNoticia;
	private boolean visibilidad=true;
	private String host;
	
	//Noticias universales--------------------------------
	public static ArrayList getArrayNoticias() {
        return noticias;
    }
	
	public void setArrayNoticias (Operaciones_noticia noticia) {
		this.noticias.add(noticia);
	}
	//-----------------------------------------------------
	
	//Noticias usuarios-------------------------------------------------------------------------------
	public ArrayList<Operaciones_noticia> getNoticiasUsuario() {
		String [] usuarioSesionAbierta = is.usuarioConSesionAbierta();
		return usuarios.get(Integer.parseInt(usuarioSesionAbierta[1])).getNoticiasPublicadas();
	}
	
	public void setNoticiasUsuario (Operaciones_noticia noticia) {
		String [] usuarioSesionAbierta = is.usuarioConSesionAbierta();
		this.usuarios.get(Integer.parseInt(usuarioSesionAbierta[1])).setNoticiasPublicadas(noticia);
	}
	//--------------------------------------------------------------------------------------------------
	
	//Getters y Setters

	public String getAutorNoticia() {
		return autorNoticia;
	}

	public void setAutorNoticia(String autorNoticia) {
		this.autorNoticia = autorNoticia;
	}

	public String getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(String fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public long getPuntos() {
		return puntos;
	}

	public void setPuntos(String operador) {
		if(operador.equals("+")) {
			this.puntos += 1;
		}
	}

	public String getFecha_antiguedad() {
		return fecha_antiguedad;
	}

	public void setFecha_antiguedad(String fecha_antiguedad) {
		this.fecha_antiguedad = fecha_antiguedad;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getDiscusion() {
		return discusion;
	}

	public void setDiscusion(String discusion) {
		this.discusion = discusion;
	}
	
	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public boolean isVisibilidad() {
		return visibilidad;
	}

	public void setVisibilidad(boolean visibilidad) {
		this.visibilidad = visibilidad;
	}
	
	

	/**
	 * Metodo para converitr las direcciones web en hosts
	 * @param url Recibe la url
	 * @return La url en modo host
	 * @throws MalformedURIException
	 */
	public String getHostName(String url) throws MalformedURIException {
	    URI uri = new URI(url);
	    String hostname = uri.getHost();
	    // to provide faultproof result, check if not null then return only hostname, without www.
	    if (hostname != null) {
	        return hostname.startsWith("www.") ? hostname.substring(4) : hostname;
	    }
	    return hostname;
	}
	
	

}
