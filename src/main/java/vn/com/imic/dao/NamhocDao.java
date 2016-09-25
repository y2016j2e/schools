package vn.com.imic.dao;

import java.util.List;

import vn.com.imic.model.Namhoc;

public interface NamhocDao {
	List<Namhoc> findAllNamhoc();
	Namhoc findNamhocById(int manamhoc);
}
