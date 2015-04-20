package com.itmoth.playball.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainMenu
 */
@WebServlet("/mainMenu")
public class MainMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainMenu() {
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
		String menu = request.getParameter("operation");
		RequestDispatcher view = null;
		if (menu.equals("lookup")) {
			view = request.getRequestDispatcher("lookup.jsp");
		} else if (menu.equals("plan")) {
			view = request.getRequestDispatcher("plna.jsp");			
		} else if (menu.equals("operate")) {
			view = request.getRequestDispatcher("operate.jsp");			
		} else {
			view = request.getRequestDispatcher("management.jsp");			
		}
		view.forward(request, response);
	}

}
