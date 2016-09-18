package vn.com.imic.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import vn.com.imic.dao.csvcInterface;
import vn.com.imic.model.Banghe;
import vn.com.imic.model.Nhavesinh;
@Service
public class Bangheimpl implements CosovatchatService<Banghe> {
	
	@Autowired
	CosovatchatService<Banghe> bgdao;

	@Override
	public List<Banghe> findAll() {
		return bgdao.findAll();
	}

	@Override
	public Banghe FindById(int id) {
		return bgdao.FindById(id);
	}

	@Override
	public List<Banghe> findByCondition(int iddt, int idcsvc,int idnamhoc) {
		return bgdao.findByCondition(iddt, idcsvc,idnamhoc);
	}

	@Override
	public void SaveOrUpdate(Banghe e) {
	bgdao.SaveOrUpdate(e);
		
	}

	@Override
	public void deleteByid(int id) {
		bgdao.deleteByid(id);
	}
	
	
}
