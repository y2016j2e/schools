package vn.com.imic.service;


import vn.com.imic.model.Giaovien;

public interface GiaovienServices {

    public Giaovien  getGVbyID(int id);
    public Giaovien findGiaovienbyName(String ten);

    public int getPage(String namhoc,String hocky,String chunhiem,int max);

}
