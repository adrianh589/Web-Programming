package registros;
import java.util.ArrayList;
import sesion.inicio_de_sesion;
import sesion.cierre_de_sesion;

import usuario.usuario;

/**
 * Clase para guardar los registros de los usuarios
 * @author Hoyos
 *
 */
public class registro {
	
	//Array list que almacenara los usuarios que se hayan registrado
	private static ArrayList<usuario> usuarios = new ArrayList<usuario>();
	
	//instancia de la clase inicio de sesion
	inicio_de_sesion ini = inicio_de_sesion.getInstanciaInicioSesion();
	
	//instancia de la clase cerrar sesion
	cierre_de_sesion cerrarDemasSesiones = new cierre_de_sesion();
	
	
	
	/**
	 * M�todo que a�ade el nombre de usuario y la contrase�a en el array list
	 * @param nombreUsuario Variable del nombre de usuario almacenar
	 * @param contrase�a Variable de la contrase�a a alamacenar
	 */
	void crearCuenta(String nombreUsuario, String contrase�a) {
		usuario usuario = new usuario();
		
		usuario.setNombreUsuario(nombreUsuario);
		usuario.setContrase�a(contrase�a);
		
		boolean existe = existe(nombreUsuario);
		
		if (!existe==true) {
			cerrarDemasSesiones.evitarMultiplesSesiones(usuarios.size());//Cerramos las demas sesiones
			usuario.setSesionIniciada(true);//El usuario que se acaba de registrar, tendra su sesion iniciada
			usuarios.add(usuario);//a�adimos al usuario con su sesion iniciada
		} else {
			System.out.println("Usuario ya existe");
		}
		
		
		
		Imprimir();
	}
	
	/**
	 * M�todo que imprime por pantalla para verificar en modo de prueba que se ha registrado de manera satisfactoria.
	 */
	void Imprimir() {
		for (int i = 0; i < usuarios.size(); i++) {
			System.out.println("Estamos en la posicion: "+i);
			usuarios.get(i).obtenerDatos();
			
		}
		System.out.println("................................");
		
	}
	
	/**
	 * metodo que verifica que no exista un usuario
	 * @param nombreUsuario
	 * @return
	 */
	public boolean existe (String nombreUsuario) {
		//variable que dira si el usuario existe
		boolean existe = false;
				
		//recorremos el array de usuarios para verificar que no exista
		for (int i = 0; i < usuarios.size(); i++) {
			if(usuarios.get(i).getNombreUsuario().equals(nombreUsuario)) {
				return true;
			}
		}
		return false;
	}
	
	public static ArrayList getArrayUsuarios() {
        return usuarios;
    }
	

}
