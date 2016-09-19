package vn.com.imic.service;

import java.util.List;

import vn.com.imic.model.Khoahoc;

public interface IKhoahocService {
	public List<Khoahoc> getAll();

	public void saveOrUpdate(Khoahoc khoahoc);

	public void delete(int makhoahoc);

	public Khoahoc findByID(int makhoahoc);
}
