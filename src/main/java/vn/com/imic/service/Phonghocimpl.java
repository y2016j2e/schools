package vn.com.imic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import vn.com.imic.dao.csvcInterface;
import vn.com.imic.model.Nhavesinh;
import vn.com.imic.model.Phonghoc;
@Service
public class Phonghocimpl implements CosovatchatService<Phonghoc> {
	@Autowired
	csvcInterface<Phonghoc> phdao;

	@Override
	public List<Phonghoc> findAll() {
		// TODO Auto-generated method stub
		return phdao.findAll();
	}

	@Override
	public Phonghoc FindById(int id) {
		// TODO Auto-generated method stub
		return phdao.FindById(id);
	}

	@Override
	public List<Phonghoc> findByCondition(int iddt, int idcsvc,int idnamhoc) {
		// TODO Auto-generated method stub
		return phdao.findByCondition(iddt, idcsvc,idnamhoc);
	}


	@Override
	public void SaveOrUpdate(Phonghoc e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByid(int id) {
		// TODO Auto-generated method stub
		
	}


}
