package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import model.Member;

public class LoginDAO {
	public static boolean xacThuc(HttpServletRequest req, Connection connection, Member member) {
		String sql = "SELECT * FROM web_toeic.thanh_vien";
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(sql);	
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String name = rs.getString("ten_dang_nhap");
				String pass = rs.getString("mat_khau");

				if (member.getTenDangNhap().equals(name) && member.getMatKhau().equals(pass)) {
					return true;
				}
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			req.setAttribute("msgDangNhap", e.getMessage());
		}
		
		return false;
	}

	public static int uyQuyen(HttpServletRequest req,Connection connection, Member member) {
		PreparedStatement ps=null;
		int categoryMemberId=0;
		String sql ="SELECT id_loai_thanh_vien FROM `web_toeic`.`thanh_vien`"
		+" where ten_dang_nhap='"+member.getTenDangNhap() +"' and"+ " mat_khau='"+member.getMatKhau()+"'";
		
		try {
			ps=connection.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				categoryMemberId=rs.getInt("id_loai_thanh_vien");
			}
		} catch (SQLException e) {
			req.setAttribute("msgDangNhap", e.getMessage());
		}
		
		return categoryMemberId;
	}
	public static String xuatTenHienThi(Connection connection, Member member) {
		PreparedStatement ps=null;
		String sql ="SELECT ten_hien_thi FROM `web_toeic`.`thanh_vien`"
				+" where ten_dang_nhap='"+member.getTenDangNhap() +"' and"+ " mat_khau='"+member.getMatKhau()+"'";
		String name = null ;		
		try {
			ps=connection.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				name =rs.getString("ten_hien_thi");
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.getMessage();
		}
		
		
		return name;
	}
}
