package com.itmoth.playball.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itmoth.playball.dao.UserDao;
import com.itmoth.playball.model.User;

public class UserManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UserManageServlet() {
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
		RequestDispatcher view = null;
		String op = request.getParameter("operation");
		//System.out.println(op);
		if (String.valueOf(op).equals("create")) {
			view = request.getRequestDispatcher("addUser.jsp");
		} else {
			if (String.valueOf(op).equals("delete")) {
				List<String> idList = getIdList(request);
				userDao.deleteUser(idList);
			} else if (String.valueOf(op).equals("update")) {
				List<String> idList = getIdList(request);
				List<User> userList = getUserList(request, idList);
				userDao.modifyUser(userList);
			}
			view = request.getRequestDispatcher("userManage.jsp");
			List<User> userList = userDao.getList();
			request.setAttribute("list", userList);
		}
		view.forward(request, response);
	}
	
	private List<String> getIdList(HttpServletRequest request) {
		List<String> idList = new ArrayList<String>();
		if (request.getParameter("checkId") != null) {
			String checkedId[] = request.getParameterValues("checkId");
			for (String id : checkedId) {
				idList.add(id);
			}
		}
		return idList;
	}
	
	private List<User> getUserList(HttpServletRequest request, List<String> idList) {
		List<User> userList = new ArrayList<User>();
		for (String id : idList) {
			if (request.getParameter(id) != null) {
				String values[] = request.getParameterValues(id);
				User user = new User();
				user.setName_user(values[0]);
				user.setGender_user(values[1]);
				//user.setId_user(values[2]);
				user.setId_user(id);
				user.setLeague_user(values[3]);
				if (values.length >= 5)
					user.setParticipant_user(true);
				else
					user.setParticipant_user(false);
				userList.add(user);
			}
		}
		return userList;
	}
}
