package SourceJava;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import SourceJava.User;
import SourceJava.DatabaseConnection;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(
		description = "Login Servlet", 
		urlPatterns = { 
				"/Login", 
				"/Login.do"
		})

public class LoginConnect extends HttpServlet {
     User user = new User();
     DatabaseConnection dataconnect = new DatabaseConnection();
    public LoginConnect() {
        super();
     
    }
   
    @SuppressWarnings("unchecked")
	public void init(){
    
    	
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getSession().getAttribute("user") != null){
			request.getRequestDispatcher("/session.jsp").forward(request, response);
			
		} else {
			doPost(request,response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         
		DatabaseConnection datab = new DatabaseConnection();                 
		if (request.getParameter("inputUsername") != null && request.getParameter("inputPassword") != null ){
                        
                        String username = request.getParameter("inputUsername");
                        String password = request.getParameter("inputPassword");
                        user.setUsername(username);
                        user.setPassword(password);
                       
                        String result =  dataconnect.ConnectUser(user);
                        System.out.println(result);
                        if (result == ""){
                            request.getSession().setAttribute("erroruser", "User or password incorrect");
                            request.getRequestDispatcher("/login.jsp").forward(request, response);
                        } else{
                            doSession(request,response);
                            request.getSession().setAttribute("user", user.getUsername());
                            request.getSession().setAttribute("sessionFullname", result);
                            Cookie fullName = new Cookie("fullName",result);
                            request.getRequestDispatcher("/session.jsp").forward(request, response);
                        } 
		} else {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
	private void doSession(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		

		HttpSession session = request.getSession();
		
		
		Date createTime = new Date(session.getCreationTime());
		
		String sessionId = session.getId();
	
		Date lastAccessedTime = new Date(session.getLastAccessedTime());
		int maxInactiveInterval = session.getMaxInactiveInterval();

		session.setAttribute("lastAccessedTime", lastAccessedTime);
		session.setAttribute("creationTime", createTime);
		session.setAttribute("sessionId", sessionId);
		session.setAttribute("maxInactiveInterval", maxInactiveInterval);
	
	}

    
}

