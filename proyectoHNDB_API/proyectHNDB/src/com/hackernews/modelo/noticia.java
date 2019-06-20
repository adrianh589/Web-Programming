package com.hackernews.modelo;

import java.sql.Timestamp;
import java.util.ArrayList;

import com.sun.org.apache.xerces.internal.util.URI;
import com.sun.org.apache.xerces.internal.util.URI.MalformedURIException;

public class noticia {
	
	private int id;
	private int id_usuario;
	private String titulo;
	private String contenido;
	private String fecha_publicacion;
	private long puntos;
	private String url;
	private boolean visibilidad;
	private String host;
	private String autor;
	
	//Getters y Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public void setPuntos(long puntos) {
		this.puntos = puntos;
	}
	
	public long getPuntos() {
		return puntos;
	}

	public void setPuntos(String operador) {
		if(operador.equals("+")) {
			this.puntos += 1;
		}
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	public String getFecha_publicacion() {
		return fecha_publicacion;
	}

	public void setFecha_publicacion(String fecha_publicacion) {
		this.fecha_publicacion = fecha_publicacion;
	}

	public boolean isVisibilidad() {
		return visibilidad;
	}

	public void setVisibilidad(boolean visibilidad) {
		this.visibilidad = visibilidad;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * Metodo para converitr las direcciones web en hosts
	 * @param url Recibe la url
	 * @return La url en modo host
	 * @throws MalformedURIException
	 */
	public String getHostName(String url) {
		
		try {//Capturamos excepcion por si se ingresa una url iinválida
		
	    URI uri = new URI(url);
	    String hostname = uri.getHost();
	    // to provide faultproof result, check if not null then return only hostname, without www.
	    if (hostname != null) {
	        return hostname.startsWith("www.") ? hostname.substring(4) : hostname;
	    }
	    hostname = "";
	    
	    return hostname;
		}catch(Exception e) {
			return "";
		}
	}

}
