package vn.com.imic.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import vn.com.imic.model.Giaovien;
@Repository
public class GiaovienDaoIplm extends HibernateDaoSupport implements GiaovienDao {

    @SuppressWarnings("unchecked")
    @Override
    public List<Giaovien> getAll() {

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
    public void saveOrupdate(Giaovien giaovien) {
    	hibernateTemplate.saveOrUpdate(giaovien);
    }

    @Override
    public void deleteGiaovien(int id) {
        Giaovien giaovien = findbyID(id);
        System.out.println("Giao Vien: "+giaovien.getTen()+giaovien.getMagiaovien());
        delete(giaovien);
       
    }

    @Override
    public boolean statusGiaovien(boolean status) {
        return true;
    }

    @Override
    public Giaovien findbyID(int id) {

        Giaovien giaovien = hibernateTemplate.get(Giaovien.class, id);
        return giaovien;
    }

    @Override
    public Giaovien findGVbyCondition(String ten) {
        // TODO Auto-generated method stub
        return null;
    }


}
