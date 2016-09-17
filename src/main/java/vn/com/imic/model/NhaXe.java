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
@Table(name="nhaxe")
public class NhaXe {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maNhaxe;
	
	@Column(name="soluong",nullable=true)
	private int soluong;
	
	@Column(name="dientich",nullable=true)
	private double dientich;
	
	@Column(name="ofgv")
	private boolean ofgv;
	
	@Column(name="ofhs")
	private boolean ofhs;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="cosovatchat")
	private Cosovatchat cosovatchat;

	public int getMaNhaxe() {
		return maNhaxe;
	}

	public void setMaNhaxe(int maNhaxe) {
		this.maNhaxe = maNhaxe;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public double getDientich() {
		return dientich;
	}

	public void setDientich(double dientich) {
		this.dientich = dientich;
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

	public Cosovatchat getCosovatchat() {
		return cosovatchat;
	}

	public void setCosovatchat(Cosovatchat cosovatchat) {
		this.cosovatchat = cosovatchat;
	}
}
