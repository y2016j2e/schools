package vn.com.imic.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import vn.com.imic.model.Giangday;
import vn.com.imic.model.Giaovien;
import vn.com.imic.model.Khoahoc;
import vn.com.imic.model.Lop;
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
	public List<Giaovien> getGiaoVien() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Giaovien.class);
		return (List<Giaovien>) hibernateTemplate.findByCriteria(criteria);
	}

	@Override
	public List<Monhoc> getMonHoc() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Monhoc.class);
		return (List<Monhoc>) hibernateTemplate.findByCriteria(criteria);
	}

	@Override
	public Giaovien getGiaoVien(int maGiaoVien) {
		return hibernateTemplate.get(Giaovien.class, maGiaoVien);
	}

	@Override
	public List<Lop> getLop() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Lop.class);
		return (List<Lop>) hibernateTemplate.findByCriteria(criteria);
	}

	@Override
	public List<Monhoc> getMonHocs() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Monhoc.class);
		return (List<Monhoc>) hibernateTemplate.findByCriteria(criteria);
	}

	@Override
	public List<Khoahoc> getKhoaHocs() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Khoahoc.class);
		return (List<Khoahoc>) hibernateTemplate.findByCriteria(criteria);
	}

	@Override
	public Khoahoc findKhoaHoc(int maKhoaHoc) {
		return hibernateTemplate.get(Khoahoc.class, maKhoaHoc);
	}

	@Override
	public Monhoc findMonHoc(int maMonHoc) {
		return hibernateTemplate.get(Monhoc.class, maMonHoc);
	}

	@Override
	public void upDatePhanCong(Giaovien giaovien) {
		save(giaovien);
	}

	@Override
	public void upDateKhoaHoc(Khoahoc khoahoc) {
		save(khoahoc);
	}

}
