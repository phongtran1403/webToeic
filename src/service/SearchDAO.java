package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.GrammarGuidline;

public class SearchDAO {
	public static List<GrammarGuidline> search(String name,Connection connection,HttpServletRequest req){
		String sql="SELECT * FROM web_toeic.huong_dan_ngu_phap where tieu_de like '%"+name+"%'";
		List<GrammarGuidline> list= new ArrayList<GrammarGuidline>();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			if(!rs.isBeforeFirst()) {
				req.setAttribute("msg", "Không có kết quả tìm kiếm");
			}else {
				while (rs.next()) {
					GrammarGuidline grammarGuidline = new GrammarGuidline();
					grammarGuidline.setIdHuongDanNguPhap(rs.getInt("id_huong_dan_ngu_phap"));
					grammarGuidline.setAnh(rs.getString("anh"));
					grammarGuidline.setNoiDung(rs.getString("noi_dung"));
					grammarGuidline.setTieuDe(rs.getString("tieu_de"));
					list.add(grammarGuidline);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
