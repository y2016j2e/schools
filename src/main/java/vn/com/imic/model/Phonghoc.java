package vn.com.imic.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="phonghoc")
public class Phonghoc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maP;
	@Column(name = "tenPhong", nullable = false)
	private int tenPhong;
	@Column(name = "capdoxd", nullable = true)
	private int capdoxd;
	@Column(name = "dientich", nullable = true)
	private double dientich;
	@Column(name = "xaymoi")
	private boolean xaymoi;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "cosovatchat")
	private Cosovatchat cosovatchat;

	public Cosovatchat getCosovatchat() {
		return cosovatchat;
	}

	public void setCosovatchat(Cosovatchat cosovatchat) {
		this.cosovatchat = cosovatchat;
	}

	public int getMaP() {
		return maP;
	}

	public void setMaP(int maP) {
		this.maP = maP;
	}

	public int getTenPhong() {
		return tenPhong;
	}

	public void setTenPhong(int tenPhong) {
		this.tenPhong = tenPhong;
	}

	public int getCapdoxd() {
		return capdoxd;
	}

	public void setCapdoxd(int capdoxd) {
		this.capdoxd = capdoxd;
	}

	public double getDientich() {
		return dientich;
	}

	public void setDientich(double dientich) {
		this.dientich = dientich;
	}

	public boolean isXaymoi() {
		return xaymoi;
	}

	public void setXaymoi(boolean xaymoi) {
		this.xaymoi = xaymoi;
	}

}
