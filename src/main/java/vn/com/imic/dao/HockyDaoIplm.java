package vn.com.imic.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import vn.com.imic.model.Hocky;

@Repository
public class HockyDaoIplm extends HibernateDaoSupport implements DaoClass<Hocky>{

	@SuppressWarnings("unchecked")
	@Override
	public List<Hocky> findAll() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Hocky.class);
		return (List<Hocky>) hibernateTemplate.findByCriteria(criteria);
	}

	@Override
	public Hocky findObjectById(int id) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(Hocky.class, id);
	}

}
