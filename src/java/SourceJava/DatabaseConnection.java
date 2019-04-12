/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SourceJava;


import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



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
      public ArrayList combobox()
      {
          ArrayList emails = new ArrayList();
          try{  
         connectdatabase();
        PreparedStatement ps= connection.prepareStatement("select * from emails");  
        ResultSet rs=ps.executeQuery();
         while(rs.next())
             {
                   
                  emails.add(rs.getString("emailaddress"));
                   
            }
//        result=rs.next();  

        }catch(Exception e){
        System.out.println(e);
        }   
          
          
            return emails;
          
      }
      
       private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

      
      
      public String uploadfiles(User user,  InputStream inputStream){  
        String result = "";

         java.util.Date uDate = new java.util.Date();
        System.out.println("Time in java.util.Date is : " + uDate);
        java.sql.Date sDate = convertUtilToSql(uDate);
        
        try{  
         connectdatabase();
         PreparedStatement ps= connection.prepareStatement("INSERT INTO record (date,file,fkUser,fkEmail) VALUES (?,?,?,?)");  
        ps.setDate(1, sDate);     
         if (inputStream != null) {
                ps.setBlob(2, inputStream);
           }
        
        ps.setInt(3, 1);  
          ps.setInt(4, 1);  
        System.out.println("Login " + user.getUsername() +  " " + user.getPassword());        
        
         
        int row = ps.executeUpdate();
            if (row > 0) {
                result = "File uploaded and saved into database";
            }
//        result=rs.next();  
        System.out.println(result);
        }catch(Exception e){
        System.out.println(e);
        }  
        return result;  
  //string
  
  
        
  
}  
      
      
      public void sendemail(){
          // Recipient's email ID needs to be mentioned.
      }

}
