package com.fruitvendor.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fruitvendor.entities.User;
import com.fruitvendor.models.UserMap;


@WebServlet("/user-register")
public class UserRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    UserMap storeUsers;
    boolean isUserCreated;
    
    public void init() {
    	storeUsers = new UserMap();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setAttribute("isUserCreated", isUserCreated);
    	RequestDispatcher requestDispatcher = request.getRequestDispatcher("register.jsp");
		requestDispatcher.forward(request, response);
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = (String)request.getParameter("userName");
		String userPassword = (String)request.getParameter("userPassword");
		if(storeUsers.getUserCredentials(userName) != null) {
			isUserCreated = false;
		}
		else {
			User currentUser = storeUsers.addNewUser(userName, userPassword);
			request.getSession().setAttribute("currentUser", currentUser);
			isUserCreated = true;
		}	
		response.sendRedirect("/user-register");
	}
}
