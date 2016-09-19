package vn.com.imic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.imic.dao.LopDao;
import vn.com.imic.model.Khoahoc;
import vn.com.imic.model.Lop;

@Service
@Transactional(readOnly=false)
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
	public void SaveOrUpdateLopInKhoahoc(Lop lop, Khoahoc khoahoc){
		if(lop != null){
			dao.insertOrUpdate(lop);
			dao.insertOrUpdateLopInKhoahoc(khoahoc);
		}
		else{
			dao.insertOrUpdateLopInKhoahoc(khoahoc);
		}
		
	}

	@Override
	public void DeleteLopInKhoahoc(int makhoahoc) {
		// TODO Auto-generated method stub
		dao.DeleteLopInKhoahoc(makhoahoc);
	}

	@Override
	public int getPage(String namhoc, String hocki, String diemtruong, int max) {
		// TODO Auto-generated method stub
		return dao.Page(namhoc, hocki, diemtruong, max);
	}
	
	public Lop findLop(String tenlop,String diemtruong){
		return dao.findLopByCondition(tenlop,diemtruong);
	}
	
	public Khoahoc getKhoahocById(int id){
		return dao.findByIdLopInKhoahoc(id);
	}
	
	public Lop getLopById(int id){
		return dao.findById(id);
	}

	@Override
	public List<Khoahoc> getLimitLopInKhoahocById(int namhoc, int hocki, int diemtruong, int first, int max) {
		// TODO Auto-generated method stub
		return dao.findLimitLopInKhoahocById(first, max, namhoc, hocki, diemtruong);
	}

	public List<Khoahoc> getAllKhoahoc(){
		return dao.findAllKhoahoc();
	}
	
	public List<Khoahoc> getLopChange(int id){
		return dao.findLopChange(id);
	}
	
	public void changeLop(int id,int hsid,int change){
		dao.changeLopById(id,hsid,change);
	}
	
	@Override
	public int getPageById(int namhoc, int hocki, int diemtruong, int max) {
		return dao.PageById(namhoc, hocki, diemtruong, max);
	}
}
