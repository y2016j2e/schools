package vn.com.imic.dao;

import java.util.List;

import vn.com.imic.model.Cosovatchat;
import vn.com.imic.model.Diemtruong;

public interface CsvcDao {
	public List<Cosovatchat> findAllInDiemTruong(String diemtruong,String namhoc);

	public List<Cosovatchat> findLimitInDiemTruong(String diemtruong,String namhoc, int first,int max );
	
	public Cosovatchat findByID(int id);

	public void insertOrUpdate(Cosovatchat csvc);

	public void DeleteCSVC(int id);

	public int CountCSVC();

	public Cosovatchat findCSVCByCondition(String tenvc, String diemtruong, String namhoc);

	public void insertOrUpdatecsvcInDiemtruong(Diemtruong diemtruong);
}
