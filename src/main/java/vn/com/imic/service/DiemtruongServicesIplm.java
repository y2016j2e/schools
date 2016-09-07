package vn.com.imic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.imic.dao.DaoClass;
import vn.com.imic.model.Diemtruong;

@Service
public class DiemtruongServicesIplm implements ServicesInterface<Diemtruong>{

	@Autowired
	private DaoClass<Diemtruong> diemtruongDao;
	
	@Override
	public List<Diemtruong> getAllObjects() {
		// TODO Auto-generated method stub
		return diemtruongDao.findAll();
	}

	@Override
	public Diemtruong getObjectById(int id) {
		// TODO Auto-generated method stub
		return diemtruongDao.findObjectById(id);
	}

}
