package vn.com.imic.service;

import java.util.List;

import vn.com.imic.model.Khoahoc;
import vn.com.imic.model.Lop;

public interface LopServices {
	List<Khoahoc> getAllLopInKhoahoc(String namhoc, String hocki, String diemtruong);
	List<Khoahoc> getLimitLopInKhoahoc(String namhoc, String hocki, String diemtruong, int first, int max);
	void SaveOrUpdateLopInKhoahoc(Lop lop, Khoahoc khoahoc);
	void DeleteLopInKhoahoc(int makhoahoc);
	int getPage(String namhoc, String hocki, String diemtruong, int max);
	Khoahoc getKhoahocById(int id);
	Lop getLopById(int id);
	Lop findLop(String tenlop, String diemtruong);
}
