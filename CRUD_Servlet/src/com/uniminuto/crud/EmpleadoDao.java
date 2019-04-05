package com.uniminuto.crud;

import java.util.*;  
import java.sql.*;  
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
  
  
public class EmpleadoDao {  
  
    public static Connection getConnection() throws  SQLException, ClassNotFoundException{  
    	 // Initialize all the information regarding 
        // Database Connection 
        String dbDriver = "com.mysql.jdbc.Driver"; 
        String dbURL = "jdbc:mysql://localhost:3306/"; 
        // Database name to access 
        String dbName = "crud_test"; 
        String dbUsername = "root"; 
        String dbPassword = ""; 
        Class.forName(dbDriver); 
        Connection con = DriverManager.getConnection(dbURL + dbName,dbUsername,dbPassword); 
        return con; 
    }  
    
    
    public static int save(Empleado e){  
        int status=0;  
        try{  
            Connection con=EmpleadoDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into datos(name,password,email,country) values (?,?,?,?)");  
            ps.setString(1,e.getName());  
            ps.setString(2,e.getPassword());  
            ps.setString(3,e.getEmail());  
            ps.setString(4,e.getCountry());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int update(Empleado e){  
        int status=0;  
        try{  
            Connection con=EmpleadoDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update datos set name=?,password=?,email=?,country=? where id=?");  
            ps.setString(1,e.getName());  
            ps.setString(2,e.getPassword());  
            ps.setString(3,e.getEmail());  
            ps.setString(4,e.getCountry());  
            ps.setInt(5,e.getId());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=EmpleadoDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from datos where id=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    public static Empleado getEmployeeById(int id){  
        Empleado e=new Empleado();  
          
        try{  
            Connection con=EmpleadoDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from datos where id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setPassword(rs.getString(3));  
                e.setEmail(rs.getString(4));  
                e.setCountry(rs.getString(5));  
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  
    public static List<Empleado> getAllEmployees(){  
        List<Empleado> list=new ArrayList<Empleado>();  
          
        try{  
            Connection con=EmpleadoDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from datos");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Empleado e=new Empleado();  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setPassword(rs.getString(3));  
                e.setEmail(rs.getString(4));  
                e.setCountry(rs.getString(5));  
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
}  