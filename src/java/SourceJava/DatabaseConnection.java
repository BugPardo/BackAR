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
	private Boolean checkUser; 
	
      public void initializeDatabase() 
        throws SQLException, ClassNotFoundException 
    { 
        String dbDriver = "com.mysql.cj.jdbc.Driver"; 
        String dbURL = "jdbc:mysql://db4free.net:3306/dataservice?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"; 
        // Database name to access 
       // String dbName = "dataservic"; 
        String dbUsername = "backroot"; 
        String dbPassword = "Aus@ew03ps4"; 
         
           Class.forName("com.mysql.cj.jdbc.Driver");
                this.connection = DriverManager.getConnection(dbURL,
                        dbUsername, 
                        dbPassword);
                this.statement = connection.createStatement();
        
    }
    
   public Connection getConnection() {
		return connection;
	}
      
      public Boolean query(String user, String password) 
      {
          ResultSet rs;
        try {
           // String sql = ("select * from dataservice.Maincontrol where Maincontrol.MainUser =? AND Maincontrol.MainPassword =?");
            rs = this.statement.executeQuery("select * from dataservice.Maincontrol\n" +
"where Maincontrol.MainUser ='"+user+"' AND Maincontrol.MainPassword ='"+password+"'");

            
            if(rs.next())
            {
                    int id = rs.getInt("idMaincontrol");
                    String firstName = rs.getString("MainUser");
                    String lastName = rs.getString("MainPassword");
            checkUser = true;

                    System.out.format("%s, %s, %s\n", id, firstName, lastName);
            }
            else
            {
            checkUser = false;  
            }
            
      this.statement.close();
//		}
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
          
          return checkUser;
      }
      
}
