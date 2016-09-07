package vn.com.imic.dao;

import java.util.List;

public interface DaoClass <E>{
	public List<E> findAll();
	public E findObjectById(int id);
}