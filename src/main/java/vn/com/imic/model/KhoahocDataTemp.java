package vn.com.imic.model;

public class KhoahocDataTemp {
	private String namhoc;
	private String hocki;
	private String diemtruong;
	
	
	public KhoahocDataTemp() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public KhoahocDataTemp(String namhoc, String hocki, String diemtruong) {
		super();
		this.namhoc = namhoc;
		this.hocki = hocki;
		this.diemtruong = diemtruong;
	}



	public String getNamhoc() {
		return namhoc;
	}
	public void setNamhoc(String namhoc) {
		this.namhoc = namhoc;
	}
	public String getHocki() {
		return hocki;
	}
	public void setHocki(String hocki) {
		this.hocki = hocki;
	}
	public String getDiemtruong() {
		return diemtruong;
	}
	public void setDiemtruong(String diemtruong) {
		this.diemtruong = diemtruong;
	}
	
	
}
