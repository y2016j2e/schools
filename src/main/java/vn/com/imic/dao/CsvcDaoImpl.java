package vn.com.imic.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import vn.com.imic.model.Cosovatchat;
import vn.com.imic.model.Diemtruong;
@Repository
public class CsvcDaoImpl extends HibernateDaoSupport implements CsvcDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Cosovatchat> findAllInDiemTruong(String diemtruong, String namhoc) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Cosovatchat.class, "csvc");
		criteria.createAlias("csvc.diemtruong", diemtruong).createAlias("csvc.namhoc", namhoc)
				.add(Restrictions.eq("diemtruong", diemtruong)).add(Restrictions.eq("namhoc", namhoc));
		List<Cosovatchat> lis = (List<Cosovatchat>) hibernateTemplate.findByCriteria(criteria);
		return lis;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cosovatchat> findLimitInDiemTruong(String diemtruong, String namhoc, int first, int max) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Cosovatchat.class, "csvc");
		criteria.createAlias("csvc.diemtruong", diemtruong).createAlias("csvc.namhoc", namhoc)
				.add(Restrictions.eq("diemtruong.tendiemtruong", diemtruong))
				.add(Restrictions.eq("namhoc.thoigian", namhoc));
		List<Cosovatchat> lis = (List<Cosovatchat>) hibernateTemplate.findByCriteria(criteria, first, max);
		return lis;
	}

	@Override
	public Cosovatchat findByID(int id) {
		Cosovatchat vc = hibernateTemplate.get(Cosovatchat.class, id);
		return vc;
	}

	@Override
	public void insertOrUpdate(Cosovatchat csvc) {
		save(csvc);
	}

	@Override
	public void DeleteCSVC(int id) {
		Cosovatchat vc = findByID(id);
		delete(vc);
	}

	@Override
	public int CountCSVC() {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		int count = ((Long) session.createQuery("select count (*)form cosovatchat").uniqueResult()).intValue();
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Cosovatchat findCSVCByCondition(String tenvc, String diemtruong, String namhoc) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Cosovatchat.class, "csvc");
		criteria.createAlias("csvc.diemtruong", diemtruong).createAlias("csvc.namhoc", namhoc)
				.add(Restrictions.eq("diemtruong.tendiemtruong", diemtruong))
				.add(Restrictions.eq("namhoc.thoigian", namhoc)).add(Restrictions.eq("tenvc.ten", tenvc));
		List<Cosovatchat> lis = (List<Cosovatchat>) hibernateTemplate.findByCriteria(criteria);
		if (lis.size()!=0)
			return lis.get(0);

		return null;
	}

	@Override
	public void insertOrUpdatecsvcInDiemtruong( Diemtruong diemtruong) {
		save(diemtruong);
	}

}
