package vn.com.imic.dao;

import java.util.List;

import vn.com.imic.model.Hocsinh;

public interface HocsinhDao {
	List<Hocsinh> findAllInKhoahoc(int makhoahoc);
	List<Hocsinh> findLimitInKhoahoc(int makhoahoc, int first, int max);
	Long CountHocsinhInKhoahoc(int khoahoc);
}
