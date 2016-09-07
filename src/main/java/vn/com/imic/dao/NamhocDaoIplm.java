package vn.com.imic.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import vn.com.imic.model.Namhoc;

@Repository
public class NamhocDaoIplm extends HibernateDaoSupport implements NamhocDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Namhoc> findAllNamhoc() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Namhoc.class);
		return (List<Namhoc>) hibernateTemplate.findByCriteria(criteria);
	}

	@Override
	public Namhoc findNamhocById(int manamhoc) {
		return hibernateTemplate.get(Namhoc.class, manamhoc);
	}

}
