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


@WebServlet("/ListGrammarGuidlineManage")
public class ListGrammarGuidlineManage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ListGrammarGuidlineManage() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection = JDBCConnection.getConnection();
		List<GrammarGuidline> list =GrammarGuidlineManageDAO.hienThiDSHDNP(connection, request);
		
			request.setAttribute("list",list);
			RequestDispatcher rd= request.getRequestDispatcher("View/Admin/listGrammarGuidlineManage.jsp");
			rd.forward(request, response);
		}
		


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
