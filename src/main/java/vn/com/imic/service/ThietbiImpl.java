package vn.com.imic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import vn.com.imic.dao.ThietBiImpl;
import vn.com.imic.model.Thietbi;

public class ThietbiImpl implements CosovatchatService<Thietbi>{

	@Autowired
	ThietBiImpl tbdao;

	@Override
	public List<Thietbi> findAll() {
		// TODO Auto-generated method stub
		return tbdao.findAll();
	}

	@Override
	public Thietbi FindById(int id) {
		// TODO Auto-generated method stub
		return tbdao.FindById(id);
	}

	@Override
	public List<Thietbi> findByCondition(int iddt, int idcsvc,int idnamhoc) {
		// TODO Auto-generated method stub
		return tbdao.findByCondition(iddt, idcsvc,idnamhoc);
	}

	@Override
	public void SaveOrUpdate(Thietbi e) {
		// TODO Auto-generated method stub
		SaveOrUpdate(e);
	}

	@Override
	public void deleteByid(int id) {
		deleteByid(id);
	}
	
	

}
