package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import model.Member;

public class RegisterDAO {
	// Đăng kí
	public static boolean dangKi(HttpServletRequest req, Connection connection, Member member) {
		PreparedStatement ps = null;
		String sql = "INSERT INTO `web_toeic`.`thanh_vien` ( `ten_dang_nhap`, `mat_khau`, `ten_hien_thi`,`id_loai_thanh_vien`) VALUES (?, ?, ?,?)";
		try {
			ps = connection.prepareStatement(sql);

			ps.setString(1, member.getTenDangNhap());
			ps.setString(2, member.getMatKhau());
			ps.setString(3, member.getTenHienThi());
			ps.setInt(4, 1);
			
			int kt= ps.executeUpdate();
			System.out.println(kt);
			if (kt != 0) {
				return true;
			} 
			
		} catch (SQLException e) {
			req.setAttribute("msgDangKi", e.getMessage());
			
		}
		
		System.out.println("chạy vào false");
		return false;

	}
}
