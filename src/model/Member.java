package model;

public class Member {
	private int idThanhVien, idLoaiThanhVien;
	private String tenDangNhap, matKhau, tenHienThi, anh;

	public int getIdThanhVien() {
		return idThanhVien;
	}

	public void setIdThanhVien(int idThanhVien) {
		this.idThanhVien = idThanhVien;
	}

	public int getIdLoaiThanhVien() {
		return idLoaiThanhVien;
	}

	public void setIdLoaiThanhVien(int idLoaiThanhVien) {
		this.idLoaiThanhVien = idLoaiThanhVien;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getTenHienThi() {
		return tenHienThi;
	}

	public void setTenHienThi(String tenHienThi) {
		this.tenHienThi = tenHienThi;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}
}
