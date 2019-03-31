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
	private static final long serialVersionUID = 1L;
	
  
    public LoginConnect() {
        super();
     
    }
   
    @SuppressWarnings("unchecked")
	public void init(){
    
        
        
    	Map<String, User> DB = null;
    	if (this.getServletContext().getAttribute("DB") == null){ 
    		DB = new HashMap<String,User>();
    		User user1 = new User("1", "3");
    		user1.setFullName("123");
    		User user2 = new User("1", "2");
    		user2.setFullName("123");
    		DB.put("1",user1);
    		DB.put("2", user2);
    		this.getServletContext().setAttribute("DB", DB);

    	} else {
    		DB = (HashMap<String, User>) this.getServletContext().getAttribute("DB");
    	}
    	
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getSession().getAttribute("user") != null){
			request.getRequestDispatcher("/session.jsp").forward(request, response);
			
		} else {
			doPost(request,response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> errors = new ArrayList<String>();
	
               
//            // to display the succesful result 
//            PrintWriter out = response.getWriter(); 
//            out.println("<html><body><b>"+"asdasdnsdnsjndjhis"+ "</b></body></html>"); 
                 
		DatabaseConnection datab = new DatabaseConnection();
                //request.setAttribute("InputUsername", "12312312312");
            try {
                datab.initializeDatabase();
            } catch (SQLException ex) {
                Logger.getLogger(LoginConnect.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(LoginConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
                 
		if (request.getParameter("inputUsername") != null && request.getParameter("inputPassword") != null ){
			String username = request.getParameter("inputUsername");
			String password = request.getParameter("inputPassword");
                        Integer bash = 0;
//                        datab.query(username, password);
                        
                        if (bash !=0){
//
                            errors.add("Invalid username or password.");
                            request.setAttribute("errors", errors);
                            request.getRequestDispatcher("/login.jsp").forward(request, response);
                        } else{
//
                            doSession(request,response);
                            request.getSession().setAttribute("user","Testing");
                            Cookie fullName = new Cookie("fullName","Jelipedejesus");
                            request.getRequestDispatcher("/session.jsp").forward(request, response);
//
                        }
                        
		} else {
//    	     PrintWriter out = response.getWriter(); 
//			out.println("");
			errors.add("You should login first");
			request.setAttribute("errors", errors);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
	
	private User login(String username, String password){
	
		if (username == null || password == null){
            return null;
        }
		Map<String,User> DB = null;
		DB = (HashMap<String, User>) this.getServletContext().getAttribute("DB");
		User user = DB.get(username);
         
        if (user == null){
            return null;
        }
         
        if (!user.getPassword().equals(password.trim())){
            return null;
        }
        return user;
         
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

