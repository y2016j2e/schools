package vn.com.imic.service;


import vn.com.imic.model.Giaovien;
import java.util.List;

public interface GiaovienServices {

  
    public Giaovien  getGVbyID(int id);
    public Giaovien findGiaovienbyName(String ten);
    public void saveOrupdate(Giaovien giaovien);

    public void deleteGiaovien(int id);

    public int getPage(String namhoc,String hocky,String chunhiem,int max);

}
