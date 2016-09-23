package vn.com.imic.dao;

import java.util.List;

import vn.com.imic.model.Giangday;
import vn.com.imic.model.Giaovien;
import vn.com.imic.model.Khoahoc;
import vn.com.imic.model.Lop;
import vn.com.imic.model.Monhoc;

public interface IGiangDayDAO {

	public List<Giaovien> getGiaoVien(int first, int max);

	public List<Monhoc> getMonHoc();

	public List<Lop> getLop();

	public List<Giangday> getAll();

	public void saveOrUpdate(Giangday giangday);

	public void delete(int magiangday);

	public Giangday findByID(int magiangday);

	public Giaovien getGiaoVien(int maGiaoVien);

	public List<Monhoc> getMonHocs();

	public List<Khoahoc> getKhoaHocs();

	public Khoahoc findKhoaHoc(int maKhoaHoc);

	public Monhoc findMonHoc(int maMonHoc);

	public void upDatePhanCong(Giaovien giaovien);

	public void upDateKhoaHoc(Khoahoc khoahoc);

	public int countGiaoVien();

	public List<Giaovien> getGVCN();

	public void updateGiangDay(Giangday giangday);

}
