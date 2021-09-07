package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.GrammarGuidline;

public class PaginationGrammarguidelineDAO {
	public static List<GrammarGuidline> displayList(Connection connection, int start, int count) {
		// lấy ra danh sách theo hàng ngang
		// start là hàng thứ start -1
		// count là tổng số hàng cần lấy
		List<GrammarGuidline> list = new ArrayList<GrammarGuidline>();
		String sql = "select * from web_toeic.huong_dan_ngu_phap limit " + (start - 1) + ", " + count;
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				GrammarGuidline grammar = new GrammarGuidline();
				grammar.setIdHuongDanNguPhap(rs.getInt("id_huong_dan_ngu_phap"));
				grammar.setAnh(rs.getString("anh"));
				grammar.setNoiDung(rs.getString("noi_dung"));
				grammar.setTieuDe(rs.getString("tieu_de"));
				list.add(grammar);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// cách đếm tổng số hàng trong data
	public static int count(Connection connection) {
		int count = 0;
		String sql = "select count(*) from web_toeic.huong_dan_ngu_phap";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			count = rs.getInt(1);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return count;
	}

	public static List<GrammarGuidline> showDetail(Connection connection, int id) {
		List<GrammarGuidline> list = new ArrayList<GrammarGuidline>();
		String sql = "SELECT * FROM web_toeic.huong_dan_ngu_phap where id_huong_dan_ngu_phap ="+id;
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				GrammarGuidline grammar = new GrammarGuidline();
				grammar.setIdHuongDanNguPhap(rs.getInt("id_huong_dan_ngu_phap"));
				grammar.setAnh(rs.getString("anh"));
				grammar.setNoiDung(rs.getString("noi_dung"));
				grammar.setTieuDe(rs.getString("tieu_de"));
				list.add(grammar);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
