package vn.com.imic.service;

import java.util.List;

import javax.annotation.PostConstruct;

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
	
	//TODO HARDCODE 
//	@PostConstruct
//	public void init() {
//		Diemtruong diemtruong = new Diemtruong();
//		diemtruong.setTendiemtruong("Nguyen Van Troi 01");
//		diemtruong.setDiachi("Ha Noi");
//		diemtruong.setMadiemtruong(1);
//		if(diemtruongDao.findObjectById(1) == null) {
//			diemtruongDao.save(diemtruong);
//		}
//		
//	}

}
