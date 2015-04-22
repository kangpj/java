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
import com.itmoth.playball.model.Participant;
import com.itmoth.playball.model.Sport;

/**
 * Servlet implementation class PlanServlet
 */
@WebServlet("/plan")
public class PlanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlanServlet() {
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
		GameDao gameDao = new GameDao();
		RequestDispatcher view = null;
		if (menu.equals("gamePlan")) {
			List<Sport> sportList = gameDao.getSport();
			request.setAttribute("list", sportList);
			view = request.getRequestDispatcher("plan.jsp");			
		} else { // menu.equals("matchPlan")
			List<Participant> participantList = gameDao.getParticipant();
			request.setAttribute("list", participantList);
			view = request.getRequestDispatcher("match.jsp");			
		}
		view.forward(request, response);
	}

}
