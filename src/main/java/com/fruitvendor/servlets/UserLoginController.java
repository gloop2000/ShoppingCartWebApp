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


@WebServlet("/user-login")
public class UserLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected UserMap storeUsers;
    Boolean isLoginSuccessful;
    User currentUser;
    
    public void init() {
    	storeUsers = new UserMap();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	if(currentUser != null)
			isLoginSuccessful = true;
		else
			isLoginSuccessful = false;
		request.setAttribute("isLoginSuccessful", isLoginSuccessful);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
		requestDispatcher.forward(request, response);
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = (String)request.getParameter("userName");
		String userPassword = (String)request.getParameter("userPassword");
		boolean isUserValid = storeUsers.isUserValid(userName, userPassword);
		if(isUserValid) {
			currentUser = storeUsers.getUserCredentials(userName);
			request.getSession().setAttribute("currentUser", currentUser);
		}
		response.sendRedirect("/user-login");
	}
}
