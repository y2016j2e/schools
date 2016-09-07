package vn.com.imic.service;

import java.util.List;

import vn.com.imic.model.Hocsinh;

public interface HocsinhLopServices {
	public List<Hocsinh> getLimitHocsinhInLop(int lop,int first,int max);
	public Long countHocsinhInLop(int lop);
}
