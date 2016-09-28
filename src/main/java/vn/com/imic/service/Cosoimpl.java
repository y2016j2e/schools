package vn.com.imic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.imic.dao.DaoClass;
import vn.com.imic.dao.csvcInterface;
import vn.com.imic.model.Cosovatchat;
@Service
public class Cosoimpl implements csvcInterface<Cosovatchat> {
	
	@Autowired
	DaoClass<Cosovatchat> csdao;
	
	@Override
	public List<Cosovatchat> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cosovatchat FindById(int id) {
		// TODO Auto-generated method stub
		return csdao.findObjectById(id);
	}

	@Override
	public List<Cosovatchat> findByCondition(int iddt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void SaveOrUpdate(Cosovatchat e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByid(int id) {
		// TODO Auto-generated method stub
		
	}

}
