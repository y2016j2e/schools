package vn.com.imic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.imic.dao.DiemTruongDao;
import vn.com.imic.model.Diemtruong;

@Service
@Transactional(readOnly=false)
public class DiemtruongServicesIplm implements ServicesInterface<Diemtruong>{

	@Autowired
	private DiemTruongDao diemtruongDao;
	
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
	@Override
	public void SaveOrUpdate(Diemtruong e) {
		diemtruongDao.save(e);
	}
}