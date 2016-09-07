package vn.com.imic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.imic.dao.HocsinhDao;
import vn.com.imic.model.Hocsinh;

@Service
public class HocsinhLopIplm implements HocsinhLopServices{

	@Autowired
	private HocsinhDao hocsinhDao;
	
	@Override
	public List<Hocsinh> getLimitHocsinhInLop(int lop,int first,int max) {
		return hocsinhDao.findLimitInKhoahoc(lop, first, max);
	}

	@Override
	public Long countHocsinhInLop(int lop) {
		return hocsinhDao.CountHocsinhInKhoahoc(lop);
	}
	
}
