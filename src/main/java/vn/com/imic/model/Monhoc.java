package vn.com.imic.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Monhoc")
public class Monhoc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mamonhoc;
	
	@Column(name="tenmonhoc",nullable=false)
	private String tenmonhoc;
	
	@OneToMany(mappedBy="monhoc")
	private List<Giangday> giangday;

	public int getMamonhoc() {
		return mamonhoc;
	}

	public void setMamonhoc(int mamonhoc) {
		this.mamonhoc = mamonhoc;
	}

	public String getTenmonhoc() {
		return tenmonhoc;
	}

	public void setTenmonhoc(String tenmonhoc) {
		this.tenmonhoc = tenmonhoc;
	}

	public List<Giangday> getGiangday() {
		return giangday;
	}

	public void setGiangday(List<Giangday> giangday) {
		this.giangday = giangday;
	}
	
}