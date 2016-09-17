package vn.com.imic.service;

import java.util.List;

import vn.com.imic.model.Phonghoc;


public interface PhonghocService {
	public List<Phonghoc> findAll();
	public Phonghoc findById(int id);
	public List<Phonghoc> findBycondition(int iddt,int idcsvc,int idnamhoc);
}
