package vn.com.imic.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import vn.com.imic.model.Giaovien;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;
import org.hibernate.criterion.Restrictions;

import vn.com.imic.model.Giaovien;


@Repository
public class GiaovienDaoIplm extends HibernateDaoSupport implements GiaovienDao,DaoClass<Giaovien> {

    @SuppressWarnings("unchecked")
    @Override
    public List<Giaovien> findAll() {

        DetachedCriteria criteria = DetachedCriteria.forClass(Giaovien.class);
        List<Giaovien> list = (List<Giaovien>) hibernateTemplate.findByCriteria(criteria);
        System.out.println(list.get(0).getMagiaovien());
        return list;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Giaovien> findLimit(int first, int max) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Giaovien.class);
        List<Giaovien> list = (List<Giaovien>) hibernateTemplate.findByCriteria(criteria, first, max);

        return list;
    }

    @Override
    public void deleteGiaovien(int id) {
        delete(hibernateTemplate.get(Giaovien.class, id));

    }

    @Override
    public boolean statusGiaovien(boolean status) {
        return true;
    }

    @Override
    public Giaovien findbyID(int id) {

        Giaovien giaovien = hibernateTemplate.get(Giaovien.class, id);
        return null;
    }

    @Override
    public Giaovien findGVbyCondition(String ten) {
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

	@Override
	public List<Giaovien> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveOrupdate(Giaovien giaovien) {
		
	}

}
