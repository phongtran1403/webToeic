package controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import database.JDBCConnection;
import model.Member;
import service.LoginDAO;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public LoginController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection = JDBCConnection.getConnection();
		String name = request.getParameter("name");
		String pass=request.getParameter("pass");
		Member member = new Member();
		member.setTenDangNhap(name);
		member.setMatKhau(pass);
		boolean kt = LoginDAO.xacThuc(request, connection, member);
		String fullname =LoginDAO.xuatTenHienThi(connection, member);
		if(kt ==true) {
			
			int kt2=LoginDAO.uyQuyen(request, connection, member);
				if(kt2== 1){
					HttpSession session = request.getSession(true);
					session.setAttribute("session", fullname);
					
					RequestDispatcher rd =request.getRequestDispatcher("/HomeForward");
					rd.forward(request, response);
				}if(kt2==2) {
					HttpSession session = request.getSession(true);
					session.setAttribute("session", fullname);
					
					RequestDispatcher rd =request.getRequestDispatcher("/AdminForward");
					rd.forward(request, response);
				}
			
		}
		else {
		request.setAttribute("msgDangNhap", "sai tên tài khoản hoặc mật khẩu");
		RequestDispatcher rd =request.getRequestDispatcher("/login-forward");
		rd.forward(request, response);
	}
  }

}
