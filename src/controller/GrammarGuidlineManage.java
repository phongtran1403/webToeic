package controller;

import java.io.IOException;
import java.io.PrintWriter;
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


@WebServlet("/GrammarGuidlineManage")
public class GrammarGuidlineManage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public GrammarGuidlineManage() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getCharacterEncoding()==null){
			request.setCharacterEncoding("UTF-8");
		}
		RequestDispatcher rd=request.getRequestDispatcher("/View/Admin/grammarGuidelineManage.jsp");
		rd.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection=JDBCConnection.getConnection();
		if(request.getCharacterEncoding()==null){
			request.setCharacterEncoding("UTF-8");
		}
		String idvao = request.getParameter("id");
		int id= Integer.parseInt(idvao);	
		
		String noiDung=request.getParameter("content");
		GrammarGuidlineManageDAO.themNoiDung(id, noiDung, connection);
		List<GrammarGuidline> list =GrammarGuidlineManageDAO.hienThiDSHDNP(connection, request);
		request.setAttribute("list",list);
		RequestDispatcher rd= request.getRequestDispatcher("View/Admin/listGrammarGuidlineManage.jsp");
		rd.forward(request, response);
	}
}
