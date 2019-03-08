package parEimpar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class paresImpares {
	
	static InputStreamReader isr = new InputStreamReader(System.in);
	static BufferedReader br = new BufferedReader(isr);
	static String rta = "s";
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
			
		valorar();//Llamamos a la funcion que valora los numeros
	}
	
	/**
	 * Funcion que valora si son numeros pares o impares
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	static void valorar() throws NumberFormatException, IOException {
		try {
			do {
				System.out.println("Porfavor ingrese el numero para evaluar");
				double numero = Double.parseDouble(br.readLine());
				
				if (numero%2==0) {
					System.out.println("Este numero es par");
				} else {
					System.out.println("Este numero es impar");
				}
				System.out.println("Desea valorar otro numero? s/n");
				rta = br.readLine();
			}
			while( rta.equals("s") );
			
		}catch(Exception e) {
			System.out.println("Ingrese solo numeros validos");
			valorar();
		}
	}
}
