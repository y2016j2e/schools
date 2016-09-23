package vn.com.imic.dao;

import java.util.List;

import vn.com.imic.model.Giaovien;

public interface GiaovienDao {
    public List<Giaovien> getAll();

    public List<Giaovien> findLimit(int first, int max);

    public void saveOrupdate(Giaovien giaovien);

    public void deleteGiaovien(int id);

    public boolean statusGiaovien(boolean status);
    //public void dfPass();
    public Giaovien findbyID(int id);

    public Giaovien findGVbyCondition(String ten);
    //public Giaovien Page();

}
