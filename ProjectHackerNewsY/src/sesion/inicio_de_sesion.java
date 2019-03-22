package sesion;
import usuario.*;
import java.util.ArrayList;

import registros.registro;

public class inicio_de_sesion{
	
	private static inicio_de_sesion instancia = null;
	
	protected inicio_de_sesion() {
    }
	
	//Traemos los usuarios registrados de la variable de registros
	private static ArrayList <usuario> usuariosLocales = registro.getArrayUsuarios();
	
	//instancia de la clase cierre de sesion
	cierre_de_sesion cerrarLasDemasSesiones = new cierre_de_sesion();
	
	/**
	 * Este metodo verificara que un usuario exista para poder iniciar sesion correctamente
	 * @param nombreUsuario variable para leer el nombre que se haya dado
	 * @param contraseña variable para poder leer la contraseña 
	 * @return retorna verdadero si el usuario esta registrado, en caso contrario retornara false
	 */
	public boolean iniciarSesion(String nombreUsuario, String contraseña) {
		for (int i = 0; i < usuariosLocales.size(); i++) {
			if (usuariosLocales.get(i).getNombreUsuario().equals(nombreUsuario) && usuariosLocales.get(i).getContraseña().equals(contraseña) ) {
				cerrarLasDemasSesiones.evitarMultiplesSesiones(i);//Se cerraran las demas sesiones
				usuariosLocales.get(i).setSesionIniciada(true);//Ponemos que ese usuario inicie sesion
				verificar();
				return true;
			}
		}
		verificar();
		return false;
	}
	
	/**
	 * Metodo que nos devolvera el usuario que tenga la sesion abierta actualmente
	 * @return un array con los valores de su nombre y la posicion en el array
	 */
	public String[] usuarioConSesionAbierta() {
		String array [] = new String[2];
		for (int i = 0; i < usuariosLocales.size(); i++) {
			if(usuariosLocales.get(i).isSesionIniciada()==true) {
				System.out.println("mira lo que te retorno: "+usuariosLocales.get(i).getNombreUsuario());
				String nom = usuariosLocales.get(i).getNombreUsuario();
				array[0]=nom;
				array[1]= Integer.toString(i);
				System.out.println("Esto viene del metodo "+array[0]);
				verificar();
				return array;
			}
		}
		verificar();
		System.out.println("--------------------");
		array[0]="ninguno";
		return array;
	}
	
	/**
	 * metodo para borrar
	 */
	private void verificar() {
		for (int i = 0; i < usuariosLocales.size(); i++) {
			System.out.println("El usuario "+usuariosLocales.get(i).getNombreUsuario()+" tiene la sesion: "+usuariosLocales.get(i).isSesionIniciada());
		}
		System.out.println("--------------------");
	}
	
	/**
	 * Metodo que instancia la clase inicio_de_sesion, evita que se instancie múltipes veces
	 * @return La instancia creada si no la tiene, o la misma en caso de no tenerla
	 */
	public static inicio_de_sesion getInstanciaInicioSesion() {
		if (instancia == null) {
            instancia = new inicio_de_sesion();
        }
 
        return instancia;
	}
	
	

}
