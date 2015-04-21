package com.itmoth.playball.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itmoth.playball.dao.GameDao;
import com.itmoth.playball.dao.LookupDao;
import com.itmoth.playball.model.Ranking;
import com.itmoth.playball.model.Sport;

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
			LookupDao lookupDao = new LookupDao();
			List<Ranking> rankingList = lookupDao.getRanking();
			request.setAttribute("list", rankingList);
			view = request.getRequestDispatcher("lookup.jsp");
		} else if (menu.equals("plan")) {
			GameDao gameDao = new GameDao();
			List<Sport> sportList = gameDao.getSport();
			request.setAttribute("list", sportList);
			view = request.getRequestDispatcher("plan.jsp");			
		} else if (menu.equals("operate")) {
			view = request.getRequestDispatcher("operate.jsp");			
		} else {
			view = request.getRequestDispatcher("management.jsp");			
		}
		view.forward(request, response);
	}

}
