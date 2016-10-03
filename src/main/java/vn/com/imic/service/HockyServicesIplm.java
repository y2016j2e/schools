package vn.com.imic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.imic.dao.DaoClass;
import vn.com.imic.model.Hocky;

@Service
public class HockyServicesIplm implements ServicesInterface<Hocky>{

	@Autowired
	private DaoClass<Hocky> hockyDao;
	
	@Override
	public List<Hocky> getAllObjects() {
		// TODO Auto-generated method stub
		return hockyDao.findAll();
	}

	@Override
	public Hocky getObjectById(int id) {
		// TODO Auto-generated method stub
		return hockyDao.findObjectById(id);
	}

	@Override
	public void SaveOrUpdate(Hocky e) {
		// TODO Auto-generated method stub
		
	}

}
