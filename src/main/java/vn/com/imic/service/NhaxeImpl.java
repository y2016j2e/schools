package vn.com.imic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import vn.com.imic.model.NhaXe;

public class NhaxeImpl implements CosovatchatService<NhaXe> {

	@Autowired
	vn.com.imic.dao.NhaxeImpl nxdao;

	@Override
	public List<NhaXe> findAll() {
		// TODO Auto-generated method stub
		return nxdao.findAll();
	}

	@Override
	public NhaXe FindById(int id) {
		// TODO Auto-generated method stub
		return nxdao.FindById(id);
	}

	@Override
	public List<NhaXe> findByCondition(int iddt, int idcsvc,int idnamhoc) {
		// TODO Auto-generated method stub
		return nxdao.findByCondition(iddt, idcsvc,idnamhoc);
	}

	@Override
	public void SaveOrUpdate(NhaXe e) {
		SaveOrUpdate(e);
	}

	@Override
	public void deleteByid(int id) {
		deleteByid(id);
	}

}
