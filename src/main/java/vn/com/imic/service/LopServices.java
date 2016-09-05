package vn.com.imic.service;

import java.util.List;

import vn.com.imic.model.Khoahoc;
import vn.com.imic.model.Lop;

public interface LopServices {
	public List<Khoahoc> getAllLopInKhoahoc(String namhoc,String hocki,String diemtruong);
	public List<Khoahoc> getLimitLopInKhoahoc(String namhoc,String hocki,String diemtruong,int first,int max);
	public void SaveOrUpdateLopInKhoahoc(Lop lop,Khoahoc khoahoc);
	public void DeleteLopInKhoahoc(int makhoahoc);
	public int getPage(String namhoc,String hocki,String diemtruong,int max);
}
