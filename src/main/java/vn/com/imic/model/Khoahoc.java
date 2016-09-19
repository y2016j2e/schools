package vn.com.imic.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Khoahoc", uniqueConstraints = { @UniqueConstraint(columnNames = { "namhoc", "hocky", "lop" }) })
public class Khoahoc {

	public Khoahoc() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int makhoahoc;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "lop")
	private Lop lop;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "namhoc")
	private Namhoc namhoc;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "hocky")
	private Hocky hocky;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "hocsinhkhoa", joinColumns = { @JoinColumn(name = "makhoahoc") }, inverseJoinColumns = {
			@JoinColumn(name = "mahocsinh") })
	private List<Hocsinh> hocsinh;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "chunhiem")
	private Giaovien chunhiem;

	@OneToMany(mappedBy = "khoahoc", cascade = CascadeType.ALL)
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

	public Giaovien getChunhiem() {
		return chunhiem;
	}

	public void setChunhiem(Giaovien chunhiem) {
		this.chunhiem = chunhiem;
	}

	public List<Giangday> getGiangday() {
		return giangday;
	}

	public void setGiangday(List<Giangday> giangday) {
		this.giangday = giangday;
	}

}
