package vn.com.imic.service;

import java.util.List;

import org.springframework.stereotype.Service;
@Service
public interface CosovatchatService<E> {
	public List<E> findAll();
	public E FindById(int id);
	public List<E> findByCondition(int iddt,int idcsvc,int idnamhoc);
	public void SaveOrUpdate(E e);
	public void deleteByid(int id);
}
