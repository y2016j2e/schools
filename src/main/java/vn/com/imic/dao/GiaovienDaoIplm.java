package vn.com.imic.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import vn.com.imic.model.Giaovien;
import vn.com.imic.model.Lop;
import vn.com.imic.model.Namhoc;

@Repository
public class GiaovienDaoIplm extends HibernateDaoSupport implements DaoClass<Giaovien>{

	@Override
	public List<Giaovien> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Giaovien findObjectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Giaovien findByCondition(String... condition) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Giaovien.class, "giaovien");
		criteria.createAlias("giaovien.diemtruong", "diemtruong")
		.add(Restrictions.eq("ten",condition[0]))
		.add(Restrictions.eq("diemtruong.tendiemtruong",condition[1]));
			if(hibernateTemplate.findByCriteria(criteria).size()!=0)
				return (Giaovien) hibernateTemplate.findByCriteria(criteria).get(0);
		return null;
	}

}
