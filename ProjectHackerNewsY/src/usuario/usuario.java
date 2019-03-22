package usuario;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import noticias.Operaciones_noticia;
import sesion.inicio_de_sesion;
/**
 * Clase usuario, se almacena todo lo que tienen los usuarios
 * @author Hoyos
 *
 */
public class usuario {
	
	
	
	Date date = new Date();
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	private String nombreUsuario;
	private String contraseña;
	private String fecha_creacion=dateFormat.format(date);
	private int karma=0;
	private String acerca_de_mi="";
	private String email="";
	private String showdead="no";
	private String noprocast="no";
	private long visitasMaximas=20;
	private int minAway=180;
	private int retraso=0;
	private boolean sesionIniciada=false;
	private ArrayList <Operaciones_noticia> noticiasPublicadas;
	private String id = "user?id="+nombreUsuario;
	
	
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
	public String getFecha_creacion() {
		return fecha_creacion;
	}
	public void setFecha_creacion(String fecha_cracion) {
		this.fecha_creacion = fecha_cracion;
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
	
	public boolean isSesionIniciada() {
		return sesionIniciada;
	}
	
	public void setSesionIniciada(boolean sesionIniciada) {
		this.sesionIniciada = sesionIniciada;
	}
	
	public ArrayList<Operaciones_noticia> getNoticiasPublicadas() {
		return noticiasPublicadas;
	}
	
	public void setNoticiasPublicadas(Operaciones_noticia nuevaNoticia) {
		if (noticiasPublicadas == null) {
			this.noticiasPublicadas = new ArrayList<Operaciones_noticia>();
		}
		this.noticiasPublicadas.add(nuevaNoticia);
	}
	
	public void obtenerDatos(){
		System.out.println("********************");
		System.out.println(getNombreUsuario());
		System.out.println(isSesionIniciada());
		System.out.println(getAcerca_de_mi());
		System.out.println(getContraseña());
		System.out.println(getEmail());
		System.out.println(getFecha_creacion());
		System.out.println(getKarma());
		System.out.println(getMinAway());
		System.out.println(getRetraso());
		System.out.println(getRetraso());
		System.out.println(getVisitasMaximas());
		System.out.println(getShowdead());
		System.out.println(getNoprocast());
		System.out.println("********************");
	}
	
	

}
