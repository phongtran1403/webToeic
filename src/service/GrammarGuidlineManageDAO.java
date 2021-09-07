package service;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import model.GrammarGuidline;

public class GrammarGuidlineManageDAO {
	public static List<GrammarGuidline> hienThiDSHDNP(Connection connection, HttpServletRequest req) {
		List<GrammarGuidline> list = new ArrayList<GrammarGuidline>();
		String sql = "SELECT * FROM web_toeic.huong_dan_ngu_phap";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.isBeforeFirst() == true) {
				while (rs.next()) {
					GrammarGuidline grammarGuidline = new GrammarGuidline();
					grammarGuidline.setIdHuongDanNguPhap(rs.getInt("id_huong_dan_ngu_phap"));
					grammarGuidline.setAnh(rs.getString("anh"));
					grammarGuidline.setNoiDung(rs.getString("noi_dung"));
					grammarGuidline.setTieuDe(rs.getString("tieu_de"));
					list.add(grammarGuidline);
				}
			} else {
				req.setAttribute("msgHDNP", "Chưa có bài viết nào trong danh sách");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

	public static boolean themTieuDeHDNP(Connection conn, GrammarGuidline grammarGuidline) {
		String sql = "INSERT INTO `web_toeic`.`huong_dan_ngu_phap` (`tieu_de`) VALUES (?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, grammarGuidline.getTieuDe());

			int kt = ps.executeUpdate();
			if (kt == 0) {
				return false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;

	}

	public static boolean themTenAnhTieuDe(Connection connection, int id, String tenAnh) {
		PreparedStatement ps=null;
		String sql = "update huong_dan_ngu_phap set anh=? where id_huong_dan_ngu_phap="+id;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1,tenAnh);
			int kt = ps.executeUpdate();
			if (kt != 0) {
			ps.close();
				return true;
			} else {

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static String themAnhTieuDe(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		if (req.getCharacterEncoding() == null) {
			req.setCharacterEncoding("UTF-8");
		}
		resp.setContentType("text/html;charset=UTF-8");
		final String address = "C:\\Users\\DA\\eclipse-workspace\\WebToeic\\WebContent\\ImageUpload";
		final int maxMemorySize = 3 * 1024 * 1024;
		final int maxRequestSize = 55 * 1024 * 1024;
		String fileName = null;

		PrintWriter out = resp.getWriter();
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);

		if (!isMultipart) {
			out.println("chưa có enctype='multipart/form-data'");
		}
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// set factory constraints
		factory.setSizeThreshold(maxMemorySize);
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

		// create new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setSizeMax(maxRequestSize);

		try {
			// parse the req
			List<FileItem> items = upload.parseRequest(req);

			/// process the upload item
			Iterator<FileItem> iterator = items.iterator();
			while (iterator.hasNext()) {
				FileItem item = iterator.next();
				if (!item.isFormField()) {
					fileName = item.getName();
					// pathFile : vị trí mà chúng ta muốn up file vào
					// gửi cho server

					String pathFile = address + File.separator + fileName;
					File uploadFile = new File(pathFile);

					boolean kt = uploadFile.exists();
					if (kt == true) {
						out.println("file đã tồn tại ");
					} else {
						try {
							item.write(uploadFile);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		return fileName; 
	}
	public static boolean themNoiDung(int id,String noiDung, Connection connection) {
		String sql = "update huong_dan_ngu_phap set noi_dung=? where id_huong_dan_ngu_phap="+id;
		try {
			PreparedStatement ps= connection.prepareStatement(sql);
			ps.setString(1,noiDung);
			int kt=ps.executeUpdate();
			if(kt==0) {
				return false;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return true;
	}

}
