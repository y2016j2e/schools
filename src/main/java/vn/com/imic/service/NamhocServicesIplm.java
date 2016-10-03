package vn.com.imic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.imic.dao.NamhocDao;
import vn.com.imic.model.Namhoc;

@Service
@Transactional(readOnly=false)
public class NamhocServicesIplm implements NamhocServices{
	
	@Autowired
	private NamhocDao namhocdao;

	@Override
	public List<Namhoc> getAllNamhoc() {
		return namhocdao.findAllNamhoc();
	}

	@Override
	public Namhoc getNamhocById(int id) {
		// TODO Auto-generated method stub
		return namhocdao.findNamhocById(id);
	}
	
	public void SaveNamhoc(Namhoc nh){
		namhocdao.SaveOrUpdateNamhoc(nh);
	}
	
}
