package vn.com.imic.dao;

import java.util.List;

import vn.com.imic.model.Giaovien;
import vn.com.imic.model.Khoahoc;

public interface GiaovienDao {
    public List<Giaovien> findAll();

    public List<Giaovien> findLimit(int first, int max);

    public void insertOrupdate(Giaovien giaovien);

    public void deleteGiaovien(int id);

    public boolean statusGiaovien(boolean status);
    //public void dfPass();
    public Giaovien findbyID(int id);

    public Giaovien findGVbyCondition(String ten);
    //public Giaovien Page();

}
