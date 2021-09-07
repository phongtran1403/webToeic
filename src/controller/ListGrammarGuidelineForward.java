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
import service.PaginationGrammarguidelineDAO;

/**
 * Servlet implementation class ListGrammarGuidelineForward
 */
@WebServlet("/ListGrammarGuidelineForward")
public class ListGrammarGuidelineForward extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListGrammarGuidelineForward() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection connection = JDBCConnection.getConnection();
		int pageid = Integer.parseInt(request.getParameter("pageid"));
		int count = 3;
		if (pageid == 1) {

		} else {
			pageid = (pageid - 1) * count + 1;
		}
		List<GrammarGuidline> list = PaginationGrammarguidelineDAO.displayList(connection, pageid, count);
		int countRow = PaginationGrammarguidelineDAO.count(connection);
		int pageMax = countRow / count;
		if (pageMax % count == 0) {
			pageMax = countRow / count;
		} else {
			pageMax = countRow / count + 1;
		}
		request.setAttribute("pageMax", pageMax);
		request.setAttribute("listGrammar", list);
		request.setAttribute("numberPage", Integer.parseInt(request.getParameter("pageid")));

		RequestDispatcher rd = request.getRequestDispatcher("/View/listGrammarGuideline.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection connection= JDBCConnection.getConnection();
		int id=Integer.parseInt(request.getParameter("id"));
		List<GrammarGuidline> list =PaginationGrammarguidelineDAO.showDetail(connection, id);
		request.setAttribute("detail", list);
		request.setAttribute("data", "**");
		request.setAttribute("html", "<b>");
		request.setAttribute("data1", "_");
		request.setAttribute("html1", "<i>");
		request.setAttribute("data2", "\n");
		request.setAttribute("html2", "<br>");
		RequestDispatcher rd = request.getRequestDispatcher("View/grammarGuidelineDetail.jsp");
		rd.forward(request, response);
	}

}
