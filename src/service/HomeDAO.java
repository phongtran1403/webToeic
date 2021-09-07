package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.SlideBanner;

public class HomeDAO {
	public static List<SlideBanner> slideBanners(Connection connection){
		List<SlideBanner> list =new ArrayList<SlideBanner>();
		
		String sql ="SELECT * FROM web_toeic.slider_banner";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				SlideBanner banner =new SlideBanner();
				banner.setSlideId(rs.getInt("slide_id"));
				banner.setTen(rs.getString("ten"));
				banner.setNoiDung(rs.getString("noi_dung"));
				banner.setAnh(rs.getString("anh"));
				list.add(banner);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}
}
