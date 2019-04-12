/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SourceJava;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author arellajo
 */
@MultipartConfig(maxFileSize = 16177215)

@WebServlet(
		description = "Home Page", 
		urlPatterns = { 
				"/Home", 
				"/Home.do"
		})
public class MainDatalogin extends HttpServlet {
    User user = new User();
    public MainDatalogin() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getSession().getAttribute("sessionFullname") != null){
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			
		} else {
			doPost(request,response);
		}
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      
        
        if(request.getParameter("log") != null)
        {
        System.out.println("use this shit");
        DatabaseConnection datab = new DatabaseConnection();
         InputStream inputStream = null; 
       final  Part filePart = request.getPart("zip");
      // final String fileName = filePart.getSubmittedFileName();
        final PrintWriter writer = response.getWriter();
       
         if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
            inputStream = filePart.getInputStream();
         } 
        user.setUsername("Data");
        String Result = datab.uploadfiles(user, inputStream);
        System.out.println(Result);
         request.getRequestDispatcher("/session.jsp").forward(request, response);
        }
        else
        {
               request.getSession().removeAttribute("sessionFullname");
             request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
        
        
      
//             

       
        
    }

    
}
