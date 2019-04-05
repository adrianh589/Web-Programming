package comentarios;

import java.util.ArrayList;

public class comentarios {
	
		private String autor;
		private String titulo;
		private String texto;

		//Array donde se guardaran los comentarios
		private ArrayList<comentarios> comentarios;
		
		
		//Getters y Setters
		
		public ArrayList getComentarios() {
			if (comentarios == null) {
				comentarios = new ArrayList();
	        }
	        return comentarios;
		}

		public void setComentarios(comentarios comentarios) {
			this.comentarios.add(comentarios);
		}
		
		

}
