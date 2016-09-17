package vn.com.imic.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import vn.com.imic.model.Khuonvien;

public class KhuonvienDaoImpl extends HibernateDaoSupport implements csvcInterface<Khuonvien> {

	@SuppressWarnings("unchecked")
	@Override
	public List<Khuonvien> findAll() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Khuonvien.class, "kv");
		List<Khuonvien> lis = (List<Khuonvien>) hibernateTemplate.findByCriteria(criteria);
		return lis;
	}

	@SuppressWarnings("unchecked")
	public List<Khuonvien> findByCondition(int diemtruongid, int cosovatchatid,int idnamhoc) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Khuonvien.class, "kv");
		criteria.createAlias("kv.cosovatchat", "cosovatchat")
				.add(Restrictions.eq("cosovatchat.macosovatchat", cosovatchatid))
				.add(Restrictions.eq("cosovatchat.diemtruong.madiemtruong", diemtruongid))
				.add(Restrictions.eq("cosovatchat.diemtruong.namhoc.manamhoc", idnamhoc));
		List<Khuonvien> lis = (List<Khuonvien>) hibernateTemplate.findByCriteria(criteria);
		return lis;

	}

	@Override
	public Khuonvien FindById(int id) {
		return hibernateTemplate.get(Khuonvien.class, id);
	}

	@Override
	public void SaveOrUpdate(Khuonvien e) {
		save(e);
	}

	@Override
	public void deleteByid(int id) {
		Khuonvien kv = hibernateTemplate.get(Khuonvien.class, id);
		delete(kv);
	}

}
