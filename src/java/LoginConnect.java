
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
    		User user1 = new User("anakin", "deathStar2");
    		user1.setFullName("Anakin Skywalker");
    		User user2 = new User("kenobi", "starfighter");
    		user2.setFullName("Obi Wan Knenobi");
    		DB.put("anakin",user1);
    		DB.put("kenobi", user2);
    		this.getServletContext().setAttribute("DB", DB);

    	} else {
    		DB = (HashMap<String, User>) this.getServletContext().getAttribute("DB");
    	}
    	
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getSession().getAttribute("user") != null){
			request.getRequestDispatcher("/WEB-INF/views/session.jsp").forward(request, response);
			
		} else {
			doPost(request,response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> errors = new ArrayList<String>();
	
                
		if (request.getParameter("inputUsername") != null && request.getParameter("inputPassword") != null ){
			String username = request.getParameter("inputUsername");
			String password = request.getParameter("inputPassword");
		
		
			User user = login(username, password);
			if (user != null){
			
				doSession(request,response);
				request.getSession().setAttribute("user", user.getUsername());
				Cookie fullName = new Cookie("fullName",user.getFullName());
				request.getRequestDispatcher("/WEB-INF/views/session.jsp").forward(request, response);
				
			} else{
				
				errors.add("Invalid username or password.");
				request.setAttribute("errors", errors);
				request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
			}
		} else {
    	
			errors.add("You should login first");
			
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
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

