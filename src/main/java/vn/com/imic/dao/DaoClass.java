package vn.com.imic.dao;

import java.util.List;

public interface DaoClass <E>{
	List<E> findAll();
	E findObjectById(int id);
	E findByCondition(String... condition);
}
