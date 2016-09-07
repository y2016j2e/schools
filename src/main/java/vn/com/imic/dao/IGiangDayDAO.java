package vn.com.imic.dao;

import java.util.List;

import vn.com.imic.model.Giangday;
import vn.com.imic.model.Giaovien;
import vn.com.imic.model.Monhoc;

public interface IGiangDayDAO {

	public List<Giaovien> getGiaVien();

	public List<Monhoc> getMonHoc();

	public List<Giangday> getAll();

	public void saveOrUpdate(Giangday giangday);

	public void delete(int magiangday);

	public Giangday findByID(int magiangday);
}
