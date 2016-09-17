package vn.com.imic.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import vn.com.imic.model.Nhavesinh;

public class NhavesinhImpl extends HibernateDaoSupport implements csvcInterface<Nhavesinh> {

	@SuppressWarnings("unchecked")
	@Override
	public List<Nhavesinh> findAll() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Nhavesinh.class, "nvs");

		return (List<Nhavesinh>) hibernateTemplate.findByCriteria(criteria);
	}

	@Override
	public Nhavesinh FindById(int id) {
		return hibernateTemplate.get(Nhavesinh.class, id);
	}

	@Override
	public List<Nhavesinh> findByCondition(int iddt, int idcsvc,int idnamhoc) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Nhavesinh.class, "nvs");
		criteria.createAlias("nvs.cosovatchat", "cosovatchat").add(Restrictions.eq("cosovatchat.macosovatchat", idcsvc))
				.add(Restrictions.eq("cosovatchat.diemtruong.madiemtruong", iddt)).add(Restrictions.eq("cosovatchat.diemtruong.namhoc.manamhoc", idnamhoc));
		return null;
	}

	@Override
	public void SaveOrUpdate(Nhavesinh e) {
		save(e);
	}

	@Override
	public void deleteByid(int id) {
		delete(hibernateTemplate.get(Nhavesinh.class, id));
	}

}
