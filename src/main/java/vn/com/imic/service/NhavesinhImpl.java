package vn.com.imic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import vn.com.imic.model.Nhavesinh;

public class NhavesinhImpl implements CosovatchatService<Nhavesinh>{

	@Autowired
	vn.com.imic.dao.NhavesinhImpl nvsdao;

	@Override
	public List<Nhavesinh> findAll() {
		return nvsdao.findAll();
	}

	@Override
	public Nhavesinh FindById(int id) {
		// TODO Auto-generated method stub
		return nvsdao.FindById(id);
	}

	@Override
	public List<Nhavesinh> findByCondition(int iddt, int idcsvc,int idnamhoc) {
		// TODO Auto-generated method stub
		return nvsdao.findByCondition(iddt, idcsvc,idnamhoc);
	}

	@Override
	public void SaveOrUpdate(Nhavesinh e) {
		nvsdao.SaveOrUpdate(e);
	}

	@Override
	public void deleteByid(int id) {
		nvsdao.deleteByid(id);
	}
	

}
