package vn.com.imic.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import vn.com.imic.model.Cosovatchat;
@Repository
public class CosoImpl extends HibernateDaoSupport implements DaoClass<Cosovatchat> {

	@Override
	public List<Cosovatchat> findAll() {
		return null;
	}

	@Override
	public Cosovatchat findObjectById(int id) {
		return hibernateTemplate.get(Cosovatchat.class, id);
	}

	@Override
	public Cosovatchat findByCondition(String... condition) {
		return null;
	}

}
