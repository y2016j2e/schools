package vn.com.imic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import vn.com.imic.model.Phonghoc;

public class PhonghocImpl implements PhonghocService {
	@Autowired
	vn.com.imic.dao.PhonghocImpl phdao;

	@Override
	public List<Phonghoc> findAll() {
		// TODO Auto-generated method stub
		return phdao.findAll();
	}

	@Override
	public Phonghoc findById(int id) {
		// TODO Auto-generated method stub
		return phdao.FindById(id);
	}

	@Override
	public List<Phonghoc> findBycondition(int iddt, int idcsvc,int idnamhoc) {
		// TODO Auto-generated method stub
		return phdao.findByCondition(iddt, idcsvc,idnamhoc);
	}


}
