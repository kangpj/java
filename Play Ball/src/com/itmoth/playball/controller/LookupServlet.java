package com.itmoth.playball.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itmoth.playball.dao.LookupDao;
import com.itmoth.playball.model.Ranking;

/**
 * Servlet implementation class LookupServlet
 */
@WebServlet("/lookup")
public class LookupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LookupServlet() {
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
		LookupDao lookupDao = new LookupDao();
		RequestDispatcher view = null;
		String op = request.getParameter("operation");
		if (String.valueOf(op).equals("performance")) {
		} else if (String.valueOf(op).equals("fund")) {
		} else {
			List<Ranking> rankingList = lookupDao.getRanking();
			request.setAttribute("list", rankingList);
		}
		view = request.getRequestDispatcher("lookup.jsp");
		view.forward(request, response);		
	}
}
