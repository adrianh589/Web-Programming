package com.hackernews.modelo;

/**
 * Clase que anexa comentarios a las noticias segun los usuarios
 * @author Hoyos
 *
 */
public class comentario {
	
	private int id;
	private int id_noticia;
	private int id_usuario;
	private String autor;
	private String contenido;
	private String fecha_creacion;
	private int votos;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_noticia() {
		return id_noticia;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
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
	public int getVotos() {
		return votos;
	}
	public void setVotos(int votos) {
		this.votos = votos;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getFecha_creacion() {
		return fecha_creacion;
	}
	public void setFecha_creacion(String fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	
	

	
}
