package vn.com.imic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import vn.com.imic.dao.KhuonvienDaoImpl;
import vn.com.imic.model.Khuonvien;

public class KhuonVienImpl implements CosovatchatService<Khuonvien> {

	@Autowired
	KhuonvienDaoImpl kvdao;

	@Override
	public List<Khuonvien> findAll() {
		// TODO Auto-generated method stub
		return kvdao.findAll();
	}

	@Override
	public Khuonvien FindById(int id) {
		// TODO Auto-generated method stub
		return kvdao.FindById(id);
	}

	@Override
	public List<Khuonvien> findByCondition(int iddt, int idcsvc,int idnamhoc) {
		// TODO Auto-generated method stub
		return kvdao.findByCondition(iddt, idcsvc,idnamhoc);
	}

	@Override
	public void SaveOrUpdate(Khuonvien e) {
		kvdao.SaveOrUpdate(e);
	}

	@Override
	public void deleteByid(int id) {
		kvdao.deleteByid(id);
	}
}
