package vn.com.imic.service;

import java.util.List;

import vn.com.imic.model.Hocsinh;

public interface HocsinhLopServices {
	List<Hocsinh> getLimitHocsinhInLop(int lop, int first, int max);
	Long countHocsinhInLop(int lop);
}
