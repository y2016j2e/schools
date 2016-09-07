package vn.com.imic.dao;

import java.util.List;

import vn.com.imic.model.Hocsinh;

public interface HocsinhDao {
	public List<Hocsinh> findAllInKhoahoc(int makhoahoc);
	public List<Hocsinh> findLimitInKhoahoc(int makhoahoc,int first,int max);
	public Long CountHocsinhInKhoahoc(int khoahoc);
}
