package sesion;
import java.util.ArrayList;
import registros.*;
import usuario.*;

public class cierre_de_sesion {
	
	//Traemos los usuarios registrados de la variable deregistros
	static ArrayList <usuario> usuariosLocales = registros.registro.getArrayUsuarios();
	
	/**
	 * Metodo que cerrara la sesion del usuario actual
	 * @param nombreUsuario Variable del nombre del usuario al que se le va a cerrar sesion
	 */
	public void cerrarSesion(String nombreUsuario) {
		for (int i = 0; i < usuariosLocales.size(); i++) {
			if (usuariosLocales.get(i).getNombreUsuario().equals(nombreUsuario)) {
				usuariosLocales.get(i).setSesionIniciada(false);//cerramos su sesion
			}
		}
	}
	
	/**
	 * Metodo que cerrara las demas sesiones
	 */
	public void evitarMultiplesSesiones(int i) {
			for (int j = 0; j < usuariosLocales.size(); j++) {
				if(i!=j) {
					usuariosLocales.get(j).setSesionIniciada(false);
				}
			}
	}

}
