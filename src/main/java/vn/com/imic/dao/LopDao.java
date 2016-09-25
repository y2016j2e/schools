package vn.com.imic.dao;

import java.util.List;

import vn.com.imic.model.Khoahoc;
import vn.com.imic.model.Lop;

public interface LopDao {
	List<Lop> findAll();
	List<Lop> findLimit(int first, int max);
	Lop findById(int id);
	void insertOrUpdate(Lop lop);
	void DeleteLop(int id);
	int CountLop();
	Lop findLopByCondition(String tenlop, String diemtruong);
	
	List<Khoahoc> findAllLopInKhoahoc(String namhoc, String hocki, String diemtruong);
	List<Khoahoc> findLimitLopInKhoahoc(int first, int max, String namhoc, String hocki, String diemtruong);
	Khoahoc findByIdLopInKhoahoc(int id);
	void insertOrUpdateLopInKhoahoc(Khoahoc khoahoc);
	void DeleteLopInKhoahoc(int id);
	int CountLopInKhoahoc(String namhoc, String hocki, String diemtruong);
	int Page(String namhoc, String hocki, String diemtruong, int max);
}
