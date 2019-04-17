package com.hackernews.modelo;

/**
 * Clase que anexa comentarios a las noticias segun los usuarios
 * @author Hoyos
 *
 */
public class comentario {
	
	private int id;
	private int id_noticia;
	private String contenido;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_noticia() {
		return id_noticia;
	}
	public void setId_noticia(int id_noticia) {
		this.id_noticia = id_noticia;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	
	

	
}
