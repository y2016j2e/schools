package vn.com.imic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.imic.dao.IGiangDayDAO;
import vn.com.imic.model.Giangday;

@Service
@Transactional
public class GiangDayService implements IGiangDayService {
	@Autowired
	private IGiangDayDAO giangdayDAO;

	@Override
	public List<Giangday> getAll() {
		return giangdayDAO.getAll();
	}

	@Override
	public void saveOrUpdate(Giangday giangDay) {
		giangdayDAO.saveOrUpdate(giangDay);
	}

	@Override
	public void delete(int maGiangDay) {
		giangdayDAO.delete(maGiangDay);
	}

	@Override
	public Giangday findByID(int maGiangDay) {
		return giangdayDAO.findByID(maGiangDay);
	}

}
