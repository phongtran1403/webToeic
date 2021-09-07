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

@WebServlet("/InsertImage")
public class InsertGrammarGuidlineImage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InsertGrammarGuidlineImage() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/View/Admin/insertImage.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection connection = JDBCConnection.getConnection();
		String idvao = request.getParameter("idAnh");
		int id = Integer.parseInt(idvao);
		String tenAnh = GrammarGuidlineManageDAO.themAnhTieuDe(request, response);
		boolean kt = GrammarGuidlineManageDAO.themTenAnhTieuDe(connection, id, tenAnh);
		if (kt == true) {

			List<GrammarGuidline> list = GrammarGuidlineManageDAO.hienThiDSHDNP(connection, request);

			request.setAttribute("list", list);
			request.setAttribute("msgHDNP", "Thêm ảnh thành công cho ID = " + id + "");
			RequestDispatcher rd = request.getRequestDispatcher("View/Admin/listGrammarGuidlineManage.jsp");
			rd.forward(request, response);
		} else {
			List<GrammarGuidline> list = GrammarGuidlineManageDAO.hienThiDSHDNP(connection, request);

			request.setAttribute("list", list);
			request.setAttribute("msgHDNP", "Thêm ảnh thất bại cho ID = " + id + "");
			RequestDispatcher rd = request.getRequestDispatcher("View/Admin/listGrammarGuidlineManage.jsp");
			rd.forward(request, response);
		}
	}

}
