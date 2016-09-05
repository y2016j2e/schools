package vn.com.imic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.imic.dao.LopDao;
import vn.com.imic.model.Khoahoc;
import vn.com.imic.model.Lop;

@Service
public class LopServicesIplm implements LopServices{

	@Autowired
	private LopDao dao;
	
	@Override
	public List<Khoahoc> getAllLopInKhoahoc(String namhoc, String hocki, String diemtruong) {
		return dao.findAllLopInKhoahoc(namhoc, hocki, diemtruong);
	}

	@Override
	public List<Khoahoc> getLimitLopInKhoahoc(String namhoc, String hocki, String diemtruong, int first, int max) {
		// TODO Auto-generated method stub
		return dao.findLimitLopInKhoahoc(first, max, namhoc, hocki, diemtruong);
	}

	@Override
	public void SaveOrUpdateLopInKhoahoc(Lop lop, Khoahoc khoahoc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional(readOnly=false)
	public void DeleteLopInKhoahoc(int makhoahoc) {
		// TODO Auto-generated method stub
		dao.DeleteLopInKhoahoc(makhoahoc);
	}

	@Override
	public int getPage(String namhoc, String hocki, String diemtruong, int max) {
		// TODO Auto-generated method stub
		return dao.Page(namhoc, hocki, diemtruong, max);
	}

}
