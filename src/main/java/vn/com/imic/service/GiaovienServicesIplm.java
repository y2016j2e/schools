package vn.com.imic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.com.imic.model.Giaovien;
import  vn.com.imic.dao.GiaovienDao;

@Service
@Transactional(readOnly=false)
public class GiaovienServicesIplm implements GiaovienServices {

    @Autowired
    private  GiaovienDao dao;


    @Override
    public Giaovien getGVbyID(int id) {
        return dao.findbyID(id);
    }

    @Override
    public Giaovien findGiaovienbyName(String ten) {
        return dao.findGVbyCondition(ten);
    }

    @Override
    public int getPage(String namhoc, String hocky, String chunhiem, int max) {
        return 0;
        ///Thieu page
    }

	@Override
	public void saveOrupdate(Giaovien giaovien) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteGiaovien(int id) {
		// TODO Auto-generated method stub
		
	}
}
