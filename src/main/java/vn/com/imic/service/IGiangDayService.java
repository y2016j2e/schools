package vn.com.imic.service;

import java.util.List;

import vn.com.imic.model.Giangday;

public interface IGiangDayService {
	public List<Giangday> getAll();

	public void saveOrUpdate(Giangday giangday);

	public void delete(int magiangday);

	public Giangday findByID(int magiangday);
}
