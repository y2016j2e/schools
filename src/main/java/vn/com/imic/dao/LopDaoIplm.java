package vn.com.imic.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import vn.com.imic.model.Khoahoc;
import vn.com.imic.model.Lop;

@Repository
public class LopDaoIplm extends HibernateDaoSupport implements LopDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Lop> findAll() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Lop.class);
		List<Lop> lis = (List<Lop>) hibernateTemplate.findByCriteria(criteria);
		System.out.println(lis.get(0).getMalop());
		return lis;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Lop> findLimit(int first, int max) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Lop.class);
		List<Lop> lis = (List<Lop>) hibernateTemplate.findByCriteria(criteria, first,max);
		return lis;
	}

	@Override
	public Lop findById(int id) {
		Lop lop = hibernateTemplate.get(Lop.class, id);
		return lop;
	}

	@Override
	public void insertOrUpdate(Lop lop) {
		save(lop);
	}

	@Override
	public void DeleteLop(int id) {
		delete(hibernateTemplate.get(Lop.class, id));
	}

	public int CountLop(){
		Session session = hibernateTemplate.getSessionFactory().openSession();
		int count = ((Long)session.createQuery("select count(*) from Lop").uniqueResult()).intValue();//from Lop.class.getName()
		return count;
	}
	
	
	public Lop findLopByCondition(String tenlop,String diemtruong){
		DetachedCriteria criteria = DetachedCriteria.forClass(Lop.class, "lop");
		criteria.createAlias("lop.diemtruong", "diemtruong")
		.add(Restrictions.eq("tenlop",tenlop))
		.add(Restrictions.eq("diemtruong.tendiemtruong",diemtruong));
			if(hibernateTemplate.findByCriteria(criteria).size()!=0)
				return (Lop) hibernateTemplate.findByCriteria(criteria).get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Khoahoc> findAllLopInKhoahoc(String namhoc,String hocki,String diemtruong) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Khoahoc.class, "khoahoc");
		criteria.createAlias("khoahoc.lop.diemtruong", "diemtruong")
		.createAlias("khoahoc.namhoc","namhoc")
		.createAlias("khoahoc.hocky","hocky")
		.add(Restrictions.eq("namhoc.thoigian",namhoc))
		.add(Restrictions.eq("hocky.tenhocky", hocki))
		.add(Restrictions.eq("diemtruong.tendiemtruong", diemtruong));
		 List<Khoahoc> lis = (List<Khoahoc>) hibernateTemplate.findByCriteria(criteria);
		System.out.println(lis.size());
		return lis;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Khoahoc> findLimitLopInKhoahoc(int first, int max,String namhoc,String hocki,String diemtruong) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Khoahoc.class, "khoahoc");
		criteria.createAlias("khoahoc.lop.diemtruong", "diemtruong")
		.createAlias("khoahoc.namhoc","namhoc")
		.createAlias("khoahoc.hocky","hocky")
		.add(Restrictions.eq("namhoc.thoigian",namhoc))
		.add(Restrictions.eq("hocky.tenhocky", hocki))
		.add(Restrictions.eq("diemtruong.tendiemtruong", diemtruong));
		 List<Khoahoc> lis = (List<Khoahoc>) hibernateTemplate.findByCriteria(criteria,first,max);
		System.out.println(lis.size());
		return lis;
	}

	@Override
	public Khoahoc findByIdLopInKhoahoc(int id) {
		return hibernateTemplate.get(Khoahoc.class, id);
	}

	@Override
	public void insertOrUpdateLopInKhoahoc(Khoahoc khoahoc){
			save(khoahoc);
	}

	@Override
	public void DeleteLopInKhoahoc(int id) {
		// TODO Auto-generated method stub
		Khoahoc kh = hibernateTemplate.get(Khoahoc.class, id);
		delete(kh);
	}

	@Override
	public int CountLopInKhoahoc(String namhoc,String hocki,String diemtruong) {
//		DetachedCriteria criteria = DetachedCriteria.forClass(Khoahoc.class, "khoahoc");
//		criteria.createAlias("khoahoc.lop.diemtruong", "diemtruong")
//		.createAlias("khoahoc.namhoc","namhoc")
//		.createAlias("khoahoc.hocky","hocky")
//		.setProjection(Projections.rowCount())
//		.add(Restrictions.eq("namhoc.thoigian",namhoc))
//		.add(Restrictions.eq("hocky.tenhocky", hocki))
//		.add(Restrictions.eq("diemtruong.tendiemtruong", diemtruong));
//		List count = hibernateTemplate.findByCriteria(criteria);
		Session session = hibernateTemplate.getSessionFactory().openSession();
		int count = ((Long)session.createQuery("select count(*) from Khoahoc a,Lop b,Diemtruong c,Namhoc d,Hocky e where a.lop=b.malop and b.diemtruong=c.madiemtruong and a.namhoc=d.manamhoc and a.hocky=e.mahocky and c.tendiemtruong='"+diemtruong+"' and d.thoigian='"+namhoc+"' and e.tenhocky='"+hocki+"'")
				.uniqueResult()).intValue(); //from ??? luôn phải trùng tên với các model trong java , không phải sql
		System.out.println(count+" so lop");
		return count;
	}
	
	public int Page(String namhoc,String hocki,String diemtruong,int max){
		int count = CountLopInKhoahoc(namhoc, hocki, diemtruong);
		System.out.println(count/max+" page");
		if(count%max!=0)
			return 1+(count/max);
		return count/max;
	}
}
