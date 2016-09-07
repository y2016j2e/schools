package vn.com.imic.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import vn.com.imic.model.Giangday;
import vn.com.imic.model.Giaovien;
import vn.com.imic.model.Monhoc;

@Repository
public class GiangDayDAO extends HibernateDaoSupport implements IGiangDayDAO {

	@Override
	public List<Giangday> getAll() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Giangday.class);
		return (List<Giangday>) hibernateTemplate.findByCriteria(criteria);
	}

	@Override
	public void saveOrUpdate(Giangday giangday) {
		save(giangday);
	}

	@Override
	public void delete(int magiangday) {
		Giangday giangday = findByID(magiangday);
		delete(giangday);
	}

	@Override
	public Giangday findByID(int magiangday) {
		return hibernateTemplate.get(Giangday.class, magiangday);
	}

	@Override
	public List<Giaovien> getGiaVien() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Giaovien.class);
		return (List<Giaovien>) hibernateTemplate.findByCriteria(criteria);
	}

	@Override
	public List<Monhoc> getMonHoc() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Monhoc.class);
		return (List<Monhoc>) hibernateTemplate.findByCriteria(criteria);
	}

}
