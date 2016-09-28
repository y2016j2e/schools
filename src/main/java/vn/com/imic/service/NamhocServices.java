package vn.com.imic.service;

import java.util.List;

import vn.com.imic.model.Namhoc;

public interface NamhocServices {
	List<Namhoc> getAllNamhoc();
	Namhoc getNamhocById(int id);
	void save(Namhoc namhoc);
}
