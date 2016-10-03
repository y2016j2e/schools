package vn.com.imic.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import vn.com.imic.model.Diemtruong;

@Repository
public class DiemtruongDaoIplm extends HibernateDaoSupport implements DiemTruongDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Diemtruong> findAll() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Diemtruong.class);
		return (List<Diemtruong>) hibernateTemplate.findByCriteria(criteria);
	}

	@Override
	public Diemtruong findObjectById(int id) {
		return hibernateTemplate.get(Diemtruong.class, id);
	}

	public Diemtruong findByCondition(String... condition){
		return null;
	}

	@Override
	public void save(Diemtruong diemtruong) {
		hibernateTemplate.saveOrUpdate(diemtruong);
	}
}
