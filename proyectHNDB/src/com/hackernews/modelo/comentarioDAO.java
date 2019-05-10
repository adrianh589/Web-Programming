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
            PreparedStatement ps=con.prepareStatement("SELECT U.nombre_usuario, C.fecha_creacion, C.contenido, C.id, C.id_noticia,N.titulo\r\n" + 
            		"            		FROM comentario C\r\n" + 
            		"            		INNER JOIN usuario U\r\n" + 
            		"            		ON C.id_usuario = U.id\r\n" + 
            		"            		INNER JOIN noticia N\r\n" + 
            		"            		ON C.id_noticia = N.id\r\n" + 
            		"            		WHERE N.id = ?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
            	comentario c=new comentario(); 
                c.setAutor(rs.getString(1));   
                c.setFecha_creacion(rs.getString(2).toString());  
                c.setContenido(rs.getString(3));  
                c.setId(rs.getInt(4));
                c.setId_noticia(rs.getInt(5));
                c.setNombreNoticia(rs.getString(6));
                
                list.add(c);
            } 
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return list;
	}
	
	public static int guardarComentariosComentario(comentario c){  
	       int status=0;  
	       try{  
	           Connection con=noticiaDAO.getConnection();  
	           PreparedStatement ps=con.prepareStatement(  
	                        "INSERT INTO comentarios_comentario (id_usuario,id_comentario,id_noticia,contenido) VALUES (?,?,?,?)");
	           ps.setInt(1,c.getId_usuario());
	           ps.setInt(2, c.getId());
	           ps.setInt(3, c.getId_noticia());
	           ps.setString(4, c.getContenido());
	             
	           status=ps.executeUpdate();  
	           System.out.println(status);
	             
	           con.close();  
	       }catch(Exception ex){ex.printStackTrace();}  
	         
	       return status;  
	   }
	
	public static ArrayList<comentario> obtenerComentariosdeComentario(int idComentario){
		ArrayList<comentario> list = new ArrayList<comentario>();  
          
        try{  
            Connection con=noticiaDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement("SELECT U.nombre_usuario, CC.contenido \r\n" + 
            		"FROM comentarios_comentario CC \r\n" + 
            		"INNER JOIN usuario U\r\n" + 
            		"ON CC.id_usuario = U.id \r\n" + 
            		"INNER JOIN noticia N\r\n" + 
            		"ON CC.id_noticia = N.id \r\n" + 
            		"INNER JOIN comentario C \r\n" + 
            		"ON CC.id_comentario = C.id \r\n" + 
            		"WHERE CC.id_comentario = ?");  
            ps.setInt(1,idComentario); 
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
            	comentario c=new comentario(); 
                c.setAutor(rs.getString(1));   
                c.setContenido(rs.getString(2));  
                
                list.add(c);
            } 
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return list;
	}
	

}
