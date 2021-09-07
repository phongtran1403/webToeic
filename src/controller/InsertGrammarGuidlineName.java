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

/**
 * Servlet implementation class InsertGrammarGuidlineName
 */
@WebServlet("/InsertGrammarGuidlineName")
public class InsertGrammarGuidlineName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public InsertGrammarGuidlineName() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getCharacterEncoding() == null) {
			request.setCharacterEncoding("UTF-8");
		}
		Connection connection =JDBCConnection.getConnection();
		String tieuDe= request.getParameter("tieuDe");
		GrammarGuidline grammarGuidline=new GrammarGuidline();
		grammarGuidline.setTieuDe(tieuDe);
		boolean kt =GrammarGuidlineManageDAO.themTieuDeHDNP(connection, grammarGuidline);
		
		if(kt==true) {
			List<GrammarGuidline> list =GrammarGuidlineManageDAO.hienThiDSHDNP(connection, request);
			request.setAttribute("msgHDNP", "Thêm tiêu đề thành công!");

			request.setAttribute("list",list);
			RequestDispatcher rd= request.getRequestDispatcher("View/Admin/listGrammarGuidlineManage.jsp");
			rd.forward(request, response);
		}else {
			List<GrammarGuidline> list =GrammarGuidlineManageDAO.hienThiDSHDNP(connection, request);
			request.setAttribute("msgHDNP", "Thêm tiêu đề thất bại!");

			request.setAttribute("list",list);
			RequestDispatcher rd= request.getRequestDispatcher("View/Admin/listGrammarGuidlineManage.jsp");
			rd.forward(request, response);
		}
	}

}
