/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SourceJava;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author arellajo
 */
public class DatabaseConnection {
 
        String Driver = "com.mysql.cj.jdbc.Driver"; 
        String URL = "jdbc:mysql://db4free.net:3306/backdata?autoReconnect=true&useSSL=false"; 
        String Username = "blackroot"; 
        String Password = "rAsuea1d@"; 
       public Connection connection = null;
    
    
      public void connectdatabase() throws ClassNotFoundException, SQLException     { 
        Class.forName(Driver);
        connection = DriverManager.getConnection(URL,Username,Password);
    }
  

        public String ConnectUser(User user){  
        String result = "";

     
        try{  
         connectdatabase();
        System.out.println("Entra a esta mamada");
        PreparedStatement ps= connection.prepareStatement("select * from usercontrol where namecontrol=? and passwordcontrol=?");  
        ps.setString(1,user.getUsername());  
        ps.setString(2, user.getPassword());  
        System.out.println("Login " + user.getUsername() +  " " + user.getPassword());        
        ResultSet rs=ps.executeQuery();
         if(rs.next())
            {
                    int id = rs.getInt("idcontrol");
                    String name = rs.getString("namecontrol");
                    String password = rs.getString("passwordcontrol");
                    result = rs.getString("fullnamecontrol");
                    System.out.format("%s, %s, %s, %s\n", id, name, password,result);
                   
            }
//        result=rs.next();  
        System.out.println(result);
        }catch(Exception e){
        System.out.println(e);
        }  
        return result;  
  //string
  
  
  
}  
      
      


}
