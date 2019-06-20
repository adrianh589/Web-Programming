package com.hackernews.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hackernews.modelo.noticia;

public class noticiaDAO {
	
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
	
	public static int guardar(noticia n){  
	       int status=0;  
	       try{  
	           Connection con=noticiaDAO.getConnection();  
	           PreparedStatement ps=con.prepareStatement(  
	                        "insert into noticia (id_usuario,titulo,contenido,url,host) values (?,?,?,?,?)");
	           ps.setInt(1,n.getId_usuario());
	           ps.setString(2, n.getTitulo());
	           ps.setString(3, n.getContenido());
	           ps.setString(4, n.getUrl());
	           ps.setString(5, n.getHostName(n.getUrl()));
	             
	           status=ps.executeUpdate();  
	           System.out.println(status);
	             
	           con.close();  
	       }catch(Exception ex){ex.printStackTrace();}  
	         
	       return status;  
	   }
	
	public static ArrayList<noticia> obtenerNoticias(){  
        ArrayList<noticia> list=new ArrayList<noticia>();  
        
        try{  
            Connection con=noticiaDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement("SELECT N.titulo, N.url, N.host,N.puntos, U.nombre_usuario, N.fecha_publicacion, N.id_usuario\r\n" + 
            		"FROM noticia N\r\n" + 
            		"LEFT JOIN usuario U\r\n" + 
            		"ON U.id = N.id_usuario");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
               noticia n=new noticia();  
               n.setTitulo(rs.getString(1));  
               n.setUrl(rs.getString(2));  
               n.setHost(rs.getString(3));  
               n.setPuntos(rs.getInt(4));  
               n.setAutor(rs.getString(5));
               n.setFecha_publicacion(rs.getTimestamp(6).toString());
               n.setId_usuario(rs.getInt(7));
               
               list.add(n);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    } 
	
	public static int votar(int idNoticia){  
		int status=0;  
        try{  
            Connection con=noticiaDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "UPDATE noticia SET puntos = puntos + 1 WHERE id= ?");
             ps.setInt(1, idNoticia);
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;   
	   }
	
	/**
	 * Metodo que devuelve una noticia mediante su id
	 * @param id Recibe el id de la noticia
	 * @return Devuelve la noticia de la base de datos
	 */
	public static noticia obtenerNoticiaPorId(int id){  
	        noticia n=new noticia(); 
	        
	        try{  
	            Connection con=noticiaDAO.getConnection();  
	            PreparedStatement ps=con.prepareStatement("SELECT N.id,U.nombre_usuario,N.titulo,N.contenido,N.fecha_publicacion,N.puntos,N.url,N.visibilidad,N.host\r\n" + 
	            		"FROM noticia N\r\n" + 
	            		"LEFT JOIN usuario U\r\n" + 
	            		"ON U.id = N.id_usuario\r\n" + 
	            		"WHERE N.id = ?");  
	            ps.setInt(1,id);  
	            ResultSet rs=ps.executeQuery();  
	            if(rs.next()){  
	                n.setId(rs.getInt(1));  
	                n.setAutor(rs.getString(2));  
	                n.setTitulo(rs.getString(3));  
	                n.setContenido(rs.getString(4));  
	                n.setFecha_publicacion(rs.getString(5).toString()); 
	                n.setPuntos(rs.getInt(6)); 
	                n.setUrl(rs.getString(7)); 
	                n.setVisibilidad(rs.getBoolean(8));
	                n.setHost(rs.getString(9)); 
	            } 
	            
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return n;  
	    }

}
