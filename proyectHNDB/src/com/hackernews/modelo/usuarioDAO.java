package com.hackernews.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class usuarioDAO {

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
   
   
   public static int guardar(usuario u){  
       int status=0;  
       try{  
           Connection con=usuarioDAO.getConnection();  
           PreparedStatement ps=con.prepareStatement(  
                        "insert into usuario(nombre_usuario,contraseña) values (?,?)");  
           ps.setString(1,u.getNombreUsuario());  
           ps.setString(2,u.getContraseña());
             
           status=ps.executeUpdate();  
           System.out.println(status);
             
           con.close();  
       }catch(Exception ex){ex.printStackTrace();}  
         
       return status;  
   }
   
   /**
    * verifica si el usuario esta en la BD
    */
   public static usuario verificar(String nombre_usuario, String contraseña) {
	   usuario u = null;
	   try {
		Connection con=usuarioDAO.getConnection();
		PreparedStatement ps=con.prepareStatement(  
                "SELECT * FROM usuario U "
                + "WHERE U.nombre_usuario = '"+nombre_usuario+"' "
                + "AND U.contraseña = '"+contraseña+"'");  
		
				ResultSet rs=ps.executeQuery(); 
				
				if(rs.next()) {//Si se encontro el susuario
					u= new usuario();

					u.setId(rs.getInt(1));  
	                u.setNombreUsuario(rs.getString(2));  
	                u.setContraseña(rs.getString(3));  
	                u.setFecha_creacion(rs.getTimestamp(4));  
	                u.setKarma(rs.getInt(5));
	                u.setAcerca_de_mi(rs.getString(6));
	                u.setEmail(rs.getString(7));
	                u.setShowdead(rs.getString(8));
	                u.setNoprocast(rs.getString(9));
	                u.setVisitasMaximas(rs.getInt(10));
		            u.setMinAway(rs.getInt(11));
		            u.setRetraso(rs.getInt(12));
		            
		            return u;
				}
	            
	            con.close(); 
				
	} catch (Exception ex) {ex.printStackTrace();}
	   
	   return u;
   }
   
   public static int actualizar(usuario u){  
       int status=0;  
       try{  
           Connection con=usuarioDAO.getConnection();  
           PreparedStatement ps=con.prepareStatement(  
                        "update usuario set acerca_de_mi=?,email=?,showdead=?,noprocast=?,visitas_maximas=?,min_away=?,retraso=?"
                        + " where id=?");  
           ps.setString(1,u.getAcerca_de_mi());  
           ps.setString(2,u.getEmail());  
           ps.setString(3,u.getShowdead()); 
           ps.setString(4,u.getNoprocast()); 
           ps.setLong(5,u.getVisitasMaximas());
           ps.setInt(6,u.getMinAway());
           ps.setInt(7,u.getRetraso());
           ps.setInt(8,u.getId());
             
           status=ps.executeUpdate();  
             
           con.close();  
       }catch(Exception ex){ex.printStackTrace();}  
         
       return status;  
   }  
   
   public static int borrar(int id){  
       int status=0;  
       try{  
           Connection con=usuarioDAO.getConnection();  
           PreparedStatement ps=con.prepareStatement("delete from datos where id=?");  
           ps.setInt(1,id);  
           status=ps.executeUpdate();  
             
           con.close();  
       }catch(Exception e){e.printStackTrace();}  
         
       return status;  
   }

}
