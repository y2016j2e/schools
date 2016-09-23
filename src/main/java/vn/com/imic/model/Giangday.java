package vn.com.imic.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Giangday")
public class Giangday {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int magiangday;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private Giaovien giaovien;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private Monhoc monhoc;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private Khoahoc khoahoc;

	public int getMagiangday() {
		return magiangday;
	}

	public void setMagiangday(int magiangday) {
		this.magiangday = magiangday;
	}

	public Giaovien getGiaovien() {
		return giaovien;
	}

	public void setGiaovien(Giaovien giaovien) {
		this.giaovien = giaovien;
	}

	public Monhoc getMonhoc() {
		return monhoc;
	}

	public void setMonhoc(Monhoc monhoc) {
		this.monhoc = monhoc;
	}

	public Khoahoc getKhoahoc() {
		return khoahoc;
	}

	public void setKhoahoc(Khoahoc khoahoc) {
		this.khoahoc = khoahoc;
	}

}
