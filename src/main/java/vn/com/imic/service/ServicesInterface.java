package vn.com.imic.service;

import java.util.List;

public interface ServicesInterface <E>{
	List<E> getAllObjects();
	E getObjectById(int id);
}
