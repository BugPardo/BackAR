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
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author arellajo
 */
public class DatabaseConnection {
    private String database;
	private Connection connection;
	private Statement statement;
	private int checkUser; 
	
      public void initializeDatabase() 
        throws SQLException, ClassNotFoundException 
    { 
        String dbDriver = "com.mysql.cj.jdbc.Driver"; 
        String dbURL = "jdbc:mysql://localhost:3306/dataservic?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"; 
        // Database name to access 
       // String dbName = "dataservic"; 
        String dbUsername = "backroot"; 
        String dbPassword = "Aus@ew03ps4"; 
         
           Class.forName("com.mysql.cj.jdbc.Driver");
                this.connection = DriverManager.getConnection(dbURL,dbUsername,dbPassword);
                this.statement = connection.createStatement();
        
    }
    
   public Connection getConnection() {
		return connection;
	}
   
   
      public void query(String user, String password) 
      {
         // ResultSet rs;
        try {
           // String sql = ("select * from dataservice.Maincontrol where Maincontrol.MainUser =? AND Maincontrol.MainPassword =?");
           // rs = this.statement.executeQuery("select * from dataservic.users where users.Username ='"+user+"' AND users.UserPassword ='"+password+"'");  where users.Username =? AND users.UserPassword =?

            
            PreparedStatement pst = connection.prepareStatement("select * from users ");
        pst.setString(1, user);
        pst.setString(2, password);
        ResultSet rs = pst.executeQuery();  
            
            
            if(rs.next())
            {
                    int id = rs.getInt("idMaincontrol");
                    String firstName = rs.getString("MainUser");
                    String lastName = rs.getString("MainPassword");
            checkUser = 1;

                    System.out.format("%s, %s, %s\n", id, firstName, lastName);
            }
            else
            {
            checkUser = 2;
            }
            
     rs.close();
//		}
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
          
         
      }
      
}
