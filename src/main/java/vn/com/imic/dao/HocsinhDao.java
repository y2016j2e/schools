package vn.com.imic.dao;

import java.util.List;

import vn.com.imic.model.Hocsinh;

public interface HocsinhDao {
	public List<Hocsinh> findAllInKhoahoc(int makhoahoc);
	public List<Hocsinh> findLimitInKhoahoc(int makhoahoc,int first,int max);
	public Long CountHocsinhInKhoahoc(int khoahoc);
	public void deleteHocsinhInKhoahoc(int lop, int hocsinh);
	public Hocsinh findHocsinh(String ten,String diachi);
	public void SaveOrUpdateHocsinhInLop(int kh,Hocsinh hs);
	public List<Hocsinh> findAllHocsinh();
}
