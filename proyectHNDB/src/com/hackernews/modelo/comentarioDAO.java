package com.hackernews.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class comentarioDAO {
	
	public static Connection getConnection() throws  SQLException, ClassNotFoundException{  
	   	 // Initialize all the information regarding 
	       // Database Connection 
	       String dbDriver = "com.mysql.jdbc.Driver"; 
	       String dbURL = "jdbc:mysql://localhost:3306/"; 
	       // Database name to access 
	       String dbName = "hackerbd"; 
	       String dbUsername = "root"; 
	       String dbPassword = ""; 
	       Class.forName(dbDriver); 
	       Connection con = DriverManager.getConnection(dbURL + dbName,dbUsername,dbPassword); 
	       return con; 
	   }
	
	public static int guardar(comentario c){  
	       int status=0;  
	       try{  
	           Connection con=noticiaDAO.getConnection();  
	           PreparedStatement ps=con.prepareStatement(  
	                        "INSERT INTO comentario (id,id_noticia,id_usuario,contenido) VALUES (?,?,?,?)");
	           ps.setInt(1,c.getId());
	           ps.setInt(2, c.getId_noticia());
	           ps.setInt(3, c.getId_usuario());
	           ps.setString(4, c.getContenido());
	             
	           status=ps.executeUpdate();  
	           System.out.println(status);
	             
	           con.close();  
	       }catch(Exception ex){ex.printStackTrace();}  
	         
	       return status;  
	   }
	
	public static ArrayList<comentario> obtenerComentariosPorIdNoticia(int id){
		ArrayList<comentario> list = new ArrayList<comentario>();  
          
        try{  
            Connection con=noticiaDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement("SELECT U.nombre_usuario, C.fecha_creacion, C.contenido\r\n" + 
            		"FROM noticia N\r\n" + 
            		"INNER JOIN comentario C\r\n" + 
            		"ON N.id = C.id_noticia\r\n" + 
            		"INNER JOIN usuario U\r\n" + 
            		"ON U.id = N.id_usuario\r\n" + 
            		"WHERE N.id = ?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
            	comentario c=new comentario(); 
                c.setAutor(rs.getString(1));   
                c.setFecha_creacion(rs.getString(2).toString());  
                c.setContenido(rs.getString(3));  
                
                list.add(c);
            } 
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return list;
	}
	

}
