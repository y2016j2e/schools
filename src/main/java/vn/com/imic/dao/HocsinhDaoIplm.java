package vn.com.imic.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import vn.com.imic.model.Hocsinh;

@Repository
public class HocsinhDaoIplm extends HibernateDaoSupport implements DaoClass<Hocsinh>,HocsinhDao{

	@Override
	public List<Hocsinh> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hocsinh findObjectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Hocsinh> findAllInKhoahoc(int makhoahoc) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Hocsinh> findLimitInKhoahoc(int makhoahoc, int first, int max) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Hocsinh.class,"hocsinh");
		criteria.createAlias("hocsinh.khoahoc","khoahoc")
		.add(Restrictions.eq("khoahoc.makhoahoc",makhoahoc));
		List<Hocsinh> lis = (List<Hocsinh>) hibernateTemplate.findByCriteria(criteria, first, max);
		System.out.println("hoc sinh "+lis.get(0));
		return lis;
	}

	@Override
	public Long CountHocsinhInKhoahoc(int khoahoc) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Hocsinh.class,"hocsinh");
		criteria.createAlias("hocsinh.khoahoc","khoahoc")
		.add(Restrictions.eq("khoahoc.makhoahoc",khoahoc))
		.setProjection(Projections.rowCount());
		@SuppressWarnings("rawtypes")
		List lis = hibernateTemplate.findByCriteria(criteria);
		return (Long) lis.get(0);
	}

}
