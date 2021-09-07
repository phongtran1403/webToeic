package controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.JDBCConnection;
import model.Member;
import service.RegisterDAO;

@WebServlet(urlPatterns = {"/register-controller"})
public class RegisterController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
//	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Đăng kí
		if(req.getCharacterEncoding() == null) {
			req.setCharacterEncoding("UTF-8");
		}
		String name = req.getParameter("name");
		String fullName = req.getParameter("fullName");
		String pass = req.getParameter("pass");
		String enterThePass = req.getParameter("enterThePass");
		Connection connection=JDBCConnection.getConnection();
		
		Member member =new Member();
		
		member.setTenDangNhap(name);
		member.setTenHienThi(fullName);
		member.setMatKhau(pass);
		
		
	
		if(pass.equals(enterThePass)) {
			boolean kt=  RegisterDAO.dangKi(req, connection, member);
			if(kt ==true) {
				req.setAttribute("msgDangKi", "Chào mừng ! " + fullName + " Đã đăng kí thành công");
				RequestDispatcher rd= req.getRequestDispatcher("/register-forward");
				rd.forward(req, resp);
			}else {
				req.setAttribute("msgDangKi", "Đăng kí thất bại,vui lòng kiểm tra lại thông tin nhập vào.");
				RequestDispatcher rd= req.getRequestDispatcher("/register-forward");
				rd.forward(req, resp);
				
			}
		}else {
			req.setAttribute("msgDangKi", "Đăng kí thất bại,vui lòng kiểm tra lại thông tin nhập vào.");
			System.out.println("Mật khẩu xác nhận và mật khẩu chọn không trùng khớp");
			RequestDispatcher rd= req.getRequestDispatcher("/register-forward");
			rd.forward(req, resp);
			
		}
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
