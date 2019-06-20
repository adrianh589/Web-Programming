package com.hackernews.modelo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Clase usuario, se almacena todo lo que tienen los usuarios
 * @author Hoyos
 *
 */
public class usuario {
	
	private int id;
	private String nombreUsuario;
	private String contraseña;
	private Timestamp fecha_creacion;
	private int karma;
	private String acerca_de_mi;
	private String email;
	private String showdead;
	private String noprocast;
	private long visitasMaximas;
	private int minAway;
	private int retraso;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
		
	}
	public void setNombreUsuario(String nombre) {
		this.nombreUsuario = nombre;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	public int getKarma() {
		return karma;
	}
	
	public void setKarma(int karma) {
		this.karma = karma;
	}
	
	public String getAcerca_de_mi() {
		return acerca_de_mi;
	}
	public void setAcerca_de_mi(String acerca_de_mi) {
		this.acerca_de_mi = acerca_de_mi;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getShowdead() {
		return showdead;
	}
	public void setShowdead(String showdead) {
		this.showdead = showdead;
	}
	public String getNoprocast() {
		return noprocast;
	}
	public void setNoprocast(String noprocast) {
		this.noprocast = noprocast;
	}
	public long getVisitasMaximas() {
		return visitasMaximas;
	}
	public void setVisitasMaximas(long visitasMaximas) {
		this.visitasMaximas = visitasMaximas;
	}
	public int getMinAway() {
		return minAway;
	}
	public void setMinAway(int minAway) {
		this.minAway = minAway;
	}
	public int getRetraso() {
		return retraso;
	}
	public void setRetraso(int retraso) {
		this.retraso = retraso;
	}
	
	public Timestamp getFecha_creacion() {
		return fecha_creacion;
	}
	public void setFecha_creacion(Timestamp fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	
	

}
