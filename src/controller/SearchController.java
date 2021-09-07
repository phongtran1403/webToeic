package controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.JDBCConnection;
import model.GrammarGuidline;
import service.GrammarGuidlineManageDAO;
import service.SearchDAO;

@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection = JDBCConnection.getConnection();
		String name=request.getParameter("searchn");
		if(name.equals("")) {
			response.sendRedirect("ListGrammarGuidelineForward?pageid=1");
		}else{
		List<GrammarGuidline> list= SearchDAO.search(name, connection, request);
		request.setAttribute("listGrammar", list);
		RequestDispatcher rd= request.getRequestDispatcher("View/resultSearch.jsp");
		rd.forward(request, response);
	}
}

}
