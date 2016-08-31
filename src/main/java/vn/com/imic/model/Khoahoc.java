package vn.com.imic.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Khoahoc")
public class Khoahoc {
	@Id
	private int makhoahoc;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="lop")
	private Lop lop;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="namhoc")
	private Namhoc namhoc;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="hocky")
	private Hocky hocky;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name = "hocsinhkhoa",joinColumns = { @JoinColumn(name = "makhoahoc") }, inverseJoinColumns = {@JoinColumn(name = "mahocsinh") })
	private List<Hocsinh> hocsinh;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name = "chunhiem",joinColumns = { @JoinColumn(name = "makhoahoc") }, inverseJoinColumns = {@JoinColumn(name = "giaovien") })
	private List<Giaovien> chunhiem;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name = "phancong",joinColumns = { @JoinColumn(name = "makhoahoc") }, inverseJoinColumns = {@JoinColumn(name = "magiangday") })
	private List<Giangday> giangday;
	
	public int getMakhoahoc() {
		return makhoahoc;
	}

	public void setMakhoahoc(int makhoahoc) {
		this.makhoahoc = makhoahoc;
	}

	public Lop getLop() {
		return lop;
	}

	public void setLop(Lop lop) {
		this.lop = lop;
	}

	public Namhoc getNamhoc() {
		return namhoc;
	}

	public void setNamhoc(Namhoc namhoc) {
		this.namhoc = namhoc;
	}

	public Hocky getHocky() {
		return hocky;
	}

	public void setHocky(Hocky hocky) {
		this.hocky = hocky;
	}

	public List<Hocsinh> getHocsinh() {
		return hocsinh;
	}

	public void setHocsinh(List<Hocsinh> hocsinh) {
		this.hocsinh = hocsinh;
	}

	public List<Giaovien> getChunhiem() {
		return chunhiem;
	}

	public void setChunhiem(List<Giaovien> chunhiem) {
		this.chunhiem = chunhiem;
	}

	public List<Giangday> getGiangday() {
		return giangday;
	}

	public void setGiangday(List<Giangday> giangday) {
		this.giangday = giangday;
	}
	
	
}
