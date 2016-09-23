package vn.com.imic.service;

import java.util.List;

import vn.com.imic.model.Giangday;
import vn.com.imic.model.Giaovien;
import vn.com.imic.model.Khoahoc;
import vn.com.imic.model.Lop;
import vn.com.imic.model.Monhoc;

public interface IGiangDayService {

	public List<Giaovien> getGiaoVienLimit(int first,int max);

	public List<Monhoc> getMonHoc();

	public List<Giangday> getAll(int maNamHoc);

	public void saveOrUpdate(Giangday giangday);

	public void delete(int magiangday);

	public Giangday findByID(int magiangday);

	// Lấy Danh Sách Giáo Viên, kèm theo danh sách giảng dạy trong 1 năm học.
	public Giaovien getGiaoVien(int maGiaoVien, int maNamHoc);

	public List<Lop> getLops();

	public List<Monhoc> getMonHocs();

	// lấy danh sách khóa học trong namhoc
	public List<Khoahoc> getKhoaHocs(int maNamHoc);

	public void updatePhanCong(Giaovien giaovien2);

	public Khoahoc findKhoaHoc(int maKhoaHoc);

	public Monhoc findMonHoc(int maMonHoc);
	public List<Giaovien> getGVCN();

	public void updateKhoaHoc(Khoahoc khoahoc);

	public boolean checkPhanCong(List<Giangday> listGiangDay, Giangday giangday);

	public int countGiaoVien();
}
