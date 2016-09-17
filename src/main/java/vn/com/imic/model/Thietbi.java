package vn.com.imic.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="thietbi")
public class Thietbi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maTbi;
	@Column(name="soluong",nullable=true)
	private int soluong;
	@Column(name="ofgv")
	private boolean ofgv;
	@Column(name="ofhs")
	private boolean ofhs;
	@Column(name="somaychieu")
	private int somaychieu;
	@Column(name="internet")
	private boolean internet;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="cosovatchat")
	private Cosovatchat cosovatchat;
	public int getMaTbi() {
		return maTbi;
	}
	public void setMaTbi(int maTbi) {
		this.maTbi = maTbi;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public boolean isOfgv() {
		return ofgv;
	}
	public void setOfgv(boolean ofgv) {
		this.ofgv = ofgv;
	}
	public boolean isOfhs() {
		return ofhs;
	}
	public void setOfhs(boolean ofhs) {
		this.ofhs = ofhs;
	}
	public int getSomaychieu() {
		return somaychieu;
	}
	public void setSomaychieu(int somaychieu) {
		this.somaychieu = somaychieu;
	}
	public boolean isInternet() {
		return internet;
	}
	public void setInternet(boolean internet) {
		this.internet = internet;
	}
	public Cosovatchat getCosovatchat() {
		return cosovatchat;
	}
	public void setCosovatchat(Cosovatchat cosovatchat) {
		this.cosovatchat = cosovatchat;
	}
}
