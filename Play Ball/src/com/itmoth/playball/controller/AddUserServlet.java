package com.itmoth.playball.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itmoth.playball.dao.UserDao;
import com.itmoth.playball.model.User;

/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/addUser")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDao();
		User user = new User();
		
		user.setId_user(request.getParameter("id"));
		user.setName_user(request.getParameter("name"));
		user.setGender_user(request.getParameter("gender"));
		user.setAuthKey_user(request.getParameter("authKey"));
		user.setLeague_user(request.getParameter("league"));
		user.setParticipant_user(request.getParameter("participant").equals("yes"));
		userDao.addUser(user);
		List<User> userList = userDao.getList();
			
		request.setAttribute("list", userList);
		RequestDispatcher view = request.getRequestDispatcher("userManage.jsp"); 
		view.forward(request, response);		
	}

}
